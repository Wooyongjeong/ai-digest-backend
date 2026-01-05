# 개발 환경 설정

## 공통 코딩 규약

- 모든 코드에 상세한 주석 포함
- 함수명은 camelCase 사용

# 프로젝트 개요

## 주제

- 사용자가 Topic과 Keyword들을 설정하여 Subscription하면, 매일 아침 설정한 이메일로 해당 주제와 키워드들을 기반으로 뉴스레터를 생성하여 보내주는 서비스

## 기술 스택

- Spring 서버는 사용자 인증, 인가와 구독한 내용들, 메일 발송 등을 처리함
- spring Security, redis를 이용한 session 처리
- Java 21, Spring Boot, Spring Data JPA

