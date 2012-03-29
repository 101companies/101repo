#include "employee.h"

Employee::Employee(){
    Employee("unknown","unknown",0.0);
}

Employee::Employee(QString name, QString address, double salary)
{
    this->address = address;
    this->name = name;
    this->salary = salary;
}

QString Employee::getName()
{
    return name;
}

void Employee::setName(QString name)
{
    this->name = name;
}

QString Employee::getAddress()
{
    return address;
}

void Employee::setAddress(QString address)
{
    this->address = address;
}

double Employee::getSalary()
{
    return salary;
}

void Employee::setSalary(double salary)
{
    this->salary = salary;
}

void Employee::cut()
{
    this->salary = salary/2.0;
}
