{-# LANGUAGE DeriveDataTypeable, StandaloneDeriving #-}

module Deriving where

import Company
import Data.Typeable
import Data.Data

deriving instance Eq Company
deriving instance Read Company
deriving instance Show Company
deriving instance Typeable Company
deriving instance Data Company

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

