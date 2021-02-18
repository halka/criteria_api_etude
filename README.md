# criteria_api_etude
How it works?

To learn how to use Criteria API and Spring boot
## setup database
```shell
psql postgres
```

### create database
```sql
CREATE DATABASE criteria_etude OWNER=postgres;
```

## Build and Run
```shell
./gradlew build
./gradlew bootRun
```

## Endpoints
### create user
POST /users
```json
{
  "name": "Saya",
  "status": "active"
}
```
### update user
PUT /users/{id}
```json
{
  "name": "Ayame",
  "status": "inactive"
}
```
### get all users
GET /users

### get specified user
GET /users/{id}

### delete user
DELETE /users/{id}
