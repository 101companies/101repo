@license{
  Copyright (c) 2009-2011 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Bas Basten - Bas.Basten@cwi.nl (CWI)}
@contributor{Mark Hills - Mark.Hills@cwi.nl (CWI)}
@contributor{Paul Klint - Paul.Klint@cwi.nl - CWI}
module ide::Visualize

import AST;

import vis::Figure;
import vis::Render;

private str getId(company(str n,_)) = "c_" + n;
private str getId(department(str n, _, _)) = "d_" + n;
private str getId(manager(employee(str n, _))) = "m_" + n;
private str getId(employee(str n,_)) = "e_" + n;

private Figure getBox(Company c:company(str n,_)) = box(text(n), vis::Figure::id(getId(c)), fillColor("red"));
private Figure getBox(Department d:department(str n, _, _)) = box(text(n), vis::Figure::id(getId(d)), fillColor("orange"));
private Figure getBox(Employee m:manager(employee(str n, _))) = box(text(n), vis::Figure::id(getId(m)), fillColor("yellow"), size(getSalary(m) / 1000));
private Figure getBox(Employee e:employee(str n,_)) = box(text(n), vis::Figure::id(getId(e)), fillColor("white"), size(getSalary(e) / 1000));

private int getSalary(manager(Employee e)) = getSalary(e);
private int getSalary(employee(_,[*_,intProp("salary",v),*_])) = v;
private default int getSalary(_) { throw "Can only call getSalary on managers or employees with a salary property"; }

public Figure company2Tree(Company c) {
	Figure toTree(Company c) {
		return tree(getBox(c),[toTree(d) | d <- c.deps], gap(20));
	}
	
	Figure toTree(Department d) {
		return tree(getBox(d),[toTree(dsub) | dsub <- d.deps] + [toTree(e) | e <- d.empls], gap(20));
	}
	
	Figure toTree(Employee e) {
		return getBox(e);
	}
	
	return toTree(c);
}

public void render(Company c) {
	render(company2Tree(c));
}