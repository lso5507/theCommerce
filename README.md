# 사용자 CRU구현
## 더커머스 과제 제출을 위한 토이프로젝트입니다.

## Project
- Spring Boot 2.7.5
- spring-boot-starter-data-jpa 2.7.5
- h2database 2.2.224
- springdoc-openapi-ui 1.8.0
- jbcrypt 0.4

### Swagger API
[localhost:8081/](http://localhost:8081/swagger-ui/index.html#/)

### Database
- H2 Database(In Memory DataBase)
 
### 기능구현 설명
- 공통
  - Request Dto, Response Dto 구현
  - ErrorResponse 구현
  - Swagger API 추가
  
- 회원가입
  - 패스워드 bcrpyt(no Salt) 적용
  - 이메일 패턴 및 사용자 Validation 추가
- 사용자 수정
  - 변경된 컬럼만 수정진행
  - Password is Null -> 컬럼 업데이트 미진행
- 사용자 목록 조회
  - JPA pagination 사용
  - 정렬 종류 2가지(생성날짜 오름차순, 사용자명 오름차순)
   - UserSort Enum 클래스 사용으로 하드코딩 방지
- MockResult를 이용한 테스트코드 구현
  -  성공 및 실패 시나리오 테스트 코드 구현
