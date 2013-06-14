<?php

require_once(__DIR__ . DIRECTORY_SEPARATOR . 'YAPAF' . DIRECTORY_SEPARATOR . 'StreamWrapper.php');

class YAPAF {

	/**
	 * Name of protocoll to be used for stream-handling.
	 *
	 * @var String
	 */
	const PROTOCOLL = 'yapaf';

	/**
	 * @param array $aspects
	 */
	public static function init(array $aspects = array()) {
		YAPAF_Weaver::setAspects($aspects);

		stream_wrapper_register(self::PROTOCOLL, 'YAPAF_StreamWrapper');
		spl_autoload_register(array('YAPAF', 'yapaf_autoload'));
	}

	/**
	 * YAPAF-Autoloader
	 *
	 * @param String $class
	 */
	private static function yapaf_autoload($class) {
		foreach (explode(':', get_include_path()) as $classFolderPath) {
			$pathToFile = $classFolderPath . DIRECTORY_SEPARATOR . $class . '.php';
			if (file_exists($pathToFile)) {
				require self::PROTOCOLL . '://' . $pathToFile;
			}
		}
	}
}