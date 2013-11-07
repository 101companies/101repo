#! /usr/bin/env python
from SQLFactExtractor import * 

extractor = SQLFactExtractor(sys.argv[1], False)
print(json.dumps(extractor.extract_file()))
