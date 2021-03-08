package projet_robot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;



public class FenetreRobotListner extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JLabel MondeLabel[][];
	JLabel box = new JLabel();
	JLabel JLabelPapierGras; //declaration JLabel pour compter le nombre de papier gras dans le monde
	
	Monde m = new Monde();
	
	//instancier les classes qui extends de robot
	Robot PollueurToutDroit = new PollueurToutDroit(m);
	Robot PollueurSauteurs = new PollueurSauteurs(m,2);
	Robot PollueurLibre = new PollueurLibre(m);
	Robot NettoyeurSmart = new NettoyeurSmart(m);
	Robot NettoyeurSauteur = new NettoyeurSauteur(m);
	Robot NettoyeurLibre = new NettoyeurLibre(m);
	
	
	
	
	
		//constructeur
		public FenetreRobotListner() {//la fentre qui va contenir les composants et containers
		
			super("Harry Potter");
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //arrêter le programme quand la fênetre est fermé
			//ordre important setSize avant de centrer
			this.setSize(900, 500);
			this.setLocationRelativeTo(null); //centrer la fenetre par rapport au bureau (null = bureau)
	        
	        JPanel contentPane= (JPanel) this.getContentPane();//fênetre générale avec un JPanel borderLayout
	        contentPane.setLayout(new BorderLayout());
	        contentPane.add(principalNord(), BorderLayout.NORTH);
	        contentPane.add(createOuest(), BorderLayout.WEST);	
	        contentPane.add(createEst(), BorderLayout.EAST);
	        contentPane.add(createSud(),BorderLayout.SOUTH);
	        contentPane.add(createCentre(), BorderLayout.CENTER);
	        
	}
	
/************************************************************************************************************************************/		
		
		//Methode pour la partie NORTH
		private JPanel principalNord() { 
			
			JPanel JPnordPrincipale = new JPanel();
			JPnordPrincipale.setLayout(new GridLayout(2,1));
			
			JPnordPrincipale.add(createNord()); // ajout de la méthode1 createNord dans JPnordPrincipale
			JPnordPrincipale.add(createNordLabel());//ajout de la méthode2 createNordLabel dans JPnordPrincipale
			
			return JPnordPrincipale;
		}
		
		//définition des méthodes createNord() et createNordLabel qui appartiennet au JPanel principalNord
		
		private JPanel createNord() { //la méthode1 createNord pour la partie des boutons 
			
			JPanel JPnord = new JPanel();
			JPnord.setLayout(new FlowLayout());
			
			ImageIcon poudlart = new ImageIcon(new ImageIcon("image/poudlart.png").getImage()); //déclaration de l'icone
			JButton btnNettoyer = new JButton("Nettoyer",poudlart); //création du bouton polluer et insertion de l'icone
			btnNettoyer.setPreferredSize(new Dimension(170,40));
			JPnord.add(btnNettoyer);
			btnNettoyer.addActionListener(new ActionListener() { //rendre notre boutton à l'écoute de notre demande
				public void actionPerformed(ActionEvent e) {
					btnNettoyer();//fonction du boutton qui est définie dans la partie des ActionsListeners
				}});
			
			/*************************************************************************************************************/
			
			ImageIcon death = new ImageIcon(new ImageIcon("image/death.png").getImage());//déclaration de l'icone
			JButton btnPolluer = new JButton("Polluer",death);//création du bouton polluer et insersersion de l'icone
			btnPolluer.setPreferredSize(new Dimension(170,40));//donner des dimensions au boutton
			
			btnPolluer.addActionListener(new ActionListener() { //rendre notre bouton à l'écoute de notre demande
				@Override
				public void actionPerformed(ActionEvent e) {
					btnPolluer(); //fonction du bouton qui est définie dans la partie des ActionsListeners
				}});
			
			JPnord.add(btnPolluer); //ajout du bouton dans la partie Nord de notre panel
			
			/*************************************************************************************************************/
			
			ImageIcon i = new ImageIcon(new ImageIcon("image/i.png").getImage());//déclaration de l'icone
			JButton btnReinitialise = new JButton("Reinitialiser",i);//création du bouton polluer et insersersion de l'icone
			btnReinitialise.setPreferredSize(new Dimension(170,40));//donner des dimensions au bouton
			
			btnReinitialise.addActionListener(new ActionListener() {//rendre notre bouton à l'écoute de notre demande
				public void actionPerformed(ActionEvent e) {
					btnReinitialise();//fonction du bouton qui est définie dans la partie des ActionsListeners
				}
			});
			
			JPnord.add(btnReinitialise);//ajout du bouton dans la partie Nord de notre panel
			
			/*************************************************************************************************************/
			
			ImageIcon HP = new ImageIcon(new ImageIcon("image/HP4.png").getImage());//déclaration de l'icone
			JButton btnQuitter = new JButton("Quitter",HP);//création du bouton polluer et insersersion de l'icone
			btnQuitter.setPreferredSize(new Dimension(170,40));//donner des dimensions au bouton
			
			btnQuitter.addActionListener(new ActionListener() {//rendre notre bouton à l'écoute de notre demande
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);//Quitter le programme
				}});			
			
			JPnord.add(btnQuitter);//ajout du bouton dans la partie Nord de notre panel
			
			
			return JPnord; //une fois que tous les boutons ont été ajoutés dans JPnord on le retourne.
		}
		
