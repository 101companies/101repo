compile:
	jocamlc company.mli
	jocamlc -o company company.ml

test:
	jocaml company.cmo main.ml  > log
	diff log baseline
	rm log

clean:
	rm -f log
	rm -f company
	rm -f *.cmi
	rm -f *.cmo