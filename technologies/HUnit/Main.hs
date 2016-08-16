import Test.HUnit (runTestTT, Test(TestList, TestLabel), (~=?))

-- The tests
tests :: Test
tests =
    TestList [
      TestLabel "notNotTrue" (doubleNegation True),
      TestLabel "notNotFalse" (doubleNegation False)
    ]
  where
   doubleNegation x = x ~=? not (not x)

-- Run all tests
main = runTestTT tests
