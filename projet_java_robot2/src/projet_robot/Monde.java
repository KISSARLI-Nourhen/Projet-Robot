package projet_robot;


public class Monde {
	
	//attributs
	private int nbL, nbC; //nombre de ligne et de colonne
	private boolean Mat[][]; //matrice 
	
	//constructeur
	public Monde() {
		nbL=10;
		nbC=10;
		Mat= new boolean[nbL][nbC];
		
		//Matrice sans papier gras
		for(int i=0; i<Mat.length;i++)
			for(int j=0; j<Mat[i].length; j++)
				Mat[i][j]=false;
	}
	
	//robot qui dépose un papier gras 
	public void DeposePapierGras(int i, int j)throws ErreurCoord{
		if(i<0 || i>nbL ||j<0 || j>=nbC) throw new ErreurCoord();
		Mat[i][j]=true;
	}

	//robot qui nettoie le papier gras
	public void PrendPapierGras(int i, int j)throws ErreurCoord{
		if(i<0 || i>nbL ||j<0 || j>=nbC) throw new ErreurCoord();
		Mat[i][j]= false;
	}
	
	//test si papier gras existe
	public boolean TestPapierGras(int i, int j) throws ErreurCoord{
		if(i<0 || i>nbL ||j<0 || j>=nbC) throw new ErreurCoord();
		if(Mat[i][j]==true) {
			return true;
			//System.out.println("papier gras");
		}
		else {
			return false;
			//System.out.println("pas de papier gras");
		}
	}
	
	//méthode qui compte le papier gras
	public int ComptePapierGras()  {
		
		int gras=0; //gras = nombre de papier gras dans le monde
		
		for(int i=0; i<Mat.length; i++)
			for(int j=0; j<Mat[i].length; j++)
			{
				if(Mat[i][j]==true)
					gras +=1;
			}
		return gras;
	}
	
	//affichage de la matrice
	public void affiche() {
		
		for(int i=0; i<Mat.length; i++)
		{
			for(int j=0; j<Mat[i].length; j++)
			{
				System.out.print(Mat[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public int getNbl() {
		return nbL;
	}
	
	public void setNbl(int nbL) {
		this.nbL = nbL;
	}
	
	
	public int getNbc() {
		return nbC;
	}
	
	public void setNbc(int nbC) {
		this.nbC = nbC;
	}
	
	
	public boolean[][] getMat() {
		return Mat;
	}

	public void setMat(boolean[][] mat) {
		Mat = mat;
	}
	
}

