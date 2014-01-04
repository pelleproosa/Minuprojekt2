package pele.mysql.library.katse;


//STEP 1. Import required packages
import java.sql.*;

public class sql_tegevused {
 // JDBC driver name and database URL
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 static final String DB_URL = "jdbc:mysql://localhost/test";

 //  Database credentials
// static final String USER = "root";
// static final String PASS = "pele";
 
 public static String[] start(String USER, String PASS, int kaartidearv ) {
 Connection conn = null;
 Statement stmt = null;
 String[] jada=new String[280];
 int i=0;
 try{
    //STEP 2: Register JDBC driver
    Class.forName("com.mysql.jdbc.Driver");

    //STEP 3: Open a connection
    System.out.println("Connecting to database...");
    conn = DriverManager.getConnection(DB_URL,USER,PASS);

    //STEP 4: Execute a query
    System.out.println("Creating statement...");
    stmt = conn.createStatement();
    
    String sql = "UPDATE Kaardipakk_in_game " +
            "SET Trump = 10 WHERE J‰rjekorranumber in (53, 54)";
stmt.executeUpdate(sql);
sql = "UPDATE Kaardipakk_in_game " +
        "SET Trump = 10 WHERE J‰rjekorranumber in (55)";
stmt.executeUpdate(sql);
    
    
    
  //  String sql;
    sql = "SELECT J‰rjekorranumber, Mast, Nimi, V‰‰rtus, Trump FROM Kaardipakk_in_game";
    ResultSet rs = stmt.executeQuery(sql);

    //STEP 5: Extract data from result set
    while(rs.next()){
       //Retrieve by column name
    	
    	
       int id  = rs.getInt("J‰rjekorranumber");
      jada[0]=""+id;
      i++;
      jada[i]=""+id;
       String mast = rs.getString("Mast");
       i++;
       jada[i]=""+mast;
       String nimi = rs.getString("Nimi");
       i++;
       jada[i]=""+nimi;
       int v22rtus = rs.getInt("V‰‰rtus");
       i++;
       jada[i]=""+v22rtus;
       String trump = rs.getString("Trump");
       i++;
       jada[i]=""+trump;
       
       
       if(kaartidearv==36){
    	   if (mast.equalsIgnoreCase("Risti")){jada[(i-4)]=""+(id-4);}
    	   if (mast.equalsIgnoreCase("Ruutu")){jada[(i-4)]=""+(id-8);}
    	   if (mast.equalsIgnoreCase("ƒrtu")){jada[(i-4)]=""+(id-12);}
    	   if (mast.equalsIgnoreCase("Poti")){jada[(i-4)]=""+(id-16);}
    	 if  (v22rtus<6){i=i-5;}

       }
    	   
    	   
       if((kaartidearv==52)&&(id==52)){
    	   break;
       }
       if((kaartidearv==54)&&(id==54)){
    	   break;
       }
    	   
    	 if(id==55){
    		 break;
    	 }  
    	   
       
/*
       //Display values
       if (id>52){
    	   
       System.out.print("J‰rjekorranumber: " + id);
       System.out.print(", Mast: " + mast);
       System.out.print(", Nimi: " + nimi);
       System.out.print(", V‰‰rtus: " + v22rtus);
       System.out.println(", Trump: " + trump);
       }
       */
       
       
       
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
 System.out.println("Goodbye!");
 if(kaartidearv==36){jada[0]=""+36;}
return jada;
}//end main
}//end FirstExample