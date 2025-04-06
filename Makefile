.PHONY: build
build:
	clojure -T:build jar

.PHONY: uber
uber:
	clojure -T:build uber

.PHONY: clean
clean:
	rm -rf target
