#include "department.h"
#include <iostream>

using namespace std;

Department::Department(){}

Department::Department(QString name)
{
    this->name = name;
}

void Department::addEmployee(Employee e)
{
    this->employees.append(e);
}

void Department::addSubDepartment(Department d)
{
    this->subdepartments.append(d);
}

void Department::setManager(Employee e)
{
    this->manager = e;
}

Employee Department::getManager()
{
    return manager;
}

void Department::setName(QString name)
{
    this->name = name;
}

QString Department::getName()
{
    return name;
}

QVector<Employee> Department::getEmployees()
{
    return employees;
}

QVector<Department> Department::getDepartments()
{
    return subdepartments;
}

void Department::cut()
{
    manager.cut();

    for(QVector<Employee>::iterator it = employees.begin(); it != employees.end(); it++)
    {
        it->cut();
    }

    for(QVector<Department>::iterator it = subdepartments.begin(); it != subdepartments.end(); it++)
    {
        it->cut();
    }
}

double Department::total()
{
    double total = 0.0;

    total += manager.getSalary();

    for(QVector<Employee>::iterator it = employees.begin(); it != employees.end(); it++)
    {
        total += it->getSalary();
    }

    for(QVector<Department>::iterator it = subdepartments.begin(); it != subdepartments.end(); it++)
    {
        total += it->total();
    }
    return total;
}

void Department::walkDepartment(QTreeWidgetItem* parent)
{

    QTreeWidgetItem *current = new QTreeWidgetItem();
    current->setText(0,manager.getName());

    Registry::makeEntry(manager);
    QVariant iD = manager.getID();
    manager.setTypeInfo('e');
    current->setData(0,32,iD);

    parent->addChild(current);

    for(QVector<Employee>::iterator it = employees.begin(); it != employees.end(); it++)
    {
        QTreeWidgetItem *current = new QTreeWidgetItem();
        current->setText(0,it->getName());
        Registry::makeEntry(*it);
        QVariant iD = it->getID();
        it->setTypeInfo('e');
        current->setData(0,32,iD);

        parent->addChild(current);

  }
    for(QVector<Department>::iterator it = subdepartments.begin(); it != subdepartments.end(); it++)
    {
        QTreeWidgetItem *current = new QTreeWidgetItem();
        current->setText(0,it->getName());

        Registry::makeEntry(*it);
        QVariant iD = it->getID();
        it->setTypeInfo('d');
        current->setData(0,32,iD);

        parent->addChild(current);
        it->walkDepartment(current);
    }
}
