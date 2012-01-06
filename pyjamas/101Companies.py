import pyjd # this is dummy in pyjs.
from pyjamas.ui.RootPanel import RootPanel
from pyjamas.ui.Button import Button
from pyjamas.ui.Label import Label
from pyjamas.ui.Grid import Grid
from pyjamas.ui.TextBox import TextBox
from pyjamas.ui.ListBox import ListBox
from pyjamas.ui.AbsolutePanel import AbsolutePanel

import pygwt

# ------------------------------------------------------
# ---------------- 101Companies classes ----------------
# ------------------------------------------------------

class Company:
	def __init__(self, id = 0, name = "", departments = []):
		self.id = id
		self.name = name
		self.departments = departments
		
	def total(self):
		total = 0
		for department in self.departments:
			total += department.total()
		return total
	
	def cut(self):
		for department in self.departments:
			department.cut()
	
	def save(self, name):
		self.name = name
		
class Department:
	def __init__(self, id = 0, name = "", departments = [], employees = []):
		self.id = id
		self.name = name
		self.departments = departments
		self.employees = employees
		
	def total(self):
		total = 0
		for employee in self.employees:
			total += employee.total()
		for department in self.departments:
			total += department.total()
		return total
	
	def cut(self):
		for employee in self.employees:
			employee.cut()
		for department in self.departments:
			department.cut()
	
	def save(self, name):
		self.name = name
		
	def getManager(self):
		for employee in self.employees:
			if employee.manager == 1:
				return employee
		
class Employee:
	def __init__(self, id = 0, name = "", address = "", salary = 0, manager = 0):
		self.id = id
		self.name = name
		self.address = address
		self.salary = salary
		self.manager = manager
		
	def total(self):
		return self.salary
	
	def cut(self):
		self.salary = self.salary / 2
		
	def save(self, name, address, salary):
		self.name = name
		self.address = address
		self.salary = salary

# ------------------------------------------------------
# ------------------ init application ------------------
# ------------------------------------------------------
	
class CompaniesApp:
	def __init__(self):
	
		craig = Employee(1, "Craig", "Redmond", 123456, 1)
		ray = Employee(2, "Ray", "Redmond", 234567, 1)
		klaus = Employee(3, "Klaus", "Boston", 23456, 1)
		karl = Employee(4, "Karl", "Riga", 2345, 1)
		erik = Employee(5, "Erik", "Utrecht", 12345, 0)
		ralf = Employee(6, "Ralf", "Koblenz", 1234, 0)
		joe = Employee(7, "Joe", "Wifi City", 2344, 0)
		
		self.employees = set([craig, ray, klaus, karl, erik, ralf, joe])

		dev11 = Department(1, "Dev1.1", [], [karl, joe])
		dev1 = Department(2, "Dev1", [dev11], [klaus])
		research = Department(3, "Research", [], [craig, erik, ralf])
		development = Department(4, "Development", [dev1], [ray])
		
		self.departments = set([dev11, dev1, research, development])
	
		self.company = Company(1, "meganalysis", [research, development])
		
	def cutCompany(self):
		self.company.cut()	

	def getDepartment(self, index):
		for item in self.departments:
			if item.id == index:
				return item
				
	def getEmployee(self, index):
		for item in self.employees:
			if item.id == index:
				return item
		
