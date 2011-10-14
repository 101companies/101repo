-- By Martijn van Steenbergen
-- 7 July 2011, 23h00
-- GTTSE 2011, Braga, Portugal

module Parser where

import Company

import Control.Applicative hiding (many, (<|>))
import Text.Parsec


parseCompany :: String -> Either ParseError Company
parseCompany = runP (spaces *> pCompany <* eof) () 
               "input"

type P = Parsec String ()


-- Primitives

pString :: String -> P String
pString s = string s <* spaces

pLit :: P String
pLit = string "\"" *> many (noneOf "\"") <* string "\"" <* spaces

pFloat :: P Float
pFloat = read <$> some (digit <|> char '.') <* spaces


-- Company-related parsers

pCompany :: P Company
pCompany = (,)
  <$  pString "company" <*> pLit
  <*  pString "{" <*> many pDepartment <* pString "}"

pDepartment :: P Department
pDepartment = Department
  <$  pString "department" <*> pLit
  <*  pString "{" <*> pEmployee "manager"
  <*> many pSubUnit <* pString "}"

pEmployee :: String -> P Manager
pEmployee ty = Employee
  <$  pString ty <*> pLit
  <*  pString "{" <* pString "address" <*> pLit
  <*  pString "salary" <*> pFloat
  <*> optionMaybe (pString "mentor" *> pLit) <* pString "}"

pSubUnit :: P SubUnit
pSubUnit = EUnit <$> pEmployee "employee"
       <|> DUnit <$> pDepartment
