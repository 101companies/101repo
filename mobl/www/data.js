mobl.provides('data');
mobl.load('mobl.js');

data.Company = persistence.define('data__Company', {
  'name': 'VARCHAR(255)'
});



data.Department = persistence.define('data__Department', {
  'name': 'VARCHAR(255)'
});



data.Employee = persistence.define('data__Employee', {
  'name': 'VARCHAR(255)',
  'address': 'VARCHAR(255)',
  'salary': 'INT'
});


data.Department.hasMany('departments', data.Department, 'parentDept');
data.Department.hasMany('employees', data.Employee, 'department');
data.Company.hasMany('departments', data.Department, 'company');
data.Department.hasOne('manager', data.Employee);
