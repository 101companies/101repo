#include "company.h"

Company::Company(){}

Company::Company(QString name)
{
    this->name = name;
}

Company::~Company(){}

void Company::addDepartment(Department dep)
{
    this->departments.append(dep);
}

void Company::cut()
{
    for(QVector<Department>::iterator it = departments.begin(); it != departments.end(); it++)
    {
        it->cut();
    }
}

double Company::total()
{
    double total = 0.0;
    for(QVector<Department>::iterator it = departments.begin(); it != departments.end(); it++)
    {
        total += it->total();
    }
    return total;
}

QVector<Department> Company::getDepartments()
{
    return departments;
}

QString Company::getName()
{
    return name;
}

void Company::setName(QString name) {
    this->name = name;
}

QTreeWidgetItem* Company::walkCompany()
{
    QTreeWidgetItem *item = new QTreeWidgetItem();
    item->setText(0,name);

    //set CompanyId
    Registry::createNewID();

    for(QVector<Department>::iterator it = departments.begin(); it != departments.end(); it++)
    {
        QTreeWidgetItem *current = new QTreeWidgetItem();
        current->setText(0, it->getName());

        Registry::makeEntry(*it);
        QVariant iD = it->getID();
        it->setTypeInfo('d');
        current->setData(0,32,iD);

        item->addChild(current);
        it->walkDepartment(current);
    }
    return item;
}
