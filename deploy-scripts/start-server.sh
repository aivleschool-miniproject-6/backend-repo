#!/bin/bash

echo ">>> 애플리케이션 시작"

APP_DIR=/home/ec2-user/app
JAR_FILE=$(ls -t $APP_DIR/*.jar 2>/dev/null | head -1)

if [ -z "$JAR_FILE" ]; then
  echo "JAR 파일을 찾을 수 없습니다."
  exit 1
fi

echo "실행할 JAR: $JAR_FILE"

nohup java -jar "$JAR_FILE" \
  --spring.profiles.active=prod \
  > $APP_DIR/app.log 2>&1 &

echo "애플리케이션이 시작되었습니다. PID: $!"
