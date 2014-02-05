package pele.mysql.library.katse;


public class MAIN {

	public static void main(String[] args) throws Exception {

      
		
		
	//	abiprogrammid.start();

sql_muuda.start("root", "pele", 0,"puhastahetkeseis",GLOBAL.Players);
GLOBAL.Players=4;GLOBAL.KaartidearvPerHand=3;GLOBAL.Kaartepakis=52;GLOBAL.mitukaartiplayerile=GLOBAL.KaartidearvPerHand; //players 1-4  kaartidearv perhand 1-13 kaartepakis 36/52-55            /// segab uue jaotuse
funktsioonid.teekaardipakk();
//System.out.println(GLOBAL.Players+"      "+GLOBAL.KaartidearvPerHand+"       "+GLOBAL.Kaartepakis);

funktsioonid.pakijagamine();



//vahefunktsioon süsteemi liitmata
GLOBAL.minuplayerinumber=3;
GLOBAL.minukaartidearv=GLOBAL.KaartidearvPerHand;
//sql_muuda.start("root", "pele", 0,"hetkeseis_uus_kaart_playerile",GLOBAL.minuplayerinumber);       //annab valitud playerile pakist 1 uue kaardi juurde tabelisse kaardipakk.hetkeseis

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx





//System.exit(0);
//String a="lisa";String b="kustuta";sqltekstisisestuseproov.start("root", "pele",10, "noh!",20,a);

       BorderLayoutDemo.start(null);// nupud kogu aknas näide(nagu veebilehe progemine)
		
	
		
		
		
	}

}

