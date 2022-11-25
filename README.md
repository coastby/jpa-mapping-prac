## JPA mapping 연습


#### API swagger 링크
http://ec2-43-200-181-68.ap-northeast-2.compute.amazonaws.com:8080/swagger-ui/

#### API 설계
| 구분 | 기능 | METHOD | API |
| --- | --- | --- | --- |
| 병원 관리 | 병원 리스트 조회 | GET | /api/v1/hospitals |
|  | 특정 병원 정보 조회 | GET | /api/v1/hospitals/{id} |
|  | 특정 병원 댓글 조회 | GET | ​/api​/v1​/hospitals​/{id}​/comments |
|  | 병원 댓글 작성 | POST | /api/v1/hospitals/{id}/comments |
|  | 병원 댓글 id로 조회 | GET | /api/v1/hospitals/comments/{id} |
| 도서 관리 | 도서 리스트 조회 (저자, 출판사 이름 포함) | GET | /api/v1/books |





