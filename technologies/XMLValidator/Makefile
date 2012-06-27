all:
	make build

build:
	xbuild XMLValidator.csproj

run:
	make build
	./validator.py $(file)

test:
	./validator.py example/AcmeCorp.xml

clean:
	cd bin; rm -r *.*	