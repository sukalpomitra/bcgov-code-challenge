FROM gitpod/workspace-postgres

# Install Maven
RUN sudo apt-get update && sudo apt-get install -y maven

# Configure PostgreSQL
USER postgres
RUN /etc/init.d/postgresql start && \
    psql --command "CREATE USER forms WITH SUPERUSER PASSWORD 'postgres';" && \
    createdb -O forms forms
USER root

# Set up working directory
WORKDIR /workspace
