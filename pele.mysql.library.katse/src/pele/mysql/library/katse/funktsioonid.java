package pele.mysql.library.katse;

public class funktsioonid {

	
	public static void yksjuhuslikleht(int K2tteLehti,int pakiskaarte){
		
		int player=0;
		int juhuslik=0;
		int muudatus=0,muudatus2=0;
		String a="kaardipakist_v6tmine";
		String b="hetkeseis";
		
		while (player<4){
		player++;
		int i=1;	while((i-1)<K2tteLehti){
			juhuslik=random.start(pakiskaarte);

				muudatus=Integer.parseInt(sql_loe.start("root", "pele", juhuslik));

			sql_muuda.start("root", "pele", juhuslik,muudatus,b,player,i);
			if(!(juhuslik==pakiskaarte)){
				muudatus2=Integer.parseInt(sql_loe.start("root", "pele", pakiskaarte));
				sql_muuda.start("root", "pele", muudatus,muudatus2,a,player,i);
			}
			
			pakiskaarte--;
			i++;
		}
		
		
		}
		
		
		
		
		
		
	}
	
	
}
