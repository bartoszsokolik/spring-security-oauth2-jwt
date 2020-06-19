## About
Simple REST application with Spring Security, OAuth2 and JWT. 
During authorization-server startup two users are added - user and admin

## Usage
To start application build application with `./mvnw clean install` and then run `docker-compose up`

To log in as user or admin curl
```
curl -v -X POST -H "Content-Type: application/x-www-form-urlencoded" 'http://localhost:8080/oauth/token' \
--user sampleClientId:sampleClientSecret \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=user' \
--data-urlencode 'password=user'
```

```
curl -v -X POST -H "Content-Type: application/x-www-form-urlencoded" 'http://localhost:8080/oauth/token' \
--user sampleClientId:sampleClientSecret \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=admin' \
--data-urlencode 'password=admin'
```
