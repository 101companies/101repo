module SampleCompany where

import Company

company = 
 ( "meganalysis"
 , [ Department "Research" 
      (Employee "Craig" "Redmond" 123456)
      [ EUnit (Employee "Erik" "Utrecht" 12345)
      , EUnit (Employee "Ralf" "Koblenz" 1234)
      ]
   , Department "Development"
      (Employee "Ray" "Redmond" 234567)
       [ DUnit (Department "Dev1"
             (Employee "Klaus" "Boston" 23456)
             [ DUnit (Department "Dev1.1"
                   (Employee "Karl" "Riga" 2345)
                   [ EUnit (Employee "Joe" "Wifi City" 2344)
                   ])
             ])
       ]
   ]
 )
