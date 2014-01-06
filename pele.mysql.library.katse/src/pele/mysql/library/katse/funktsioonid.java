package pele.mysql.library.katse;

public class funktsioonid {

	
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
}
