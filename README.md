# Gradle Command

버전
- `gradle --version`

프로젝트 생성
- `gradle init [--type 타입명]`

프로젝트 빌드
- `gradle build`
- 빌드 후 생성된 자바 파일을 직접 실행
  - `java -jar '-Dserver.port=9004' .\build\libs\user-service-0.0.1-SNAPSHOT.jar`

프로젝트 실행
- `gradle run`

스프링부트 프로젝트 실행
- `gradle bootRun`

프로젝트 클린
- `gradle clean`

gradle-wrapper 실행명령
- `gradlew` : 리눅스(맥)
- `gradlew.bat` : 윈도우

윈도우 스프링부트 프로젝트 실행
- `.\gradlew.bat bootRun`

Gradle 인자 사용
- `.\gradlew.bat bootRun --args='--port=9003'`
- application.yaml에서 port 입력 받을 수 있도록 처리 필요
```yaml
server:
  port: ${port:9001}
```

# 주의
Spring Boot 사용시 패키지 경로 주의 : 다른 패키지에 Config, Bean, Controller 등록시 Spring Boot에서 해당 컴포넌트를 탐색하지 못하게 된다.
