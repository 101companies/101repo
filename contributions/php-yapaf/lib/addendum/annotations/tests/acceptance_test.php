<?php
	require_once('simpletest/autorun.php');
	require_once('simpletest/mock_objects.php');
	
	require_once(dirname(__FILE__).'/../../annotations.php');
	
	interface DummyInterface {}
	
	/** @FirstAnnotation @SecondAnnotation */
	interface ExampleInterface {}
	
	class ParentExample {}
	
	/** @FirstAnnotation @SecondAnnotation */
	class Example extends ParentExample implements DummyInterface {
		/** @SecondAnnotation */
		private $exampleProperty;
		
		public $publicOne;
		
		public function __construct() {}
		
		/** @FirstAnnotation */
		public function exampleMethod() {
		}
		
		private function justPrivate() {}
	}
	
	/** @FirstAnnotation(1) @FirstAnnotation(2) @SecondAnnotation(3) */
	class MultiExample {
		/** @FirstAnnotation(1) @FirstAnnotation(2) @SecondAnnotation(3) */
		public $property;
		
		/** @FirstAnnotation(1) @FirstAnnotation(2) @SecondAnnotation(3) */
		public function aMethod() {}
	}
	
	class FirstAnnotation extends Annotation {
		public $key;
	}

	class SecondAnnotation extends Annotation {}

	class NoAnnotation {}

	/** @NoAnnotation @FirstAnnotation */
	class ExampleWithInvalidAnnotation {}

	/** @SelfReferencingAnnotation */
	class SelfReferencingAnnotation extends Annotation {}

	/** @IndirectReferenceLoopAnnotationHelper */
	class IndirectReferenceLoopAnnotation extends Annotation {}

	/** @IndirectReferenceLoopAnnotation */
	class IndirectReferenceLoopAnnotationHelper extends Annotation {}


	class Statics {
		const A_CONSTANT = 'constant';
		static public $static = 'static';
	}

	/** @FirstAnnotation(Statics::A_CONSTANT) */
	class ClassAnnotatedWithStaticConstant {}

	/** @FirstAnnotation(Statics::UNKNOWN_CONSTANT) */
	class ClassAnnotatedWithNonExistingConstant {}

	/** @FirstAnnotation(key = @SecondAnnotation(3.14)) */
	class ClassAnnotatedWithNestedAnnotations {}

	class Namespace_AnnotationWithNamespace extends Annotation {}

	/** @AnnotationWithNamespace */
	class ClassAnnotatedWithNamespacedAnnotation {}
	
	class TestOfAnnotations extends UnitTestCase {
		public function testReflectionAnnotatedClass() {
			$reflection = new ReflectionAnnotatedClass('Example');
			$this->assertTrue($reflection->hasAnnotation('FirstAnnotation'));
			$this->assertTrue($reflection->hasAnnotation('SecondAnnotation'));
			$this->assertFalse($reflection->hasAnnotation('NonExistentAnnotation'));
			$this->assertIsA($reflection->getAnnotation('FirstAnnotation'), 'FirstAnnotation');
			$this->assertIsA($reflection->getAnnotation('SecondAnnotation'), 'SecondAnnotation');
			
			$annotations = $reflection->getAnnotations();
			$this->assertEqual(count($annotations), 2);
			$this->assertIsA($annotations[0], 'FirstAnnotation');
			$this->assertIsA($annotations[1], 'SecondAnnotation');
			$this->assertFalse($reflection->getAnnotation('NonExistentAnnotation'));
			
			$this->assertIsA($reflection->getConstructor(), 'ReflectionAnnotatedMethod');
			$this->assertIsA($reflection->getMethod('exampleMethod'), 'ReflectionAnnotatedMethod');
			foreach($reflection->getMethods() as $method) {
				$this->assertIsA($method, 'ReflectionAnnotatedMethod');
			}
			
			$this->assertIsA($reflection->getProperty('exampleProperty'), 'ReflectionAnnotatedProperty');
			foreach($reflection->getProperties() as $property) {
				$this->assertIsA($property, 'ReflectionAnnotatedProperty');
			}
			
			foreach($reflection->getInterfaces() as $interface) {
				$this->assertIsA($interface, 'ReflectionAnnotatedClass');
			}
			
			$this->assertIsA($reflection->getParentClass(), 'ReflectionAnnotatedClass');
		}
		
		public function testReflectionAnnotatedClassInterface() {
			$reflection = new ReflectionAnnotatedClass('ExampleInterface');
			$this->assertTrue($reflection->hasAnnotation('FirstAnnotation'));
			$this->assertTrue($reflection->hasAnnotation('SecondAnnotation'));
		}
		
		public function testReflectionAnnotatedMethod() {
			$reflection = new ReflectionAnnotatedMethod('Example', 'exampleMethod');
			$this->assertTrue($reflection->hasAnnotation('FirstAnnotation'));
			$this->assertFalse($reflection->hasAnnotation('NonExistentAnnotation'));
			$this->assertIsA($reflection->getAnnotation('FirstAnnotation'), 'FirstAnnotation');
			$this->assertFalse($reflection->getAnnotation('NonExistentAnnotation'));
			
			$annotations = $reflection->getAnnotations();
			$this->assertEqual(count($annotations), 1);
			$this->assertIsA($annotations[0], 'FirstAnnotation');
			
			$this->assertIsA($reflection->getDeclaringClass(), 'ReflectionAnnotatedClass');
		}
		
		public function testReflectionAnnotatedProperty() {
			$reflection = new ReflectionAnnotatedProperty('Example', 'exampleProperty');
			$this->assertTrue($reflection->hasAnnotation('SecondAnnotation'));
			$this->assertFalse($reflection->hasAnnotation('FirstAnnotation'));
			$this->assertIsA($reflection->getAnnotation('SecondAnnotation'), 'SecondAnnotation');
			$this->assertFalse($reflection->getAnnotation('NonExistentAnnotation'));
			
			$annotations = $reflection->getAnnotations();
			$this->assertEqual(count($annotations), 1);
			$this->assertIsA($annotations[0], 'SecondAnnotation');
			
			$this->assertIsA($reflection->getDeclaringClass(), 'ReflectionAnnotatedClass');
		}
		
		public function testReflectionClassCanFilterMethodsByAccess() {
			$reflection = new ReflectionAnnotatedClass('Example');
			$privateMethods = $reflection->getMethods(ReflectionMethod::IS_PRIVATE);
			$this->assertEqual(count($privateMethods), 1);
			$this->assertEqual($privateMethods[0]->getName(), 'justPrivate');
		}
		
		public function testReflectionClassCanFilterPropertiesByAccess() {
			$reflection = new ReflectionAnnotatedClass('Example');
			$privateProperties = $reflection->getProperties(ReflectionProperty::IS_PUBLIC);
			$this->assertEqual(count($privateProperties), 1);
			$this->assertEqual($privateProperties[0]->getName(), 'publicOne');
		}
		
		public function testReflectionClassShouldReturnAllMethodsWithNoFilter() {
			$reflection = new ReflectionAnnotatedClass('Example');
			$methods = $reflection->getMethods();
			$this->assertEqual(count($methods), 3);
		}
		
		public function testReflectionClassShouldReturnAllPropertiesWithNoFilter() {
			$reflection = new ReflectionAnnotatedClass('Example');
			$properties = $reflection->getProperties();
			$this->assertEqual(count($properties), 2);
		}
		
		public function testMultipleAnnotationsOnClass() {
			$reflection = new ReflectionAnnotatedClass('MultiExample');
			$annotations = $reflection->getAllAnnotations();
			$this->assertEqual(count($annotations), 3);
			$this->assertEqual($annotations[0]->value, 1);
			$this->assertEqual($annotations[1]->value, 2);
			$this->assertEqual($annotations[2]->value, 3);
			$this->assertIsA($annotations[0], 'FirstAnnotation');
			$this->assertIsA($annotations[1], 'FirstAnnotation');
			$this->assertIsA($annotations[2], 'SecondAnnotation');
		}
		
		public function testMultipleAnnotationsOnClassWithRestriction() {
			$reflection = new ReflectionAnnotatedClass('MultiExample');
			$annotations = $reflection->getAllAnnotations('FirstAnnotation');
			$this->assertEqual(count($annotations), 2);
			$this->assertEqual($annotations[0]->value, 1);
			$this->assertEqual($annotations[1]->value, 2);
			$this->assertIsA($annotations[0], 'FirstAnnotation');
			$this->assertIsA($annotations[1], 'FirstAnnotation');
		}
		
		public function testMultipleAnnotationsOnProperty() {
			$reflection = new ReflectionAnnotatedClass('MultiExample');
			$reflection = $reflection->getProperty('property');
			$annotations = $reflection->getAllAnnotations();
			$this->assertEqual(count($annotations), 3);
			$this->assertEqual($annotations[0]->value, 1);
			$this->assertEqual($annotations[1]->value, 2);
			$this->assertEqual($annotations[2]->value, 3);
			$this->assertIsA($annotations[0], 'FirstAnnotation');
			$this->assertIsA($annotations[1], 'FirstAnnotation');
			$this->assertIsA($annotations[2], 'SecondAnnotation');
		}

		public function testMultipleAnnotationsOnPropertyWithRestriction() {
			$reflection = new ReflectionAnnotatedClass('MultiExample');
			$reflection = $reflection->getProperty('property');
			$annotations = $reflection->getAllAnnotations('FirstAnnotation');
			$this->assertEqual(count($annotations), 2);
			$this->assertEqual($annotations[0]->value, 1);
			$this->assertEqual($annotations[1]->value, 2);
			$this->assertIsA($annotations[0], 'FirstAnnotation');
			$this->assertIsA($annotations[1], 'FirstAnnotation');
		}
		
		public function testMultipleAnnotationsOnMethod() {
			$reflection = new ReflectionAnnotatedClass('MultiExample');
			$reflection = $reflection->getMethod('aMethod');
			$annotations = $reflection->getAllAnnotations();
			$this->assertEqual(count($annotations), 3);
			$this->assertEqual($annotations[0]->value, 1);
			$this->assertEqual($annotations[1]->value, 2);
			$this->assertEqual($annotations[2]->value, 3);
			$this->assertIsA($annotations[0], 'FirstAnnotation');
			$this->assertIsA($annotations[1], 'FirstAnnotation');
			$this->assertIsA($annotations[2], 'SecondAnnotation');
		}

		public function testMultipleAnnotationsOnMethodWithRestriction() {
			$reflection = new ReflectionAnnotatedClass('MultiExample');
			$reflection = $reflection->getMethod('aMethod');
			$annotations = $reflection->getAllAnnotations('FirstAnnotation');
			$this->assertEqual(count($annotations), 2);
			$this->assertEqual($annotations[0]->value, 1);
			$this->assertEqual($annotations[1]->value, 2);
			$this->assertIsA($annotations[0], 'FirstAnnotation');
			$this->assertIsA($annotations[1], 'FirstAnnotation');
		}

		public function testClassWithNoAnnotationParentShouldNotBeParsed() {
			$reflection = new ReflectionAnnotatedClass('ExampleWithInvalidAnnotation');
			$annotations = $reflection = $reflection->getAnnotations();
			$this->assertEqual(count($annotations), 1);
			$this->assertIsA($annotations[0], 'FirstAnnotation');
		}

		public function testCircularReferenceShouldThrowError() {
			$this->expectError("Circular annotation reference on 'SelfReferencingAnnotation'");
			$reflection = new ReflectionAnnotatedClass('SelfReferencingAnnotation');
			$reflection->getAnnotations();

			$this->expectError("Circular annotation reference on 'IndirectReferenceLoopAnnotationHelper'");
			$reflection = new ReflectionAnnotatedClass('IndirectReferenceLoopAnnotation');
			$reflection->getAnnotations();
		}

		public function testConstInAnnotationShouldReturnCorrectValue() {
			$reflection = new ReflectionAnnotatedClass('ClassAnnotatedWithStaticConstant');
			$annotation = $reflection->getAnnotation('FirstAnnotation');
			$this->assertEqual($annotation->value, Statics::A_CONSTANT);
		}

		public function testBadConstInAnnotationShouldCauseError() {
			$this->expectError("Constant 'Statics::UNKNOWN_CONSTANT' used in annotation was not defined.");
			$reflection = new ReflectionAnnotatedClass('ClassAnnotatedWithNonExistingConstant');
			$annotation = $reflection->getAnnotation('FirstAnnotation');
		}

		public function testNestedAnnotationSupport() {
			$reflection = new ReflectionAnnotatedClass('ClassAnnotatedWithNestedAnnotations');
			$this->assertEqual(count($reflection->getAnnotations()), 1);
			$annotation = $reflection->getAnnotation('FirstAnnotation');
			$this->assertIsA($annotation, 'FirstAnnotation');
			$this->assertIsA($annotation->key, 'SecondAnnotation');
			$this->assertEqual($annotation->key->value, 3.14);
		}

		public function testAnnotationWithoutNamespaceShouldBeRecognized() {
			$reflection = new ReflectionAnnotatedClass('ClassAnnotatedWithNamespacedAnnotation');
			$this->assertTrue($reflection->hasAnnotation('AnnotationWithNamespace'));
		}
	}
	
	Mock::generatePartial('AnnotationsBuilder', 'MockedAnnotationsBuilder', array('getDocComment'));
	
	class TestOfPerformanceFeatures extends UnitTestCase {
		public function setUp() {
			AnnotationsBuilder::clearCache();
		}

		public function tearDown() {
			AnnotationsBuilder::clearCache();
		}
	
		public function testBuilderShouldCacheResults() {
			$builder = new MockedAnnotationsBuilder;
			$reflection = new ReflectionClass('Example');
			$builder->build($reflection);
			$builder->build($reflection);
			$builder->expectOnce('getDocComment');
		}
	}
	
	class TestOfSupportingFeatures extends UnitTestCase {
		public function setUp() {
			Addendum::resetIgnoredAnnotations();
		}
		
		public function tearDown() {
			Addendum::resetIgnoredAnnotations();
		}
	
		public function testIgnoredAnnotationsAreNotUsed() {
			Addendum::ignore('FirstAnnotation', 'SecondAnnotation');
			$reflection = new ReflectionAnnotatedClass('Example');
			$this->assertFalse($reflection->hasAnnotation('FirstAnnotation'));
			$this->assertFalse($reflection->hasAnnotation('SecondAnnotation'));
		}
	}
?>
