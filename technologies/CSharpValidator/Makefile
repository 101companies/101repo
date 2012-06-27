build:
	xbuild CSharpValidator.csproj

run:
	make build
	cd bin; mono CSharpValidator.exe $(file)

test:
	make build
	cd bin; mono CSharpValidator.exe ../example/Program.cs

clean:
	cd build; rm -r *.*	