package projet_robot;



public class NettoyeurSmart extends Robot {
	
	//ce robot va nettoyer spécialement les cases avec papier gras
	public NettoyeurSmart(Monde m) {
		super(m);
		
	}

	@Override
	public void parcourir(){
		
		
				try {
					int x,y;
					for(int i=0; i<10; i++)
					{
						do {
							 x=(int)(Math.random()* 10);
							 y=(int)(Math.random()* 10);
							 getM().PrendPapierGras(x,y);
							}
						while(getM().TestPapierGras(x, y) == true);
					}
				}
					
				catch (ErreurCoord e) {
					System.out.println("erreur robot sort de la matrice");
					e.printStackTrace();
				}
	}
}

