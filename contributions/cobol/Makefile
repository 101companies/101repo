progs = 	SampleCompany.dylib \
		Total.dylib \
		Cut.dylib \
		Depth.dylib

test: ${progs}
	cobcrun SampleCompany
	cobcrun Total > Total.result
	diff baselines/Total.result Total.result
	rm -f Total.result
	cobcrun Cut
	cobcrun Total > Cut.result
	diff baselines/Cut.result Cut.result
	rm -f Cut.result
	cobcrun Depth > Depth.result
	diff baselines/Depth.result Depth.result
	rm -f Depth.result

%.dylib: programs/%.cob copybooks/* Makefile
	cobc -std=cobol85 programs/$*.cob

clean:
	rm -rf *.result
	rm -rf data/*
	rm -rf *.dylib
