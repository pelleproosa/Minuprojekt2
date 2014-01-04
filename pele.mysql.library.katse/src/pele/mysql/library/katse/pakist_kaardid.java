package pele.mysql.library.katse;

/*
 * 
 * Siia antakse soovitud kaartide arv ja tagastatakse pakist(SQL tabelist vastav jada) ... sql_tegevused.java 
 * kaartide tellimise numbrid: 36, 52, 54, 55
 * 
 * */
 

public class pakist_kaardid {

	public static void start(int kaartidearv){
	
	String[]jada=	sql_tegevused.start("root","pele",kaartidearv);
	int i=Integer.parseInt(jada[0]);
	int samm=0;
       System.out.println(i);
	int ii=(i*5);
       
       
	while(samm<ii){
	samm=samm+5;
		System.out.print("Järjekorranumber: " + jada[(samm-4)]);
       System.out.print(", Mast: " + jada[(samm-3)]);
       System.out.print(", Nimi: " + jada[(samm-2)]);
       System.out.print(", Väärtus: " + jada[(samm-1)]);
       System.out.println(", Trump: " + jada[samm]);
	
	}
	}
	
}
