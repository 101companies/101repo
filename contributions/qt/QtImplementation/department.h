#include <QtGui>
#include <QtCore>
#include "employee.h"
#include "registry.h"
#include "companyobject.h"


#ifndef DEPARTMENT_H
#define DEPARTMENT_H
class Department : public CompanyObject
{

public:
    Department();
    Department(QString name);

    void addEmployee(Employee e);
    void addSubDepartment(Department d);
    void setManager(Employee e);

    Employee getManager();
    void setName(QString name);
    QString getName();
    QVector<Employee> getEmployees();
    QVector<Department> getDepartments();

    void walkDepartment(QTreeWidgetItem* parent);

    void cut();
    double total();

private:
    QString name;
    Employee manager;
    QVector<Employee> employees;
    QVector<Department> subdepartments;
};


#endif // DEPARTMENT_H
