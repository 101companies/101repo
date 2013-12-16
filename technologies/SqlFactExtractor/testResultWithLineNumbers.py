#! /usr/bin/env python
from SQLFactExtractor import * 

extractor = SQLFactExtractor(sys.stdin, True)
print(json.dumps(extractor.extract_file()))
