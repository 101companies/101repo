module Types where

-- list of log messages
type Log = [String] 

ppLog :: Log -> String
ppLog = concat.(map ((++) "\n"))

composeLog :: String -> String -> String -> String -> Int
composeLog p a c n o t =
  a ++ " " ++ a ++ " " ++ c ++ " \"" ++ n ++ "\" , " ++ o ++ " total = " ++ t      