/************************************************************************************************************************************/
		
		//la méthode2 createNordLabel pour la partie texte
		private JPanel createNordLabel() {
			
			JPanel JLabelTxt = new JPanel();
			JLabelTxt.setLayout(new FlowLayout());
			
			JLabel nombre = new JLabel("Nombre de case maudite est :");
			JLabelTxt.add(nombre);
			/*************************************************************************************************************/
			
			JLabelPapierGras = new JLabel(" ");
			JLabelTxt.add(JLabelPapierGras);
			
			return JLabelTxt;
		}
		
/************************************************************************************************************************************/		
		
		//méthode pour la partie SOUTH
		private JPanel createSud() { 
			
			JPanel JPsud = new JPanel();
			JPsud.setLayout(new FlowLayout());
			
			/*************************************************************************************************************/
			
			JButton btnPapierGras = new JButton();
			btnPapierGras.setPreferredSize(new Dimension(70,40));
			btnPapierGras.setBackground(new Color(110,11,20));
			JPsud.add(btnPapierGras);
			
			/*************************************************************************************************************/
			JLabel LabelPapierGras = new JLabel("Mort");
			JPsud.add(LabelPapierGras);
			
			/*************************************************************************************************************/
			JButton btnPapierNettoyer = new JButton();
			btnPapierNettoyer.setPreferredSize(new Dimension(70,40));
			btnPapierNettoyer.setBackground(new Color(244,227,214));
			JPsud.add(btnPapierNettoyer);
			
			/*************************************************************************************************************/
			JLabel LabelCaseNettoyer = new JLabel("Vie");
			JPsud.add(LabelCaseNettoyer);
			
			return JPsud;
		}
		
