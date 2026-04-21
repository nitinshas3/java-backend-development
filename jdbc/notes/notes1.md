there are many db vendors like postgresql , mysql , oracle db etc 

so java created an interface for them to implement their own methods , how they will implement the methods with their database syntax 

java.sql package contains the interface it has to be imported , its in jdk 

.jar files of the individual database vendors contain the .class files of their implentation of the java interface of jdbc , so this .jar files need to be added in dependency of maven , coz these are not in jdk

body different , or implementataion different of all 3 but methods will be same because of interface

the implementation class id called jdbc driver

----------------

steps involved in developing jdbc application 

import the required package 

load and register the driver 

establish the connection 

create the statement 

execute the query 

process the result 

close

java.sql.* → the standard JDBC interfaces (Connection, DriverManager, PreparedStatement, ResultSet, etc.).

PostgreSQL driver (org.postgresql.Driver) → the actual implementation that knows how to talk to a PostgreSQL server.

---------------------

If you already downloaded the PostgreSQL JDBC jar manually (like postgresql-42.7.10.jar), you can put it on your project’s classpath and use it directly.

In plain Java (no Maven), you’d drop the jar into a lib/ folder and run with: