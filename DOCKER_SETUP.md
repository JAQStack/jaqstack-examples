# Docker Hub Deployment Setup

This guide explains how to set up automatic Docker Hub deployment for the JAQ Stack Examples repository.

## Overview

The repository is configured with:
- **Dockerfile**: Builds the Basic Authentication example
- **GitHub Actions**: Automatically builds and pushes to Docker Hub on main branch pushes
- **Docker Hub Repository**: `surendocker/jaqstack-examples`

## Prerequisites

1. Docker Hub account
2. GitHub repository with Actions enabled
3. Docker installed locally (for testing)

## Setup Instructions

### 1. Create Docker Hub Repository

1. Go to [Docker Hub](https://hub.docker.com/)
2. Click "Create Repository"
3. Set repository name: `jaqstack-examples`
4. Set visibility: Public or Private (your choice)
5. Click "Create"

### 2. Set up GitHub Secrets

1. Go to your GitHub repository
2. Navigate to **Settings** → **Secrets and variables** → **Actions**
3. Click **New repository secret**
4. Add the following secrets:

#### DOCKERHUB_USERNAME
- **Name**: `DOCKERHUB_USERNAME`
- **Value**: Your Docker Hub username (e.g., `surendocker`)

#### DOCKERHUB_TOKEN
- **Name**: `DOCKERHUB_TOKEN`
- **Value**: Your Docker Hub access token

**To create a Docker Hub access token:**
1. Go to Docker Hub → Account Settings → Security
2. Click "New Access Token"
3. Give it a name (e.g., "GitHub Actions")
4. Set permissions to "Read, Write, Delete"
5. Copy the generated token

### 3. Test the Setup

1. Push changes to the `main` branch
2. Go to **Actions** tab in your GitHub repository
3. Watch the "Build and Push Docker Image" workflow
4. Check Docker Hub for the new image

## Using the Deployed Image

### Pull and Run the Image

```bash
# Pull the latest image
docker pull surendocker/jaqstack-examples:latest

# Run the container
docker run -d -p 8080:8080 --name jaqstack-app surendocker/jaqstack-examples:latest
```

### Access the Application

- **URL**: http://localhost:8080
- **Basic Authentication Example**: http://localhost:8080

### Environment Variables

You can customize the application with environment variables:

```bash
docker run -d -p 8080:8080 \
  -e JAVA_OPTS="-Xmx1024m -Xms512m" \
  --name jaqstack-app \
  surendocker/jaqstack-examples:latest
```

### Docker Compose (Optional)

Create a `docker-compose.yml` file:

```yaml
version: '3.8'
services:
  jaqstack-app:
    image: surendocker/jaqstack-examples:latest
    ports:
      - "8080:8080"
    environment:
      - JAVA_OPTS=-Xmx1024m -Xms512m
    restart: unless-stopped
```

Then run:
```bash
docker-compose up -d
```

## Troubleshooting

### Common Issues

1. **Build fails**: Check that all secrets are set correctly
2. **Push fails**: Verify Docker Hub token has correct permissions
3. **Image not found**: Ensure the repository name matches exactly

### Checking Logs

```bash
# Check container logs
docker logs jaqstack-app

# Check GitHub Actions logs
# Go to Actions tab → Click on failed workflow → View logs
```

### Manual Build (for testing)

```bash
# Build locally
docker build -t jaqstack-examples:local .

# Run locally
docker run -d -p 8080:8080 --name jaqstack-app jaqstack-examples:local
```

## Image Tags

The workflow creates multiple tags:
- `latest`: Latest version from main branch
- `main`: Branch-specific tag
- `sha-<commit-hash>`: Specific commit tags

## Security Notes

- Never commit Docker Hub credentials to the repository
- Use GitHub Secrets for all sensitive information
- Regularly rotate your Docker Hub access tokens
- Consider using Docker Hub's automated security scanning

## Support

For issues with:
- **Docker**: Check [Docker documentation](https://docs.docker.com/)
- **GitHub Actions**: Check [GitHub Actions documentation](https://docs.github.com/en/actions)
- **Docker Hub**: Check [Docker Hub documentation](https://docs.docker.com/docker-hub/)
