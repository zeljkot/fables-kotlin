Java EE example shows how to convert simple Java Enterprise Edition project from Java to Kotlin. It contains 4 modules showing different
stage of conversion:

* *java:* pure Java code.
* *converted:* converted code without any special Kotlin plugins.
* *plugins:* Kotlin compiler and Jackson plugins. 
* *idiomatic:* idiomatic Kotlin code. 

## Setting up the project

Prepare IntelliJ IDEA 2017, JDK 8, Gradle, PostgreSQL and Wildfly 10.

Thanks to FlywayDB, database preparation is simple. Just follow the 
[instructions in the database module](https://github.com/zeljkot/fables-kotlin/blob/master/jee/database/README.md).

Deploy the PostgreSQL driver to Wildfly, start in, and create data source "TestDS" with JNDI name `java:jboss/datasources/test`.
I will not go into details of Wildfly configuration, but there is a lot of articles on the Internet that cover that topic nicely.
 I would recommend deploying driver as module rather than auto-deploying it.
