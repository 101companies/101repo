{-# LANGUAGE DeriveDataTypeable #-}

module Company where

import Data.Typeable
import Data.Data

type Company = (Name, [Department])
data Department = Department Name Manager [SubUnit]
 deriving (Eq, Read, Show, Typeable, Data)
type Manager = Employee
data Employee = Employee Name Address Salary (Maybe Mentor)
 deriving (Eq, Read, Show, Typeable, Data)
data SubUnit = EUnit Employee | DUnit Department
 deriving (Eq, Read, Show, Typeable, Data)
type Mentor = Name
type Name = String
type Address = String
type Salary = Float
