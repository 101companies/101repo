all:
	make build
	make run
	make clean

build:
	ghc Main.hs
	javac HelloWorld.java

run:
	./Main
	java HelloWorld
	python HelloWorld.py

clean:
	rm -f *.o Main *.hi *.class	
