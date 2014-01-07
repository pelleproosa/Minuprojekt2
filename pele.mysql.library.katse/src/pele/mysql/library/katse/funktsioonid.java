package pele.mysql.library.katse;
import java.sql.*;
public class funktsioonid {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/kaardipakk";
	
	public static void yksjuhuslikleht(int K2tteLehti,int pakiskaarte,int players){
		int pakimeelespea=pakiskaarte;
		int player=0;
		int juhuslik=0;
		String[] muudatus={"",""};
		String a="clear";
		String b="hetkeseis";
		String c="puhastahetkeseis";
	pakiskaarte++;
	
	if (players==0){
			sql_muuda.start("root", "pele", 0,muudatus,c,players,0);
			
	}else{
	
		while (player<players){
		player++;
	//	System.out.println("Player: "+player);
		int i=1;	
		while((i-1)<K2tteLehti){
	
			if(pakiskaarte>1){
			juhuslik=random.start((pakiskaarte));
			
			while (((juhuslik==pakiskaarte)||(juhuslik==0))||(juhuslik==37)){juhuslik=random.start((pakiskaarte));}
			}else{
				break;
			}
		//	System.out.println("Kaart: "+i);
		//	if (juhuslik==pakiskaarte){System.out.println("Viimane");}
		//	System.out.println("Random nr: "+juhuslik);
		//	System.out.println("pakiskaarte: "+(pakiskaarte-1));
			muudatus=(sql_loe.start("root", "pele", juhuslik,(pakiskaarte-1)));
		//	System.out.println("muudatus: "+muudatus[0]+" , "+muudatus[1]);

			sql_muuda.start("root", "pele", juhuslik,muudatus,b,player,i);
			
			pakiskaarte--;
			i++;
			juhuslik=0;
		}
		
		
		}
		

		sql_muuda.start("root", "pele", 0,muudatus,a,player,pakimeelespea);
		
		
		
		
	}
	
	}
	
	public static boolean kaardidekraanile(){
		Connection conn = null;
		Statement stmt = null;
		GLOBAL.hand[0]="leian kaardid ja annan tagasi url... pisikesed 30%-sed ning lõpuks suure.";
		/// Teen kindlaks, milline player olen ja loen oma kaardid sisse tabelist kaardipakk hetkeseis
		
		try{
			  //STEP 2: Register JDBC driver
			  Class.forName("com.mysql.jdbc.Driver");

			  //STEP 3: Open a connection
			  //System.out.println("Connecting to database...");
			  conn = DriverManager.getConnection(DB_URL,GLOBAL.USER, GLOBAL.PASS);

			  //STEP 4: Execute a query
			 // System.out.println("Creating statement...");
			  stmt = conn.createStatement();

			  
			//  String sql;
			  int i=0;
			  String sql = "SELECT ID, MängijaNimi, Skoor ";
			  while(i<GLOBAL.KaartidearvPerHand){
				  i++;
			  sql =(sql+ "Kaart"+i+", ");
					  
			  }
			  sql=(sql+"FROM hetkeseis");
			  sql="SELECT * FROM hetkeseis";
			  System.out.println(sql);
			  ResultSet rs = stmt.executeQuery(sql);
		//	  System.exit(0);

			  //STEP 5: Extract data from result set
			  i=0;
			  while(rs.next()){
			     //Retrieve by column name
			  	
			  	
			     int id  = rs.getInt("ID");
			     
			     if(GLOBAL.minuplayerinumber==id)
			     {
			    	 
			    	 while(i<13){
			    		 i++;
			    	GLOBAL.handerinr[i]=rs.getInt(("Kaart"+i));
			    	System.out.println(GLOBAL.handerinr[i]);
			    	
			    	 }
			    	
			    	
			    	
			     }
			     

			 
			     
			  }
			  
			  sql = "SELECT Järjekorranumber, Erinumber, PildiUrl, PildiUrlx FROM kaardipakk_in_game";
			  rs = stmt.executeQuery(sql);
			  i=0;
			  int handlugeja=1;
			  int erinrlugeja=0;
			  int arv=0;
			  while(rs.next()){
				     //Retrieve by column name
				  	
				  	
				      i  = rs.getInt("Erinumber");
				      arv=0;
				      erinrlugeja=0;
				     while(arv<(GLOBAL.KaartidearvPerHand+1)){
				    	 arv++;
				    	 if(i==GLOBAL.handerinr[erinrlugeja]){
				    		GLOBAL.hand[handlugeja]=rs.getString("PildiUrl");
				    		GLOBAL.handx[handlugeja]=rs.getString("PildiUrlx");
				    		System.out.println(GLOBAL.hand[handlugeja]+"    "+GLOBAL.handx[handlugeja]+"   "+GLOBAL.KaartidearvPerHand+"   "+handlugeja+"  "+GLOBAL.handerinr[erinrlugeja]);
				    				handlugeja++;
				    				arv=(GLOBAL.KaartidearvPerHand+1);
				    	 }else{
				    		 erinrlugeja++;
				    	 }
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

		
		return true;
	}
	
	
	
	
	
	
	
	
	
}
