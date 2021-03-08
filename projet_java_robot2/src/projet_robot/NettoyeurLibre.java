package projet_robot;


public class NettoyeurLibre extends Robot {
	
	
	public NettoyeurLibre(Monde m) {
		super(m);
		
	}
	
	public void parcourir() {
		int x,y;
		try {
			do {
				x=(int)(Math.random()* 10);
				y=(int)(Math.random()* 10);
				getM().PrendPapierGras(x,y);
			}
			while(getM().TestPapierGras(x, y) == true);
		} catch (ErreurCoord e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
}
