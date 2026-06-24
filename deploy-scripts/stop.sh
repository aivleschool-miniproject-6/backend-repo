#!/bin/bash
if systemctl is-active --quiet book-backend; then
  sudo systemctl stop book-backend
fi
