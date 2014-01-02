#! /usr/bin/env python
import sys
import json
from SQLFactExtractor import * 

extractor = SQLFactExtractor(sys.stdin)
print(json.dumps(extractor.extract_file()))