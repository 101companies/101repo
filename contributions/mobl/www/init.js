mobl.provides('init');
mobl.load('mobl.js');
mobl.load('data.js');
init.initialData = function() {
   var __this = this;
  var mega = new data.Company({'name': "meganalysis"});
  
  var res = new data.Department({'name': "Research"});
  
  res.manager = new data.Employee({'name': "Craig", 'address': "Redmond", 'salary': 123456});
  res.employees.add(new data.Employee({'name': "Erik", 'address': "Utrecht", 'salary': 12345}));
  res.employees.add(new data.Employee({'name': "Ralf", 'address': "Koblenz", 'salary': 1234}));
  mega.departments.add(res);
  var dev = new data.Department({'name': "Development"});
  
  dev.manager = new data.Employee({'name': "Ray", 'address': "Redmond", 'salary': 234567});
  var dev1 = new data.Department({'name': "Dev1"});
  
  dev1.manager = new data.Employee({'name': "Klaus", 'address': "Boston", 'salary': 23456});
  var dev11 = new data.Department({'name': "Dev1.1"});
  
  dev11.manager = new data.Employee({'name': "Karl", 'address': "Riga", 'salary': 2345});
  dev11.employees.add(new data.Employee({'name': "Joe", 'address': "Wifi city", 'salary': 2344}));
  dev1.departments.add(dev11);
  dev.departments.add(dev1);
  mega.departments.add(dev);
  mobl.add(mega);
};

