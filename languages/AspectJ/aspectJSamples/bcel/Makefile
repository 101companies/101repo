cp = -cp bcel/bcel-5.2.jar:.

all:
	make rebuild
	make run
	make transform
	make run

build:
	cd ..; javac ${cp} bcel/*.java

run:
	cd ..; java bcel/StringBuilder 1000

transform:
	cd ..; java ${cp} bcel.AddTiming
	
rebuild:
	make clean
	make build

clean:
	rm -f *.class
