# sample project

## 構成
- Spring Boot
- Spring WebFlux

## 開発環境(推奨)
- Windows10
- IntelliJ(IntelliJ IDEA Community Edition 2019.1.3)

## Database
- MySQL(5.7)

## 起動方法
```sh
./gradlew clean bootRun
```

## 実行可能Jarのビルドと実行

```sh
./gradlew clean build
java -jar build/libs/spring-sample-webflux-0.0.1-SNAPSHOT.jar
```

## エンドポイント
| エンドポイント                   | メソッド | 用途 |
|:--------------------------------:|:-------|:------------|
| http://localhost:8080/users      | GET    | ユーザー一覧情報取得  |
| http://localhost:8080/users/{id} | GET    | ユーザー情報取得  |
| http://localhost:8080/users      | POST   | ユーザー情報登録 |
| http://localhost:8080/users/{id} | PUT    | ユーザー情報登録 |
| http://localhost:8080/users/{id} | DELETE | ユーザー情報登録 |