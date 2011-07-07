module Action where

-- data type for url action parameter data type 
data Action =
      View 
    | Cut
    | Save
        deriving (Show, Read)  