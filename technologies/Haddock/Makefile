all:
	make clean
	make build
	make doc
	make clean

build:
	cabal check
	cabal configure
	cabal build

doc:
	cabal haddock

clean:
	cabal clean

