test: 
	@echo Calculating facts for examples and comparing them to baseline
	@./extractor.py < example/sampleCompany.xml > example/facts_sample_Company.json
	@diff --ignore-all-space example/facts_sample_Company.baseline example/facts_sample_Company.json
	@./extractor.py < example/Company.xsd > example/facts_company.json
	@diff --ignore-all-space example/facts_company.baseline example/facts_company.json
	@echo Tests passed

clean: 
	@rm -f example/*.json
