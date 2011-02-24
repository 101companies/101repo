test:
	swipl -q -f Tests.pro > log
	diff log baseline
	rm log

clean:
	rm -f log
