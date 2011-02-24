module meganalysis

imports company	

	var meganalysis := Company {
		name := "meganalysis"
		depts := List<Dept>(
			Dept {
				name := "Research"
				manager := Employee {
					name := "Craig"
					address := "Redmond"
					salary := 123456.0
				}
				employees := List<Employee>(
					Employee {
						name := "Erik"
						address := "Utrecht"
						salary := 12345.0
					}, 
					Employee {
						name := "Ralf"
						address := "Koblenz"
						salary := 1234.0
					}
					)
				subDepts := List<Dept>()}, 
			Dept {
				name := "Development"
				manager := Employee {
					name := "Ray"
					address := "Redmond"
					salary := 234567.0
				}
				employees := List<Employee>()
				subDepts := List<Dept>(
					Dept{
						name := "Dev 1"
						manager := Employee {
							name := "Klaus"
							address := "Boston"
							salary := 23456.0
						}
						employees := List<Employee>()
						subDepts := List<Dept>(
							Dept{
								name := "Dev 1.1"
								manager := Employee {
									name := "Karl"
									address := "Riga"
									salary := 2345.0
								}
								employees := List<Employee>(
									Employee{
										name := "Joe"
										address := "Wifi City"
										salary := 2344.0
									}
								)
								subDepts := List<Dept>()
							}
	
						)
					}
				)
			}
			)
	}