build:
	xbuild CSharpValidator.csproj

run:
	make build
	cd bin/Debug; mono CSharpValidator.exe $1	

test:
	make build
	cd bin/Debug; mono CSharpValidator.exe ../example/Program.cs

clean:
	@no-op	