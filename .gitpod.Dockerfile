FROM gitpod/workspace-full

# Install Maven
RUN apt-get update && apt-get install -y maven

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
