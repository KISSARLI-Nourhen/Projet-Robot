package projet_robot;



public class test {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Monde mon = new Monde();
		
		/*mon.DeposePapierGras(3, 4); 
		mon.affiche();
		
		System.out.println(mon.TestPapierGras(3, 4));
		System.out.println(mon.TestPapierGras(0, 0));
		System.out.println(mon.ComptePapierGras());*/
		
		PollueurToutDroit pdroit= new PollueurToutDroit(mon);
		pdroit.parcourir();
		pdroit.getM().affiche();
		System.out.println();
		System.out.println();
		
		/*PollueurSauteurs ps = new PollueurSauteurs(mon,2);
		ps.parcourir();
		ps.getM().affiche();
		System.out.println();
		System.out.println();*/
		
		/*PollueurLibre pl = new PollueurLibre(mon);
		pl.parcourir();
		pl.getM().affiche();
		
		System.out.println();
		System.out.println();*/
		
		/*PollueurLibre pl1 = new PollueurLibre(mon);
		pl1.parcourir();
		pl1.getM().affiche();
		
		System.out.println();
		System.out.println();*/
		
		
		/*PollueurLibre pl3 = new PollueurLibre(mon);
		pl3.parcourir();
		pl3.getM().affiche();
		System.out.println();
		System.out.println();*/
		
		/*NettoyeurSmart ns = new NettoyeurSmart(0,0,mon);
		ns.parcourir();
		ns.getM().affiche();*/
		
		/*NettoyeurSauteur nsaut = new NettoyeurSauteur(0, 0, mon);
		nsaut.parcourir();
		nsaut.getM().affiche();*/
		
		/*NettoyeurLibre nl = new NettoyeurLibre(mon);
		nl.parcourir();
		nl.getM().affiche();*/
		
		System.out.println(pdroit.getPosx());
		System.out.println(pdroit.getPosy());
		System.out.println();
		
		try {
			pdroit.deplace(1, 1);
		} catch (ErreurCoord e) {
			e.printStackTrace();
		}
		System.out.println(pdroit.getPosx());
		System.out.println(pdroit.getPosy());
		pdroit.parcourir();
		pdroit.getM().affiche();
		
		System.out.println(mon.ComptePapierGras());
		
	}


}

