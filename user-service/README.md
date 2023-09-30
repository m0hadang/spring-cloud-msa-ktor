# check
- 접속 : http://192.168.219.102:{port}/user-service/health_check
- DB 접속 : http://192.168.219.102:{port}/h2-console
- 사용자 추가
- post : http://localhost:{port}/user-service/user
```json
{
    "email": "test123s@test3.com",
    "name" : "Jhon3",
    "pwd" : "test12a342"
}
```