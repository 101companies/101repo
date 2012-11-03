<?php
	require_once('simpletest/autorun.php');
	require_once(dirname(__FILE__).'/../../annotations.php');

	/** @Target("class") */
	class ClassRestrictedAnnotation extends Annotation {}

	/** @Target("method") */
	class MethodRestrictedAnnotation extends Annotation {}
	
	/** @Target("property") */
	class PropertyRestrictedAnnotation extends Annotation {}

	/** @Target("nested") */
	class NestedRestrictedAnnotation extends Annotation {}

	/** @Target({"class", "property"}) */
	class ClassOrPropertyRestrictedAnnotation extends Annotation {}
	

	class BadlyAnnotatedClass {
		/** @ClassRestrictedAnnotation */
		private $property;
		
		/** @ClassRestrictedAnnotation */
		public function method() {}
		
		/** @ClassOrPropertyRestrictedAnnotation */
		public function method2() {}
	}

	/** @ClassRestrictedAnnotation(value = @MethodRestrictedAnnotation(true)) */
	class ClassWithBadlyNestedAnnotations {}
	
	/** @ClassRestrictedAnnotation */
	class SuccesfullyAnnotatedClass {
		/** @PropertyRestrictedAnnotation */
		private $property;
		
		/** @ClassOrPropertyRestrictedAnnotation */
		private $property2;

		/** @MethodRestrictedAnnotation */
		public function method() {}

		/** @MethodRestrictedAnnotation(value = @NestedRestrictedAnnotation) */
		public function method2() {}
	}

	class TestOfConstrainedAnnotation extends UnitTestCase {
		public function testClassAnnotationThrowsErrorWhenOnMethod() {
			$this->expectError("Annotation 'ClassRestrictedAnnotation' not allowed on BadlyAnnotatedClass::method");
			$reflection = new ReflectionAnnotatedClass('BadlyAnnotatedClass');
			$method = $reflection->getMethod('method');
		}
		
		public function testClassAnnotationThrowsErrorWhenOnProperty() {
			$this->expectError("Annotation 'ClassRestrictedAnnotation' not allowed on BadlyAnnotatedClass::\$property");
			$reflection = new ReflectionAnnotatedClass('BadlyAnnotatedClass');
			$method = $reflection->getProperty('property');
		}
		
		public function testSingleTargetAnnotationThrowsNoErrorWhenOnRightPlace() {
			$reflection = new ReflectionAnnotatedClass('SuccesfullyAnnotatedClass');
			$method = $reflection->getMethod('method');
			$property = $reflection->getProperty('property');
		}
		
		public function testMultiTargetAnnotationThrowsErrorWhenOnWrongPlace() {
			$this->expectError("Annotation 'ClassOrPropertyRestrictedAnnotation' not allowed on BadlyAnnotatedClass::method2");
			$reflection = new ReflectionAnnotatedClass('BadlyAnnotatedClass');
			$method = $reflection->getMethod('method2');
		}
		
		public function testMultiTargetAnnotationThrowsNoErrorWhenOnRightPlace() {
			$reflection = new ReflectionAnnotatedClass('SuccesfullyAnnotatedClass');
			$method = $reflection->getProperty('property2');
		}

		public function testBadlyNestedAnnotationThrowsError() {
			$this->expectError("Annotation 'MethodRestrictedAnnotation' nesting not allowed");
			$this->expectError("Annotation 'MethodRestrictedAnnotation' nesting not allowed"); // because of parsing
			$reflection = new ReflectionAnnotatedClass('ClassWithBadlyNestedAnnotations');
		}

		public function testSuccesfullyNestedAnnotationThrowsNoError() {
			$reflection = new ReflectionAnnotatedClass('SuccesfullyAnnotatedClass');
			$reflection->getMethod('method2')->getAnnotation('MethodRestrictedAnnotation');
			
		}
	}
?>
