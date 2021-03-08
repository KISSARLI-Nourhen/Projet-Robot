package projet_robot;


public abstract class Robot {
	//attribut pour le robot
	
	private int posx, posy;
	private Monde m;
	
	public Robot(int x, int y, Monde m) {
		this.posx=x;
		this.posy=y;
		this.m=m;
			
	}
	
	public Robot(Monde m) {
		
		this.posx=(int)(Math.random()*10);
		this.posy=(int)(Math.random()*10);	
		this.m=m;	
		}
	
	public void deplace(int i, int j)throws ErreurCoord {
		if ((i<0) || (i>m.getNbl()) || (j<0) || (j>m.getNbc()))throw new ErreurCoord();
		posx=i;
		posy=j;
	}
	
	public abstract void parcourir()throws ErreurMatrice;
	//parcourir c'est la position initial du robot
	
	
	//nettoyer le monde
	public void NettoieMonde() {
		
		try {
		for(int i=0; i<getM().getNbl(); i++)
		{
			for(int j=0; j<getM().getNbc(); j++)
			{
				if(m.getMat()[i][j]==true) {
					m.PrendPapierGras(i,j);
				}
			}
		}
	} catch (ErreurCoord e) {
		
		e.printStackTrace();}
	}
	
	//polluer le monde
	public void PollueMonde() {
		
		try {
		for(int i=0; i<getM().getNbl(); i++)
		{
			for(int j=0; j<getM().getNbc(); j++)
			{
				if(m.getMat()[i][j]==false) {
					m.DeposePapierGras(i, j);
				}
			}
		}
		} catch(ErreurCoord e) {
			e.printStackTrace();
		}
	}
	
	
	
	//récupération des attributs
	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		if(posx >= 0 && posx <10)
		this.posx = posx;
	}
	

	public int getPosy() {
		return posy;
	}
	
	public void setPosy(int posy) {
		if(posy>=0 && posy<10) {
			this.posy = posy;
		}
	}

	public Monde getM() {
		return m;
	}

	public void setM(Monde m) {
		this.m = m;
	}
	
	
	
	
}
