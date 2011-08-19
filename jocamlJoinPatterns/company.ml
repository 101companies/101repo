(************************************************************************
*
*  company.ml
*  101implementations
*
*  Created by Jan Baltzer
*
************************************************************************)

(* helper functions *)
let rec map f = function
    [] -> []
    | x::l -> (f x)::(map f l)
;;

let rec sum = function
    [] -> 0.
    | x::l -> x +. (sum l)
;;

(* top level functions, triggering the events*)
let applyCut (total, cut) = 
    (* asynchronous event *)
    spawn cut ();
    total, cut
;;

let applyTotal (total, _) =
    (* synchronous event *) 
    total ()
;;

(* definitions of the join patterns*)
let employee name address salary =
    (* join pattern for total *)
    def employeeState (n, a, s) & total () = 
        employeeState (n, a, s) & 
        reply s to total
    (* join pattern for cut *)
     or employeeState (n, a, s) & cut () = 
        employeeState (n, a, s *. 0.5) in
    (* spawn first internal channel *)
    spawn employeeState (name, address, salary);
    (* return external channels *) 
    total, cut
;;

let department name manager employees subdepts = 
    (* join pattern for total *)
    def deptState (n, m, es, ds) & total () = 
        deptState (n, m, es, ds) & 
        reply (sum (map applyTotal (m :: (es @ ds)))) to total
    (* join pattern for cut *)
     or deptState (n, m, es, ds) & cut () = 
        deptState (n, applyCut m, map applyCut es, map applyCut ds) in
    (* spawn first internal channel *)
    spawn deptState (name, manager, employees, subdepts);
    (* return external channels *)
    total, cut
;;

let company name depts = 
    (* join pattern for total *)
    def companyState (n, ds) & total () = 
            companyState (n, ds) & 
            reply (sum (map applyTotal ds)) to total
    (* join pattern for cut *)
     or companyState (n, ds) & cut () = 
            companyState (n, map applyCut ds) in
    (* spawn first internal channel *)
    spawn companyState (name, depts);
    (* return external channels *)
    total, cut
;;