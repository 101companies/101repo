class Subunit
  
  attr_reader :pu, :du
  
  
  def pu=(pu)
    @pu = pu
    @du = nil
  end
  
  def du=(du)
    @pu = nil
    @du = du
  end
  
  def total
    ttl = 0.0
    if (pu != nil)
      ttl = pu.total
    else
      ttl = du.total
    end
    ttl
  end
  
  def cut
    if (pu!= nil)
      pu.cut
    else
      du.cut
    end
  end
  
end
