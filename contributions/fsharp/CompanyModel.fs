namespace CompanyModel 
open System.Collections.Generic

    type Person() =
     class
        let mutable name = ""
        let mutable address = ""
        member this.Name with get() = name and set v = name <- v
        member this.Address with get() = address and set v = address <- v
    end

    type Employee(person:Person) =
     class
        let mutable salary = 0M
        member this.Salary with get() = salary and set v = salary <- v
        member this.Person with get() = person
    end

    type Department() =
     class
        let mutable name = ""
        let mutable manager= new Employee(new Person())
        let mutable employees = new List<Employee>()
        let mutable subUnits = new List<Department>()

        member this.Name with get() = name and set v = name <- v
        member this.Manager with get() = manager and set v = manager <- v
        member this.Employees with get() = employees and set v = employees <- v
        member this.SubUnits with get() = subUnits and set v = subUnits <- v
        
        member this.Cut =
            List.iter (fun (dept:Department) -> dept.Cut) (List.ofSeq subUnits)
            manager.Salary <- manager.Salary / 2M
            List.iter (fun (emp:Employee) -> emp.Salary <- emp.Salary / 2M) (List.ofSeq employees)
        
        member this.Total with get() =
         let total = manager.Salary
         let totalSubUnits = List.fold (fun (acc) (elem:Department) -> acc + elem.Total) total (List.ofSeq subUnits)
         let res = List.fold (fun (acc) (elem:Employee) -> acc + elem.Salary) totalSubUnits (List.ofSeq employees)
         res
   end

    type Company() = 
     class
       let mutable name = ""
       let mutable departments:List<Department> = new List<Department>()  
        
       member this.Name with get() = name and set v = name <- v
       member this.Departments with get() = departments and set v = departments <- v
       
       member this.TotalSalaries =
        let x = List.fold (fun (acc) (elem:Department) -> acc + elem.Total) 0M (List.ofSeq departments)
        x
      
       member this.CutSalaries = 
         List.iter (fun (dept:Department) -> dept.Cut) (List.ofSeq departments)
    end
