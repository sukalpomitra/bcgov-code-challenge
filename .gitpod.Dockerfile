FROM openjdk:11-jre-slim

# Install Maven
RUN apt-get update && apt-get install -y maven

# Install Git
RUN apt-get update && apt-get install -y git

# Install PostgreSQL
RUN apt-get install -y postgresql postgresql-contrib

# Configure PostgreSQL
USER postgres
RUN /etc/init.d/postgresql start && \
    psql --command "CREATE USER forms WITH SUPERUSER PASSWORD 'postgres';" && \
    createdb -O forms forms
USER root

# Set up working directory
WORKDIR /workspace
