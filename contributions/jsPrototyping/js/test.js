/**
 * test.js-Unit-testing framework
 * 	Test is a small package, which allows to
 * 	create test suites with different simple
 * 	test cases.
 * 
 * Indentation: by tabs (size=4)
 * 
 * @author {Marius Rackwitz}
 * @license {GPLv3}
 * @version {0.3}
 */
var test = new (function($, undefined) {
	
	/**
	 * Init a callback property, which contains a
	 * function to handle test results.
	 */
	this.callback = function(testCase, success, message) {
		if (success) {
			console.log("[SUCCEED] "+message);
		} else {
			console.log("[FAILED] "+message);
		}
	};
	
	
	/**
	 * Check if a condition is true
	 */
	this.assertTrue = function(toBeTrue) {
		if (!toBeTrue) {
			throw "assertTrue: the condition is false!";
		}
	};
	
	
	/**
	 * Check if two values are equal
	 */
	this.assertEquals = function(expected, compareWith) {
		if (expected != compareWith) {
			throw "assertEquals: the value is not equal to expected '"+expected+"'";
		}
	};
	
	
	/**
	 * Check if a function fails
	 */
	this.assertFail = function(f) {
		try {
			f();
			throw "assertFail: function didn't failed!";
		} catch (e) {}
	};
	
	
	/**
	 * Check if a function fails with a specified exception
	 */
	this.assertFailWith = function(expectedException, f) {
		try {
			f();
			throw "assertFail: function didn't failed!";
		} catch (e) {
			if (e != expectedException) {
				throw "assertFail: function failed with an other exception"
					+" as expected '"+expectedException+"'";
			}
		}
	};
	
	
	/**
	 * Constructor for a single test case, which gives a
	 * testFunction a fully extensible object context to
	 * store or read fields.
	 */
	this.TestCase = function(testFunction) {
		this.name		= "";
		this.succeed	= undefined;
		
		var testFunction = testFunction;
		
		// NOTE: self helps to keep reference to the outer context
		var self = this;
		
		/**
		 * Executes the inner testFunction and
		 * catches any exceptions. If an exception
		 * was thrown then return false, otherwise
		 * return true. But anyhow the callback,
		 * will be called before returning.
		 */
		this.execute = function(testSuite) {
			var testName = "Test of '"+self.name+"'";
			
			try {
				testFunction.call(testSuite);
			} catch (e) {
				test.callback(self, false, testName+" failed because of: "+e);
				return false;
			}
			
			test.callback(self, true, testName+" succeeded!");
			return true;
		};
	}
	
	
	/**
	 * Constructor for a test case bundle,
	 * which could be run by one call.
	 */
	this.TestSuite = function(data) {
		if (data == undefined) {
			throw "First argument is not optional!";
		}
		
		// Tear up and down functions
		this.beforeAll	= (data.beforeAll	!= undefined) ? data.beforeAll	: $.noop;
		this.before		= (data.before		!= undefined) ? data.before		: $.noop;
		this.after		= (data.after		!= undefined) ? data.after		: $.noop;
		this.afterAll	= (data.afterAll	!= undefined) ? data.afterAll	: $.noop;
		
		// Store the test cases and dynamically bind their names to the function objects
		var testCases	= data.testCases;
		$.each(testCases, function(name, testCase) {
					testCase.name = name;
				});
		
		var self = this;
		
		this.execute = function(testCase) {
			self.beforeAll();
			self.before();
			testCase.execute(self);
			self.after();
			self.afterAll();
			
			return testCase.succeed;
		};
		
		
		this.executeAll = function() {
			var success = true;
			
			self.beforeAll();
			$.each(testCases, function(name, testCase) {
					self.before();
					success &= testCase.execute(self);
					self.after();
				});
			self.afterAll();
			
			return success;
		};
		
		
		this.getCases = function() {
			return testCases;
		};
		
	};
	
})($);
