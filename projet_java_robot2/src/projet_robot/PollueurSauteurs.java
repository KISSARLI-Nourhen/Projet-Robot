package projet_robot;



public class PollueurSauteurs extends Robot {
	
	private int saut;
	
	public PollueurSauteurs(Monde m, int saut) {
		super(0,0,m);
		this.saut=saut;
		
		
	}
	@Override
	public void parcourir() {
		try {
		for(int i=getPosx(); i<getM().getNbl(); i++) {
			if(i%2==0)
			for(int j=getPosy(); j<getM().getNbc();j=j+saut)
			{
				getM().DeposePapierGras(i,j);
			}
			else {
				for(int j=getPosy()+1;j<getM().getNbc();j=j+saut) {
					getM().DeposePapierGras(i,j);
				}
			}
				
		}
		} catch(ErreurCoord e) {
			e.printStackTrace();
		}
	}
	
	public int getSaut() {
		return saut;
	}
	
	public void SetSaut(int saut) {
		this.saut= saut;
	}

}

