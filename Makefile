.PHONY: build
build:
	clojure -T:build jar

.PHONY: uber
uber:
	clojure -T:build uber

.PHONY: clean
clean:
	rm -rf target

.PHONY: migrate
migrate:
	psqldef calendar -p15432 < schema.sql
