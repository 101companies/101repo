<?php

	require_once('simpletest/autorun.php');
	require_once(dirname(__FILE__).'/../../annotations.php');

	require_once dirname(__FILE__).'/fixtures/namespaced_annotation.php';

	class TestOfNamespaces extends UnitTestCase {
	    public function testClassAndAnnotationInNamespaces() {
	        $reflection = new ReflectionAnnotatedClass('Example\Example');
	        $this->assertTrue($reflection->hasAnnotation('Example\Annotation\ExampleAnnotation'));
	    }
	}
?>
