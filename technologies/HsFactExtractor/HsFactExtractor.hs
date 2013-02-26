import System.Environment
import System.IO
import System.Directory
import Text.JSON
import Text.JSON.String
import System.Exit
import Language.Haskell.Syntax
import Language.Haskell.Parser
import qualified Data.Text as T
import Data.Maybe


-- Read source from stdin, write extracted facts to stdout	
main = do
   input <- getContents
   case parseModule input of
     (ParseFailed _ _) -> do
       putStrLn "Haskell parser failed."
       abnormal
     (ParseOk m) -> do
       putStrLn $ showJSValue (walkModule m) ""


-- Walk the module and identify fragments and possibly other facts
walkModule :: HsModule -> JSValue
walkModule (HsModule _ _ _ imports decls) =
  JSObject $
  toJSObject $
  [ ( "imports",
      JSArray $ 
      map walkImport imports
    ),
    ( "fragments",
      JSArray $ 
      catMaybes $ 
      map walkDecl decls
    ) 
  ]


-- Map imports to JSON
walkImport :: HsImportDecl -> JSValue
walkImport idecl = showJSON $ let (Module str) = importModule idecl in str


-- Map declarations to JSON for fragments
walkDecl :: HsDecl -> Maybe JSValue
walkDecl (HsTypeDecl _ (HsIdent n) _ _) = fragment "type" n
walkDecl (HsDataDecl _ _ (HsIdent n) _ _ _) = fragment "data" n
walkDecl (HsNewTypeDecl _ _ (HsIdent n) _ _ _) = fragment "newtype" n
walkDecl (HsFunBind (HsMatch _ (HsIdent n) _ _ _:_)) = fragment "function" n
walkDecl (HsPatBind _ (HsPVar (HsIdent n)) _ _) = fragment "pattern" n
walkDecl _ = Nothing -- Some declarations may not be handled
 where

  
-- Form a fragment selector for a given classifier and name
fragment :: String -> String -> Maybe JSValue
fragment classifier name =
    Just $
    JSObject $
    toJSObject $
    [
      ("classifier", showJSON classifier),
      ("name", showJSON name) 
    ]


-- Helper for abnormal exit
abnormal = exitWith $ ExitFailure $ 101
