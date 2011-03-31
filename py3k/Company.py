#!/usr/bin/env python3

class Company:
    def __init__(self, name, depts):
        self.name = name
        self.depts = depts

    def cut(self):
        [dept.cut() for dept in self.depts]

    def total(self):
        return sum(dept.total() for dept in self.depts)

    def __eq__(self, other):
        return self.__dict__ == other.__dict__

class Employee:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary

    def cut(self):
        self.salary = self.salary / 2.0

    def total(self):
        return self.salary

    def __eq__(self, other):
        return self.__dict__ == other.__dict__

class Dept:
    def __init__(self, name, manager, subunits):
        self.name = name
        self.manager = manager
        self.subunits = subunits

    def cut(self):
        self.manager.cut()
        [subunit.cut() for subunit in self.subunits]

    def total(self):
        return self.manager.total() + sum(subunit.total() for subunit in self.subunits)

    def __eq__(self, other):
        return self.__dict__ == other.__dict__

