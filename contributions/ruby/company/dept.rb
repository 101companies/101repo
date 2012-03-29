class Dept
  
  attr_accessor :name, :manager, :subunits
  
  def total
    ttl = manager.total
    subunits.each do |subunit|
      ttl += subunit.total
    end
    ttl
  end
  
  def cut
    manager.cut
    subunits.each do |subunit|
      subunit.cut
    end
  end
  
end