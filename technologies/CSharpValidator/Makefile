all:
	make build

build:
	xbuild CSharpValidator.csproj

run:
	make build
	./validator.py $(file)

test:
	./validator.py example/Program.cs

clean:
	cd bin; rm -r *.*	