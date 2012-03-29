module Types where

import Happstack.Server (FromReqURI(..))

import Focus
import Company

data EName = NameE | AddressE | SalaryE
  deriving Eq
type ENames = [EName] 

-- validating 'a' by maybe a validation error name/message pair
type Validation a  = Company -> Focus -> a -> Maybe (ENames,String)
-- many validators by means of multiple error messages
type Validations a = Company -> Focus -> a -> Maybe [(ENames,String)] 

-- view data type
data View   = CompanyV | DeptV | EmployeeV
  deriving Show
  
-- action data type
data Action = View | Cut | Save
  deriving (Show, Read)

-- read action from URI
instance FromReqURI Action where
  fromReqURI a = Just $ read a

-- read view from URI  
instance FromReqURI View where
  fromReqURI v =
    case v of                                                    
      "Company" -> Just CompanyV
      "Department" -> Just DeptV
      "Employee" -> Just EmployeeV
      _          -> Nothing

-- read focus from URI
instance FromReqURI Focus where
  fromReqURI f = Just $ read f  