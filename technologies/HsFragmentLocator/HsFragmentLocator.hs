import System.Environment
import Text.JSON
import System.Exit
import Language.Haskell.Syntax
import Language.Haskell.Parser
import qualified Data.Text as T

	
main = do
   -- 1 arg for "/"-based fragment selector
   args <- getArgs
   if length args < 1 then do
     putStrLn "Command-line argument missing."
     abnormal
   else do
     -- Only selectors for top-level fragments supported
     case fromSelector (args !! 0) of
       Nothing -> do
         putStrLn "Illegal fragment selector."
         abnormal
       Just (classifier, name) -> do
         -- Parse stdin
         input <- getContents
         case parseModule input of
           (ParseFailed _ _) -> do
             putStrLn "Haskell parser failed."
             abnormal
           (ParseOk m) -> do
             -- Walk parsed input for fragment location
             case walkModule (lines' input) classifier name m of
               Nothing -> do
                 putStrLn "Fragment location failed."
                 abnormal
               Just (from, to) ->
                 -- Write JSON for line range to stdout
                 putStrLn (
                   showJSValue (
                     JSObject (
                       toJSObject
                         [ ("from", showJSON from),
                           ("to", showJSON to) ])) "")


-- Convert string into newline-separated lines with trimming
lines' :: String -> [String]
lines' = map (T.unpack . T.strip . T.pack) . lines


-- Helper for abnormal exit
abnormal = exitWith $ ExitFailure 101


-- Decompose fragment selector
fromSelector :: String -> Maybe (String, String)
fromSelector sel =
  case T.splitOn (T.pack "/") (T.pack sel) of
    [x,y] -> Just (T.unpack x, T.unpack y)
    _ -> Nothing


-- Walk the module and try to locate the fragment
walkModule :: [String]
           -> String
           -> String
           -> HsModule
           -> Maybe (Int,Int)
walkModule lines classifier n (HsModule _ _ _ _ decls) =
    walkDecls decls
  where

    -- Search list of declarations for selected fragment
    walkDecls :: [HsDecl] -> Maybe (Int, Int)
    walkDecls (HsTypeDecl x (HsIdent n) _ _:r) | test "type" n = range x r
    walkDecls (HsDataDecl x _ (HsIdent n) _ _ _:r) | test "data" n = range x r
    walkDecls (HsNewTypeDecl x _ (HsIdent n) _ _ _:r) | test "newtype" n = range x r
    walkDecls (HsFunBind (HsMatch x (HsIdent n) _ _ _:_):r) | test "function" n = range x r
    walkDecls (HsPatBind x (HsPVar (HsIdent n)) _ _:r) | test "pattern" n = range x r
    walkDecls (HsTypeSig x [HsIdent n] _:
               HsFunBind (HsMatch _ (HsIdent n') _ _ _:_):r)
      |    n == n'
        && test "function" n = range x r
    walkDecls (HsTypeSig x [HsIdent n] _:
               HsPatBind _ (HsPVar (HsIdent n')) _ _:r)
      |    n == n'
        && test "pattern" n = range x r
    walkDecls (_:r) = walkDecls r
    walkDecls [] = Nothing

    -- Compare declaration with selector
    test :: String -> String -> Bool
    test classifier' n' = classifier == classifier' && n == n'

    -- Construct a line range
    range :: SrcLoc -> [HsDecl] -> Maybe (Int, Int)
    range l (decl:_) = Just (include (srcLine l), exclude (srcLine (srcLoc decl) - 1))
    range l [] = Just (include (srcLine l), length lines)

    --
    -- Include preceding comment
    -- We search upwards for line comments and include them.
    -- We also include white prior to hitting comments and between comment lines.
    -- Whitespace above the comment is not included.
    --
    include :: Int -> Int
    include i = include' i i
      where
        include' i 1 = i
        include' i i' | lines !! (i'-2) == "" = include' i (i'-1)
        include' i i' | take 2 (lines !! (i'-2)) == "--" = include' (i'-1) (i'-1)
        include' i _ = i

    --
    -- Exclude subsequent whitespace/comment
    -- We search upwards for line comments and whitespace and include them.
    -- 
    exclude :: Int -> Int
    exclude i | lines !! (i-1) == "" = exclude (i-1)
    exclude i | take 2 (lines !! (i-1)) == "--" = exclude (i-1)
    exclude i = i


-- Extract source location from given declaration
srcLoc :: HsDecl -> SrcLoc
srcLoc (HsTypeDecl x _ _ _) = x
srcLoc (HsDataDecl x _ _ _ _ _) = x
srcLoc (HsInfixDecl x _ _ _) = x
srcLoc (HsNewTypeDecl x _ _ _ _ _) = x
srcLoc (HsClassDecl x _ _ _ _) = x	 
srcLoc (HsInstDecl x _ _ _ _) = x	 
srcLoc (HsDefaultDecl x _) = x	 
srcLoc (HsTypeSig x _ _) = x
srcLoc (HsFunBind (HsMatch x _ _ _ _:_)) = x	 
srcLoc (HsPatBind x _ _ _) = x	 
srcLoc (HsForeignImport x _ _ _ _ _) = x
srcLoc (HsForeignExport x _ _ _ _) = x	 
