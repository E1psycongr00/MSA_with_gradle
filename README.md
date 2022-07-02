# MSA_with_gradle
MSA 학습 내용을 Maven에서 Gradle을 활용한 멀티모듈로 재구성해보기


## 목적

- MSA 관련 내용 학습


## 공부 내용

- Kafka
- Eureka
- API gateway
- CQRS
- Ribbon
- feign client, restTemplate
- hystrix

## 특이사항

- Gradle 7 이상
- postgre sql
- 기존 학습 내용은 maven으로 따로 파일을 만들어서 관리했는데 이 프로젝트는 멀티 프로젝트로 구성해서 상위 모듈이 의존성을 관리하도록 만듬..
    - 멀티 모듈로 구성한 이유는 jar르 파일을 만들기 편리하고 상위 gradle에서 하위 모듈을 쉽게 관리 가능하기 때문에 사용했다.
