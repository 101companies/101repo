build:
	@echo nothing to do

test: test-positive test-negative

test-positive:
	./validator.py index.html -verbose

test-negative:
	./validator.py department.html -verbose -negative
