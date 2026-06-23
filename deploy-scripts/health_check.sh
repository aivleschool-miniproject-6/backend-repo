#!/bin/bash
sleep 15
if ss -tlnp | grep :8080; then
  echo "Application is running"
  exit 0
else
  echo "Application failed to start"
  exit 1
fi
