# Getting Started

## Required software

- Install Docker Desktop (https://www.docker.com/products/docker-desktop/)
- Install VSCode install VSCode (or any devcontainers compatible IDE) (https://code.visualstudio.com/download)
- Download this repository (download zip archive or use git)

## Start devcontainer

- Open VSCode
- Open the source code folder you just downloaded
- VSCode will show a popup at the bottom right telling you to reopen the project in a devcontainer
  - If it doesn't show it, using CTRL+SHIFT+p (or CMD+SHIFT+p on mac), search for the Dev containers: reopen command in Containers

VSCode will restart and, after a few seconds/minutes, open inside a devcontainer.
You can confirm that the devcontainer is working correctly by issuing the `mvn --version` command

# MVN

## COMMANDS

```
mvn clean
mvn compile
mvn spring-boot:run
```

# VSCODE

To run the project in debug mode, press `F5`
