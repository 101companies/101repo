all:
	make build

build:
	xbuild XSDValidator.csproj

run:
	make build
	./validator.py $(file)

test:
	./validator.py example/Company.xsd

clean:
	cd bin; rm -r *.*	