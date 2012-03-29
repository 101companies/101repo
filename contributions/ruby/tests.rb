require 'company/company.rb'
require 'company/dept.rb'
require 'company/subunit.rb'
require 'company/person.rb'
require 'company/employee.rb'
require "test/unit"

class Tests< Test::Unit::TestCase
  
  
  def setup
    @sampleCompany = Company.new
    @sampleCompany.name = "megaanalysis"
    @sampleCompany.topDepts = []
    
    research = Dept.new
    research.name = "Research"
    research.subunits = []
    
    craig = Person.new
    craig.name = "Craig"
    craig.address = "Redmond"   
    craigE = Employee.new
    craigE.person = craig
    craigE.salary = 123456.0
    research.manager = craigE
    
    erik = Person.new
    erik.name = "Erik"
    erik.address = "Utrecht"
    erikE = Employee.new
    erikE.person = erik
    erikE.salary = 12345.0
    researchS1 = Subunit.new
    researchS1.pu = erikE
    research.subunits << researchS1
    
    ralf = Person.new
    ralf.name = "Ralf"
    ralf.address = "Koblenz"
    ralfE = Employee.new
    ralfE.person = ralf
    ralfE.salary = 1234.0
    researchS2 = Subunit.new
    researchS2.pu = ralfE
    research.subunits << researchS2
    
    development = Dept.new
    development.name = "Development"
    development.subunits= []
    
    ray = Person.new
    ray.name = "Ray"
    ray.address = "Redmond"
    rayE = Employee.new
    rayE.person = ray
    rayE.salary = 234567.0
    development.manager = rayE
    
    dev1 = Dept.new
    dev1.name = "Dev1"
    dev1.subunits = []
    
    klaus = Person.new
    klaus.name = "Klaus"
    klaus.address = "Boston"
    klausE = Employee.new
    klausE.person = klaus
    klausE.salary = 23456.0
    dev1.manager = klausE
    
    
    dev11 = Dept.new
    dev11.name = "Dev1.1"
    dev11.subunits = []
    
    karl = Person.new
    karl.name = "Karl"
    karl.address = "Riga"
    karlE = Employee.new
    karlE.person = karl
    karlE.salary = 2345.0
    dev11.manager = karlE
    
    joe = Person.new
    joe.name = "Joe"
    joe.address = "Wifi City"
    joeE = Employee.new
    joeE.person = joe
    joeE.salary = 2344.0
    dev11S1 = Subunit.new
    dev11S1.pu = joeE
    dev11.subunits << dev11S1
    
    dev1S1 = Subunit.new
    dev1S1.du = dev11
    dev1.subunits << dev1S1
    
    developmentS1 = Subunit.new
    developmentS1.du = dev1
    development.subunits << developmentS1
    
    
    @sampleCompany.topDepts << research << development
  end
  
  def test_total
    assert_equal(399747.0, @sampleCompany.total)
  end
  
  def test_cut
    preCutTotal =  @sampleCompany.total
    @sampleCompany.cut
    newTotal = @sampleCompany.total
    assert_equal(preCutTotal / 2, newTotal)
  end
  
end