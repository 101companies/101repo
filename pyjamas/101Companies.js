/* start module: 101Companies */
$pyjs.loaded_modules['101Companies'] = function (__mod_name__) {
	if($pyjs.loaded_modules['101Companies'].__was_initialized__) return $pyjs.loaded_modules['101Companies'];
	var $m = $pyjs.loaded_modules["101Companies"];
	$m.__repr__ = function() { return "<module: 101Companies>"; };
	$m.__was_initialized__ = true;
	if ((__mod_name__ === null) || (typeof __mod_name__ == 'undefined')) __mod_name__ = '101Companies';
	$m.__name__ = __mod_name__;


	$m['pyjd'] = $p['___import___']('pyjd', null);
	$m['RootPanel'] = $p['___import___']('pyjamas.ui.RootPanel.RootPanel', null, null, false);
	$m['Button'] = $p['___import___']('pyjamas.ui.Button.Button', null, null, false);
	$m['Label'] = $p['___import___']('pyjamas.ui.Label.Label', null, null, false);
	$m['Grid'] = $p['___import___']('pyjamas.ui.Grid.Grid', null, null, false);
	$m['TextBox'] = $p['___import___']('pyjamas.ui.TextBox.TextBox', null, null, false);
	$m['ListBox'] = $p['___import___']('pyjamas.ui.ListBox.ListBox', null, null, false);
	$m['AbsolutePanel'] = $p['___import___']('pyjamas.ui.AbsolutePanel.AbsolutePanel', null, null, false);
	$m['pygwt'] = $p['___import___']('pygwt', null);
	$m['Company'] = (function(){
		var $cls_definition = new Object();
		var $method;
		$cls_definition.__module__ = '101Companies';
		$method = $pyjs__bind_method2('__init__', function(id, name, departments) {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
				id = arguments[1];
				name = arguments[2];
				departments = arguments[3];
			}
			if (typeof id == 'undefined') id=arguments.callee.__args__[3][1];
			if (typeof name == 'undefined') name=arguments.callee.__args__[4][1];
			if (typeof departments == 'undefined') departments=arguments.callee.__args__[5][1];

			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('id', id) : $p['setattr'](self, 'id', id);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('$$name', name) : $p['setattr'](self, '$$name', name);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('departments', departments) : $p['setattr'](self, 'departments', departments);
			return null;
		}
	, 1, [null,null,['self'],['id', 0],['name', ''],['departments', $p['list']([])]]);
		$cls_definition['__init__'] = $method;
		$method = $pyjs__bind_method2('total', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $iter1_nextval,$iter1_type,$iter1_iter,$add2,$add1,$iter1_array,department,total,$iter1_idx;
			total = 0;
			$iter1_iter = self['departments'];
			$iter1_nextval=$p['__iter_prepare']($iter1_iter,false);
			while (typeof($p['__wrapped_next']($iter1_nextval).$nextval) != 'undefined') {
				department = $iter1_nextval.$nextval;
				total = $p['__op_add']($add1=total,$add2=department['total']());
			}
			return total;
		}
	, 1, [null,null,['self']]);
		$cls_definition['total'] = $method;
		$method = $pyjs__bind_method2('cut', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $iter2_nextval,$iter2_type,$iter2_iter,$iter2_idx,department,$iter2_array;
			$iter2_iter = self['departments'];
			$iter2_nextval=$p['__iter_prepare']($iter2_iter,false);
			while (typeof($p['__wrapped_next']($iter2_nextval).$nextval) != 'undefined') {
				department = $iter2_nextval.$nextval;
				department['cut']();
			}
			return null;
		}
	, 1, [null,null,['self']]);
		$cls_definition['cut'] = $method;
		$method = $pyjs__bind_method2('save', function(name) {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
				name = arguments[1];
			}

			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('$$name', name) : $p['setattr'](self, '$$name', name);
			return null;
		}
	, 1, [null,null,['self'],['name']]);
		$cls_definition['save'] = $method;
		var $bases = new Array(pyjslib.object);
		var $data = $p['dict']();
		for (var $item in $cls_definition) { $data.__setitem__($item, $cls_definition[$item]); }
		return $p['_create_class']('Company', $p['tuple']($bases), $data);
	})();
	$m['Department'] = (function(){
		var $cls_definition = new Object();
		var $method;
		$cls_definition.__module__ = '101Companies';
		$method = $pyjs__bind_method2('__init__', function(id, name, departments, employees) {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
				id = arguments[1];
				name = arguments[2];
				departments = arguments[3];
				employees = arguments[4];
			}
			if (typeof id == 'undefined') id=arguments.callee.__args__[3][1];
			if (typeof name == 'undefined') name=arguments.callee.__args__[4][1];
			if (typeof departments == 'undefined') departments=arguments.callee.__args__[5][1];
			if (typeof employees == 'undefined') employees=arguments.callee.__args__[6][1];

			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('id', id) : $p['setattr'](self, 'id', id);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('$$name', name) : $p['setattr'](self, '$$name', name);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('departments', departments) : $p['setattr'](self, 'departments', departments);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('employees', employees) : $p['setattr'](self, 'employees', employees);
			return null;
		}
	, 1, [null,null,['self'],['id', 0],['name', ''],['departments', $p['list']([])],['employees', $p['list']([])]]);
		$cls_definition['__init__'] = $method;
		$method = $pyjs__bind_method2('total', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $iter3_idx,$iter4_type,$iter4_nextval,$iter3_type,$add5,$iter4_idx,$add3,department,$add6,$iter3_iter,$add4,$iter3_array,employee,total,$iter4_iter,$iter3_nextval,$iter4_array;
			total = 0;
			$iter3_iter = self['employees'];
			$iter3_nextval=$p['__iter_prepare']($iter3_iter,false);
			while (typeof($p['__wrapped_next']($iter3_nextval).$nextval) != 'undefined') {
				employee = $iter3_nextval.$nextval;
				total = $p['__op_add']($add3=total,$add4=employee['total']());
			}
			$iter4_iter = self['departments'];
			$iter4_nextval=$p['__iter_prepare']($iter4_iter,false);
			while (typeof($p['__wrapped_next']($iter4_nextval).$nextval) != 'undefined') {
				department = $iter4_nextval.$nextval;
				total = $p['__op_add']($add5=total,$add6=department['total']());
			}
			return total;
		}
	, 1, [null,null,['self']]);
		$cls_definition['total'] = $method;
		$method = $pyjs__bind_method2('cut', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $iter5_nextval,$iter6_idx,$iter6_type,$iter5_idx,department,$iter6_array,$iter5_iter,$iter5_array,employee,$iter5_type,$iter6_iter,$iter6_nextval;
			$iter5_iter = self['employees'];
			$iter5_nextval=$p['__iter_prepare']($iter5_iter,false);
			while (typeof($p['__wrapped_next']($iter5_nextval).$nextval) != 'undefined') {
				employee = $iter5_nextval.$nextval;
				employee['cut']();
			}
			$iter6_iter = self['departments'];
			$iter6_nextval=$p['__iter_prepare']($iter6_iter,false);
			while (typeof($p['__wrapped_next']($iter6_nextval).$nextval) != 'undefined') {
				department = $iter6_nextval.$nextval;
				department['cut']();
			}
			return null;
		}
	, 1, [null,null,['self']]);
		$cls_definition['cut'] = $method;
		$method = $pyjs__bind_method2('save', function(name) {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
				name = arguments[1];
			}

			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('$$name', name) : $p['setattr'](self, '$$name', name);
			return null;
		}
	, 1, [null,null,['self'],['name']]);
		$cls_definition['save'] = $method;
		$method = $pyjs__bind_method2('getManager', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $attr2,$iter7_nextval,$attr1,$iter7_iter,$iter7_array,$iter7_idx,employee,$iter7_type;
			$iter7_iter = self['employees'];
			$iter7_nextval=$p['__iter_prepare']($iter7_iter,false);
			while (typeof($p['__wrapped_next']($iter7_nextval).$nextval) != 'undefined') {
				employee = $iter7_nextval.$nextval;
				if ($p['bool']($p['op_eq']((($attr1=($attr2=employee)['manager']) == null || (($attr2.__is_instance__) && typeof $attr1 == 'function') || (typeof $attr1['__get__'] == 'function')?
							$p['getattr']($attr2, 'manager'):
							employee['manager']), 1))) {
					return employee;
				}
			}
			return null;
		}
	, 1, [null,null,['self']]);
		$cls_definition['getManager'] = $method;
		var $bases = new Array(pyjslib.object);
		var $data = $p['dict']();
		for (var $item in $cls_definition) { $data.__setitem__($item, $cls_definition[$item]); }
		return $p['_create_class']('Department', $p['tuple']($bases), $data);
	})();
	$m['Employee'] = (function(){
		var $cls_definition = new Object();
		var $method;
		$cls_definition.__module__ = '101Companies';
		$method = $pyjs__bind_method2('__init__', function(id, name, address, salary, manager) {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
				id = arguments[1];
				name = arguments[2];
				address = arguments[3];
				salary = arguments[4];
				manager = arguments[5];
			}
			if (typeof id == 'undefined') id=arguments.callee.__args__[3][1];
			if (typeof name == 'undefined') name=arguments.callee.__args__[4][1];
			if (typeof address == 'undefined') address=arguments.callee.__args__[5][1];
			if (typeof salary == 'undefined') salary=arguments.callee.__args__[6][1];
			if (typeof manager == 'undefined') manager=arguments.callee.__args__[7][1];

			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('id', id) : $p['setattr'](self, 'id', id);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('$$name', name) : $p['setattr'](self, '$$name', name);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('address', address) : $p['setattr'](self, 'address', address);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('salary', salary) : $p['setattr'](self, 'salary', salary);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('manager', manager) : $p['setattr'](self, 'manager', manager);
			return null;
		}
	, 1, [null,null,['self'],['id', 0],['name', ''],['address', ''],['salary', 0],['manager', 0]]);
		$cls_definition['__init__'] = $method;
		$method = $pyjs__bind_method2('total', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $attr3,$attr4;
			return (($attr3=($attr4=self)['salary']) == null || (($attr4.__is_instance__) && typeof $attr3 == 'function') || (typeof $attr3['__get__'] == 'function')?
						$p['getattr']($attr4, 'salary'):
						self['salary']);
		}
	, 1, [null,null,['self']]);
		$cls_definition['total'] = $method;
		$method = $pyjs__bind_method2('cut', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $div2,$div1,$attr5,$attr6;
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('salary', (typeof ($div1=(($attr5=($attr6=self)['salary']) == null || (($attr6.__is_instance__) && typeof $attr5 == 'function') || (typeof $attr5['__get__'] == 'function')?
						$p['getattr']($attr6, 'salary'):
						self['salary']))==typeof ($div2=2) && typeof $div1=='number' && $div2 !== 0?
				$div1/$div2:
				$p['op_div']($div1,$div2))) : $p['setattr'](self, 'salary', (typeof ($div1=(($attr5=($attr6=self)['salary']) == null || (($attr6.__is_instance__) && typeof $attr5 == 'function') || (typeof $attr5['__get__'] == 'function')?
						$p['getattr']($attr6, 'salary'):
						self['salary']))==typeof ($div2=2) && typeof $div1=='number' && $div2 !== 0?
				$div1/$div2:
				$p['op_div']($div1,$div2)));
			return null;
		}
	, 1, [null,null,['self']]);
		$cls_definition['cut'] = $method;
		$method = $pyjs__bind_method2('save', function(name, address, salary) {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
				name = arguments[1];
				address = arguments[2];
				salary = arguments[3];
			}

			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('$$name', name) : $p['setattr'](self, '$$name', name);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('address', address) : $p['setattr'](self, 'address', address);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('salary', salary) : $p['setattr'](self, 'salary', salary);
			return null;
		}
	, 1, [null,null,['self'],['name'],['address'],['salary']]);
		$cls_definition['save'] = $method;
		var $bases = new Array(pyjslib.object);
		var $data = $p['dict']();
		for (var $item in $cls_definition) { $data.__setitem__($item, $cls_definition[$item]); }
		return $p['_create_class']('Employee', $p['tuple']($bases), $data);
	})();
	$m['CompaniesApp'] = (function(){
		var $cls_definition = new Object();
		var $method;
		$cls_definition.__module__ = '101Companies';
		$method = $pyjs__bind_method2('__init__', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var development,joe,klaus,craig,research,dev1,erik,dev11,ralf,karl,ray;
			craig = $m['Employee'](1, 'Craig', 'Redmond', 123456, 1);
			ray = $m['Employee'](2, 'Ray', 'Redmond', 234567, 1);
			klaus = $m['Employee'](3, 'Klaus', 'Boston', 23456, 1);
			karl = $m['Employee'](4, 'Karl', 'Riga', 2345, 1);
			erik = $m['Employee'](5, 'Erik', 'Utrecht', 12345, 0);
			ralf = $m['Employee'](6, 'Ralf', 'Koblenz', 1234, 0);
			joe = $m['Employee'](7, 'Joe', 'Wifi City', 2344, 0);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('employees', $p['set']($p['list']([craig, ray, klaus, karl, erik, ralf, joe]))) : $p['setattr'](self, 'employees', $p['set']($p['list']([craig, ray, klaus, karl, erik, ralf, joe])));
			dev11 = $m['Department'](1, 'Dev1.1', $p['list']([]), $p['list']([karl, joe]));
			dev1 = $m['Department'](2, 'Dev1', $p['list']([dev11]), $p['list']([klaus]));
			research = $m['Department'](3, 'Research', $p['list']([]), $p['list']([craig, erik, ralf]));
			development = $m['Department'](4, 'Development', $p['list']([dev1]), $p['list']([ray]));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('departments', $p['set']($p['list']([dev11, dev1, research, development]))) : $p['setattr'](self, 'departments', $p['set']($p['list']([dev11, dev1, research, development])));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('company', $m['Company'](1, 'meganalysis', $p['list']([research, development]))) : $p['setattr'](self, 'company', $m['Company'](1, 'meganalysis', $p['list']([research, development])));
			return null;
		}
	, 1, [null,null,['self']]);
		$cls_definition['__init__'] = $method;
		$method = $pyjs__bind_method2('cutCompany', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}

			self['company']['cut']();
			return null;
		}
	, 1, [null,null,['self']]);
		$cls_definition['cutCompany'] = $method;
		$method = $pyjs__bind_method2('getDepartment', function(index) {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
				index = arguments[1];
			}
			var $iter8_idx,$attr8,$iter8_array,$attr7,$iter8_iter,item,$iter8_nextval,$iter8_type;
			$iter8_iter = self['departments'];
			$iter8_nextval=$p['__iter_prepare']($iter8_iter,false);
			while (typeof($p['__wrapped_next']($iter8_nextval).$nextval) != 'undefined') {
				item = $iter8_nextval.$nextval;
				if ($p['bool']($p['op_eq']((($attr7=($attr8=item)['id']) == null || (($attr8.__is_instance__) && typeof $attr7 == 'function') || (typeof $attr7['__get__'] == 'function')?
							$p['getattr']($attr8, 'id'):
							item['id']), index))) {
					return item;
				}
			}
			return null;
		}
	, 1, [null,null,['self'],['index']]);
		$cls_definition['getDepartment'] = $method;
		$method = $pyjs__bind_method2('getEmployee', function(index) {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
				index = arguments[1];
			}
			var $attr9,$iter9_iter,$iter9_nextval,$iter9_idx,$iter9_type,item,$attr10,$iter9_array;
			$iter9_iter = self['employees'];
			$iter9_nextval=$p['__iter_prepare']($iter9_iter,false);
			while (typeof($p['__wrapped_next']($iter9_nextval).$nextval) != 'undefined') {
				item = $iter9_nextval.$nextval;
				if ($p['bool']($p['op_eq']((($attr9=($attr10=item)['id']) == null || (($attr10.__is_instance__) && typeof $attr9 == 'function') || (typeof $attr9['__get__'] == 'function')?
							$p['getattr']($attr10, 'id'):
							item['id']), index))) {
					return item;
				}
			}
			return null;
		}
	, 1, [null,null,['self'],['index']]);
		$cls_definition['getEmployee'] = $method;
		var $bases = new Array(pyjslib.object);
		var $data = $p['dict']();
		for (var $item in $cls_definition) { $data.__setitem__($item, $cls_definition[$item]); }
		return $p['_create_class']('CompaniesApp', $p['tuple']($bases), $data);
	})();
	$m['CompaniesAppGUI'] = (function(){
		var $cls_definition = new Object();
		var $method;
		$cls_definition.__module__ = '101Companies';
		$method = $pyjs__bind_method2('__init__', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $attr11,$attr12;
			$m['AbsolutePanel']['__init__'](self);
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('app', $m['CompaniesApp']()) : $p['setattr'](self, 'app', $m['CompaniesApp']());
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('history', $p['list']([])) : $p['setattr'](self, 'history', $p['list']([]));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('save', $m['Button']('save', self)) : $p['setattr'](self, 'save', $m['Button']('save', self));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('selectDepartment', $m['Button']('select', self)) : $p['setattr'](self, 'selectDepartment', $m['Button']('select', self));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('selectEmployee', $m['Button']('select', self)) : $p['setattr'](self, 'selectEmployee', $m['Button']('select', self));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('edit', $m['Button']('edit', self)) : $p['setattr'](self, 'edit', $m['Button']('edit', self));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('cut', $m['Button']('cut', self)) : $p['setattr'](self, 'cut', $m['Button']('cut', self));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('back', $m['Button']('back', self)) : $p['setattr'](self, 'back', $m['Button']('back', self));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('$$name', $m['TextBox']()) : $p['setattr'](self, '$$name', $m['TextBox']());
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('address', $m['TextBox']()) : $p['setattr'](self, 'address', $m['TextBox']());
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('manager', $m['TextBox']()) : $p['setattr'](self, 'manager', $m['TextBox']());
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('departments', $pyjs_kwargs_call(null, $m['ListBox'], null, null, [{Size:'100%', VisibleItemCount:'5'}])) : $p['setattr'](self, 'departments', $pyjs_kwargs_call(null, $m['ListBox'], null, null, [{Size:'100%', VisibleItemCount:'5'}]));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('employees', $pyjs_kwargs_call(null, $m['ListBox'], null, null, [{Size:'100%', VisibleItemCount:'5'}])) : $p['setattr'](self, 'employees', $pyjs_kwargs_call(null, $m['ListBox'], null, null, [{Size:'100%', VisibleItemCount:'5'}]));
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('total', $m['TextBox']()) : $p['setattr'](self, 'total', $m['TextBox']());
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('grid', $m['Grid']()) : $p['setattr'](self, 'grid', $m['Grid']());
			self['add']((($attr11=($attr12=self)['grid']) == null || (($attr12.__is_instance__) && typeof $attr11 == 'function') || (typeof $attr11['__get__'] == 'function')?
						$p['getattr']($attr12, 'grid'):
						self['grid']));
			self['initCompanyGUI']();
			return null;
		}
	, 1, [null,null,['self']]);
		$cls_definition['__init__'] = $method;
		$method = $pyjs__bind_method2('onClick', function(sender) {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
				sender = arguments[1];
			}
			var $attr20,$attr21,$attr22,$attr23,$attr24,$attr25,$attr26,$attr27,$attr28,$attr29,$attr33,$attr32,$attr31,$attr30,$attr19,$attr18,$attr35,$attr34,$attr15,$attr14,$attr17,$attr16,$attr13,$attr36;
			if ($p['bool']($p['op_eq'](sender, (($attr13=($attr14=self)['cut']) == null || (($attr14.__is_instance__) && typeof $attr13 == 'function') || (typeof $attr13['__get__'] == 'function')?
						$p['getattr']($attr14, 'cut'):
						self['cut'])))) {
				self['current']['cut']();
				self['total']['setText'](self['current']['total']());
			}
			if ($p['bool']($p['op_eq'](sender, (($attr15=($attr16=self)['save']) == null || (($attr16.__is_instance__) && typeof $attr15 == 'function') || (typeof $attr15['__get__'] == 'function')?
						$p['getattr']($attr16, 'save'):
						self['save'])))) {
				if ($p['bool']($p['op_eq']((($attr17=($attr18=self['current']['__class__'])['__name__']) == null || (($attr18.__is_instance__) && typeof $attr17 == 'function') || (typeof $attr17['__get__'] == 'function')?
							$p['getattr']($attr18, '__name__'):
							self['current']['__class__']['__name__']), 'Employee'))) {
					self['current']['save'](self['$$name']['getText'](), self['address']['getText'](), $p['float'](self['total']['getText']()));
				}
				else {
					self['current']['save'](self['$$name']['getText']());
				}
			}
			if ($p['bool']($p['op_eq'](sender, (($attr19=($attr20=self)['selectDepartment']) == null || (($attr20.__is_instance__) && typeof $attr19 == 'function') || (typeof $attr19['__get__'] == 'function')?
						$p['getattr']($attr20, 'selectDepartment'):
						self['selectDepartment'])))) {
				if ($p['bool'](($p['cmp'](self['departments']['getSelectedIndex'](), (typeof ($usub1=1)=='number'?
					-$usub1:
					$p['op_usub']($usub1))) == 1))) {
					self['history']['append']((($attr21=($attr22=self)['current']) == null || (($attr22.__is_instance__) && typeof $attr21 == 'function') || (typeof $attr21['__get__'] == 'function')?
								$p['getattr']($attr22, 'current'):
								self['current']));
					self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('current', self['app']['getDepartment'](self['departments']['getValue'](self['departments']['getSelectedIndex']()))) : $p['setattr'](self, 'current', self['app']['getDepartment'](self['departments']['getValue'](self['departments']['getSelectedIndex']())));
					self['initDepartmentGUI']();
				}
			}
			if ($p['bool']($p['op_eq'](sender, (($attr23=($attr24=self)['selectEmployee']) == null || (($attr24.__is_instance__) && typeof $attr23 == 'function') || (typeof $attr23['__get__'] == 'function')?
						$p['getattr']($attr24, 'selectEmployee'):
						self['selectEmployee'])))) {
				if ($p['bool'](($p['cmp'](self['employees']['getSelectedIndex'](), (typeof ($usub2=1)=='number'?
					-$usub2:
					$p['op_usub']($usub2))) == 1))) {
					self['history']['append']((($attr25=($attr26=self)['current']) == null || (($attr26.__is_instance__) && typeof $attr25 == 'function') || (typeof $attr25['__get__'] == 'function')?
								$p['getattr']($attr26, 'current'):
								self['current']));
					self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('current', self['app']['getEmployee'](self['employees']['getValue'](self['employees']['getSelectedIndex']()))) : $p['setattr'](self, 'current', self['app']['getEmployee'](self['employees']['getValue'](self['employees']['getSelectedIndex']())));
					self['initEmployeeGUI']();
				}
			}
			if ($p['bool']($p['op_eq'](sender, (($attr27=($attr28=self)['edit']) == null || (($attr28.__is_instance__) && typeof $attr27 == 'function') || (typeof $attr27['__get__'] == 'function')?
						$p['getattr']($attr28, 'edit'):
						self['edit'])))) {
				self['history']['append']((($attr29=($attr30=self)['current']) == null || (($attr30.__is_instance__) && typeof $attr29 == 'function') || (typeof $attr29['__get__'] == 'function')?
							$p['getattr']($attr30, 'current'):
							self['current']));
				self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('current', self['current']['getManager']()) : $p['setattr'](self, 'current', self['current']['getManager']());
				self['initEmployeeGUI']();
			}
			if ($p['bool']($p['op_eq'](sender, (($attr31=($attr32=self)['back']) == null || (($attr32.__is_instance__) && typeof $attr31 == 'function') || (typeof $attr31['__get__'] == 'function')?
						$p['getattr']($attr32, 'back'):
						self['back'])))) {
				if ($p['bool'](($p['cmp']($p['len']((($attr33=($attr34=self)['history']) == null || (($attr34.__is_instance__) && typeof $attr33 == 'function') || (typeof $attr33['__get__'] == 'function')?
							$p['getattr']($attr34, 'history'):
							self['history'])), 0) == 1))) {
					self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('current', self['history']['pop']()) : $p['setattr'](self, 'current', self['history']['pop']());
					if ($p['bool']($p['op_eq']((($attr35=($attr36=self['current']['__class__'])['__name__']) == null || (($attr36.__is_instance__) && typeof $attr35 == 'function') || (typeof $attr35['__get__'] == 'function')?
								$p['getattr']($attr36, '__name__'):
								self['current']['__class__']['__name__']), 'Company'))) {
						self['initCompanyGUI']();
					}
					else {
						self['initDepartmentGUI']();
					}
				}
			}
			return null;
		}
	, 1, [null,null,['self'],['sender']]);
		$cls_definition['onClick'] = $method;
		$method = $pyjs__bind_method2('initCompanyGUI', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $iter10_nextval,$attr46,$attr47,$attr44,$attr45,$attr42,$attr43,$attr40,$attr41,$iter10_iter,$attr48,$attr49,$iter10_idx,$attr37,$attr39,$attr38,$attr51,$attr50,$attr53,$attr52,$attr55,$attr54,$iter10_array,$attr56,item,$iter10_type;
			self.__is_instance__ && typeof self.__setattr__ == 'function' ? self.__setattr__('current', (($attr37=($attr38=self['app'])['company']) == null || (($attr38.__is_instance__) && typeof $attr37 == 'function') || (typeof $attr37['__get__'] == 'function')?
						$p['getattr']($attr38, 'company'):
						self['app']['company'])) : $p['setattr'](self, 'current', (($attr37=($attr38=self['app'])['company']) == null || (($attr38.__is_instance__) && typeof $attr37 == 'function') || (typeof $attr37['__get__'] == 'function')?
						$p['getattr']($attr38, 'company'):
						self['app']['company']));
			self['grid']['clear']();
			self['grid']['resize'](4, 3);
			self['grid']['setWidget'](0, 0, $m['Label']('Name:'));
			self['grid']['setWidget'](1, 0, $m['Label']('Department:'));
			self['grid']['setWidget'](2, 0, $m['Label']('Total:'));
			self['grid']['setWidget'](0, 1, (($attr39=($attr40=self)['$$name']) == null || (($attr40.__is_instance__) && typeof $attr39 == 'function') || (typeof $attr39['__get__'] == 'function')?
						$p['getattr']($attr40, '$$name'):
						self['$$name']));
			self['grid']['setWidget'](1, 1, (($attr41=($attr42=self)['departments']) == null || (($attr42.__is_instance__) && typeof $attr41 == 'function') || (typeof $attr41['__get__'] == 'function')?
						$p['getattr']($attr42, 'departments'):
						self['departments']));
			self['grid']['setWidget'](2, 1, (($attr43=($attr44=self)['total']) == null || (($attr44.__is_instance__) && typeof $attr43 == 'function') || (typeof $attr43['__get__'] == 'function')?
						$p['getattr']($attr44, 'total'):
						self['total']));
			self['grid']['setWidget'](0, 2, (($attr45=($attr46=self)['save']) == null || (($attr46.__is_instance__) && typeof $attr45 == 'function') || (typeof $attr45['__get__'] == 'function')?
						$p['getattr']($attr46, 'save'):
						self['save']));
			self['grid']['setWidget'](1, 2, (($attr47=($attr48=self)['selectDepartment']) == null || (($attr48.__is_instance__) && typeof $attr47 == 'function') || (typeof $attr47['__get__'] == 'function')?
						$p['getattr']($attr48, 'selectDepartment'):
						self['selectDepartment']));
			self['grid']['setWidget'](2, 2, (($attr49=($attr50=self)['cut']) == null || (($attr50.__is_instance__) && typeof $attr49 == 'function') || (typeof $attr49['__get__'] == 'function')?
						$p['getattr']($attr50, 'cut'):
						self['cut']));
			self['$$name']['setText']((($attr51=($attr52=self['current'])['$$name']) == null || (($attr52.__is_instance__) && typeof $attr51 == 'function') || (typeof $attr51['__get__'] == 'function')?
						$p['getattr']($attr52, '$$name'):
						self['current']['$$name']));
			self['departments']['clear']();
			$iter10_iter = self['current']['departments'];
			$iter10_nextval=$p['__iter_prepare']($iter10_iter,false);
			while (typeof($p['__wrapped_next']($iter10_nextval).$nextval) != 'undefined') {
				item = $iter10_nextval.$nextval;
				self['departments']['addItem']((($attr53=($attr54=item)['$$name']) == null || (($attr54.__is_instance__) && typeof $attr53 == 'function') || (typeof $attr53['__get__'] == 'function')?
							$p['getattr']($attr54, '$$name'):
							item['$$name']), (($attr55=($attr56=item)['id']) == null || (($attr56.__is_instance__) && typeof $attr55 == 'function') || (typeof $attr55['__get__'] == 'function')?
							$p['getattr']($attr56, 'id'):
							item['id']));
			}
			if ($p['bool'](($p['cmp'](self['departments']['getItemCount'](), 0) == 1))) {
				self['departments']['setSelectedIndex'](0);
			}
			self['total']['setText'](self['current']['total']());
			return null;
		}
	, 1, [null,null,['self']]);
		$cls_definition['initCompanyGUI'] = $method;
		$method = $pyjs__bind_method2('initDepartmentGUI', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $iter12_type,$iter11_type,$attr88,$attr71,$attr82,$attr83,$attr80,$attr81,$attr68,$attr69,$attr84,$attr85,$attr64,$attr65,$attr67,$attr60,$attr61,$attr62,$attr63,$attr89,$iter12_nextval,$iter11_idx,$iter11_iter,$iter12_array,$iter11_array,$attr86,$iter11_nextval,$attr92,$attr87,$attr59,$attr58,$attr91,$attr90,$attr79,$attr78,$attr77,$attr76,$attr75,$attr74,$attr73,$attr72,$attr57,$attr70,$iter12_iter,item,$iter12_idx,$attr66;
			self['grid']['clear']();
			self['grid']['resize'](6, 3);
			self['grid']['setWidget'](0, 0, $m['Label']('Name:'));
			self['grid']['setWidget'](1, 0, $m['Label']('Manager:'));
			self['grid']['setWidget'](2, 0, $m['Label']('Department:'));
			self['grid']['setWidget'](3, 0, $m['Label']('Employee:'));
			self['grid']['setWidget'](4, 0, $m['Label']('Total:'));
			self['grid']['setWidget'](0, 1, (($attr57=($attr58=self)['$$name']) == null || (($attr58.__is_instance__) && typeof $attr57 == 'function') || (typeof $attr57['__get__'] == 'function')?
						$p['getattr']($attr58, '$$name'):
						self['$$name']));
			self['grid']['setWidget'](1, 1, (($attr59=($attr60=self)['manager']) == null || (($attr60.__is_instance__) && typeof $attr59 == 'function') || (typeof $attr59['__get__'] == 'function')?
						$p['getattr']($attr60, 'manager'):
						self['manager']));
			self['grid']['setWidget'](2, 1, (($attr61=($attr62=self)['departments']) == null || (($attr62.__is_instance__) && typeof $attr61 == 'function') || (typeof $attr61['__get__'] == 'function')?
						$p['getattr']($attr62, 'departments'):
						self['departments']));
			self['grid']['setWidget'](3, 1, (($attr63=($attr64=self)['employees']) == null || (($attr64.__is_instance__) && typeof $attr63 == 'function') || (typeof $attr63['__get__'] == 'function')?
						$p['getattr']($attr64, 'employees'):
						self['employees']));
			self['grid']['setWidget'](4, 1, (($attr65=($attr66=self)['total']) == null || (($attr66.__is_instance__) && typeof $attr65 == 'function') || (typeof $attr65['__get__'] == 'function')?
						$p['getattr']($attr66, 'total'):
						self['total']));
			self['grid']['setWidget'](0, 2, (($attr67=($attr68=self)['save']) == null || (($attr68.__is_instance__) && typeof $attr67 == 'function') || (typeof $attr67['__get__'] == 'function')?
						$p['getattr']($attr68, 'save'):
						self['save']));
			self['grid']['setWidget'](1, 2, (($attr69=($attr70=self)['edit']) == null || (($attr70.__is_instance__) && typeof $attr69 == 'function') || (typeof $attr69['__get__'] == 'function')?
						$p['getattr']($attr70, 'edit'):
						self['edit']));
			self['grid']['setWidget'](2, 2, (($attr71=($attr72=self)['selectDepartment']) == null || (($attr72.__is_instance__) && typeof $attr71 == 'function') || (typeof $attr71['__get__'] == 'function')?
						$p['getattr']($attr72, 'selectDepartment'):
						self['selectDepartment']));
			self['grid']['setWidget'](3, 2, (($attr73=($attr74=self)['selectEmployee']) == null || (($attr74.__is_instance__) && typeof $attr73 == 'function') || (typeof $attr73['__get__'] == 'function')?
						$p['getattr']($attr74, 'selectEmployee'):
						self['selectEmployee']));
			self['grid']['setWidget'](4, 2, (($attr75=($attr76=self)['cut']) == null || (($attr76.__is_instance__) && typeof $attr75 == 'function') || (typeof $attr75['__get__'] == 'function')?
						$p['getattr']($attr76, 'cut'):
						self['cut']));
			self['grid']['setWidget'](5, 2, (($attr77=($attr78=self)['back']) == null || (($attr78.__is_instance__) && typeof $attr77 == 'function') || (typeof $attr77['__get__'] == 'function')?
						$p['getattr']($attr78, 'back'):
						self['back']));
			self['$$name']['setText']((($attr79=($attr80=self['current'])['$$name']) == null || (($attr80.__is_instance__) && typeof $attr79 == 'function') || (typeof $attr79['__get__'] == 'function')?
						$p['getattr']($attr80, '$$name'):
						self['current']['$$name']));
			self['departments']['clear']();
			self['employees']['clear']();
			$iter11_iter = self['current']['departments'];
			$iter11_nextval=$p['__iter_prepare']($iter11_iter,false);
			while (typeof($p['__wrapped_next']($iter11_nextval).$nextval) != 'undefined') {
				item = $iter11_nextval.$nextval;
				self['departments']['addItem']((($attr81=($attr82=item)['$$name']) == null || (($attr82.__is_instance__) && typeof $attr81 == 'function') || (typeof $attr81['__get__'] == 'function')?
							$p['getattr']($attr82, '$$name'):
							item['$$name']), (($attr83=($attr84=item)['id']) == null || (($attr84.__is_instance__) && typeof $attr83 == 'function') || (typeof $attr83['__get__'] == 'function')?
							$p['getattr']($attr84, 'id'):
							item['id']));
			}
			if ($p['bool'](($p['cmp'](self['departments']['getItemCount'](), 0) == 1))) {
				self['departments']['setSelectedIndex'](0);
			}
			$iter12_iter = self['current']['employees'];
			$iter12_nextval=$p['__iter_prepare']($iter12_iter,false);
			while (typeof($p['__wrapped_next']($iter12_nextval).$nextval) != 'undefined') {
				item = $iter12_nextval.$nextval;
				if ($p['bool']($p['op_eq']((($attr85=($attr86=item)['manager']) == null || (($attr86.__is_instance__) && typeof $attr85 == 'function') || (typeof $attr85['__get__'] == 'function')?
							$p['getattr']($attr86, 'manager'):
							item['manager']), 0))) {
					self['employees']['addItem']((($attr87=($attr88=item)['$$name']) == null || (($attr88.__is_instance__) && typeof $attr87 == 'function') || (typeof $attr87['__get__'] == 'function')?
								$p['getattr']($attr88, '$$name'):
								item['$$name']), (($attr89=($attr90=item)['id']) == null || (($attr90.__is_instance__) && typeof $attr89 == 'function') || (typeof $attr89['__get__'] == 'function')?
								$p['getattr']($attr90, 'id'):
								item['id']));
				}
				else {
					self['manager']['setText']((($attr91=($attr92=item)['$$name']) == null || (($attr92.__is_instance__) && typeof $attr91 == 'function') || (typeof $attr91['__get__'] == 'function')?
								$p['getattr']($attr92, '$$name'):
								item['$$name']));
				}
			}
			if ($p['bool'](($p['cmp'](self['employees']['getItemCount'](), 0) == 1))) {
				self['employees']['setSelectedIndex'](0);
			}
			self['total']['setText'](self['current']['total']());
			return null;
		}
	, 1, [null,null,['self']]);
		$cls_definition['initDepartmentGUI'] = $method;
		$method = $pyjs__bind_method2('initEmployeeGUI', function() {
			if (this.__is_instance__ === true) {
				var self = this;
			} else {
				var self = arguments[0];
			}
			var $attr95,$attr94,$attr97,$attr96,$attr93,$attr110,$attr99,$attr98,$attr106,$attr107,$attr104,$attr105,$attr102,$attr103,$attr100,$attr101,$attr108,$attr109;
			self['grid']['clear']();
			self['grid']['resize'](4, 3);
			self['grid']['setWidget'](0, 0, $m['Label']('Name:'));
			self['grid']['setWidget'](1, 0, $m['Label']('Address:'));
			self['grid']['setWidget'](2, 0, $m['Label']('Salary:'));
			self['grid']['setWidget'](0, 1, (($attr93=($attr94=self)['$$name']) == null || (($attr94.__is_instance__) && typeof $attr93 == 'function') || (typeof $attr93['__get__'] == 'function')?
						$p['getattr']($attr94, '$$name'):
						self['$$name']));
			self['grid']['setWidget'](1, 1, (($attr95=($attr96=self)['address']) == null || (($attr96.__is_instance__) && typeof $attr95 == 'function') || (typeof $attr95['__get__'] == 'function')?
						$p['getattr']($attr96, 'address'):
						self['address']));
			self['grid']['setWidget'](2, 1, (($attr97=($attr98=self)['total']) == null || (($attr98.__is_instance__) && typeof $attr97 == 'function') || (typeof $attr97['__get__'] == 'function')?
						$p['getattr']($attr98, 'total'):
						self['total']));
			self['grid']['setWidget'](0, 2, (($attr99=($attr100=self)['save']) == null || (($attr100.__is_instance__) && typeof $attr99 == 'function') || (typeof $attr99['__get__'] == 'function')?
						$p['getattr']($attr100, 'save'):
						self['save']));
			self['grid']['setWidget'](2, 2, (($attr101=($attr102=self)['cut']) == null || (($attr102.__is_instance__) && typeof $attr101 == 'function') || (typeof $attr101['__get__'] == 'function')?
						$p['getattr']($attr102, 'cut'):
						self['cut']));
			self['grid']['setWidget'](3, 2, (($attr103=($attr104=self)['back']) == null || (($attr104.__is_instance__) && typeof $attr103 == 'function') || (typeof $attr103['__get__'] == 'function')?
						$p['getattr']($attr104, 'back'):
						self['back']));
			self['$$name']['setText']((($attr105=($attr106=self['current'])['$$name']) == null || (($attr106.__is_instance__) && typeof $attr105 == 'function') || (typeof $attr105['__get__'] == 'function')?
						$p['getattr']($attr106, '$$name'):
						self['current']['$$name']));
			self['address']['setText']((($attr107=($attr108=self['current'])['address']) == null || (($attr108.__is_instance__) && typeof $attr107 == 'function') || (typeof $attr107['__get__'] == 'function')?
						$p['getattr']($attr108, 'address'):
						self['current']['address']));
			self['total']['setText']((($attr109=($attr110=self['current'])['salary']) == null || (($attr110.__is_instance__) && typeof $attr109 == 'function') || (typeof $attr109['__get__'] == 'function')?
						$p['getattr']($attr110, 'salary'):
						self['current']['salary']));
			return null;
		}
	, 1, [null,null,['self']]);
		$cls_definition['initEmployeeGUI'] = $method;
		var $bases = new Array($m['AbsolutePanel']);
		var $data = $p['dict']();
		for (var $item in $cls_definition) { $data.__setitem__($item, $cls_definition[$item]); }
		return $p['_create_class']('CompaniesAppGUI', $p['tuple']($bases), $data);
	})();
	$m['pyjd']['setup']('public/101Companies.html');
	$m['gui'] = $m['CompaniesAppGUI']();
	$m['RootPanel']()['add']($m['gui']);
	$m['pyjd']['run']();
	return this;
}; /* end 101Companies */


/* end module: 101Companies */


/*
PYJS_DEPS: ['pyjd', 'pyjamas.ui.RootPanel.RootPanel', 'pyjamas', 'pyjamas.ui', 'pyjamas.ui.RootPanel', 'pyjamas.ui.Button.Button', 'pyjamas.ui.Button', 'pyjamas.ui.Label.Label', 'pyjamas.ui.Label', 'pyjamas.ui.Grid.Grid', 'pyjamas.ui.Grid', 'pyjamas.ui.TextBox.TextBox', 'pyjamas.ui.TextBox', 'pyjamas.ui.ListBox.ListBox', 'pyjamas.ui.ListBox', 'pyjamas.ui.AbsolutePanel.AbsolutePanel', 'pyjamas.ui.AbsolutePanel', 'pygwt']
*/
