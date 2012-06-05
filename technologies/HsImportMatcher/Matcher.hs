import Data.Maybe
import Data.List
import System.Environment
import System.Exit
import Language.Haskell.Syntax
import Language.Haskell.Parser


-- Read .hs file; try to find the namespace
main = do
   [hsfile,namespace] <- getArgs
   hsstring <- readFile hsfile
   case parseModule hsstring of
     (ParseFailed _ _) -> do
       putStrLn "Haskell parser failed."
       abnormal
     (ParseOk (HsModule _ _ _ idecls _)) -> do
       if (or (map (decl2bool namespace) idecls))
       then
          normal
       else
          do
            print idecls
            putStrLn "Namespace not matched."
            abnormal


-- Check for relevant imports
decl2bool :: String -> HsImportDecl -> Bool
decl2bool namespace idecl =
  let (Module str) = (importModule idecl) in
    str == namespace || isJust (stripPrefix (namespace ++ ".") str)


-- Helpers for exit
normal = exitWith ExitSuccess
abnormal = exitWith (ExitFailure (-1))
