package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Firstjdbc {
    public static void main(String[] args) throws ClassNotFoundException ,SQLException{
        //1) first step to download jar files of drivers and install dependencies 
        //2)load and register the driver 
        Class.forName("org.postgresql.Driver");
        //for static blocks in class , if it has to be executed the class has to be loaded , for other blocks an object has to be created for that block to run unlike static block , so class.forname is used to load static block and the calssname here is in the parameters , it is Driver , and that static block contains drivermanager.registerdriver method 

        //3)establish the connection 
       String url = "jdbc:postgresql://localhost:5432/jdbclearning";
        String user = "postgres";
        String password = "mandeshpostgresql";
        Connection conn =   DriverManager.getConnection(url,user,password);

        //4)creating the statement
        Statement statement = conn.createStatement();

        //5)execute query
        //here the sql queries have to be writte manually 

        /*String sql = "insert into studentinfo(id,sname,sage,scity) values(1,'nitin',20,'mysore')";
        int roweffected = statement.executeUpdate(sql);
        if(roweffected == 0){
            System.out.println("data not inserted here ");
        }
        else System.out.println("data inserted ");*/

        String sql = "select * from studentinfo";
        ResultSet rs = statement.executeQuery( sql);

        //6)process the result 

        while(rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4) );
        }

        //7)close the resources 
        rs.close();
        statement.close();
        conn.close();
    }
}
// only queries change based on the action we want , rest all remains the same like loading driver and all so it should be in boiler plate code , thats where frameworks come into place , but before that we need to learn core jdbc to know how things work 

// to know if the query is retrival or not we can use statement.execute(sql); it will return a boolean value , true if its not retrival and false if retrival 

//more methods like statement.getresultset() , statement.updatecount()