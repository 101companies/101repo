import Text.JSON
import System.Exit
import Language.Haskell.Syntax
import Language.Haskell.Parser
import Data.Maybe


-- Read source code from stdin, write extracted facts to stdout	
main = do
   input <- getContents
   case parseModule input of
     (ParseFailed _ _) -> do
       putStrLn "Haskell parser failed."
       abnormal
     (ParseOk (HsModule _ _ _ imports decls)) -> do
       putStrLn (
        showJSValue (
         jsonModule
          (map extractImport imports)
          (catMaybes (map extractFragment decls)))
        "")


-- Turn imports and fragments into JSON
jsonModule :: [String] -> [(String, String)] -> JSValue
jsonModule imports fragments =
  JSObject $
  toJSObject
    [
      ( "imports",
        JSArray (map showJSON imports)
      ),
      ( "fragments",
        JSArray (map jsonFragment fragments)
      )
    ] 
  where

    -- Turn classifier and name into JSON
    jsonFragment :: (String, String) -> JSValue
    jsonFragment (classifier, name) =
      JSObject (
       toJSObject (
        [
          ("classifier", showJSON classifier),
          ("name", showJSON name) 
        ]))


-- Helper for abnormal exit
abnormal = exitWith $ ExitFailure $ 101


-- Extract name of imported module from import declaration
extractImport :: HsImportDecl -> String
extractImport idecl = let (Module str) = importModule idecl in str


-- Extract fragment from declaration
extractFragment :: HsDecl -> Maybe (String, String)
extractFragment (HsTypeDecl _ (HsIdent n) _ _) = Just ("type", n)
extractFragment (HsDataDecl _ _ (HsIdent n) _ _ _) = Just ("data", n)
extractFragment (HsNewTypeDecl _ _ (HsIdent n) _ _ _) = Just ("newtype", n)
extractFragment (HsFunBind (HsMatch _ (HsIdent n) _ _ _:_)) = Just ("function", n)
extractFragment (HsPatBind _ (HsPVar (HsIdent n)) _ _) = Just ("pattern", n)
extractFragment _ = Nothing -- Some declarations may not be handled