/******************************************************************************************************************************************/
		private JPanel createOuest() { //la méthode pour la partie WEST
			
			JPanel JPouest = new JPanel();
			JPouest.setLayout(new GridLayout(4,1));
			
			/*************************************************************************************************************/
			ImageIcon voldemort = new ImageIcon(new ImageIcon("image/voldemort.png").getImage());
			JButton btnPollueurDroit = new JButton("Voldemort",voldemort);
			JPouest.add(btnPollueurDroit);
			
			//Action du bouton pollueur tout droit
			btnPollueurDroit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnPollueurDroit();}});
			
			/*************************************************************************************************************/
			ImageIcon bellatrix = new ImageIcon(new ImageIcon("image/bellatrix.jpg").getImage());
			JButton btnPollueurSauteur = new JButton("Bellatrix",bellatrix);
			
			JPouest.add(btnPollueurSauteur);
			btnPollueurSauteur.addActionListener(new ActionListener() { //ActionListner ppour bouton Pollueur sauteur
				
				@Override
				public void actionPerformed(ActionEvent e) {
					btnPollueurSauteur();
				}
			});
			
			
			JPouest.add(createToucheP()); //ajout de la fonction touche de circulation robot pollueur définie ci-dessous
			
			/*************************************************************************************************************/
			ImageIcon malfoy = new ImageIcon(new ImageIcon("image/malfoy.jpg").getImage());
			JButton btnPollueurLibre = new JButton("Draco",malfoy);
			//btnPollueurLibre.setPreferredSize(new Dimension(100,20));
			JPouest.add(btnPollueurLibre);
			
			//ActionListner pour le bouton pollueur libre
			btnPollueurLibre.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnPollueurLibre();}});
			
			return JPouest;
		}
		
/******************************************************************************************************************************************/		
		//les touches de circulation côté Robot pollueur
		private JPanel createToucheP() { 
			
			JPanel JPtoucheP = new JPanel();
			JPtoucheP.setLayout(new GridLayout(3,1));
			
			/*************************************************************************************************************/
			//bouton haut pollueur 
			JButton btnHautP = new JButton();
			btnHautP.setPreferredSize(new Dimension(50,19));
			ImageIcon haut = new ImageIcon(new ImageIcon("image/up.png").getImage());
			btnHautP.setIcon(haut);
			JPtoucheP.add(btnHautP);
			
			btnHautP.addActionListener(new ActionListener() {//ActionListener pour bouton haut pollueur
				@Override
				public void actionPerformed(ActionEvent e) {
					btnHautP();}});
			
			/*************************************************************************************************************/
			//bouton coté 
			JPtoucheP.add(createToucheCoteP());
			
			
			/*************************************************************************************************************/
			//bouton bas pollueur 
			JButton btnBasP = new JButton();
			btnBasP.setPreferredSize(new Dimension(50,19));
			ImageIcon bas = new ImageIcon(new ImageIcon("image/down.png").getImage());
			btnBasP.setIcon(bas);
			
			JPtoucheP.add(btnBasP);
			btnBasP.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					btnBasP();
				}
			});
			return JPtoucheP;
		}

/******************************************************************************************************************************************/
		//les touche droites et gauches coté pollueur
		private JPanel createToucheCoteP() {
		
		JPanel JPtoucheCoteP = new JPanel();
		JPtoucheCoteP.setLayout(new GridLayout(1,2));
		
		/*************************************************************************************************************/
		//bouton gauche pollueur*	
		JButton btnGaucheP = new JButton();
		//btnGaucheP.setPreferredSize(new Dimension(40,18));
		ImageIcon gauche = new ImageIcon(new ImageIcon("image/left.png").getImage());
		btnGaucheP.setIcon(gauche);
		
		/*************************************************************************************************************/
		
		JPtoucheCoteP.add(btnGaucheP);
		
		/*************************************************************************************************************/
		btnGaucheP.addActionListener(new ActionListener() { //ActionListener pour bouton gauche pollueur
			
			public void actionPerformed(ActionEvent e) {
				btnGaucheP();
			}
		});
		
		/*************************************************************************************************************/
		//bouton droit pollueur
		JButton btnDroitP = new JButton();
		//btnDroitP.setPreferredSize(new Dimension(40,18));
		ImageIcon droite = new ImageIcon(new ImageIcon("image/right.png").getImage());
		btnDroitP.setIcon(droite);
		
		
		JPtoucheCoteP.add(btnDroitP);
		btnDroitP.addActionListener(new ActionListener() {//ActionListener pour bouton de droite pollueur
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDroitP();	
			}
		});
			return JPtoucheCoteP;
		}
		
		
