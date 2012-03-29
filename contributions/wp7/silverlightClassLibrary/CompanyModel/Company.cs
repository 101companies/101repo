using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Linq;

namespace silverlightClassLibrary.CompanyModel
{
    public class Company : EntityBase
    {
        public Company()
        {
            Departments = new ObservableCollection<Department>();
            Departments.CollectionChanged += DepartmentsCollectionChanged;
        }

        void DepartmentsCollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
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

        public string Name { get; set; }
        public ObservableCollection<Department> Departments { get; private set; }

        public void Cut()
        {
            foreach (var dept in Departments)
            {
                   dept.Cut(); 
            }
        }

        public decimal Total
        {
            get
            {
                return Departments.Sum(dept => dept.Total);
            }
        }

        public int Depth
        {
            get
            {
                var depth = 0;
                foreach (var department in Departments.Where(department => department.Depth > depth))
                {
                    depth = department.Depth;
                }

                return depth;
            }
        }

        public override bool Equals(object obj)
        {
            if(GetType() != obj.GetType()) return false;

            var c1 = obj as Company;
            if (c1 == null) return false;

            foreach (var department in Departments)
            {
                if (!c1.Departments.Contains(department)) return false;
            }

            return ((c1.Name == Name) && (c1.Total == Total));
        }

        public override int GetHashCode()
        {
            unchecked
            {
                return ((Name != null ? Name.GetHashCode() : 0) * 397) ^ (Departments != null ? Departments.GetHashCode() : 0);
            }
        }
    }
}
