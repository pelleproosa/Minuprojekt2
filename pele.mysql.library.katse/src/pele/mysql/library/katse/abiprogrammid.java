package pele.mysql.library.katse;
import java.sql.*;
public class abiprogrammid {
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost/test";
	
	public static int start() throws Exception{
		
		kaartideUrlideSeadistus();
		
		return 0;
		
	}
	
	
	
	public static String kaartideUrlideSeadistus() throws Exception{
		Connection conn = null;
		Statement stmt = null;
int nr=0, value=0, trump=0, erinr=0;		
String mast="",nimi="",pildiurl=""; 		
try{
	//STEP 2: Register JDBC driver
	Class.forName("com.mysql.jdbc.Driver");

	//STEP 3: Open a connection
	//System.out.println("Connecting to database...");
	conn = DriverManager.getConnection(DB_URL,"root","pele");

	//STEP 4: Execute a query
	//System.out.println("Creating statement...");
	stmt = conn.createStatement();

	
	
	String sql = "SELECT J‰rjekorranumber, Mast, Nimi, V‰‰rtus, Trump, Erinumber, PildiUrl FROM kaardipakk_in_game";
	ResultSet rs = stmt.executeQuery(sql);	
	
	String[] MastUrl=new String[385];
	int i=0;
	int vaheloendur=0;
	  while(rs.next()){
		  	
		     nr = rs.getInt("J‰rjekorranumber");
		     mast=rs.getString("Mast");
		     nimi=rs.getString("Nimi");
		     value=rs.getInt("V‰‰rtus");
		     trump=rs.getInt("Trump");
		     erinr=rs.getInt("Erinumber");
		     pildiurl=rs.getString("PildiUrl");

		     MastUrl[i]=""+nr;
		     i++;
		     MastUrl[i]=""+mast;
		     i++;
		     MastUrl[i]=""+nimi;
		     i++;
		     MastUrl[i]=""+value;
		     i++;
		     MastUrl[i]=""+trump;
		     i++;
		     MastUrl[i]=""+erinr;
		     i++;
		     MastUrl[i]=""+pildiurl;
		     i++;
		    
System.out.println("sisestus real "+nr+" : "+mast+" : "+nimi+" : "+value+" : "+trump+" : "+erinr+" : "+pildiurl);

	  }
	  i=0;
	  while(i<385){
		  System.out.println("sisestus real "+MastUrl[i]+" : "+MastUrl[(i+1)]+" : "+MastUrl[(i+2)]+" : "+MastUrl[(i+3)]+" : "+MastUrl[(i+4)]+" : "+MastUrl[(i+5)]+" : "+MastUrl[(i+6)]);
		  String sql2="delete from kaardipakk_in_game where J‰rjekorranumber= "+MastUrl[i]+" ;";
		  stmt.executeUpdate(sql2);
		  MastUrl[(i+6)]=kaardiUrl(MastUrl[(i+5)]);
		  
		  
		  
		  
		  sql2="insert into kaardipakk_in_game values("+MastUrl[(i)]+", '"+MastUrl[(i+1)]+"','"+MastUrl[(i+2)]+"',"+MastUrl[(i+3)]+", '"+MastUrl[(i+4)]+"','"+MastUrl[(i+5)]+"','"+MastUrl[(i+6)]+"')";
		  stmt.executeUpdate(sql2);
		  
		  i=i+7;
	  }
	  
	  
/*
String sql2="delete from kaardipakk_in_game where J‰rjekorranumber= "+nr+" ;";
stmt.executeUpdate(sql2);

pildiurl="lalalaaaa!";




sql2="insert into kaardipakk_in_game values("+nr+", '"+mast+"','"+nimi+"',"+value+", '"+trump+"','"+erinr+"','"+pildiurl+"')";
stmt.executeUpdate(sql2);

*/

	
	
}
catch(SQLException e){}
	
	
	
	
	
		

		
		
		
		
		
		
		
		
		
		
		
		
		String tagasiside="";
		
		return tagasiside;
	}
	
	
	public static String kaardiUrl(String kaardierinumber){
		String kaardiUrl="";
		String kataloog="D:/temp/kaardid/2/";
		String c="c/c";
		String d="d/d";
		String h="h/h";
		String s="s/s";
		String pilt="";
		String laiend=".png";
		String mast="";
		int a=Integer.parseInt(kaardierinumber);
		
		if (a<14){
			if(a>9){
				if(a==10){
				pilt="J";
				}
				if(a==11){
					pilt="Q";
				}
				if(a==12){
					pilt="K";
				}
				if(a==13){
					pilt="A";
				}
			}else{
				a++;
				pilt=""+a;
			}
			mast=c;
		}
		
		if ((a>13)&&(a<27)){
			if(a>22){
				if(a==23){
				pilt="J";
				}
				if(a==24){
					pilt="Q";
				}
				if(a==25){
					pilt="K";
				}
				if(a==26){
					pilt="A";
				}
			}else{
				a++;
				a=a-13;
				pilt=""+a;
			}
			mast=d;
		}
		
		if ((a>26)&&(a<40)){
			if(a>35){
				if(a==36){
				pilt="J";
				}
				if(a==37){
					pilt="Q";
				}
				if(a==38){
					pilt="K";
				}
				if(a==39){
					pilt="A";
				}
			}else{
				a++;
				a=a-26;
				pilt=""+a;
			}
			mast=h;
		}
		if ((a>39)&&(a<53)){
			if(a>35){
				if(a==49){
				pilt="J";
				}
				if(a==50){
					pilt="Q";
				}
				if(a==51){
					pilt="K";
				}
				if(a==52){
					pilt="A";
				}
			}else{
				a++;
				a=a-39;
				pilt=""+a;
			}
			mast=s;

		}
		
		if((a>52)&&(a<56)){
			kataloog="D:/temp/kaardid/joker/";
			mast="joker";
			
			if(a==53){pilt="b";}
			if(a==54){pilt="r";}
			if(a==55){pilt="extra";}
			
		}
		
		
		
		
		
		kaardiUrl=kataloog+mast+pilt+laiend;
		
		return kaardiUrl;
	} 
	
	
	
	
	
	
	
	
	
}
