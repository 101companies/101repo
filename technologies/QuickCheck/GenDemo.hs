import Test.QuickCheck
import Test.QuickCheck.Random

main = do
{-
  > :i
  newtype Gen a = MkGen { unGen :: QCGen -> Int -> a}

  -- Does not work because QuickCheck does not expose unGen
  let g = mkQCGen 42
  let x = unGen (arbitrary :: Gen [Int]) g 10
  print $ x
-}
  xs <- generate (resize 5 $ arbitrary :: Gen [Int])
  print $ xs

{-

-- A generator is a recipe:
arbitrary :: Gen [Int]

-- QuickCheck can show generated examples:
sample :: Show a => Gen a -> IO ()
sample (arbitrary :: Gen [Int])

-- Or run the generator once:
generate :: Gen a -> IO a
generate (arbitrary :: Gen [Int])

-- The size parameter can be controlled:
sample (resize 5 (arbitrary :: Gen [Int]))

-}
