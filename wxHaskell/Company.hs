module Company where

data Company = Company
        { cname      :: Name
        , depts     :: [Department]
        }
    deriving (Eq,Show)
            
data Department = Department 
        { dname      :: Name
        , manager   :: Manager
        , dus  :: [Department]
        , eus  :: [Employee]
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