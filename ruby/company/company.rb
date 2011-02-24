class Company
  
  attr_accessor :name, :topDepts
  
  def total
    ttl = 0.0
    topDepts.each do |topDept|
      ttl += topDept.total
    end
    ttl
  end
  
  def cut
    topDepts.each do |topDept|
      topDept.cut
    end
  end
end