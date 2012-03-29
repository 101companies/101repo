open Company;;

(* sample company meganalysis *)
let craig = employee "Craig" "Redmond" 123456.;;
let erik = employee "Erik" "Utrecht" 12345.;;
let ralf = employee "Ralf" "Koblenz" 1234.;;
let ray = employee "Ray" "Redmond" 234567.;;
let klaus = employee "Klaus" "Boston" 23456.;;
let karl = employee "Karl" "Riga" 2345.;;
let joe = employee "Joe" "Wifi City" 2344.;;

let research = department "Research" craig [erik; ralf] [];;
let dev11 = department "Dev11" karl [joe] [];;
let dev1 = department "Dev1" klaus [] [dev11];;
let development = department "Development" ray [] [dev1];;

let meganalysis = company "meganalysis" [research; development];;

