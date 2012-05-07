# Headline

a fragment locator tool for Java

# Usage

The tool's executable is locator.py.

Usage: locator.py inputFile fragmentFile linesFile

* inputFile is the name of a .java input file.
* fragmentFile is the name of a file with the JSON input for fragment selection.
* linesFile is the name of a file with the JSON output for the resulting line range.

# Fragment selection

A JSON list is used to select a fragment.

The key is either "class" or "method" or "field".

The value is the unqualified name of the class or the method or the field.

That is, the package declaration of a file does not need to be specified.

The use of a list enables fragment selection into nested and anonymous classes.

## Example

<pre>
[
 { "class" : "HelloWorld" },
 { "method" : "main" }
]
</pre<

For the given file, the class "HelloWorld".

# Limitations

* Overloaded methods cannot be selected; XPath-like, position-based selection would be one option.

# Testing

Run "make test" to test the tool.
