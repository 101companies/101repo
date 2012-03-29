class Employee
  
  attr_accessor :person, :salary
  
  def total 
    salary
  end
  
  def cut
    self.salary = (salary / 2)
  end
end
