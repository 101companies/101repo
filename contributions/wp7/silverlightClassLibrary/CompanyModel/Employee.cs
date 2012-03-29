using System;
using System.ComponentModel;

namespace silverlightClassLibrary.CompanyModel
{
    public class Employee : EntityBase
    {
        public Employee()
        {
            Id = Guid.NewGuid();
        }
        public Employee(Person person) : this()
        {
            Person = person;
        }

        public Guid Id { get; private set; }

        private decimal _salary;
        public decimal Salary
        {
            get { return _salary; }
            set
            {
                _salary = value;
                RaisePropertyChanged("Salary");
            }
        }

        public void Cut()
        {
            Salary /= 2;
        }

        public Person Person { get; set; }

        public override bool Equals(object obj)
        {
            if (GetType() != obj.GetType()) return false;

            var c1 = obj as Employee;
            if (c1 == null) return false;

            return ((c1.Salary == Salary) && (c1.Person.Equals(Person)));
        }

        public override int GetHashCode()
        {
            unchecked
            {
                return (Salary.GetHashCode() * 397) ^ (Person != null ? Person.GetHashCode() : 0);
            }
        }
    }
}
