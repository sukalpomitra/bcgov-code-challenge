FROM openjdk:11-jre-slim

# Install Maven
RUN apt-get update && apt-get install -y maven

# Install PostgreSQL
RUN apt-get install -y postgresql postgresql-contrib

# Configure PostgreSQL
USER postgres
RUN /etc/init.d/postgresql start && \
    psql --command "CREATE USER postgres WITH SUPERUSER PASSWORD 'postgres';" && \
    createdb -O postgres postgres
USER root

# Set up working directory
WORKDIR /workspace

docker run -p 8080:8080 -t your-username/your-repo:latest
