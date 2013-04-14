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

clean:
	rm -f *.o Main *.hi *.class	
