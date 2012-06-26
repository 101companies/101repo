build:
	xbuild CSharpValidator.csproj

run:
	make build
	cd bin; mono CSharpValidator.exe $1	

test:
	make build
	cd bin; mono CSharpValidator.exe ../example/Program.cs

clean:
	cd build; rm -r *.*	