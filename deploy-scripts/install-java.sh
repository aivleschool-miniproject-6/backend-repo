#!/bin/bash

echo ">>> Java 17 설치 확인"

if java -version 2>&1 | grep -q "17"; then
  echo "Java 17이 이미 설치되어 있습니다."
else
  echo "Java 17 설치 중..."
  dnf install -y java-17-amazon-corretto-devel
  echo "Java 17 설치 완료"
fi

java -version
