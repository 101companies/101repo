import Test.HUnit

-- The tests
tests =
    TestList [
      TestLabel "notNotTrue" (doubleNegation True),
      TestLabel "notNotFalse" (doubleNegation False)
    ]
  where
   doubleNegation x = x ~=? not (not x)

-- Run all tests
main = runTestTT tests
