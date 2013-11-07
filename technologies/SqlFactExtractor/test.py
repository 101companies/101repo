from SQLFactExtractor import * 

extractor = SQLFactExtractor(sys.argv[1], False)
file_open = open("example/testResult.json","w")
file_open.write(json.dumps(extractor.extract_file()))
file_open.close()

extractor = SQLFactExtractor(sys.argv[1], True)
file_open = open("example/testResultWithLineNumbers.json","w")
file_open.write(json.dumps(extractor.extract_file()))
file_open.close()
