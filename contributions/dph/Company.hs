module Company where

import Prelude hiding (Float)
import Data.Array.Parallel.Prelude.Float

data Company = Company
        { cname      :: Name
        , depts     :: [Department]
        }
    deriving (Eq,Show)
            
data Department = Department 
        { dname      :: Name
        , manager   :: Manager
        , subunits  :: [SubUnit]
        }
    deriving (Eq,Show)
     
type Manager = Employee

data Employee = Employee 
        { ename      :: Name 
        , address   :: Address
        , salary    :: Salary
        }
    deriving (Eq,Show)

type Name = String
type Address = String
type Salary = Float
    
data SubUnit = 
          EUnit 
            { employee   :: Employee}
          |
          DUnit
            { department :: Department}       
      deriving (Eq,Show)

