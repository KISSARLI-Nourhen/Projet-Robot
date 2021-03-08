package projet_robot;



public class PollueurLibre extends Robot{ //robot pollue aléatoirement
	
	public PollueurLibre(Monde m) {
		super(m);
		
	}
	
	public void parcourir() {
		
		int x, y;
		try {
			
			do {
				x=(int)(Math.random()* 10);
				y=(int)(Math.random()* 10);
				getM().DeposePapierGras(x,y);
			}
			while(getM().TestPapierGras(x, y) == false);
			
	}catch(ErreurCoord e) {
		e.printStackTrace();
	}
}
}

