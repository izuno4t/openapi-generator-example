# openapi-generator-example

OpenAPI Generator を使ってサーバー/クライアントコードを生成するためのサンプル

- [OpenAPI Generator](https://openapi-generator.tech/)
  - [Documentation for the java Generator](https://openapi-generator.tech/docs/generators/java/)
  - [Plugins](https://openapi-generator.tech/docs/plugins/)
- [openapi-generator-maven-plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin)
- [OpenAPI Specification](https://swagger.io/specification/)
- [OpenAPI Generatorを使ったコードの自動生成とインタフェースの守り方](https://zenn.dev/angelica/articles/3b7ac906f73638)
- [第1回 OpenAPI Generator を使ったコード生成](https://developer.mamezou-tech.com/blogs/2022/06/04/openapi-generator-1/)
- [第2回 イベントストーミングとドメイン駆動設計の戦略的設計](https://developer.mamezou-tech.com/blogs/2022/06/09/openapi-generator-2/)
- [第3回 OpenAPI Generator 利用時の Generation Gap パターンの適用](https://developer.mamezou-tech.com/blogs/2022/06/17/openapi-generator-3/)
- [openapi generator を Spring Boot で利用してみる](https://yukihane.github.io/blog/202008/23/openapi-generator/)


## maven

OpenAPIファイルからソースを生成  

```sh
./mvnw generate-sources
```

ソース生成が`generate-sources`フェーズで実施されるため、実行する`Goal`でソースをさせたくない場合は、`codegen.skip=true`で生成を良くしする。

```sh
./mvnw clean compile -Dcodegen.skip=true
```

一連のコマンドは以下の通り

```shell:build-by-maven.sh
./mvnw clean
rm -rf src/gen
./mvnw generate-sources
mv target/generated-sources/src/main src/gen
./mvnw package -Dcodegen.skip=true
```

### Refs

- [openapi-generator-maven-plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin)

## Gradle

OpenAPIファイルからソースを生成  

```sh
./gradlew openApiGenerate
```

一連のコマンドは以下の通り

```shell:build-by-gradle.sh
./gradlew clean
rm -rf src/gen
./gradlew openApiGenerate
mv build/generate-resources/main src/gen
./gradlew build
```

### Refs

- [OpenAPI Generator Gradle Plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin)
