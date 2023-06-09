{- 

Illustration of different stack implementations.
We run the same tests on the different implementations.

-}

import SimpleStackADT as V1
import StacksAsLists as V2
import StacksAsOpaqueLists as V3
import StacksWithConstantTimeSize as V4
import StacksViaSimpleImpl as V5
import Test.HUnit
import System.Exit
import Data.Maybe (fromJust)

getTests v empty push isEmpty size top pop =
  [
    TestLabel (v ++ "size1") (1 ~=? size stack1),
    TestLabel (v ++ "size2") (2 ~=? size stack2),
    TestLabel (v ++ "top1") ("foo" ~=? top stack1),
    TestLabel (v ++ "top2") ("bar" ~=? top stack2),
    TestLabel (v ++ "pop") ("foo" ~=? top (pop stack2)),
    TestLabel (v ++ "isEmpty1") (True ~=? isEmpty (pop stack1)),
    TestLabel (v ++ "isEmpty2") (False ~=? isEmpty (pop stack2))
  ]
  where
    stack1 = push "foo" empty
    stack2 = push "bar" stack1
    

main = do
 let v1 = getTests "V1:" V1.empty V1.push V1.isEmpty V1.size V1.top V1.pop
 let v2 = getTests "V2:" V2.empty V2.push V2.isEmpty V2.size V2.top V2.pop
 let v3 = getTests "V3:" V3.empty V3.push V3.isEmpty V3.size V3.top V3.pop
 let v4 = getTests "V4:" V4.empty V4.push V4.isEmpty V4.size V4.top V4.pop
 let v5 = getTests "V5:" V5.empty V5.push V5.isEmpty V5.size V5.top V5.pop
 let tests = TestList (v1 ++ v2 ++ v3 ++ v4 ++ v5)
 counts <- runTestTT tests
 if (errors counts > 0 || failures counts > 0)
   then exitFailure
   else exitSuccess
