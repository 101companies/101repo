all:
	make build
	make run
	make clean

build:
	ghc Main.hs
	javac *.java

run:
	./Main
	java Demo

clean:
	rm -f *.o Main *.hi *.class     
