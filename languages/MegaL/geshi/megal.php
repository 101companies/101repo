<?php
/*************************************************************************************
 * megal.php
 * ----------
 * Author: Ralf Laemmel
 * Copyright: 101companies copyright applies
 * Release Version: 1.0.0
 * Date Started: 2012/04/01
 *
 * MegaL language file for GeSHi.
 * haskell.php was used as a starting point.
 *
 * CHANGES
 * -------
 * 2012/04/01 (1.0.0)
 *   - First Release
 *
 * TODO
 * ----
 *   - Think of how to leverage links
 *
 ************************************************************************************/

$language_data = array (
    'LANG_NAME' => 'MegaL',
    'COMMENT_SINGLE' => array( 1 => '--'),
    'COMMENT_MULTI' => array('{-' => '-}'),
    'COMMENT_REGEXP' => array(
        2 => "/-->/",
        3 => "/{-(?:(?R)|.)-}/s", //Nested Comments
        ),
    'CASE_KEYWORDS' => 0,
    'QUOTEMARKS' => array('"'),
    'ESCAPE_CHAR' => "\\",
    'KEYWORDS' => array(
        /* main keywords */
        1 => array(
		   'megamodel',
		   'local', 'global', 'variable', 'include',
		   'Language', 'Artifact', 'Function',
		   'File',
		   'Fragment',
		   'Program',
		   'Library',
		   'ObjectGraph',
		   'elementOf', 'definitionOf', 'subsetOf', 'partOf', 'correspondsTo', 'conformsTo', 'dependsOn', 'refersTo', 'realizationOf', 'descriptionOf'
            ),
        /* define names of main libraries, so we can link to it */
        2 => array(),
        /* functions */
        3 => array(),
        /* types */
        4 => array (),
        /* exceptions */
        5 => array ()
        ),
    /* highlighting symbols */
    'SYMBOLS' => array(
		       '/', '<', '@', ':', '+', '=', '-|', '~>', '->', '=>', '|->', '(', ')'
        ),
    'CASE_SENSITIVE' => array(
        GESHI_COMMENTS => false,
        1 => true,
        2 => true, /* functions name are case sensitive */
        3 => true, /* types name too */
        4 => true, /* finally exceptions too */
        5 => true
        ),
    'STYLES' => array(
        'KEYWORDS' => array(
            1 => 'color: #06c; font-weight: bold;', /* nice blue */
            2 => 'color: #06c; font-weight: bold;', /* blue as well */
            3 => 'font-weight: bold;', /* make the preduled functions bold */
            4 => 'color: #cccc00; font-weight: bold;', /* give types a different bg */
            5 => 'color: maroon;'
            ),
        'COMMENTS' => array(
            1 => 'color: #5d478b; font-style: italic;',
            2 => 'color: #339933; font-weight: bold;',
            3 => 'color: #5d478b; font-style: italic;', /* light purple */
            'MULTI' => 'color: #5d478b; font-style: italic;' /* light purple */
            ),
        'ESCAPE_CHAR' => array(
            0 => 'background-color: #3cb371; font-weight: bold;'
            ),
        'BRACKETS' => array(
            0 => 'color: green;'
            ),
        'STRINGS' => array(
            0 => 'background-color: #3cb371;' /* nice green */
            ),
        'NUMBERS' => array(
            0 => 'color: red;' /* pink */
            ),
        'METHODS' => array(
            1 => 'color: #060;' /* dark green */
            ),
        'REGEXPS' => array(
            ),
        'SYMBOLS' => array(
            0 => 'color: #339933; font-weight: bold;'
            ),
        'SCRIPT' => array(
            )
        ),
    'URLS' => array(
        1 => '',
        2 => '',
        3 => '',
        4 => '',
        5 => ''
        ),
    'OOLANG' => false,
    'OBJECT_SPLITTERS' => array(
        ),
    'REGEXPS' => array(
        ),
    'STRICT_MODE_APPLIES' => GESHI_NEVER,
    'SCRIPT_DELIMITERS' => array(
        ),
    'HIGHLIGHT_STRICT_BLOCK' => array(
        )
);

?>
