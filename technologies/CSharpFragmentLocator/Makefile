build:
	make locator/bin

locator/bin: locator/*.cs Makefile
	xbuild locator/locator.csproj

test:
	@./locator.py class/Company/method/Cut/1 < Company.cs > lines.json
	@diff -w lines.json baseline.json
	@echo Tests passed

clean:
	rm -rf locator/bin
	rm -rf locator/obj
	rm -f lines.json
