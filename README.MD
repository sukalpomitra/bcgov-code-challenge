## Getting Started

1. **Build and start the application:**

   ```bash
   docker-compose up
   ```

2. **Access your application locally:**

- [Swagger API-Docs](http://localhost:8080/swagger-ui/index.html)
- [React.js app](http://localhost:3000)

2. **Access your application remotely:**

- [React.js app](https://3000-arshadinnof-gitpodtestr-ftq4f1bo376.ws-us106.gitpod.io)
- [Swagger API-Docs](https://8080-arshadinnof-gitpodtestr-ftq4f1bo376.ws-us106.gitpod.io/swagger-ui/index.html)

## Automation Commands

- `docker-compose up`: Start the Docker-compose services
- `docker-compose build`: Build the Docker-compose services
- `docker-compose down`: Stop and remove the Docker-compose services
- `docker-compose stop`: Stop the Docker-compose services
- `docker-compose logs`: Stop and remove the Docker-compose services along with associated volumes
- `docker-compose down -v`: Stop and remove containers, including volumes

## Project-related documents

Please refer to the `/docs/` folder inside the project root directory.

## GitHub Workflow

The GitHub Actions workflow is triggered on each push to the `main` branch. It includes the following jobs:

- `run-cypress-tests`: Runs Cypress tests in the frontend. Other jobs depend on its successful completion.
- `build-push-frontend`: Builds and pushes the frontend Docker image to GitHub Container Registry.
- `build-push-backend`: Builds and pushes the backend Docker image to GitHub Container Registry.
- `build-push-database`: Builds and pushes the database Docker image to GitHub Container Registry.

## Accessing Gitpod Project and Workspace
To access the Gitpod project and workspace, follow the invite link [here](https://gitpod.io/orgs/join?inviteId=b6b7b216-69bb-4485-a3ff-ff79ce116057). Navigate to workspaces and open the relevant workspace.

## License

This project is licensed under the [Apache License 2.0](LICENSE.md) - see the [LICENSE.md](LICENSE.md) file for more details.

## Acknowledgments

- Special thanks to DEV TEAM for their contribution.

_Updated on 08/12/2023_

## Demo

A demo showcasing the system's capabilities can be found at the following link: [Demo Link](https://drive.google.com/drive/folders/12SwucZnguOHKMWCqIPb0iYTzMnAD1HYo?usp=sharing)

### Important Note:

- **GitHub Container Registry Credentials:**
  The GitHub Container Registry (GHCR) username and token mentioned in the GitHub workflow were hardcoded for demo purposes. In a production environment, it is crucial to treat these credentials securely. They will be set as secrets and managed through a secure deployment pipeline.

- **Gitpod and Image Updates:**
  The Gitpod configuration and the automation commands provided ensure that the latest Docker images for the backend, frontend, and database are fetched when creating a workspace. This guarantees that you always work with the most up-to-date environment. The setup is designed to pull the latest images from the GitHub Container Registry.
