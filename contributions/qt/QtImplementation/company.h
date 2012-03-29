#include <QtGui>
#include <QtCore>
#include "Department.h"
#include "registry.h"
#include "companyobject.h"
#ifndef COMPANY_H
#define COMPANY_H

class Company : public CompanyObject
{

public:
    Company();
    Company(QString name);
    ~Company();

    void addDepartment(Department dep);

    QVector<Department> getDepartments();
    QString getName();
    void setName(QString name);

    QTreeWidgetItem* walkCompany();

    void cut();
    double total();

private:
    QString name;
    QVector<Department> departments;
};

#endif // COMPANY_H


