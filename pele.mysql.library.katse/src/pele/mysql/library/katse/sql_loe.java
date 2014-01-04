package pele.mysql.library.katse;



//STEP 1. Import required packages
import java.sql.*;
public class sql_loe {


// JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost/test";


public static String[] start(String USER, String PASS, int kaardinumber, int pakiskaarte ) {
	String kaart[]={"",""};
Connection conn = null;
Statement stmt = null;

try{
  //STEP 2: Register JDBC driver
  Class.forName("com.mysql.jdbc.Driver");

  //STEP 3: Open a connection
  //System.out.println("Connecting to database...");
  conn = DriverManager.getConnection(DB_URL,USER,PASS);

  //STEP 4: Execute a query
 // System.out.println("Creating statement...");
  stmt = conn.createStatement();

  
//  String sql;
  String sql = "SELECT Järjekorranumber, Erinumber FROM kaardipakist_v6tmine";
  ResultSet rs = stmt.executeQuery(sql);

  //STEP 5: Extract data from result set
  while(rs.next()){
     //Retrieve by column name
  	
  	
     int id  = rs.getInt("Järjekorranumber");
     
     if(kaardinumber==id)
     {
    	 kaart[0]=rs.getString("Erinumber");
     }
     if(pakiskaarte==id)
     {
    	 kaart[1]=rs.getString("Erinumber");
     }

 
     
  }
  //STEP 6: Clean-up environment
  rs.close();
  stmt.close();
  conn.close();
}catch(SQLException se){
  //Handle errors for JDBC
  se.printStackTrace();
}catch(Exception e){
  //Handle errors for Class.forName
  e.printStackTrace();
}finally{
  //finally block used to close resources
  try{
     if(stmt!=null)
        stmt.close();
  }catch(SQLException se2){
  }// nothing we can do
  try{
     if(conn!=null)
        conn.close();
  }catch(SQLException se){
     se.printStackTrace();
  }//end finally try
}//end try
//System.out.println(".ok.");

return kaart;
}//end main
}//end FirstExample