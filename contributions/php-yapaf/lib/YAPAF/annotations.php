<?php

require_once(__DIR__ . DIRECTORY_SEPARATOR . '..' . DIRECTORY_SEPARATOR . 'addendum' . DIRECTORY_SEPARATOR . 'annotations.php');

/**
 * @Target("method")
 */
abstract class ClassPropertyJoinPoint extends Annotation {

	/**
	 * @var String
	 */
	public $class;

	/**
	 * @var String
	 */
	public $method;

	/**
	 * @var String
	 */
	public $var;

	/**
	 * @param array $tokens
	 * @return multitype:PHP_Token
	 */
	public function getMatchingTokens(array $tokens) {
		if (!($this->method || $this->var)) {
			trigger_error(
				'Neither a joining method nor variable is defined.',
				E_USER_WARNING
			);
			return array();
		}
		if ($this->method && $this->var) {
			trigger_error(
				'Both method and var are set for this joinpoint.',
				E_USER_WARNING
			);
		}

		return $this->_getMatchingTokens($tokens);
	}

	/**
	 * @param array $tokens
	 * @return multitype:PHP_Token
	 */
	abstract protected function _getMatchingTokens(array $tokens);
}


class After extends ClassPropertyJoinPoint {

	/**
	 * Return tokens of the finishing ";" for machting "after"-statements.
	 * For example, at "$this->someObject->doSth($var1, $var);" the token for ";" is returned;
	 *
	 * @param array $tokens
	 * @return multitype:PHP_Token_SEMICOLON
	 */
	protected function _getMatchingTokens(array $tokens) {
		$matches = array();

		$actClass = '';
		foreach ($tokens as $key => $token) {
			if ($token instanceof PHP_Token_Class) {
				$actClass = $token->getName();
			}

			if ($actClass !== $this->class &&
				$token instanceof PHP_Token_STRING &&
				(String)$token === $this->method) {

				do {
					$token = $tokens[$key++];
					if ($token instanceof PHP_Token_SEMICOLON) {
						$matches[] = $token;
						continue 2;
					}
				} while ($key < count($tokens));
			}
		}

		return $matches;
	}
}

class Before extends ClassPropertyJoinPoint {

	/**
	 * @param array $tokens
	 * @return multitype:PHP_Token_SEMICOLON
	 */
	protected function _getMatchingTokens(array $tokens) {
		$matches = array();

		$actClass = '';
		foreach ($tokens as $key => $token) {
			if ($token instanceof PHP_Token_Class) {
				$actClass = $token->getName();
			}

			// TODO Before-method works just outside of called class, before-var just within.
			if ($token instanceof PHP_Token_STRING &&
				($actClass !== $this->class && (String)$token === $this->method) ||
				($actClass === $this->class && (String)$token === $this->var)) {

				do {
					$token = $tokens[$key--];
					if ($token instanceof PHP_Token_SEMICOLON) {
						$matches[] = $token;
						continue 2;
					}
				} while ($key > 0);
			}
		}

		return $matches;
	}
}

class Call extends ClassPropertyJoinPoint {

	/**
	 * Returns token for the opening brace at position, where "call" is matched.
	 * At "public function __construct () {...}" the token for "{", eg.
	 *
	 * @param array $tokens
	 * @return multitype:PHP_Token_OPEN_CURLY
	 */
	protected function _getMatchingTokens(array $tokens) {
		$matches = array();

		$actClass = '';
		foreach ($tokens as $key => $token) {
			if ($token instanceof PHP_Token_Class) {
				$actClass = $token->getName();
			}

			if ($actClass === $this->class &&
				$token instanceof PHP_Token_FUNCTION &&
				$token->getName() === $this->method) {

				do {
					$token = $tokens[$key++];
					if ($token instanceof PHP_Token_OPEN_CURLY) {
						$matches[] = $token;
						continue 2;
					}
				} while ($key < count($tokens));
			}
		}

		return $matches;
	}
}