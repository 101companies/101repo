<?php
	namespace Example\Annotation;
	require_once(dirname(__FILE__).'/../../../annotations.php');

	use Annotation;

	class ExampleAnnotation extends Annotation {}

	namespace Example;

	/** @Example\Annotation\ExampleAnnotation */
	class Example {}
?>

