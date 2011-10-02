module Company where

data Company = Company
        { cname      :: Name
        , depts     :: [Department]
        }
    deriving (Eq,Read,Show)
            
data Department = Department 
        { dname      :: Name
        , manager   :: Manager
        , dus  :: [Department]
        , eus  :: [Employee]
        }
    deriving (Eq,Read,Show)
     
type Manager = Employee

data Employee = Employee 
        { ename      :: Name 
        , address   :: Address
        , salary    :: Salary
        }
    deriving (Eq,Read,Show)

type Name = String
type Address = String
type Salary = Float