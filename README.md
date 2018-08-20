# transaction-service
A small demo showing transaction services written in JAX-RS and JAVA. API tests are written in Postman.

### Structure

```
transaction-service/
├── README.md
├── tests
│   ├── input.csv
│   ├── local_env.postman_environment.json
│   ├── test-cases.postman_collection.json
│   ├── test-data.postman_collection.json
│   └── transaction-service.postman_collection.json
└── transactionservice
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
