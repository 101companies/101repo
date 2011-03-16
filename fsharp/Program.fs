open CompanyModel
open CompanyBuilder

let c = buildCompany

printfn "Company Name %A" c.Name
printf "%A" c.TotalSalaries
