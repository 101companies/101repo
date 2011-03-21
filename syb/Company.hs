{-# LANGUAGE DeriveDataTypeable #-}

module Company where

import Data.Typeable
import Data.Data

type Company = (Name, [Dept])
data Dept = Dept Name Manager [SubUnit]
 deriving (Eq, Read, Show, Typeable, Data)
type Manager = Employee
data Employee = Employee Name Address Salary
 deriving (Eq, Read, Show, Typeable, Data)
data SubUnit = PU Employee | DU Dept
 deriving (Eq, Read, Show, Typeable, Data)
type Name = String
type Address = String
type Salary = Float
