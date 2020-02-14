# graphql-demo project

This project uses spring boot with H2 DB as in memory database and graphql to demonstrate graphql capabilities. 

If you want to learn more about Graphql, please visit its website: https://graphql.org/ .

## Packaging and running the application

The application is packagable using `./mvnw package`.
It produces the executable `graphql-demo-1.0.0-SNAPSHOT.jar` file in `/target` directory.

The application is now runnable using `java -jar target/graphql-demo-1.0.0-SNAPSHOT.jar`.

## Accessing the H2 Console

You can access the H2 DB console at: http://localhost:8080/h2-console

## Sample Graph Queries

<B>POST: http://localhost:8080/client </B>
Payload: choose from below list
a) Get All clients details with first name, mid name and  city
```
{
    allClients{
       firstName,
       midName,
       address{
       city
       }
    }
 }
```
b) Get client (having clientId: 2) details with first name, city, street name
```
{
   client(clientId:2){
      firstName,
      address{
      city,
      streetName
      }
   }
}
``` 