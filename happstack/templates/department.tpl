<apply template="main">
  <bind tag="pagetitle">
    Department: "<name/>"
  </bind>
  <bind tag="view">Department</bind>
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
    <div class="manager">
      <h2>Manager:</h2>
      <p class="eName"><mname/></p>
        <a class="editB" href="/Employee/View/$(mfocus)">
          <div>Edit</div>
        </a>
    </div>
    <br>
    <apply template="components/list">
      <bind tag="name">Sub departments</bind>
      <bind tag="view">Department</bind>
      <bind tag="listcontent"><subdepts/></bind>
    </apply>
    <apply template="components/list">
      <bind tag="name">Employees</bind>
      <bind tag="view">Employee</bind>
      <bind tag="listcontent"><employees/></bind>
    </apply>
    <apply template="components/totalcut">
      <bind tag="view">Department</bind>
    </apply>
  </bind>
</apply>