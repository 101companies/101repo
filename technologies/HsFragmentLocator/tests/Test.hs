-- Import an entire module
import Data.Maybe

-- Import some bits from a module
import Control.Monad (filterM)

-- Qualified import
import qualified Data.Map

-- Import with alias
import Data.List as L

-- A simple type declaration
type MyType = ()

-- A simple data type declaration
data MyData = MyData1 | MyData2

-- A simple newtype declaration
newtype MyNewtype = MyNewtype ()

-- A function without signature and with just one equation
f 'a' = 1

-- A function with signature and with just one equation
g :: Char -> Int
g 'a' = 1

-- A function with signature and with more than one equation
h :: Char -> Int
h 'a' = 1
h 'b' = 2

-- A pattern binding with signature
x :: ()
x = ()

-- A pattern binding without signature
y = ()

--
-- Two functions where the comment counts towards the first one
--

f1 1 = 1

f2 2 = 2
