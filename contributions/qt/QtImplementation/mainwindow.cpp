
#include "mainwindow.h"

#include <iostream>
using namespace std;

int activeID = -1;

Company MainWindow::createCompany()
{
    Registry::init();

    Company company("Meganalysis");

    Department dep1("Research");
    Department dep2("Development");
    Department dep2_1("Dev1");
    Department dep2_2("Dev2");

    Employee craig("Craig", "Redmond",123456);
    Employee erik("Erik","Utrecht",12345);
    Employee ralf("Ralf","Koblenz",1234);

    Employee ray("Ray","Redmond",234567);

    Employee klaus("Klaus","Boston",23456);

    Employee karl("Karl","Riga",2345);
    Employee joe("Joe","Wifi City",2344);

    dep1.setManager(craig);
    dep1.addEmployee(erik);
    dep1.addEmployee(ralf);

    dep2.setManager(ray);
    dep2_1.setManager(klaus);
    dep2_2.setManager(karl);
    dep2_2.addEmployee(joe);
    dep2.addSubDepartment(dep2_1);
    dep2.addSubDepartment(dep2_2);

    company.addDepartment(dep1);
    company.addDepartment(dep2);

    return company;
}


/**
  *First view
  */
MainWindow::MainWindow(QWidget *parent) :  QMainWindow(parent), ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    //Create the company structure
    company = createCompany();


    ui -> CompanyNameField -> setText (company.getName());

    //Startview
    ui -> DepartmentWidget -> hide();
    ui -> EmployeeWidget -> hide();

    //compute Total
    double total = company.total();
    QString totalString = QString::number(total,'f',2);
    ui -> TotalCompanyField -> setText(totalString);

    //create tree from company object
    QTreeWidgetItem *tree = company.walkCompany();
    ui->TreeWidget->addTopLevelItem(tree);
}

/**
  *Cut company
  */
void MainWindow::on_CutTotalCompanyButton_clicked()
{
    company.cut();
    double total = company.total();
    QString totalString = QString::number(total,'f',2);
    ui -> TotalCompanyField -> setText(totalString);
    on_TreeWidget_itemClicked(ui -> TreeWidget -> currentItem(), 0);
}

/**
  *Select element in QTreeWidget
  */
void MainWindow::on_TreeWidget_itemClicked(QTreeWidgetItem *item, int column)
{

    QVariant variant = item->data(0, 32);
    bool* ok = 0;
    int iD = variant.toDouble(ok);
    activeID = iD;

    //select Employee Element
    if(Registry::employeesContains(activeID))
    {
        ui->DepartmentWidget->hide();
        ui->EmployeeWidget->show();
        ui->EmployeeNameField->setText(item->text(0));

        //set EmployeeSalarayField
        Employee *current = Registry::getCorrespondingEmployee(activeID);
        double salary = current->getSalary();
        QString salaryString = QString::number(salary,'f',2);
        ui->EmployeeSalaryField->setText(salaryString);

        //set EmployeeAddressField
         ui->EmployeeAddressField->setText(current->getAddress());
    }
     //select Department Element
    else if (Registry::departmentsContains(activeID))
        {
            ui->EmployeeWidget->hide();

            //set DepartmentTotalField
            Department *current = Registry::getCorrespondingDepartment(activeID);
            double salary = current->total();
            QString salaryString = QString::number(salary,'f',2);
            ui->DepartmentTotalField->setText(salaryString);
            ui->DepartmentWidget->show();
            ui->DepartmentNameField->setText(item->text(0));

            //set ManagerNameField
            double managerId = (current->getID())+1;
            Employee *manager =  Registry::getCorrespondingEmployee(managerId);
            ui->ManagerNameField->setText(manager->getName());
        }
        else
        {
            ui->EmployeeWidget->hide();
            ui->DepartmentWidget->hide();
        }
}

/**
  *Cut Employee
  */
void MainWindow::on_EmployeeCutButton_clicked()
{
    //Cut salary
    if(Registry::employeesContains(activeID))
    {
        Employee* current = Registry::getCorrespondingEmployee(activeID);
        current->cut();
        //Update EmployeeSalarayField
        double salary = current->getSalary();
        QString salaryString = QString::number (salary, 'f', 2);
        ui->EmployeeSalaryField ->setText(salaryString);
    }
    //Update CompanyTotalField
    double total = company.total();
    QString totalString = QString::number(total,'f',2);
    ui -> TotalCompanyField -> setText(totalString);
}

/**
  *Cut Department
  */
void MainWindow::on_DepartmentCutButton_clicked()
{
    //Cut Departments
    if(Registry::departmentsContains(activeID))
    {
        Department* current = Registry::getCorrespondingDepartment(activeID);
        current->cut();
        //Update DepartmentSalarayField
        double salary = current->total();
        QString salaryString = QString::number (salary, 'f', 2);
        ui->DepartmentTotalField ->setText(salaryString);
    }

    //Update CompanyTotalField
    double total = company.total();
    QString totalString = QString::number(total,'f',2);
    ui -> TotalCompanyField -> setText(totalString);
}

void MainWindow::on_CompanySaveButton_clicked()
{
    // company rename
    company.setName(ui -> CompanyNameField -> text());

    // update tree
    ui -> TreeWidget -> clear();

    QTreeWidgetItem *tree = company.walkCompany();
    ui -> TreeWidget -> addTopLevelItem(tree);
}

void MainWindow::on_DepartmentSaveButton_clicked()
{
    // department rename
    if(Registry::departmentsContains(activeID))
    {
        Department* current = Registry::getCorrespondingDepartment(activeID);
        current -> setName(ui -> DepartmentNameField -> text());

        // update tree
        ui -> TreeWidget -> clear();

        QTreeWidgetItem *tree = company.walkCompany();
        ui -> TreeWidget -> addTopLevelItem(tree);
    }
}

void MainWindow::on_EmployeeSaveButton_clicked()
{
    // department rename
    if(Registry::employeesContains(activeID))
    {
        Employee* current = Registry::getCorrespondingEmployee(activeID);
        current -> setName(ui -> EmployeeNameField -> text());
        current -> setAddress(ui -> EmployeeAddressField -> text());
        current -> setSalary((ui -> EmployeeSalaryField -> text()).toDouble());

        // update tree
        ui -> TreeWidget -> clear();

        QTreeWidgetItem *tree = company.walkCompany();
        ui -> TreeWidget -> addTopLevelItem(tree);

        // update total
        double total = company.total();
        QString totalString = QString::number(total,'f',2);
        ui -> TotalCompanyField -> setText(totalString);
    }
}

/*
 *Possible additional features..
 */

/**
  *Set Manager
  */
//Yet missing...

/**
  *Employee set Salary
  */
//Yet missing...


MainWindow::~MainWindow()
{
    delete ui;
}
