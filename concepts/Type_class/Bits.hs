{-

Bit streams represent unsigned binary numbers.
Preceding zeros are maintained by Read and Show, but tthey may be eliminated along number operations.

-}

module Bits where

import Data.Char (isSpace)

-- A bit can be zero or one
data Bit = Zero | One

-- Bit streams of any length
newtype Bits = Bits { getBits :: [Bit] }

-- Show bits
instance Show Bit 
  where
    show Zero = "0"
    show One = "1"

-- Show bit streams
instance Show Bits
  where
    show = concat . map show . getBits

-- Read bits
instance Read Bit
  where
    readsPrec _ [] = []
    readsPrec prec s =
      if isSpace (head s)
        then readsPrec prec (tail s)
        else 
          case head s of
              '0' -> [ (Zero, tail s) ]
              '1' -> [ (One, tail s) ]
              _ -> []

-- Read bit streams
instance Read Bits
  where
    readsPrec _ s =
        maybe []
              (\x -> [(Bits x,r)])
              bitsM
      where
        [(s',r)] = lex s
        bitsM = mapM toBit s'
        toBit '0' = Just Zero
        toBit '1' = Just One
        toBit _ = Nothing

-- Test bits for equality
instance Eq Bit
  where
    Zero == Zero = True
    Zero == One = False
    One == One = True
    One == Zero = False

-- Test bit streams for equality
instance Eq Bits
  where
    x == y =  length x' == length y'
           && and (map (uncurry (==)) (zip x' y'))
      where
        x' = trim (getBits x)
        y' = trim (getBits y)
        trim [] = []
        trim z@(One:_) = z
        trim (Zero:z) = trim z

-- Bits as a Num type
instance Num Bits
  where
    x + y = integral2bits z'
      where
        x' = bits2integral x
        y' = bits2integral y
        z' = x' + y'
    x * y = integral2bits z'
      where
        x' = bits2integral x
        y' = bits2integral y
        z' = x' * y'
    x - y = integral2bits z'
      where
        x' = bits2integral x
        y' = bits2integral y
        z' = x' - y'
    abs = id
    signum = integral2bits
           . signum
           . bits2integral
    fromInteger = integral2bits

-- Convert bits to an integer
bits2integral :: Integral a => Bits -> a
bits2integral = foldl f 0 . getBits 
  where
    f a b = a * 2 + (bit2int b)
    bit2int Zero = 0
    bit2int One = 1

-- Convert a (non-negative) integral to bits
integral2bits :: Integral a => a -> Bits
integral2bits i | i < 0 = error "Bits are unsigned"
integral2bits i = Bits (f [] i)
  where
    f xs 0 = xs
    f xs i = f (x:xs) (i `div` 2) 
      where
        x = if odd i then One else Zero 

-- Bits as a Enum type
instance Enum Bits
  where
    toEnum = integral2bits
    fromEnum = bits2integral

main = do
  let b101 = Bits [One,Zero,One]
  print $ b101
  print $ bits2integral b101
  let b = (read (show b101) :: Bits)
  print $ b101 == b
  print $ succ b101
