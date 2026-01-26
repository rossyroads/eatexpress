#!/bin/bash -i

# Alias Setup
cat <<EOF >~/.bash_aliases
alias alias-update='bash /workspace/.devcontainer/scripts/aliases.sh && source ~/.bash_aliases'
alias ssha='eval \$(ssh-agent) && ssh-add ~/.ssh/id_ed25519'
EOF
