#include <QtGui>
#include <QtCore>
#include "registry.h"
#include "companyobject.h"

#ifndef EMPLOYEE_H
#define EMPLOYEE_H

class Employee : public CompanyObject
{

public:
    Employee();
    Employee(QString name, QString address, double salary);

    void setName(QString name);
    void setAddress(QString address);

    QString getName();
    QString getAddress();
    double getSalary();

    void setSalary(double salary);

    void cut();

private:
    QString name;
    QString address;
    double salary;
};

#endif // EMPLOYEE_H
