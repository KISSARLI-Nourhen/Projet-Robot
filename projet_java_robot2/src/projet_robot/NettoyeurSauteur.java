package projet_robot;



public class NettoyeurSauteur extends Robot {
	//nettoie 1/2 des papier gras
	public NettoyeurSauteur(Monde m) {
		super(0,1,m);
		
	}
	
	@Override
	public void parcourir() {
		for(int i=getPosx(); i<getM().getNbl(); i++)
		{
			if(i%2==0) {
				for(int j=getPosy(); j<getM().getNbc();j=j+2)
					try {
						getM().PrendPapierGras(i,j);
					} catch (ErreurCoord e) {
						e.printStackTrace();
					}
			}
			else {
				for(int j=getPosy()+1; j<getM().getNbc();j=j+2)
					try {
						getM().PrendPapierGras(i,j);
					} catch (ErreurCoord e) {
						
						e.printStackTrace();
					}
			}
		}
	}
	
	
	


	
	

}
