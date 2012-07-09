public   class  Employee {
	
  
  public float getSalary  () {
    return salary;
  }

	

  public void setSalary  (float salary) {
    this.salary = salary;
  }

	
	
	public void cutSalary() {
		setSalary (getSalary() / 2);
	}

	
  private java.lang.String name;

	
  
  public java.lang.String getName () {
    return name;
  }

	

  public void setName (java.lang.String name) {
    this.name = name;
  }

	  
  
  private java.lang.String address;

	
  
  public java.lang.String getAddress () {
    return address;
  }

	

  public void setAddress (java.lang.String address) {
    this.address = address;
  }

	  
  
  private float salary;


}
