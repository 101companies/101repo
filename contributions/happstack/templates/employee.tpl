<apply template="main">
  <bind tag="pagetitle">
    Employee: "<name/>"
  </bind>
  <bind tag="view">Employee</bind>
  <bind tag="navigation">
    <apply template="components/backlink"/>
  </bind>  
  <bind tag="maincontent">
    <apply template="components/primvalue">
      <bind tag="vname">Name</bind>
      <bind tag="value"><name/></bind>
    </apply>
    <br>
    <nameEs/>
    <br>
    <apply template="components/primvalue">
      <bind tag="vname">Address</bind>
      <bind tag="value"><address/></bind>
    </apply>
    <br>
    <addressEs/>
    <br>
    <apply template="components/primvalue">
      <bind tag="vname">Salary</bind>
      <bind tag="value"><salary/></bind>
    </apply>
    <br>
    <salaryEs/>
    <apply template="components/cutlink">
      <bind tag="view">Employee</bind>
    </apply>
  </bind>
</apply>