#!/bin/bash
set -ex

./gradlew clean
rm -rf src/gen
./gradlew openApiGenerate
mv build/generate-source/src/main src/gen
./gradlew build
