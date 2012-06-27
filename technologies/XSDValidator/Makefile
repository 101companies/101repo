all:
	make build

build:
	xbuild XSDValidator.csproj

run:
	make build
	cd bin; mono XSDValidator.exe $(file)

test:
	make build
	cd bin/Debug; mono XSDValidator.exe ../../example/Company.xsd

clean:
	cd build; rm -r *.*	