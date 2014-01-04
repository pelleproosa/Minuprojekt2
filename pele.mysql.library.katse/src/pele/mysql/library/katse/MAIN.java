package pele.mysql.library.katse;

//import pele.mysql.library.katse.*;;
public class MAIN {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//MySQLAccess dao = new MySQLAccess();dao.readDataBase();
	int kaartidearv=55;	String[]jada=	sql_tegevused.start("root","pele",kaartidearv);
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

