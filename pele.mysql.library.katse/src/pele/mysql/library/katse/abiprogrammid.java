package pele.mysql.library.katse;
import java.sql.*;
public class abiprogrammid {
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost/kaardipakk";
	public static int start() throws Exception{
		kaartideUrlideSeadistus();
		return 0;
	}
	public static String kaartideUrlideSeadistus() throws Exception{
		Connection conn = null;
		Statement stmt = null;
int nr=0, value=0, trump=0, erinr=0;		
String mast="",nimi="",pildiurl="",pildiurlx; 		
try{
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection(DB_URL,"root","pele");
	stmt = conn.createStatement();
	String sql = "SELECT Järjekorranumber, Mast, Nimi, Väärtus, Trump, Erinumber, PildiUrl, PildiUrlx FROM kaardipakk_in_game";
	ResultSet rs = stmt.executeQuery(sql);	
	
	String[] MastUrl=new String[440];
	int i=0;
	while(rs.next()){
		     nr = rs.getInt("Järjekorranumber");
		     mast=rs.getString("Mast");
		     nimi=rs.getString("Nimi");
		     value=rs.getInt("Väärtus");
		     trump=rs.getInt("Trump");
		     erinr=rs.getInt("Erinumber");
		     pildiurl=rs.getString("PildiUrl");
		     pildiurlx=rs.getString("PildiUrlx");
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
		     MastUrl[i]=""+pildiurlx;
		     i++;
	  }
	  i=0;
	  String sql2="";
	  while(i<440){
	//	  System.out.println("sisestus real "+MastUrl[i]+" : "+MastUrl[(i+1)]+" : "+MastUrl[(i+2)]+" : "+MastUrl[(i+3)]+" : "+MastUrl[(i+4)]+" : "+MastUrl[(i+5)]+" : "+MastUrl[(i+6)]+" : "+MastUrl[(i+7)]);
		  //System.exit(0);
		  System.out.println(MastUrl[i]);
		  sql2="delete from kaardipakk_in_game where Järjekorranumber= "+MastUrl[i]+" ;";
		  stmt.executeUpdate(sql2);
		  String[] urlid={"",""} ;
		  urlid=kaardiUrl(MastUrl[(i+5)]);
		  MastUrl[(i+6)]=urlid[0];
		  MastUrl[(i+7)]=urlid[1];
		  sql2="insert into kaardipakk_in_game values("+MastUrl[(i)]+", '"+MastUrl[(i+1)]+"','"+MastUrl[(i+2)]+"',"+MastUrl[(i+3)]+", '"+MastUrl[(i+4)]+"','"+MastUrl[(i+5)]+"','"+MastUrl[(i+6)]+"','"+MastUrl[(i+7)]+"')";
		  stmt.executeUpdate(sql2);
		  i=i+8;
	  }
}
catch(SQLException e){}
		String tagasiside="";
		return tagasiside;
	}
	public static String[] kaardiUrl(String kaardierinumber){
		String[] kaardiUrl={"",""};
		String kataloog="D:/temp/kaardid/2/";
		String c="c/c";
		String cx="cx/c";
		String d="d/d";
		String dx="dx/d";
		String h="h/h";
		String hx="hx/h";
		String s="s/s";
		String sx="sx/s";
		String joker="joker/joker";
		String jokerx="jokerx/joker";
		String pilt="";
		String laiend=".png";
		String mast="";
		String mastx="";
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
			mastx=cx;
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
			mastx=dx;
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
			mastx=hx;
		}
		if ((a>39)&&(a<53)){
			if(a>48){
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
			mastx=sx;
		}
		if((a>52)&&(a<56)){
			mast=joker;
			mastx=jokerx;
			if(a==53){pilt="b";}
			if(a==54){pilt="r";}
			if(a==55){pilt="extra";}
		}
		kaardiUrl[0]=kataloog+mast+pilt+laiend;
		kaardiUrl[1]=kataloog+mastx+pilt+"x"+laiend;	
		System.out.println("Terve kaart: "+kaardiUrl[0]);
		System.out.println("30% kaart  : "+kaardiUrl[1]);
		return kaardiUrl;
	} 
}
