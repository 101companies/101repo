module SampleCompany where

import Company

company = 
 ( "meganalysis"
 , [ Department "Research" 
      (Employee "Craig" "Redmond" 123456 Nothing)
      [ EUnit (Employee "Erik" "Utrecht" 12345 (Just "Craig"))
      , EUnit (Employee "Ralf" "Koblenz" 1234 (Just "Craig"))
      ]
   , Department "Development"
      (Employee "Ray" "Redmond" 234567 Nothing)
       [ DUnit (Department "Dev1"
             (Employee "Klaus" "Boston" 23456 (Just "Ray"))
             [ DUnit (Department "Dev1.1"
                   (Employee "Karl" "Riga" 2345 (Just "Klaus"))
                   [ EUnit (Employee "Joe" "Wifi City" 2344 (Just "Ray")) 
                   ])
             ])
       ]
   ]
 )
