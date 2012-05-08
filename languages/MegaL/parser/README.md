# Headline

a parser for MegaL models

# Usage

Here is an illustration of usage.

<pre>
$ pwd
/Users/laemmel/projects/101repo/languages/MegaL/parser
$ make ../../../technologies/xsd.exe/MegaL/basicDeserialization.megal.parse
Parsing ../../../technologies/xsd.exe/MegaL/basicDeserialization.megal
</pre>

# Status

Under development

# Issues

* Release Text-to-RDF conversion.
* Develop RDF-to-Text conversion.
* Enable shortcuts; see below.

<pre>
x r y
x r z
->
x r y, z

x r y
x r' z
->
x 
  r y;
  r' z
</pre>
