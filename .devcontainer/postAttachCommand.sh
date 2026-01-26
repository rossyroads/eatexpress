#!/bin/sh -i

# Reuse ssh-agent, but don't throw error when no agent present
ssh-add -l || true
