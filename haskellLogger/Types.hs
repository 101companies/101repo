module Types where

-- list of log messages
type Log = [String] 

ppLog :: Log -> String
ppLog = concat.(map ((++) "\n")) 