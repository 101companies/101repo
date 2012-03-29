#include "registry.h"

int rID = 0;
static Company* company;
static QVector<Department*> departments;
static QVector<Employee*> employees;

Registry::Registry(){}

void Registry::createNewID()
{
    rID++;
}

void Registry::init()
{
    rID = 0;
}

//Methods for Employees
void Registry::makeEntry(Employee &o)
{
    Employee* e = &o;
    employees.append(e);
    o.setID(rID);
    createNewID();
}

bool Registry::employeesContains(int iD)
{
    for(QVector<Employee*>::iterator it = employees.begin(); it != employees.end(); it++)
    {
        if((*it)->getID()==iD){
            return true;
        }
    }
    return false;
}

Employee* Registry::getCorrespondingEmployee(int iD)
{
    for(QVector<Employee*>::iterator it = employees.begin(); it != employees.end(); it++)
    {
        if((*it)->getID()==iD)
        {
            return (*it);
        }
    }
}

//Method required only for testing issues
void Registry::prettyPrint()
{
    for(QVector<Employee*>::iterator it = employees.begin(); it != employees.end(); it++)
    {
        cout<< (*it)->getName().toStdString() <<endl;
        cout<< (*it)->getID() << endl;
        cout<< (*it)->getSalary()<<endl;
    }
}

//Methods for Departments
void Registry::makeEntry(Department &o)
{
    Department* d = &o;
    departments.append(d);
    o.setID(rID);
    createNewID();
}

bool Registry::departmentsContains(int iD)
{
    for(QVector<Department*>::iterator it = departments.begin(); it != departments.end(); it++)
    {
        if((*it)->getID()==iD)
        {
            return true;
        }
    }
    return false;
}

Department* Registry::getCorrespondingDepartment(int iD)
{
    for(QVector<Department*>::iterator it = departments.begin(); it != departments.end(); it++)
    {
        if((*it)->getID()==iD)
        {
            return (*it);
        }
    }
}

//Methods for Companies
void Registry::makeEntry(Company &o)
{
    Company* d = &o;
    o.setID(rID);
    createNewID();
}

