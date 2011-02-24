module SampleCompany where

import Company

company = 
 ( "meganalysis"
 , [ Dept "Research" 
      (Employee "Craig" "Redmond" 123456)
      [ PU (Employee "Erik" "Utrecht" 12345)
      , PU (Employee "Ralf" "Koblenz" 1234)
      ]
   , Dept "Development"
      (Employee "Ray" "Redmond" 234567)
       [ DU (Dept "Dev1"
             (Employee "Klaus" "Boston" 23456)
             [ DU (Dept "Dev1.1"
                   (Employee "Karl" "Riga" 2345)
                   [ PU (Employee "Joe" "Wifi City" 2344)
                   ])
             ])
       ]
   ]
 )
