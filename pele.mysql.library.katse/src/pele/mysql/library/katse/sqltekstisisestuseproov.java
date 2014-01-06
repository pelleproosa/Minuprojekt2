package pele.mysql.library.katse;








//STEP 1. Import required packages
import java.sql.*;

public class sqltekstisisestuseproov {
//JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost/test";

//Database credentials
//static final String USER = "root";
//static final String PASS = "pele";

public static void start(String USER, String PASS,int id, String sisestus,int vanus,String korraldus) throws SQLException {
Connection conn = null;
Statement stmt = null;


try{
//STEP 2: Register JDBC driver
Class.forName("com.mysql.jdbc.Driver");

//STEP 3: Open a connection
//System.out.println("Connecting to database...");
conn = DriverManager.getConnection(DB_URL,USER,PASS);

//STEP 4: Execute a query
//System.out.println("Creating statement...");
stmt = conn.createStatement();

if(korraldus.equalsIgnoreCase("lisa")){
	

String sql3="insert into tekstisisestus values("+id+", '"+sisestus+"','"+vanus+"')";
stmt.executeUpdate(sql3);
}
if(korraldus.equalsIgnoreCase("kustuta")){
	String sql3="delete from tekstisisestus where ID= "+id+" ;";
	stmt.executeUpdate(sql3);
}

stmt.close();
conn.close();
}catch(SQLException se){
//Handle errors for JDBC
	System.out.println("Viga! Ilmselt oli juba rida nr: "+id+" olemas. Läbi SQLExeptioni käivitub esmalt kustutamine ja siis lisamine.");
	
	String sql3="delete from tekstisisestus where ID= "+id+" ;";
	stmt.executeUpdate(sql3);
	sql3="insert into tekstisisestus values("+id+", '"+sisestus+"','"+vanus+"')";
	stmt.executeUpdate(sql3);
	String sql = "SELECT ID, Nimi, vanus FROM tekstisisestus";
	ResultSet rs = stmt.executeQuery(sql);
	  while(rs.next()){
		     //Retrieve by column name
		  	
		  	
		     int id2  = rs.getInt("ID");
		     
		     if(id2==id)
		     {
		    	String sqlNimi=rs.getString("Nimi");
		    	int sqlvanus=rs.getInt("vanus");
System.out.println("sisestus real "+id+" on: "+sqlNimi+" ja: "+sqlvanus);
		     }

		 
		     
		  }
		  //STEP 6: Clean-up environment
		  rs.close();
	

//String sqlNimi=rs.getString("Nimi");
//String sqlvanus=rs.getString("vanus");
//	System.out.println("Kontrolliks tagasiside: Nimi= "+sqlNimi+" vanus= "+sqlvanus);
//se.printStackTrace();
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