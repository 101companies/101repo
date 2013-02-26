import System.Environment
import System.IO
import System.Directory
import Text.JSON
import Text.JSON.String
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
             case walkModule classifier name m of
               Nothing -> do
                 putStrLn "Fragment location failed."
                 abnormal
               Just (from, to) ->
                 -- Write JSON for line range to stdout
                 putStrLn (
                   showJSValue (
                     JSObject (
                       toJSObject
                         [ ("from", (showJSON from)),
                           ("to", (showJSON to)) ])) "")


-- Walk the module and try to locate the fragment
walkModule :: String -> String -> HsModule -> Maybe (Int,Int)
walkModule classifier name (HsModule _ _ _ _ decls) = Just (1,42)


-- Locate the fragment in the list of top-level declarations
getLines :: [HsDecl] -> JSValue -> Maybe JSValue
getLines decls js
 = case js of
     (JSObject o) -> 
       (case fromJSObject o of
         [(key,JSString jsstr)] -> 
           let str = fromJSString jsstr in
           (case key of 
              "data" -> findData str
              "function" -> findFunction str
              _ -> Nothing)
         _ -> Nothing)   
     _ -> Nothing
 where
   findData :: String -> Maybe JSValue
   findData n = f decls
    where
     f (HsTypeDecl x (HsIdent n') _ _:r) | n==n' = result' x r
     f (HsDataDecl x _ (HsIdent n') _ _ _:r) | n==n' = result' x r
     f (HsNewTypeDecl x _ (HsIdent n') _ _ _:r) | n==n' = result' x r
     f (_:r) = f r
     f [] = Nothing

   findFunction :: String -> Maybe JSValue
   findFunction n = f Nothing decls
    where
     f p (HsFunBind (HsMatch x (HsIdent n') _ _ _:_):r) | n==n' = g n p x r
     f p (HsPatBind x (HsPVar (HsIdent n')) _ _:r) | n==n' = g n p x r
     f _ (h:t) = f (Just h) t
     f _ [] = Nothing

     g n (Just (HsTypeSig x [HsIdent n'] _)) _ r | n==n' = result' x r
     g _ _ x r = result' x r

   result' :: SrcLoc -> [HsDecl] -> Maybe JSValue
   result' x (y:_) = result x (srcLoc y)
   result' _ [] = Nothing 

   result :: SrcLoc -> SrcLoc -> Maybe JSValue
   result from to = 
     Just (
       JSObject (
         toJSObject
           [("from", (showJSON (srcLine from))),
            ("to", (showJSON ((srcLine to) - 1)))]))


-- Decompose fragment selector
fromSelector :: String -> Maybe (String, String)
fromSelector sel =
  case T.splitOn (T.pack "/") (T.pack sel) of
    [x,y] -> Just (T.unpack x, T.unpack y)
    _ -> Nothing


-- Convert string into lines
toLines :: String -> [String]
toLines input =
    map T.unpack
  $ T.splitOn (T.pack "\n") (T.pack input)


-- Helper for abnormal exit
abnormal = exitWith $ ExitFailure 101


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
