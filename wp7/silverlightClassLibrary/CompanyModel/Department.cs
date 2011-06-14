using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Linq;

namespace silverlightClassLibrary.CompanyModel
{
    public class Department : EntityBase
    {
        public Guid Id { get; private set; }

        public Department()
        {
            Id = Guid.NewGuid();
            SubDepartments = new ObservableCollection<Department>();
            Employees = new ObservableCollection<Employee>();

            Employees.CollectionChanged += CollectionChanged;
            SubDepartments.CollectionChanged += CollectionChanged;
        }

        void CollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
        {
            if ((e.Action == NotifyCollectionChangedAction.Add) || (e.Action == NotifyCollectionChangedAction.Replace))
            {
                foreach (Department item in e.NewItems)
                {
                    item.PropertyChanged += ItemPropertyChanged;
                }
                RaisePropertyChanged("Total");
            }
        }

        void ItemPropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            if (e.PropertyName == "Total")
            {
                RaisePropertyChanged("Total");
            }
        }

        public Department(string name, Employee manager) : this()
        {
            Name = name;
            Manager = manager;
        }

        public string Name { get; set; }

        private Employee _manager;
        public Employee Manager 
        {
            get { return _manager; }
            set
            {
                if (value == null) return;
                
                value.PropertyChanged += (s, e) =>
                                             {
                                                 if (e.PropertyName == "Salary")
                                                 {
                                                     RaisePropertyChanged("Total");
                                                 }
                                             };
                _manager = value;
            } 
        }

        public ObservableCollection<Employee> Employees { get; set; }
        public ObservableCollection<Department> SubDepartments { get; set; }

        /// <summary>
        /// Total all salaries in a department and subdepartments. 
        /// </summary>
        public decimal Total
        {
            get
            {
                return Manager.Salary + SubDepartments.Sum(department => department.Total) + Employees.Sum(employee => employee.Salary);
            }
        }

        /// <summary>
        /// Cut all salaries in half in department and subdepartments. 
        /// </summary>
        public void Cut()
        {
            foreach (var department in SubDepartments)
            {
                department.Cut();
            }

            Manager.Cut();

            foreach (var employee in Employees)
            {
               employee.Cut();
            }
        }

        /// <summary>
        /// Determine depth of department nesting. 
        /// </summary>
        public int Depth
        {
            get
            {
                var depth = 1;
                if (SubDepartments.Count > 0)
                {
                    var subDepth = 0;
                    foreach (var subUnit in SubDepartments)
                    {
                        if (subUnit.Depth > subDepth)
                        {
                            subDepth += subUnit.Depth;  
                        }
                    }

                    depth += subDepth;
                }

                return depth;
            }
        }

        public override bool Equals(object obj)
        {
            if (GetType() != obj.GetType()) return false;

            var c1 = obj as Department;
            if (c1 == null) return false;

            foreach (var employee in Employees)
            {
                if (!c1.Employees.Contains(employee)) return false;
            }
            foreach (var subUnit in SubDepartments)
            {
                if (c1.SubDepartments.Contains(subUnit)) return false;
            }
            return ((c1.Name == Name) && (c1.Manager.Equals(Manager)));
        }

        public override int GetHashCode()
        {
            unchecked
            {
                int result = (Name != null ? Name.GetHashCode() : 0);
                result = (result*397) ^ (Manager != null ? Manager.GetHashCode() : 0);
                result = (result*397) ^ (Employees != null ? Employees.GetHashCode() : 0);
                result = (result*397) ^ (SubDepartments != null ? SubDepartments.GetHashCode() : 0);
                return result;
            }
        }
    }
}
