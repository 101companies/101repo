from HTMLParser import HTMLParser
import json

class MyHTMLParser(HTMLParser):
	tree_stack = []
	fragments = {"fragments": []}

	def get_line_number(self, tag):
		return self.getpos()[0]

	def get_current_position(self):
		position = self.fragments
		for fragment_name in self.tree_stack:
			for fragment in position["fragments"]:
				if fragment["name"] == fragment_name:
					position = fragment
					break
		return position

	def count_tags(self, fragment_name):
		fragment_count = 0
		for fragment in self.get_current_position()["fragments"]:
			if fragment["name"] == fragment_name:
				fragment_count += 1
		return fragment_count

	def add_fragment(self, new_fragment):
		self.get_current_position()["fragments"].append(new_fragment)


	#Begin Override Functions
	def handle_starttag(self, tag, attrs):
		self.tree_stack.append(str(tag))
		#print(self.count_tags(str(tag)))
		self.add_fragment({"name": str(tag), "startLine": self.get_line_number(tag), "fragments": [], "classifier": "tag"})

		#debugBegin
		#print(self.get_line_number(tag))
		print(self.tree_stack)

	def handle_endtag(self, tag):
		self.get_current_position()["endLine"] = self.get_line_number(tag)
		self.tree_stack.pop()

		#debugBegin
		#print(self.get_line_number(tag))
		#print(self.tree_stack)

	def handle_data(self, data):
		pass

	def get_fragments(self):
		return self.fragments


# instantiate the parser and fed it some HTML
parser = MyHTMLParser()
parser.feed('<html>\n'
			'<head>\n'
			'<title>Test</title>\n'
			'</head>\n'
			'<body>\n'
			'<h1>Parse me!</h1>\n'
			'<h1>Parse me too!</h1>\n'
			'<h1><b>P</b><b>a</b>rse me tooo!</h1>\n'
			'</body>\n'
			'</html>\n')
print(json.dumps(parser.get_fragments()))