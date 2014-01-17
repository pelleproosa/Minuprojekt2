package pele.mysql.library.katse;




//STEP 1. Import required packages
import java.sql.*;

public class sql_muuda {
// JDBC driver name and database URL
//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost/kaardipakk";

//  Database credentials
//static final String USER = "root";
//static final String PASS = "pele";

public static void start(String USER, String PASS, int mitu, String sqltabel, int player) {
Connection conn = null;
Statement stmt = null;


try
{
  //STEP 2: Register JDBC driver
  Class.forName("com.mysql.jdbc.Driver");

  //STEP 3: Open a connection
//  System.out.println("Connecting to database...");
  conn = DriverManager.getConnection(DB_URL,USER,PASS);

  //STEP 4: Execute a query
//  System.out.println("Creating statement...");
  stmt = conn.createStatement();

  
  System.out.println("päring: : "+sqltabel);
  if (sqltabel.equalsIgnoreCase("hetkeseis_jaga_esimest_korda"))
  {		
	  int id=0;
	  int erinr=0;
	  int a=0;
	  int i=GLOBAL.mitukaartiplayerile;
	  int playerjagaja=player;
	  while (playerjagaja>0)
	  {
		  
		  					while(a<i)
		  					{
		  							a++;
		  							String sql = "SELECT ID, Erinumber FROM kaardipakist_v6tmine";
		  							ResultSet rs = stmt.executeQuery(sql);

		  							while(rs.next())
		  							{
		  											id  = rs.getInt("ID");
		  											if(GLOBAL.Kaartepakis==id)
		  											{
		  																		erinr=rs.getInt("Erinumber");
		  																		
		  																		break;
		  											}
		  							}
		  
		  							sql = "UPDATE hetkeseis SET Kaart"+a+" = "+erinr+" WHERE ID in ("+playerjagaja+")";
		  							stmt.executeUpdate(sql);

		  
	  
	  
	  
	  
	  

		  							sql = "UPDATE kaardipakist_v6tmine SET Erinumber = "+0+" WHERE ID in ("+id+")";
		  							stmt.executeUpdate(sql);

		  							GLOBAL.Kaartepakis--;
	  
		  				}
	  
	  a=0;
	  playerjagaja--;
	  }
	  System.out.println("kaarte pakis: "+GLOBAL.Kaartepakis);
  }
  if (sqltabel.equalsIgnoreCase("hetkeseis_uus_kaart_playerile"))
  {
	  															int erinr=0;
	  															int id=0;
	  															String sql = "SELECT ID, Erinumber FROM kaardipakist_v6tmine";
	  															ResultSet rs = stmt.executeQuery(sql);
	  															System.out.println("kaarte pakis: "+GLOBAL.Kaartepakis);
	  															while(rs.next())
	  								  							{
	  								  											id  = rs.getInt("ID");
	  								  											if(GLOBAL.Kaartepakis==id)
	  								  											{
	  								  																		erinr=rs.getInt("Erinumber");
	  								  																		System.out.println("Saadud Erinr: "+erinr+"...ID: "+id);
	  								  																		break;
	  								  											}
	  								  							}
	  								  							sql = "UPDATE hetkeseis SET Kaart"+(GLOBAL.minukaartidearv+1)+" = "+erinr+" WHERE ID in ("+GLOBAL.minuplayerinumber+")";
	  								  							stmt.executeUpdate(sql);
	  								  							System.out.println("hetkeseis kaart"+(GLOBAL.minukaartidearv+1)+" = "+erinr+" kohas ID: "+GLOBAL.minuplayerinumber);
	  								  
	  							  
	  							  
	  							  
	  							  
	  							  

	  								  							sql = "UPDATE kaardipakist_v6tmine SET Erinumber = "+0+" WHERE ID in ("+id+")";
	  								  							stmt.executeUpdate(sql);
	  								  							System.out.println("kaardipakist_v6tmine Erinumber ="+0+" WHERE ID in "+id);
	  								  							GLOBAL.Kaartepakis--;

  }
  
  
  
  if (sqltabel.equalsIgnoreCase("clearkaardipakk"))
  {
	  												int lugeja=0;
	  												while(lugeja<55)
	  												{
	  																lugeja++;
	  																String sql = "UPDATE kaardipakist_v6tmine SET Erinumber = "+0+" WHERE ID in ("+lugeja+")";
	  																stmt.executeUpdate(sql);
	  												}
  }
  if (sqltabel.equalsIgnoreCase("puhastahetkeseis"))
  {
	  												int lugeja=0;
	  												int lugeja2=0;
	  												while(lugeja<4)
	  												{
	  																lugeja++;
	  																while  (lugeja2<55)
	  																{
	  																					lugeja2++;
	  																					String sql = "UPDATE hetkeseis SET Kaart"+lugeja2+" = 0 WHERE ID in ("+lugeja+")";
	  																					stmt.executeUpdate(sql);
	  																}
	  																lugeja2=0;
	  
	  												}
	  
  }
  stmt.close();
  conn.close();
}catch(SQLException se)
{
						//Handle errors for JDBC
						se.printStackTrace();
}catch(Exception e)
{
					//Handle errors for Class.forName
					e.printStackTrace();
}finally
{
		//finally block used to close resources
		try
		{
			if(stmt!=null)
			stmt.close();
		}catch(SQLException se2)
		{
		}// nothing we can do
		try
		{
			if(conn!=null)
			conn.close();
		}catch(SQLException se)
		{
								se.printStackTrace();
		}//end finally try
}//end try
}//end main
}