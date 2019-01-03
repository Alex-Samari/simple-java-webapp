package dataLayer;

import java.sql.*;

public class DB_user {

    //  JDBC driver name
    static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
    //  database URL containing the name of the database(created by mySQL workbench)
    static final String DB_URL="jdbc:mysql://localhost/webapp-tutorial";

    //  Database credentials
    static final String USER="webapp-user";
    static final String PASS="test123";

    //  validation method that compares the user credentials with that existing in the database
    public boolean isValidUserLogin(String userName, String userPassword){
        //  setting the default return value to false
        boolean isValidUser = false;

        //  for setting up the connection string to the database
        Connection conn = null;
        //  for "running" sql statements
        Statement stmt = null;
        //  for "writing" sql statements
        String sql;

        try{
            //  STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver"); // note: caught by Exception e

            //  STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //  STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            //  SQL query statement
            //  \"" is the equivalent of double quotations.
            sql = "select * from users where username = \"" +
                    userName + "\" and password = \"" + userPassword + "\"";

            System.out.println(sql);

            //  executing the SQL query statement. rs stands for result set
            ResultSet rs = stmt.executeQuery(sql);
            // STEP 5: Extract data from the result set
            if(rs.next()){
                isValidUser = true;
            }

            //  STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        }catch (SQLException se){
            //  Handle errors for JDBC
            se.printStackTrace();
        }catch (Exception e){
            //  Handle errors for class.forName
            e.printStackTrace();
         // finally block used to close resources
        }finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch (SQLException se2){
                //  nothing we can do
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch (SQLException se3){
                se3.printStackTrace();
            }// end finally try
        }// end try

        System.out.println("Closing DB Connection - Goodbye!");

        //  Returning the result of validation
        return isValidUser;
    }


}
