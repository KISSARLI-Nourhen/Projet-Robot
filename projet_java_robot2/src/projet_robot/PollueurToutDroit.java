package projet_robot;



public class PollueurToutDroit extends Robot {
	
	
	public PollueurToutDroit(Monde m) {
		super(0,0,m);
		
	}

	@Override
	public void parcourir() {
		
		
			try {
				for(int i=getPosx(); i<getM().getNbl();i++)
				{
					getM().DeposePapierGras(i, this.getPosy());
				} 
			}catch (ErreurCoord e) {
				
				e.printStackTrace();
			}
		}
}

