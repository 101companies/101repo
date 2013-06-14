module Data where

-- Simple arithmetic expressions
data Expr = Const Int | Add Expr Expr
