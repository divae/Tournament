.PHONY: *

build:
	docker build -t app .
run:
	docker run app