/********************************************************************************************************************************************/
		//fonction pour les robots nettoyeurs
		private JPanel createEst() {//la methode pour la partie EAST
					
			JPanel JPest = new JPanel();
			JPest.setLayout(new GridLayout(4,1));
			
			/*************************************************************************************************************/
			ImageIcon harry = new ImageIcon(new ImageIcon("image/harry.jpg").getImage());		
			JButton btnNettoyeurSmart = new JButton("Harry",harry);
			JPest.add(btnNettoyeurSmart);
					
			btnNettoyeurSmart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNettoyeurSmart();
					}
				});
			
			/*************************************************************************************************************/
			
			ImageIcon hermione = new ImageIcon(new ImageIcon("image/hermione.jpg").getImage());	
			JButton btnNettoyeurSauteur= new JButton("Hermione",hermione);
			JPest.add(btnNettoyeurSauteur);
					
			btnNettoyeurSauteur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNettoyeurSauteur();}});
			
			/*************************************************************************************************************/
			JPest.add(createToucheN());
			
			ImageIcon ron = new ImageIcon(new ImageIcon("image/ron.jpg").getImage());		
			JButton btnNettoyeurLibre = new JButton("Ron",ron);
			JPest.add(btnNettoyeurLibre);
					
				btnNettoyeurLibre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnNettoyeurLibre();
					}
				});
					
				return JPest;
				}		
		
/********************************************************************************************************************************************/		
		
		//les touches de circulation côté Robot Nettoyeur
		private JPanel createToucheN() { 
			
			JPanel JPtoucheN = new JPanel();
					
			JPtoucheN.setLayout(new GridLayout(3,1));
					
			/*************************************************************************************************************/
			JButton btnHautN = new JButton();
			ImageIcon haut = new ImageIcon(new ImageIcon("image/up.png").getImage());
			btnHautN.setIcon(haut);
			JPtoucheN.add(btnHautN);
			btnHautN.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {//action Listener pour touche haut nettoyeur
					btnHautN();
				}
			});
			
			/*************************************************************************************************************/
			
			JPtoucheN.add(createToucheCoteN());
			
			/*************************************************************************************************************/
			JButton btnBasN = new JButton();
			ImageIcon bas = new ImageIcon(new ImageIcon("image/down.png").getImage());
			btnBasN.setIcon(bas);
			
			JPtoucheN.add(btnBasN);
			btnBasN.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {//action Listener pour touche bas nettoyeur
					btnBasN();
				}
			});
				
					
			return JPtoucheN;
		}		

		
/********************************************************************************************************************************************/
		private JPanel createToucheCoteN() {//les touche droites et gauches coté Nettoyeur
			
			JPanel JPtoucheCoteN = new JPanel();
			JPtoucheCoteN.setLayout(new GridLayout(1,2));
			
			
			/*************************************************************************************************************/
			JButton btnGaucheN = new JButton();
			//btnGaucheN.setPreferredSize(new Dimension(40,17));
			ImageIcon gauche = new ImageIcon(new ImageIcon("image/left.png").getImage());
			btnGaucheN.setIcon(gauche);
			
			btnGaucheN.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {//action Listener pour touche bas nettoyeur
					btnGaucheN();}});
			
			/*************************************************************************************************************/
			JPtoucheCoteN.add(btnGaucheN);
			
			/*************************************************************************************************************/
			JButton btnDroitN = new JButton();
			//btnDroitN.setPreferredSize(new Dimension(40,17));
			ImageIcon droite = new ImageIcon(new ImageIcon("image/right.png").getImage());
			btnDroitN.setIcon(droite);
			
			btnDroitN.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {//action Listener pour touche bas nettoyeur
					btnDroitN();}});
			
			JPtoucheCoteN.add(btnDroitN);
				return JPtoucheCoteN;
			}
		
		
