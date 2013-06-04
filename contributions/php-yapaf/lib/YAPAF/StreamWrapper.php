<?php
/**
 * Copyright (c) 2010 Arne Blankerts <arne@blankerts.de>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *   * Neither the name of Arne Blankerts nor the names of contributors
 *     may be used to endorse or promote products derived from this software
 *     without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT  * NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER ORCONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * @package    PreProcessor
 * @author     Arne Blankerts <arne@blankerts.de>
 * @copyright  Arne Blankerts <arne@blankerts.de>, All rights reserved.
 * @license    BSD License
 * @link       http://github.com/theseer/preprocessor
 */

require_once(__DIR__ . DIRECTORY_SEPARATOR . 'Weaver.php');

/**
 * Streamwrapper around php preprocessor
 *
 * @author     Arne Blankerts <arne@blankerts.de>
 * @copyright  Arne Blankerts <arne@blankerts.de>, All rights reserved.
 */
class YAPAF_StreamWrapper {

	/**
	 * Source code
	 *
	 * @var string
	 */
	protected $source;

	/**
	 * Read position
	 *
	 * @var int
	 */
	protected $readPos;

	/**
	 * Length of loaded source code
	 *
	 * @var int
	 */
	protected $sourceLen;

	/**
	 * Stat-Cache from original file
	 *
	 * @var array
	 */
	protected $stat;

	/**
	 * Passed in configuration properties
	 *
	 * @var array
	 */
	protected static $properties = array(
		'protocol' => 'yapaf'
	);

	/**
	 * Constructor
	 *
	 * return void
	 */
	public function __construct() {
		$this->source = '';
		$this->readPos = 0;
		$this->sourceLen = 0;
	}

	public static function setCachePath($path) {
		self::$properties['cache'] = $path;
	}

	public function stream_open($path, $mode, $options, &$opened_path) {
		$path = str_replace(self::$properties['protocol'].'://','', $path);
		if (!file_exists($path)) {
			return false;
		}
		$this->stat = stat($path);
		if (isset(self::$properties['cache'])) {
			$cache = self::$properties['cache'] . '/' . sha1($path) . '.php';
			if (file_exists($cache) && filemtime($cache)>=filemtime($path)) {
				$this->source = file_get_contents($cache);
				$this->sourceLen = strlen($this->source);
				return true;
			}
		}

		$proc = new YAPAF_Weaver($path);

		$this->source = $proc->weave();
		$this->sourceLen = strlen($this->source);
		if (isset(self::$properties['cache'])) {
			file_put_contents($cache, $this->source);
		}
		return true;
	}

	public function stream_close() {
		$this->source = '';
		$this->readPos = 0;
	}

	public function stream_read($count) {
		if ($this->readPos + $count > $this->sourceLen) {
			$count -= ($this->readPos - $this->sourceLen);
		}
		$tmp = substr($this->source, $this->readPos, $count);
		$this->readPos += $count;
		return $tmp;
	}

	public function stream_eof() {
		return ($this->readPos == strlen($this->source));
	}

	public function stream_tell() {
		return $this->readPos;
	}

	public function stream_seek($offset,$whence ) {
		switch($whence) {
			case SEEK_SET: $this->readPos  = $offset; break;
			case SEEK_CUR: $this->readPos += $offset; break;
			case SEEK_END: $this->readPos  = $this->sourceLen + $offset;
		}
		return 0;
	}

	public function stream_stat() {
		return $this->stat;
	}

	public function url_stat($path, $flags) {
		$path = str_replace(self::$properties['protocol'].'://','', $path);
		if (!file_exists($path)) {
			return false;
		}
		return stat($fname);
	}
}