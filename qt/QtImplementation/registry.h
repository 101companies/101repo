#ifndef REGISTRY_H
#define REGISTRY_H

#include "company.h"
#include "department.h"
#include "employee.h"
#include <Qvector>
#include <iostream>
#include "mainwindow.h"

using namespace std;

class Registry
{
public:
    Registry();

    static void init();

    static void createNewID();
    static void makeEntry (Employee &o);
    static void makeEntry(Department &o);
    static void makeEntry(Company &o);

    static Employee* getCorrespondingEmployee(int iD);
    static Department* getCorrespondingDepartment(int iD);

    static bool departmentsContains(int iD);
    static bool employeesContains(int iD);

    //required for testing issues only
    static void prettyPrint();

};

#endif // REGISTRY_H
