@license{
  Copyright (c) 2009-2011 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Bas Basten - Bas.Basten@cwi.nl (CWI)}
@contributor{Mark Hills - Mark.Hills@cwi.nl (CWI)}
module Example

import AST;

public Company exampleCompany = 
	company("meganalysis", {
		department("Research", manager(employee("Craig", "Redmond", 123456)), {}, {
			employee("Erik", "Utrecht", 12345)
		}),
		department("Development", manager(employee("Ray", "Redmond", 234567)), {
			department("Dev1", manager(employee("Chuck", "Redmond", 12345)), {}, {}),
			department("Dev2", manager(employee("Barry", "Redmond", 12345)), {}, {})
		}, {})
	}
);