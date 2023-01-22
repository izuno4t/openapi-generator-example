#!/bin/bash -x

./mvnw clean
rm -rf src/gen
./mvnw generate-sources
mv target/generated-sources/src/main src/gen
./mvnw package -Dcodegen.skip=true