class CompaniesAppGUI(AbsolutePanel):
	def __init__(self):
		AbsolutePanel.__init__(self)
		
		self.app = CompaniesApp()
		
		self.history = []
		
		self.save = Button("save", self)
		self.selectDepartment = Button("select", self)
		self.selectEmployee = Button("select", self)
		self.edit = Button("edit", self)
		self.cut = Button("cut", self)
		self.back = Button("back", self)
		
		self.name = TextBox()
		self.address = TextBox()
		self.manager = TextBox()
		self.departments = ListBox(Size=("100%"), VisibleItemCount="5")
		self.employees = ListBox(Size=("100%"), VisibleItemCount="5")
		self.total = TextBox()
		
		self.grid = Grid()
		self.add(self.grid)
		
		self.initCompanyGUI()
		
	def onClick(self, sender):
		if sender == self.cut:
			self.current.cut()
			self.total.setText(self.current.total())
		if sender == self.save:
			if self.current.__class__.__name__ == "Employee":
				self.current.save(self.name.getText(), self.address.getText(), float(self.total.getText()))
			else:
				self.current.save(self.name.getText())
		if sender == self.selectDepartment:
			if (self.departments.getSelectedIndex() > -1):
				self.history.append(self.current)
				self.current = self.app.getDepartment(self.departments.getValue(self.departments.getSelectedIndex()))
				self.initDepartmentGUI()
		if sender == self.selectEmployee:
			if (self.employees.getSelectedIndex() > -1):
				self.history.append(self.current)
				self.current = self.app.getEmployee(self.employees.getValue(self.employees.getSelectedIndex()))
				self.initEmployeeGUI()
		if sender == self.edit:
			self.history.append(self.current)
			self.current = self.current.getManager()
			self.initEmployeeGUI()
		if sender == self.back:
			if len(self.history) > 0:
				self.current = self.history.pop()
				if self.current.__class__.__name__ == "Company":
					self.initCompanyGUI()
				else:
					self.initDepartmentGUI()
			
	def initCompanyGUI(self):
		self.current = self.app.company
	
		self.grid.clear()
		self.grid.resize(4, 3)
		
		# row 1
		self.grid.setWidget(0, 0, Label("Name:"))
		self.grid.setWidget(1, 0, Label("Department:"))
		self.grid.setWidget(2, 0, Label("Total:"))
		
		# row 2
		self.grid.setWidget(0, 1, self.name)
		self.grid.setWidget(1, 1, self.departments)
		self.grid.setWidget(2, 1, self.total)

		# row 3
		self.grid.setWidget(0, 2, self.save)
		self.grid.setWidget(1, 2, self.selectDepartment)
		self.grid.setWidget(2, 2, self.cut)
		
		self.name.setText(self.current.name)
		self.departments.clear()
		for item in self.current.departments:
			self.departments.addItem(item.name, item.id)
		if self.departments.getItemCount() > 0:
			self.departments.setSelectedIndex(0)
		self.total.setText(self.current.total())
		
	def initDepartmentGUI(self):	
		self.grid.clear()
		self.grid.resize(6, 3)
		
		# row 1
		self.grid.setWidget(0, 0, Label("Name:"))
		self.grid.setWidget(1, 0, Label("Manager:"))
		self.grid.setWidget(2, 0, Label("Department:"))
		self.grid.setWidget(3, 0, Label("Employee:"))
		self.grid.setWidget(4, 0, Label("Total:"))
		
		# row 2
		self.grid.setWidget(0, 1, self.name)
		self.grid.setWidget(1, 1, self.manager)
		self.grid.setWidget(2, 1, self.departments)
		self.grid.setWidget(3, 1, self.employees)
		self.grid.setWidget(4, 1, self.total)

		# row 3
		self.grid.setWidget(0, 2, self.save)
		self.grid.setWidget(1, 2, self.edit)
		self.grid.setWidget(2, 2, self.selectDepartment)
		self.grid.setWidget(3, 2, self.selectEmployee)
		self.grid.setWidget(4, 2, self.cut)
		
		# back
		self.grid.setWidget(5, 2, self.back)
		
		self.name.setText(self.current.name)
		self.departments.clear()
		self.employees.clear()
		for item in self.current.departments:
			self.departments.addItem(item.name, item.id)
		if self.departments.getItemCount() > 0:
			self.departments.setSelectedIndex(0)
		for item in self.current.employees:
			if item.manager == 0:
				self.employees.addItem(item.name, item.id)
			else:
				self.manager.setText(item.name)
		if self.employees.getItemCount() > 0:
			self.employees.setSelectedIndex(0)
		self.total.setText(self.current.total())
		
	def initEmployeeGUI(self):
		self.grid.clear()
		self.grid.resize(4, 3)
		
		# row 1
		self.grid.setWidget(0, 0, Label("Name:"))
		self.grid.setWidget(1, 0, Label("Address:"))
		self.grid.setWidget(2, 0, Label("Salary:"))
		
		# row 2
		self.grid.setWidget(0, 1, self.name)
		self.grid.setWidget(1, 1, self.address)
		self.grid.setWidget(2, 1, self.total)
		
		# row 3
		self.grid.setWidget(0, 2, self.save)
		self.grid.setWidget(2, 2, self.cut)
		self.grid.setWidget(3, 2, self.back)
		
		self.name.setText(self.current.name)
		self.address.setText(self.current.address)
		self.total.setText(self.current.salary)
		
pyjd.setup("public/101Companies.html")
gui = CompaniesAppGUI()
RootPanel().add(gui)
pyjd.run()