/***************************************************************************************************************************************/
		private JPanel createCentre() {//la methode pour le centre
			
			JPanel JPcentre= new JPanel();
			JPcentre.setLayout(new GridLayout(10,10));
			
			MondeLabel = new JLabel[10][10];
			
			for (int i = 0; i < MondeLabel.length; i++)
	        {
	            for (int j = 0; j < MondeLabel[i].length; j++ )
	            {
	            	JLabel box = new JLabel();
	            	box.setOpaque(true);
	            	box.setBackground(Color.WHITE);
	    			box.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	    			if(m.getMat()[i][j] == false) {
	    				MondeLabel[i][j] = box;
	    			}

	            	JPcentre.add(MondeLabel[i][j]);
	            }
	        }
			return JPcentre;
		}
		
/****************************************************************************************************************************************/
									//Les méthodes pour les actions listeners
		
		//bouton Pollueur tout droit
		private void btnPollueurDroit() {
			
			try {
				PollueurToutDroit.parcourir();
				PollueurToutDroit.getM().affiche();
				System.out.println();
				
				for(int i=0; i<10; i++) {
					for(int j=0; j<10; j++) {
						if(m.getMat()[i][j]==true) {
							MondeLabel[i][j].setBackground(new Color(110,11,20));
							
						}
					}
				}
				JLabelPapierGras.setText(""+m.ComptePapierGras());
				
			} catch (ErreurMatrice e) {
				System.out.println("erreur robot sort de la matrice");
				e.printStackTrace();
			}
			
		}
		
		//bouton Pollueur Sauteur
		private void btnPollueurSauteur() {
			try {
				PollueurSauteurs.parcourir();
				PollueurSauteurs.getM().affiche();
				System.out.println();
				
				for(int i=0; i<10; i++) {
					for(int j=0; j<10; j++) {
						if(m.getMat()[i][j]==true) {
							MondeLabel[i][j].setBackground(new Color(110,11,20));	
						}
					}
				}
				JLabelPapierGras.setText(""+m.ComptePapierGras());
				
			} catch (ErreurMatrice e) {
				System.out.println("erreur coordonnee");
				e.printStackTrace();
			}
			
			
		}
		
		//bouton Pollueur Libre
		private void btnPollueurLibre() {
			
			try {
				PollueurLibre.parcourir();
				PollueurLibre.getM().affiche();
				System.out.println();
				
				for(int i=0; i<10; i++) {
					for(int j=0; j<10; j++) {
						if(m.getMat()[i][j]==true) {
							MondeLabel[i][j].setBackground(new Color(110,11,20));	
						}
					}
				}
				JLabelPapierGras.setText(""+m.ComptePapierGras());
				
			} catch (ErreurMatrice e) {
				System.out.println("erreur coordonnee");
				e.printStackTrace();
			}
			
		}
		
		//bouton polluer le monde
		private void btnPolluer() {
			
			PollueurToutDroit.PollueMonde();
			PollueurToutDroit.getM().affiche();
			System.out.println();
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(m.getMat()[i][j]==true) {
						MondeLabel[i][j].setBackground(new Color(110,11,20));
						
					}
					
				}
			}
			JLabelPapierGras.setText(""+m.ComptePapierGras());
		}
		
		//bouton nettoyer le monde
		private void btnNettoyer() {
			
			NettoyeurLibre.NettoieMonde();
			NettoyeurLibre.getM().affiche();
			System.out.println();
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if(m.getMat()[i][j]==false) {
						MondeLabel[i][j].setBackground(Color.white);
					}
					
				}
			}
			JLabelPapierGras.setText(""+m.ComptePapierGras());
		}
		
		//bouton nettoyeur sauteur
		private void btnNettoyeurSauteur() {
			try {
				NettoyeurSauteur.parcourir();
				NettoyeurSauteur.getM().affiche();
				System.out.println();
				
				for(int i=0; i<10; i++) {
					for(int j=0; j<10; j++) {
						if(m.getMat()[i][j]==false) {
							MondeLabel[i][j].setBackground(Color.white);
						}
						
					}
				}
				JLabelPapierGras.setText(""+m.ComptePapierGras());
			} catch (ErreurMatrice e) {
				System.out.println("erreur coordonnee");
				e.printStackTrace();
			}
			
		}
		
		//bouton nettoyeur libre
		private void btnNettoyeurLibre() {
			
			try {
				NettoyeurLibre.parcourir();
				NettoyeurLibre.getM().affiche();
				System.out.println();
				
				for(int i=0; i<10; i++) {
					for(int j=0; j<10; j++) {
						if(m.getMat()[i][j]==false) {
							MondeLabel[i][j].setBackground(Color.white);
						}
						
					}
				}
				JLabelPapierGras.setText(""+m.ComptePapierGras());
				
			} catch (ErreurMatrice e) {
				System.out.println("erreur coordonnee");
				e.printStackTrace();
			}
			
		}
		
		//bouton nettoyeur Smart
		private void btnNettoyeurSmart() {
			try {
				NettoyeurSmart.parcourir();
				NettoyeurSmart.getM().affiche();
				System.out.println();
				
				for(int i=0; i<10; i++) {
					for(int j=0; j<10; j++) {
						if(m.getMat()[i][j]==false) {
							MondeLabel[i][j].setBackground(Color.white);
						}
						
					}
				}
				JLabelPapierGras.setText(""+m.ComptePapierGras());
			} catch (ErreurMatrice e) {
				System.out.println("erreur coordonnee");
				e.printStackTrace();
			}
			
		}
		
		//bouton reinitialiser
		private void btnReinitialise() {
			
			NettoyeurLibre.NettoieMonde();
			NettoyeurLibre.getM().affiche();
			System.out.println();
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					
						MondeLabel[i][j].setBackground(Color.white);
						MondeLabel[i][j].setIcon(null);
					
				}
			}
			JLabelPapierGras.setText(""+m.ComptePapierGras());
		}
		/***********************************pollueur*****************************************/
		//bouton marche haut côté pollueur
		private void btnHautP() {
			
			
			try {
				PollueurToutDroit.setPosx(PollueurToutDroit.getPosx()-1);
				PollueurToutDroit.deplace(PollueurToutDroit.getPosx(), PollueurToutDroit.getPosy());
				
				avatar(PollueurToutDroit.getPosx(), PollueurToutDroit.getPosy());
				MondeLabel[PollueurToutDroit.getPosx()+1][PollueurToutDroit.getPosy()].setIcon(null);
			} catch (ErreurCoord e) {
				
				e.printStackTrace();
			}
			
				
		}
		
		//bouton marche vers haut côté pollueur
		
		private void btnBasP() {
			
			try {
				PollueurToutDroit.setPosx(PollueurToutDroit.getPosx()+1);
				PollueurToutDroit.deplace(PollueurToutDroit.getPosx(), PollueurToutDroit.getPosy());
				
				avatar(PollueurToutDroit.getPosx(), PollueurToutDroit.getPosy());
				MondeLabel[PollueurToutDroit.getPosx()-1][PollueurToutDroit.getPosy()].setIcon(null);
			} catch (ErreurCoord e) {
				
				e.printStackTrace();
			}
			
		}
		
		//bouton marche vers la droite cote pollueur
		private void btnDroitP() {
			
			
			try {
				PollueurToutDroit.setPosy(PollueurToutDroit.getPosy()+1);
				PollueurToutDroit.deplace(PollueurToutDroit.getPosx(), PollueurToutDroit.getPosy());
				avatar(PollueurToutDroit.getPosx(), PollueurToutDroit.getPosy());
				MondeLabel[PollueurToutDroit.getPosx()][PollueurToutDroit.getPosy()-1].setIcon(null);
			} catch (ErreurCoord e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		private void btnGaucheP() {
			
			try {
				PollueurToutDroit.setPosy(PollueurToutDroit.getPosy()-1);
				PollueurToutDroit.deplace(PollueurToutDroit.getPosx(), PollueurToutDroit.getPosy());
				avatar(PollueurToutDroit.getPosx(), PollueurToutDroit.getPosy());
				MondeLabel[PollueurToutDroit.getPosx()][PollueurToutDroit.getPosy()+1].setIcon(null);
			} catch (ErreurCoord e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		/***********************************Nettoyeur*****************************************/
		//bouton marche haut côté nettoyeur
		private void btnHautN() {
			
			
			try {
				NettoyeurSauteur.setPosx(NettoyeurSauteur.getPosx()-1);
				NettoyeurSauteur.deplace(NettoyeurSauteur.getPosx(), NettoyeurSauteur.getPosy());
				avatar2(NettoyeurSauteur.getPosx(), NettoyeurSauteur.getPosy());
				MondeLabel[NettoyeurSauteur.getPosx()+1][NettoyeurSauteur.getPosy()].setIcon(null);
			} catch (ErreurCoord e) {
				
				e.printStackTrace();
			}
			
				
		}
		
		//bouton marche vers haut côté pollueur
		
		private void btnBasN() {
			
			try {
				NettoyeurSauteur.setPosx(NettoyeurSauteur.getPosx()+1);
				NettoyeurSauteur.deplace(NettoyeurSauteur.getPosx(), NettoyeurSauteur.getPosy());
				avatar2(NettoyeurSauteur.getPosx(), NettoyeurSauteur.getPosy());
				MondeLabel[NettoyeurSauteur.getPosx()-1][NettoyeurSauteur.getPosy()].setIcon(null);
			} catch (ErreurCoord e) {
				
				e.printStackTrace();
			}
			
		}
		
		//bouton marche vers la droite cote nettoyeur
		private void btnDroitN() {
			
			
			try {
				NettoyeurSauteur.setPosy(NettoyeurSauteur.getPosy()+1);
				NettoyeurSauteur.deplace(NettoyeurSauteur.getPosx(), NettoyeurSauteur.getPosy());
				avatar2(NettoyeurSauteur.getPosx(), NettoyeurSauteur.getPosy());
				MondeLabel[NettoyeurSauteur.getPosx()][NettoyeurSauteur.getPosy()-1].setIcon(null);
			} catch (ErreurCoord e) {
				System.out.println("erreur robot sort de la matrice");
				e.printStackTrace();
			}
			
		}
		
		private void btnGaucheN() {
			
			try {
				NettoyeurSauteur.setPosy(NettoyeurSauteur.getPosy()-1);
				NettoyeurSauteur.deplace(NettoyeurSauteur.getPosx(), NettoyeurSauteur.getPosy());
				avatar2(NettoyeurSauteur.getPosx(), NettoyeurSauteur.getPosy());
				MondeLabel[NettoyeurSauteur.getPosx()][NettoyeurSauteur.getPosy()+1].setIcon(null);
				
			} catch (ErreurCoord e) {
				System.out.println("erreur robot sort de la matrice");
				e.printStackTrace();
			}
			
			
		}
		
		
		
/****************************************************************************************************************************************/		
	//Les methodes pour les avatares serpent et vif d'or placé sur le Monde
		
		public void avatar(int x, int y) //serpent
	  	{ 
			ImageIcon avatarI = new ImageIcon(new ImageIcon("image/snake.png").getImage());
			MondeLabel[x][y].setIcon(avatarI);		
	  	}
		
		public void avatar2(int x, int y)//vif d'or
	  	{ 
			ImageIcon avatar2 = new ImageIcon(new ImageIcon("image/vif.png").getImage());
			MondeLabel[x][y].setIcon(avatar2);		
	  	}
		
/****************************************************************************************************************************************/	
	
		public static void main(String[] args) throws Exception {
		//appliquer un look'n feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		FenetreRobotListner frame= new FenetreRobotListner();
		frame.setVisible(true);
		
		
}
}
