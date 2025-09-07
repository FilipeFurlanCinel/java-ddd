.PHONY: start stop

# Start MySQL container and Spring Boot application
start:
	docker compose up -d
	./mvnw spring-boot:run

# Stop Spring Boot (Ctrl+C) then shut down containers
stop:
	docker compose down