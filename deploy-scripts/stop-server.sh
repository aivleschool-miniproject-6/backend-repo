#!/bin/bash

echo ">>> 실행 중인 애플리케이션 종료"

PID=$(pgrep -f "java.*\.jar")

if [ -z "$PID" ]; then
  echo "실행 중인 애플리케이션이 없습니다."
else
  echo "PID $PID 종료 중..."
  kill -15 "$PID"
  sleep 5

  if kill -0 "$PID" 2>/dev/null; then
    echo "강제 종료합니다."
    kill -9 "$PID"
  fi

  echo "애플리케이션이 종료되었습니다."
fi
