build:
	make locator/bin

locator/bin: locator/*.cs Makefile
	xbuild locator/locator.csproj

test:
	mono locator/bin/Debug/locator.exe Company.cs fragment.json lines.json
	diff -w baseline.json lines.json	

fragmentDescriptionTest:
	./locator.py Company.cs Cut/0

clean:
	rm -rf locator/bin
	rm -rf locator/obj
	rm -f lines.json
