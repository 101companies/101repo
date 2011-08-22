<apply template="main">
  <bind tag="pagetitle">
    Company: "<name/>"
  </bind>
  <bind tag="navigation">
    <!-- TODO -->
  </bind>
  <br>
  <bind tag="maincontent">
    <apply template="components/primvalue">
      <bind tag="vname">Name</bind>
      <bind tag="value"><name/></bind>
    </apply>
    <br>
    <apply template="components/list">
      <bind tag="name">Departments</bind>
      <bind tag="view">Department</bind>      
      <bind tag="listcontent"><depts/></bind>
    </apply>
    <apply template="components/totalcut"/>
  </bind>
</apply>