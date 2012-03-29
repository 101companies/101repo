#!/usr/bin/env python3

import unittest
import copy
import pickle
from Company import *

company = Company(
    name = "Meganalysis",
    depts = [
        Dept(
            name = "Research",
            manager = Employee(
                name = "Craig",
                salary = 123456.0
            ),
            subunits = [
                Employee(
                    name = "Erik",
                    salary = 12345.0
                ),
                Employee(
                    name = "Ralf",
                    salary = 1234.0
                )
            ]
        ),
        Dept(
            name = "Development",
            manager = Employee(
                name = "Ray",
                salary = 234567.0
            ),
            subunits = [
                Dept(
                    name = "Dev1",
                    manager = Employee(
                        name = "Klaus",
                        salary = 23456.0
                    ),
                    subunits = [
                        Dept(
                            name = "Dev1.1",
                            manager = Employee(
                                name = "Karl",
                                salary = 2345.0
                            ),
                            subunits = [
                                Employee(
                                    name = "Joe",
                                    salary = 2344.0
                                )
                            ]
                        )
                    ]
                )
            ]
        )            
    ]
)

class CompanyTest(unittest.TestCase):

    def test_cut_in_half(self):
        '''After a pay cut Meganalysis should pay half of what it paid before'''
        copycomp = copy.deepcopy(company)
        old_total = copycomp.total()
        copycomp.cut()
        self.assertEqual(copycomp.total(), old_total/2.0)

    def test_if_total_checks_out(self):
        '''Meganalysis Ltd. should pay a total of 3999747.0 to it's employees'''
        copycomp = copy.deepcopy(company)
        self.assertEqual(copycomp.total(), 399747.0)

    def test_if_serialization_works(self):
        '''The Company model should be properly pickled and unpickled'''
        self.assertEqual(pickle.loads(pickle.dumps(company)), company)

class EqualityTests(unittest.TestCase):
    def test_if_equals_works_for_employee(self):
        '''Structural equality should work for Employee'''
        self.assertEqual(Employee("Joe", 100.0), Employee("Joe", 100.0))
        self.assertNotEqual(Employee("Joe", 100.0), Employee("Bill", 150.0))

    def test_if_equals_works_for_dept(self):
        '''Structural equality should work for Dept'''
        d1 = Dept("Dev", Employee("Steve", 100.0), [])
        d2 = Dept("Dev", Employee("Steve", 100.0), [])
        d3 = Dept("Research", Employee("Woz", 100.0), [])
        self.assertEqual(d1, d2)
        self.assertNotEqual(d2, d3)

    def test_if_equals_works_for_company(self):
        '''Structural equality should work for Company'''
        self.assertEqual(Company("Foo", []), Company("Foo", []))
        self.assertNotEqual(Company("Foo", []), Company("Bar", []))

if __name__ == "__main__":
    unittest.main()
