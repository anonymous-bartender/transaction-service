# A REST API application with api tests
This project consists of `maven project` running REST app with `JAX-RS` top of `Jetty Server`. API tests are written separately with POSTMAN app. 

## Run Server
```
mvn jetty:run
```

## Structure
### REST Server (maven)

```
── transactionservice
    ├── pom.xml
    └── src
        ├── main
        │   ├── java
        │   │   └── com
        │   │       ├── dao
        │   │       │   ├── AppDAO.java
        │   │       │   └── TransactionException.java
        │   │       ├── main
        │   │       │   └── App.java
        │   │       └── resource
        │   │           ├── Sum.java
        │   │           └── Transaction.java
        │   └── webapp
        │       └── WEB-INF
        │           └── web.xml
        └── test
            └── java
                └── transaction
                    ├── BasicPingTest.java
                    └── Hooks.java
```
### API Tests (Postman Collections)
```
transaction-service/
└── tests
   ├── input.csv
   ├── local_env.postman_environment.json
   ├── test-cases.postman_collection.json
   ├── test-data.postman_collection.json
   └── transaction-service.postman_collection.json
```
