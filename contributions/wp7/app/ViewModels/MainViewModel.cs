using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Collections.ObjectModel;
using System.Linq;
using silverlightClassLibrary;
using silverlightClassLibrary.CompanyModel;

namespace Wp7.ViewModels
{
    public class MainViewModel : INotifyPropertyChanged
    {
        public MainViewModel()
        {
            this.Company = new Company();
        }
        
        public Company Company { get; private set; }

        private static ObservableCollection<Department> GetAllDepartments(IEnumerable<Department> depts)
        {
            var allDepts = new ObservableCollection<Department>();

            foreach (var department in depts)
            {
                allDepts.Add(department);
                foreach (var subDepartment in GetAllDepartments(department.SubDepartments))
                {
                    allDepts.Add(subDepartment);
                }
            }

            return allDepts;
        }

        public ObservableCollection<Department> Departments
        {
            get { return this.Company.Departments; }
        }
        public ObservableCollection<Department> AllDepartments
        {
            get
            {
                var departments = GetAllDepartments(this.Company.Departments);
                return departments;
            }
        }

        public IEnumerable<Employee> AllEmployees
        {
            get
            {
                var empl = new List<Employee>();
                foreach (var dept in GetAllDepartments(this.Company.Departments))
                {
                    empl.AddRange(dept.Employees);
                }

                return empl;
            }
        }

        public string Name { get; private set; }
 
        public bool IsDataLoaded
        {
            get;
            private set;
        }

        /// <summary>
        /// Creates and adds a few ItemViewModel objects into the Items collection.
        /// </summary>
        public void LoadData()
        {
            var company = CompanyBuilder.CreateInMemoryModel();
            this.Company = company;
            this.Name = company.Name;

            this.IsDataLoaded = true;
        }

        public event PropertyChangedEventHandler PropertyChanged;
        private void NotifyPropertyChanged(String propertyName)
        {
            PropertyChangedEventHandler handler = PropertyChanged;
            if (null != handler)
            {
                handler(this, new PropertyChangedEventArgs(propertyName));
            }
        }
    }
}