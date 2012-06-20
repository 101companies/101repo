{-# LANGUAGE DeriveDataTypeable, StandaloneDeriving #-}

module Company where

import Data.Typeable
import Data.Data

type Company = (Name, [Department])
data Department = Department Name Manager [SubUnit]
data Employee = Employee Name Address Salary (Maybe Mentor)
data SubUnit = EUnit Employee | DUnit Department
type Manager = Employee
type Mentor = Name
type Name = String
type Address = String
type Salary = Float

deriving instance Eq Department
deriving instance Read Department
deriving instance Show Department
deriving instance Typeable Department
deriving instance Data Department

deriving instance Eq Employee
deriving instance Read Employee
deriving instance Show Employee
deriving instance Typeable Employee
deriving instance Data Employee

deriving instance Eq SubUnit
deriving instance Read SubUnit
deriving instance Show SubUnit
deriving instance Typeable SubUnit
deriving instance Data SubUnit
