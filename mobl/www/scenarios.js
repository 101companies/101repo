mobl.provides('scenarios');
mobl.load('mobl.js');
mobl.load('data.js');
scenarios.total = function(callback) {
  var __this = this;
  var result__ = 0;
  var sum = result__;
  var result__ = data.Employee.all();
  data.Employee.all().list(function(coll67) {
    coll67 = coll67.reverse();
    function processOne43() {
      var e;
      e = coll67.pop();
      var result__ = sum + e.salary;
      sum = result__;
      
      if(coll67.length > 0) processOne43(); else rest43();
      
    }
    function rest43() {
      var result__ = sum;
      if(callback && callback.apply) callback(result__);
      return;
      if(callback && callback.apply) callback(); return;
    }
    if(coll67.length > 0) processOne43(); else rest43();
  });
  
};

scenarios.totalDept = function(dept, callback) {
  var __this = this;
  var result__ = dept.manager.salary;
  var sum = result__;
  var result__ = dept.employees;
  dept.employees.list(function(coll68) {
    coll68 = coll68.reverse();
    function processOne44() {
      var employee;
      employee = coll68.pop();
      var result__ = sum + employee.salary;
      sum = result__;
      
      if(coll68.length > 0) processOne44(); else rest44();
      
    }
    function rest44() {
      var result__ = dept.departments;
      dept.departments.list(function(coll69) {
        coll69 = coll69.reverse();
        function processOne45() {
          var dept;
          dept = coll69.pop();
          scenarios.totalDept(dept, function(result__) {
            var tmp441 = result__;
            var result__ = sum + tmp441;
            var tmp440 = result__;
            var result__ = tmp440;
            sum = result__;
            
            if(coll69.length > 0) processOne45(); else rest45();
            
          });
        }
        function rest45() {
          var result__ = sum;
          if(callback && callback.apply) callback(result__);
          return;
          if(callback && callback.apply) callback(); return;
        }
        if(coll69.length > 0) processOne45(); else rest45();
      });
      
    }
    if(coll68.length > 0) processOne44(); else rest44();
  });
  
};

scenarios.cut = function(callback) {
  var __this = this;
  var result__ = data.Employee.all();
  data.Employee.all().list(function(coll70) {
    coll70 = coll70.reverse();
    function processOne46() {
      var e;
      e = coll70.pop();
      var result__ = e.salary / 2;
      e.salary = result__;
      
      if(coll70.length > 0) processOne46(); else rest46();
      
    }
    function rest46() {
      if(callback && callback.apply) callback(); return;
    }
    if(coll70.length > 0) processOne46(); else rest46();
  });
  
};

scenarios.cutDept = function(d, callback) {
  var __this = this;
  var result__ = d.manager.salary / 2;
  d.manager.salary = result__;
  var result__ = d.departments;
  d.departments.list(function(coll71) {
    coll71 = coll71.reverse();
    function processOne47() {
      var subDept;
      subDept = coll71.pop();
      scenarios.cutDept(subDept, function(result__) {
        var tmp442 = result__;
        
        if(coll71.length > 0) processOne47(); else rest47();
        
      });
    }
    function rest47() {
      var result__ = d.employees;
      d.employees.list(function(coll72) {
        coll72 = coll72.reverse();
        function processOne48() {
          var employee;
          employee = coll72.pop();
          var result__ = employee.salary / 2;
          employee.salary = result__;
          
          if(coll72.length > 0) processOne48(); else rest48();
          
        }
        function rest48() {
          if(callback && callback.apply) callback(); return;
        }
        if(coll72.length > 0) processOne48(); else rest48();
      });
      
    }
    if(coll71.length > 0) processOne47(); else rest47();
  });
  
};

scenarios.depthDept = function(d, callback) {
  var __this = this;
  var result__ = 0;
  var max = result__;
  var result__ = d.departments;
  d.departments.list(function(coll73) {
    coll73 = coll73.reverse();
    function processOne49() {
      var dept;
      dept = coll73.pop();
      scenarios.depthDept(dept, function(result__) {
        var tmp444 = result__;
        var result__ = mobl.Math.max(tmp444, max);
        var tmp443 = result__;
        var result__ = tmp443;
        max = result__;
        
        if(coll73.length > 0) processOne49(); else rest49();
        
      });
    }
    function rest49() {
      var result__ = max + 1;
      if(callback && callback.apply) callback(result__);
      return;
      if(callback && callback.apply) callback(); return;
    }
    if(coll73.length > 0) processOne49(); else rest49();
  });
  
};

scenarios.depth = function(c, callback) {
  var __this = this;
  var result__ = 0;
  var max = result__;
  var result__ = c.departments;
  c.departments.list(function(coll74) {
    coll74 = coll74.reverse();
    function processOne50() {
      var dept;
      dept = coll74.pop();
      scenarios.depthDept(dept, function(result__) {
        var tmp446 = result__;
        var result__ = mobl.Math.max(tmp446, max);
        var tmp445 = result__;
        var result__ = tmp445;
        max = result__;
        
        if(coll74.length > 0) processOne50(); else rest50();
        
      });
    }
    function rest50() {
      var result__ = max + 1;
      if(callback && callback.apply) callback(result__);
      return;
      if(callback && callback.apply) callback(); return;
    }
    if(coll74.length > 0) processOne50(); else rest50();
  });
  
};

