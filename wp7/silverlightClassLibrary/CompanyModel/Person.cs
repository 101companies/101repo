namespace silverlightClassLibrary.CompanyModel
{
    public class Person
    {
        public Person() {}
        public Person(string name)
        {
            Name = name;
        }
        public string Name { get; set; }
        public string Address { get; set; }

        public override bool Equals(object obj)
        {
            if (GetType() != obj.GetType()) return false;

            var c1 = obj as Person;
            if (c1 == null) return false;

            return ((c1.Name == Name) && (c1.Address == Address));
        }

        public override int GetHashCode()
        {
            unchecked
            {
                return ((Name != null ? Name.GetHashCode() : 0) * 397) ^ (Address != null ? Address.GetHashCode() : 0);
            }
        }
    }
}
