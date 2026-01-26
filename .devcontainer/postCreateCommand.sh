#!/bin/sh

whoami
java -version

# Const
SCRIPTS_PATH=/workspace/.devcontainer

# sudo chown -R vscode:vscode .
# sudo chown -R vscode:vscode ~/.ssh
# chmod  0700 ~/.ssh; chmod 600 ~/.ssh/*

# mkdir -p ~/.gradle
# echo springProfilesActiveTests=testcontainer >>  ~/.gradle/gradle.properties

# Aliases
${SCRIPTS_PATH}/aliases.sh

# Bashrc additions
${SCRIPTS_PATH}/bashrc.sh

# Install Node version
${SCRIPTS_PATH}/nvm-install.sh

# NPM
npm install -g npm@latest
