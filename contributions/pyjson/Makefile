test:
	rm -f log
	touch log
	echo Total before cut: >> log 
	./total.py sampleCompany.json >> log
	./cut.py sampleCompany.json output.json >> log
	echo Total after cut: >> log 
	./total.py output.json >> log
	diff baseline log
	make clean

clean:
	rm -f output.json log
