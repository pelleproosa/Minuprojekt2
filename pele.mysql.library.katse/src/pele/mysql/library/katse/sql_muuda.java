package pele.mysql.library.katse;




//STEP 1. Import required packages
import java.sql.*;

public class sql_muuda {
// JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost/test";

//  Database credentials
//static final String USER = "root";
//static final String PASS = "pele";

public static void start(String USER, String PASS, int juhuslik, String[] muudatus, String sqltabel, int player, int i ) {
Connection conn = null;
Statement stmt = null;


try{
  //STEP 2: Register JDBC driver
  Class.forName("com.mysql.jdbc.Driver");

  //STEP 3: Open a connection
//  System.out.println("Connecting to database...");
  conn = DriverManager.getConnection(DB_URL,USER,PASS);

  //STEP 4: Execute a query
//  System.out.println("Creating statement...");
  stmt = conn.createStatement();

  
  if (sqltabel.equalsIgnoreCase("hetkeseis"))
  {
	  String sql = "UPDATE "+sqltabel+" " +
		      "SET Kaart"+i+" = "+muudatus[0]+" WHERE ID in ("+player+")";
		stmt.executeUpdate(sql);
		sql = "UPDATE kaardipakist_v6tmine " +
			      "SET Erinumber = "+muudatus[1]+" WHERE Järjekorranumber in ("+juhuslik+")";
			stmt.executeUpdate(sql);
	  
  }
  if (sqltabel.equalsIgnoreCase("clear"))
  {
	  int lugeja=0;
	  while(lugeja<i){
		  lugeja++;
	  String sql = "UPDATE kaardipakist_v6tmine " +
		      "SET Erinumber = "+lugeja+" WHERE Järjekorranumber in ("+lugeja+")";
	  stmt.executeUpdate(sql);
	  }
	  
  }
  
  
//  String sql;

  //STEP 6: Clean-up environment
 
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


}//end main
}//end FirstExample