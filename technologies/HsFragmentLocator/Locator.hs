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
   args <- getArgs
   let len = length args
   let hsfile = head args
   let jsonfile = (!!) args 1
   hsstring <- readFile hsfile
   let hsstring' = hsstring ++ "\nfoo = 42" -- See comment.

{-

RL: We use a hack to be able to determine the last line of each
fragment. That is, we add a vacous binding "foo = 42" at the end of
the file, prior to parsing. In this manner, we make sure that we
always have an HsDecl past the located one and hence, we can determine
the "to" line for the fragment. This ought to be done differently some
day.

-}

   case parseModule hsstring' of
     (ParseFailed _ _) -> do
       putStrLn "Haskell parser failed."
       abnormal
     (ParseOk (HsModule _ _ _ _ decls)) -> do
       fileExists <- doesFileExist jsonfile
       jsonstring <- if fileExists
           then do content <- readFile jsonfile
                   return content
           else do let parts = T.splitOn (T.pack "/") (T.pack jsonfile)
                   let str = "{ \""++ T.unpack ((!!) parts 0) ++ "\" : \"" ++ T.unpack ((!!) parts 1) ++ "\"}"
                   return str
       case runGetJSON readJSObject jsonstring of
         (Left _) -> do 
           putStrLn "JSON parser failed."
           abnormal
         (Right jsonvalue) ->
           case getLines decls jsonvalue of
             Nothing -> do 
               putStrLn "Fragment location failed."
               abnormal
             Just fromto -> do
               let lines = showJSValue fromto "" ++ "\n"
               if len == 2
                  then putStrLn lines
                  else writeFile ((!!) args 2) lines


-- Helper for abnormal exit
abnormal = exitWith (ExitFailure (-1))

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
