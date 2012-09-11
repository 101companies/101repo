all:

test:
	@rm -f log
	@touch log
	@echo Total before cut: >> log 
	@./total.py input.json >> log
	@./cut.py input.json output.json >> log
	@echo Total after cut: >> log 
	@./total.py output.json >> log
	@diff baseline log
	@make clean

clean:
	@rm -f output.json log
