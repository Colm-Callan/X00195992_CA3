#!/usr/bin/env bash
set -euo pipefail

JAVA_OPTS=${JAVA_OPTS:-"-Xms128m -Xmx256m"}
PORT="${PORT:-8080}"
JAR_PATH="app/build/libs/calculator-all.jar"

# Check /home/site/wwwroot path (when deployed via zip to web app)
if [ -f "/home/site/wwwroot/${JAR_PATH}" ]; then
  JAR="/home/site/wwwroot/${JAR_PATH}"
else
  # fallback to relative path inside package context
  if [ -f "${JAR_PATH}" ]; then
    JAR="${JAR_PATH}"
  else
    echo "ERROR: Jar not found at /home/site/wwwroot/${JAR_PATH} or ${JAR_PATH}"
    ls -la /home/site/wwwroot || true
    ls -la . || true
    exit 1
  fi
fi

echo "Starting app with JAR: $JAR"
export PORT
exec java $JAVA_OPTS -Dserver.port="$PORT" -jar "$JAR"