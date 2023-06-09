{- 

Illustration of different stack implementations.
We run the same tests on the different implementations.

-}

import StackImpl
import Test.HUnit
import System.Exit
import Data.Maybe (fromJust)

getTests v impl =
  [
    TestLabel (v ++ "size1") (1 ~=? getSize impl stack1),
    TestLabel (v ++ "size2") (2 ~=? getSize impl stack2),
    TestLabel (v ++ "top1") ("foo" ~=? getTop impl stack1),
    TestLabel (v ++ "top2") ("bar" ~=? getTop impl stack2),
    TestLabel (v ++ "pop") ("foo" ~=? getTop impl (getPop impl stack2)),
    TestLabel (v ++ "isEmpty1") (True ~=? getIsEmpty impl (getPop impl stack1)),
    TestLabel (v ++ "isEmpty2") (False ~=? getIsEmpty impl (getPop impl stack2))
  ]
  where
    stack1 = getPush impl "foo" (getEmpty impl)
    stack2 = getPush impl "bar" stack1
    

main = do
 let v1 = getTests "simpleStackADT:" simpleStackADT
 let v2 = getTests "stacksAsLists:" stacksAsLists
 let v3 = getTests "stacksAsOpaqueLists:" stacksAsOpaqueLists
 let v4 = getTests "stacksWithConstantTimeSize:" stacksWithConstantTimeSize
 let tests = TestList (v1 ++ v2 ++ v3 ++ v3)
 counts <- runTestTT tests
 if (errors counts > 0 || failures counts > 0)
   then exitFailure
   else exitSuccess
