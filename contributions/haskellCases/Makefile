none:

test:
	@echo "main" | ghci -v0 Main.hs > log
	@diff log baseline
	@echo Test succeeded.
	@make clean

clean:
	@rm -f log
