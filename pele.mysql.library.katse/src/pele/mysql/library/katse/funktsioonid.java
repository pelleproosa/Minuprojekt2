package pele.mysql.library.katse;
import java.sql.*;
public class funktsioonid {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/kaardipakk";
	public static void pakijagamine(){
	
		int pakimeelespea=GLOBAL.Kaartepakis;
		int player=0;
		int mitu=0;
//		String[] muudatus={"",""};
		String a="clear";
		String b="hetkeseis_jaga_esimest_korda";
		String c="puhastahetkeseis";
		
	
	if (GLOBAL.Players==0){
			sql_muuda.start("root", "pele", 0,c,GLOBAL.Players);
			
	}
	else{
		
		sql_muuda.start("root", "pele", mitu,b,GLOBAL.Players);
	}
	
	
	
	
	
	/*
	else{
	
		while (player<GLOBAL.Players){
		player++;

		int i=1;	
		while((i-1)<GLOBAL.KaartidearvPerHand){
	
			if(GLOBAL.Kaartepakis>1){
			juhuslik=random.start((GLOBAL.Kaartepakis));
			
			while (((juhuslik==GLOBAL.Kaartepakis)||(juhuslik==0))||(juhuslik==37)){juhuslik=random.start((GLOBAL.Kaartepakis));}
			}else{
				break;
			}

			muudatus=(sql_loe.start("root", "pele", juhuslik,(GLOBAL.Kaartepakis-1)));

			sql_muuda.start("root", "pele", juhuslik,muudatus,b,player,i);
			
			GLOBAL.Kaartepakis--;
			i++;
			juhuslik=0;
		}
		
		
		}
		

		sql_muuda.start("root", "pele", 0,muudatus,a,player,pakimeelespea);
		
		
		
		
	}
	
	*/
	//GLOBAL.Kaartepakis=pakimeelespea;
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
		/*	  while(i<GLOBAL.KaartidearvPerHand){
				  i++;
			  sql =(sql+ "Kaart"+i+", ");
					  
			  }
			  sql=(sql+"FROM hetkeseis");*/
			  sql="SELECT * FROM hetkeseis";
		//	  System.out.println(sql);
			  ResultSet rs = stmt.executeQuery(sql);
		//	  System.exit(0);

			  //STEP 5: Extract data from result set
			  i=0;
			  while(rs.next()){
			     //Retrieve by column name
			  	
			  	
			     int id  = rs.getInt("ID");
			     
			     if(GLOBAL.minuplayerinumber==id)
			     {
			    	 
			    	 while(i<55){
			    		 i++;
			    	GLOBAL.handerinr[i]=rs.getInt(("Kaart"+i));
			    	//System.out.println(GLOBAL.handerinr[i]);
			    	
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
				    	//	System.out.println(GLOBAL.hand[handlugeja]+"    "+GLOBAL.handx[handlugeja]+"   "+GLOBAL.KaartidearvPerHand+"   "+handlugeja+"  "+GLOBAL.handerinr[erinrlugeja]);
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
	public static void teekaardipakk(){

		int kaardid[]=new int[GLOBAL.Kaartepakis];

		
		
		if (GLOBAL.Kaartepakis==36){                   /////// 36-ne pakk jadana  valmis lisamiseks tabelisse: kaardipakk.kaardipakist võtmine
			
			int a=0;
			int i=0;
			int o=0;
			while(a<4){
			
			while(i<9){
				
				kaardid[o]=(i+5);
				
				
				i++;
				o++;
			}
			i=i+9;
			while(i<27){
				
				kaardid[o]=(i);
				
				
				i++;
				o++;
			}
			i=i+4;
			while(i<40){
				
				kaardid[o]=(i);
				
				
				i++;
				o++;
			}
			i=i+4;
			while(i<53){
				
				kaardid[o]=(i);
				
				
				i++;
				o++;
			}
			
			
			
			
			a++;
			}
		}
		
		
		if (GLOBAL.Kaartepakis>51){
			int i=0;
			while(i<GLOBAL.Kaartepakis){
				
				kaardid[i]=(i+1);
				
				
				i++;
				
			}
		}
		
		
		
		
		
	//	System.out.println("kaarte pakis: "+GLOBAL.Kaartepakis);
/*		int i=0;
		while (i<GLOBAL.Kaartepakis){
			System.out.println(kaardid[i]);
			i++;
		}
*/		
		segakaardipakk(kaardid);
	}
	
	
	public static void segakaardipakk(int[]kaardid){
	
		int i=(GLOBAL.Kaartepakis-1);
		int[] buffer={0,0,0};
		
		while (i>1){
			buffer[0]=random.start(i);
			if((buffer[0]>0)){
			buffer[1]=kaardid[(buffer[0])];
			buffer[2]=kaardid[i];
			kaardid[i]=buffer[1];
			kaardid[(buffer[0])]=buffer[2];
			i--;
			}
			
		}
		
		
		panekaardidtabelissevalmis(kaardid);
		
		
	}
	
	public static void panekaardidtabelissevalmis(int[]kaardid){
		
		Connection conn = null;
		Statement stmt = null;
		try{
			  //STEP 2: Register JDBC driver
			  Class.forName("com.mysql.jdbc.Driver");

			  //STEP 3: Open a connection
			//  System.out.println("Connecting to database...");
			  conn = DriverManager.getConnection(DB_URL,GLOBAL.USER,GLOBAL.PASS);

			  //STEP 4: Execute a query
			//  System.out.println("Creating statement...");
			  stmt = conn.createStatement();

			  
			  
				  

			  int i=0;
			  while (i<GLOBAL.Kaartepakis){
				  
				  String sql = "UPDATE kaardipakist_v6tmine " +
						  "SET Erinumber = "+kaardid[i]+" WHERE ID in ("+(i+1)+")";
				  

				  
				  stmt.executeUpdate(sql);

			//	  System.out.println(i+"    "+kaardid[i]);
				  i++;
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
	}
	
	
	
}
