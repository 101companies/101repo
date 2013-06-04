<?php

require_once('PHP/Token.php');
require_once('PHP/Token/Stream.php');
require_once(__DIR__ . DIRECTORY_SEPARATOR . 'annotations.php');

class YAPAF_Weaver extends PHP_Token_Stream {

	/**
	 * @var array
	 */
	protected static $_aspects = array();

	/**
	 * @param array $aspects
	 */
	public static function setAspects(array $aspects) {
		self::$_aspects = $aspects;
	}

	public function weave() {
		foreach (self::$_aspects as $aspect) {
			$aspectReflected = new ReflectionAnnotatedClass($aspect);
			foreach ($aspectReflected->getMethods() as $aspectMethodReflected) {
				$aspectsJoinpoints = $aspectMethodReflected->getAllAnnotations('Call');
				foreach ($aspectsJoinpoints as $joinpoint) {
					$tokens = $joinpoint->getMatchingTokens($this->tokens);
					foreach ($tokens as $token) {
						$this->callInjection($token, $joinpoint, $aspectMethodReflected);
					}
				}

				$aspectsJoinpoints = $aspectMethodReflected->getAllAnnotations('After');
				foreach ($aspectsJoinpoints as $joinpoint) {
					$tokens = $joinpoint->getMatchingTokens($this->tokens);
					foreach ($tokens as $token) {
						$this->afterInjection($token, $joinpoint, $aspectMethodReflected);
					}
				}

				$aspectsJoinpoints = $aspectMethodReflected->getAllAnnotations('Before');
				foreach ($aspectsJoinpoints as $joinpoint) {
					$tokens = $joinpoint->getMatchingTokens($this->tokens);
					foreach ($tokens as $token) {
						$this->beforeInjection($token, $joinpoint, $aspectMethodReflected);
					}
				}
			}
		}

		#$this->addFunction('My_SomeClass', 'echoSth', 'echo "blabla\n";');

		$this->parse();

		#var_dump((String)$this); ob_flush();
		return (String)$this;
	}

	/**
	 * @param string $class
	 * @param string $name
	 * @param string $body
	 */
	protected function addFunction($class, $name, $body) {
		foreach ($this->tokens as $token) {
			if ($token instanceof PHP_Token_CLASS &&
				$token->getName() === $class) {

				$function = "\npublic function " . $name . "() {\n" . $body . "\n}\n";
				$tokenStream = new parent($function);

				array_splice($this->tokens, $token->getEndTokenId(), 0, $tokenStream->tokens());
			}
		}
	}

	/**
	 * @param PHP_Token_SEMICOLON $token
	 * @param After $joinpoint
	 * @param ReflectionMethod $aspectMethodReflected
	 */
	private function afterInjection(PHP_Token_SEMICOLON $token, After $joinpoint, ReflectionMethod $aspectMethodReflected) {
		// TODO: Dont check for instanceof, if not needed.
		$callingObjectName = $this->getCallingObjectName($token, $joinpoint);
		$src  = 'if (' . $callingObjectName . ' instanceof ' . $joinpoint->class . ') {';
		$src .= $this->getMethodBody($aspectMethodReflected);
		$src .= '}';

		$tokenId = array_search($token, $this->tokens);
		$tokenStream = new parent($src);
		array_splice($this->tokens, $tokenId + 1, 0, $tokenStream->tokens());
	}

	/**
	 * @param PHP_Token_SEMICOLON $token
	 * @param Before $joinpoint
	 * @param ReflectionMethod $aspectMethodReflected
	 */
	private function beforeInjection(PHP_Token_SEMICOLON $token, Before $joinpoint, ReflectionMethod $aspectMethodReflected) {
		// TODO: Dont check for instanceof, if not needed.
		#$callingObjectName = $this->getCallingObjectName();
		// TODO: Get calling object name and insert instanceof-check.
		#$src  = 'if (' . $callingObjectName . ' instanceof ' . $joinpoint->class . ') {';
		$src = $this->getMethodBody($aspectMethodReflected);
		#$src .= '}';

		$tokenId = array_search($token, $this->tokens);
		$tokenStream = new parent($src);
		array_splice($this->tokens, $tokenId + 1, 0, $tokenStream->tokens());
	}

	/**
	 * @param PHP_Token_OPEN_CURLY $token
	 * @param Call $joinpoint
	 * @param ReflectionMethod $aspectMethodReflected
	 */
	private function callInjection(PHP_Token_OPEN_CURLY $token, Call $joinpoint, ReflectionMethod $aspectMethodReflected) {
		$methodBody = $this->getMethodBody($aspectMethodReflected);
		if (false !== strpos($methodBody, '__FUNC_SET_ARG__')) {
			$src = '
				$methodReflected = new ReflectionMethod(__METHOD__);
				$varNames = array();
				foreach ($methodReflected->getParameters() as $param) {
					$varNames[] = $param->name;
				}
			';
			$methodBody = preg_replace(
				'~__FUNC_SET_ARG__\((.*),(.*)\);~',
				'${$varNames[$1]} = $2;',
				$methodBody
			);

			// Append source to determine var-names after regex (bc performance).
			$methodBody = $src . $methodBody;
		}
		$replace = array(
				'__FUNC_GET_ARG__' 	=> 'func_get_arg',
				'__FUNC_GET_ARGS__' => 'func_get_args',
				'__FUNC_NUM_ARGS__' => 'func_num_args',
		);
		$methodBody = str_replace(array_keys($replace), $replace, $methodBody);
		$tokenStream = new parent($methodBody);

		array_splice($this->tokens, array_search($token, $this->tokens) + 1, 0, $tokenStream->tokens());
	}

	/**
	 * @param PHP_Token_SEMICOLON $token
	 * @param After $joinpoint
	 * @return string
	 */
	private function getCallingObjectName(PHP_Token_SEMICOLON $token, After $joinpoint) {
		$tokenId = array_search($token, $this->tokens);
		$callingObjectName = '';
		$key = $tokenId - 1;
		$cut = false;
		$token = $this->tokens[$key--];
		while (!($token instanceof PHP_Token_SEMICOLON)) {
			if ($cut) {
				$callingObjectName = (String)$token . $callingObjectName;
			}
			if ((String)$token === $joinpoint->method) {
				$cut = true;
				$key--;
			}
			$token = $this->tokens[$key--];
		}

		return $callingObjectName;
	}

	/**
	 * @param ReflectionMethod $aspectMethodReflected
	 * @return String
	 */
	private function getMethodBody(ReflectionMethod $aspectMethodReflected) {
		$methodClassSrc = file($aspectMethodReflected->getFileName());
		$startLine = $aspectMethodReflected->getStartLine();
		$endLine = $aspectMethodReflected->getEndLine() - $aspectMethodReflected->getStartLine() - 1;
		$methodBodySrc = array_slice($methodClassSrc, $startLine, $endLine);

		return implode("\n", $methodBodySrc);
	}
}