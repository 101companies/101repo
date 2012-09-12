none:

test:
	@echo "main" | ghci -v0 Main.hs > log
	@diff log baseline
	@make clean

clean:
	@rm -f log
