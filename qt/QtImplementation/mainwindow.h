
#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QtGui>
#include <QWidget>
#include <vector>
#include <QTreeWidget>
#include "company.h"
#include "mainwindow.h"
#include "ui_mainwindow.h"
#include "company.h"
#include "companyobject.h"
#include "registry.h"

namespace Ui {
    class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();
    Company createCompany();

private slots:

    void on_CutTotalCompanyButton_clicked();

    void on_TreeWidget_itemClicked(QTreeWidgetItem *item, int column);

    void on_EmployeeCutButton_clicked();

    void on_DepartmentCutButton_clicked();

    void on_CompanySaveButton_clicked();

    void on_DepartmentSaveButton_clicked();

    void on_EmployeeSaveButton_clicked();


private:
    Ui::MainWindow *ui;
    Company company;
};

#endif // MAINWINDOW_H
