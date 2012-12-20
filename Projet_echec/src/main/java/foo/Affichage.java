package foo;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pieces.Cavalier;
import pieces.Dame;
import pieces.Fou;
import pieces.Pion;
import pieces.Position;
import pieces.Roi;
import pieces.Tour;




public class Affichage extends JFrame{

	//attributs de menuPricipal()
	private static JFrame fenMenu = new JFrame("Jeu D'échec - Menu");
	private static JButton creer =new JButton("Créer Partie");
	private static JButton revoir =new JButton("Revoir la Partie");
	private static JButton exit =new JButton("Quitter la partie");


	//attributs de menuJoueurs()
	private static JFrame fenMenuJoueur = new JFrame("Jeu D'échec - Création des joueurs");
	private static JTextField j1 = new JTextField("Joueur 1");
	private static JTextField j2 = new JTextField("Joueur 2");
	private static JButton ok =new JButton("Confirmer");

	//attributs de menuPartie()
	private static JFrame fenMenuPartie = new JFrame("Jeu D'échec - Création de la Partie");
	private static JButton partieS =new JButton("Partie Standard");
	private static JButton partieP =new JButton("Partie Personnalisée");
	private static JButton revenir =new JButton("Revenir au menu principale");

	//attribut afficherEchiquier()
	private static JFrame fenEchiquier = new JFrame("Jeu D'échec ");
	private static JPanel panEchiquier = new JPanel();
	private static JPanel monPanel = new JPanel();
	private static boolean[][] dejaEcoute = new boolean[8][8];

	//attributs afficherPartieStandard et partie perso
	private static JFrame fenEchiquierStand = new JFrame("Jeu D'échec ");
	private static JFrame fenEchiquierPerso = new JFrame("Jeu D'échec ");
	private static JButton  commencer = new JButton ("Commencer la partie");
	private static JLabel timer =new JLabel("Timer");

	//attribut afficherAide()
	private static boolean aide = false;
	private static JButton aideBoutton = new JButton("Aide");



	private static JButton tabBoutton[][] = new JButton[8][8];
	private static JButton tabPiece[][] = new JButton[6][2];

	private static Partie p = new Partie();
	// attribut utilisé par partie
	/*private static Echiquier ech = new Echiquier();
	private static String J1;
	private static String J2;
	private static Position CaseCliquee = new Position();
	private static Position CaseCliqueeMenu = new Position(); 
	private static String Nom = "";
	private static String Couleur = "";
	private static boolean Suivant = false ;*/


	public Affichage(){
		for(int i=0; i<8; i++)
			for(int j=0; j<8 ; j++)
				this.dejaEcoute[i][j]=false;
	}

	public static boolean getdejaEcoute(int i, int j){
		return dejaEcoute[i][j];
	}

	public static void setdejaEcoute(int i, int j, boolean stat){
		dejaEcoute[i][j] = stat;
	}


	public static void menuPrincipal(){


		JPanel pan = new JPanel();

		creer.setSize(200,60);
		creer.addActionListener(new EcouteurMenu());


		revoir.setSize(200,60);
		revoir.addActionListener(new EcouteurMenu());


		exit.setSize(200,60);
		exit.addActionListener(new EcouteurMenu());

		pan.setLayout(new GridLayout(3,1));
		pan.add(creer);
		pan.add(revoir);
		pan.add(exit);


		fenMenu.getContentPane().add(pan);
		fenMenu.pack();
		fenMenu.setSize(400,400);
		fenMenu.setVisible(true);

	}

	public static void menuJoueurs(){

		//j1.setColumns(10);
		//j2.setColumns(10);
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(1,2));
		pan1.add(new JLabel("Blanc"));
		pan1.add(new JLabel("Noir"));


		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1,2));
		pan2.add(j1);
		pan2.add(j2);

		JPanel pan3 = new JPanel();
		pan3.setLayout(new GridLayout(1,2));
		ok.addActionListener(new EcouteurChoixJoueur());
		revenir.addActionListener(new EcouteurChoixJoueur());
		pan3.add(ok);
		pan3.add(revenir);

		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(3,1));
		pan.add(pan1);
		pan.add(pan2);
		pan.add(pan3);


		fenMenuJoueur.getContentPane().add(pan);
		fenMenuJoueur.pack();
		fenMenuJoueur.setSize(400,400);
		fenMenuJoueur.setVisible(true);


	}

	public static void menuPartie(){

		fenMenuPartie.setTitle("Jeu D'échec-Création de partie");
		JPanel pan = new JPanel();


		partieS.setSize(200,60);
		partieS.addActionListener(new EcouteurChoixPartie());

		partieP.setSize(200,60);
		partieP.addActionListener(new EcouteurChoixPartie());

		revenir.setSize(200,60);
		revenir.addActionListener(new EcouteurChoixPartie());

		pan.setLayout(new GridLayout(3,1));
		pan.add(partieS);
		pan.add(partieP);
		pan.add(revenir);


		fenMenuPartie.getContentPane().add(pan);
		fenMenuPartie.pack();
		fenMenuPartie.setSize(400,400);
		fenMenuPartie.setVisible(true);
	}

	public static JPanel tabPieces(){

		JFrame fen = new JFrame("Pieces disponibles");
		JPanel pan = new JPanel();
		pan.setSize(400, 100);

		pan.setLayout(new GridLayout(6,2));

		JButton roin = new JButton(new ImageIcon("src//main/java/images/roin.gif"));
		roin.setSize(200, 16);
		tabPiece[0][0] = roin;
		JButton roib = new JButton(new ImageIcon("src//main/java/images/roib.gif"));
		roib.setSize(200, 16);
		tabPiece[0][1] = roib;

		JButton damen = new JButton(new ImageIcon("src//main/java/images/damen.gif"));
		damen.setSize(200, 16);
		tabPiece[1][0] = damen;
		JButton dameb = new JButton(new ImageIcon("src//main/java/images/dameb.gif"));
		dameb.setSize(200, 16);
		tabPiece[1][1] = dameb;

		JButton tourn = new JButton(new ImageIcon("src//main/java/images/tourn.gif"));
		tourn.setSize(200, 16);
		tabPiece[2][0] = tourn;
		JButton tourb = new JButton(new ImageIcon("src//main/java/images/tourb.gif"));
		tourb.setSize(200, 16);
		tabPiece[2][1] = tourb;

		JButton foun = new JButton(new ImageIcon("src//main/java/images/foun.gif"));
		foun.setSize(200, 16);
		tabPiece[3][0] = foun;
		JButton foub = new JButton(new ImageIcon("src//main/java/images/foub.gif"));
		foub.setSize(200, 16);
		tabPiece[3][1] = foub;

		JButton cavaliern = new JButton(new ImageIcon("src//main/java/images/cavaliern.gif"));
		cavaliern.setSize(200, 16);
		tabPiece[4][0] = cavaliern;
		JButton cavalierb = new JButton(new ImageIcon("src//main/java/images/cavalierb.gif"));
		cavalierb.setSize(200, 16);
		tabPiece[4][1] = cavalierb;

		JButton pionn = new JButton(new ImageIcon("src//main/java/images/pionn.gif"));
		pionn.setSize(200, 16);
		tabPiece[5][0] = pionn;
		JButton pionb = new JButton(new ImageIcon("src//main/java/images/pionb.gif"));
		pionb.setSize(200, 16);
		tabPiece[5][1] = pionb;

		for (int i=0 ; i<6 ; i++){
			for(int j = 0 ; j<2 ; j++){
				tabPiece[i][j].addActionListener(new EcouteurPiece());
			}
		}
		pan.add(roin);
		pan.add(roib);
		pan.add(damen);
		pan.add(dameb);
		pan.add(tourn);
		pan.add(tourb);
		pan.add(foun);
		pan.add(foub);
		pan.add(cavaliern);
		pan.add(cavalierb);
		pan.add(pionn);
		pan.add(pionb);


		fen.getContentPane().add(pan);
		fen.pack();
		fen.setVisible(true);

		return pan;

	}

	public void confirmExit(){

		JFrame fenetre1 = new JFrame("Fin de partie");
		JPanel panel1 =new JPanel();
		panel1.setSize(400, 100);
		panel1.setLayout( new BoxLayout(panel1,1));

		JButton confirmer = new JButton("Confirmer sortie de la partie");
		confirmer.setSize(200,50);

		panel1.add(confirmer);

		fenetre1.getContentPane().add(panel1);
		fenetre1.pack();
		fenetre1.setVisible(true);


	}

	public static void afficherAide(){
		if (p.getEchiquier().getTableau()[p.getCaseCliquee().getI()][p.getCaseCliquee().getJ()] != null){
			Vector<Position> dest = p.getEchiquier().destinationPossible(p.getEchiquier().getTableau()[p.getCaseCliquee().getI()][p.getCaseCliquee().getJ()]);

			for (Position pos : dest){
				tabBoutton[pos.getI()][pos.getJ()].setBackground(Color.green);
				tabBoutton[pos.getI()][pos.getJ()].repaint();
			}
		}
		else 
			System.out.println("error");


	}

	public static JPanel afficherEchiquier(Echiquier ech)
	{
		if( panEchiquier == null )
			panEchiquier = new JPanel();
		JPanel pan = panEchiquier;
		pan.removeAll();

		pan.setSize(400, 100);
		pan.setLayout(new GridLayout(9,8));
		for(int i=0; i<8; i++){
			for(int j=0; j<8 ; j++){

				if(ech.getTableau()[i][j]!=null){

					String type = ech.getTableau()[i][j].getClass().getName();
					String color = ech.getTableau()[i][j].getCouleur();
					if((type=="pieces.Pion")&&(color=="blanc")){
						p.getEchiquier().getTableau()[i][j]= new Pion(new Position(i,j),"blanc");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/pionb.gif"));
						
					}
					else if((type=="pieces.Tour") && (color=="blanc")){
						p.getEchiquier().getTableau()[i][j]= new Tour(new Position(i,j),"blanc");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/tourb.gif"));
					}
					else if((type=="pieces.Fou")&&(color=="blanc")){
						p.getEchiquier().getTableau()[i][j]= new Fou(new Position(i,j),"blanc");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/foub.gif"));
					}
					else if((type=="pieces.Cavalier")&&(color=="blanc")){
						p.getEchiquier().getTableau()[i][j]= new Cavalier(new Position(i,j),"blanc");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/cavalierb.gif"));
					}
					else if((type=="pieces.Dame")&&(color=="blanc")){
						p.getEchiquier().getTableau()[i][j]= new Dame(new Position(i,j),"blanc");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/dameb.gif"));
					}
					else if((type=="pieces.Roi")&&(color=="blanc")){
						p.getEchiquier().getTableau()[i][j]= new Roi(new Position(i,j),"blanc");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/roib.gif"));
					}
					else if((type=="pieces.Pion")&&(color=="noir")){
						p.getEchiquier().getTableau()[i][j]= new Pion(new Position(i,j),"noir");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/pionn.gif"));
					}
					else if((type=="pieces.Tour") && (color=="noir")){
						p.getEchiquier().getTableau()[i][j]= new Tour(new Position(i,j),"noir");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/tourn.gif"));
					}
					else if((type=="pieces.Fou")&&(color=="noir")){
						p.getEchiquier().getTableau()[i][j]= new Fou(new Position(i,j),"noir");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/foun.gif"));
					}
					else if((type=="pieces.Cavalier")&&(color=="noir")){
						p.getEchiquier().getTableau()[i][j]= new Cavalier(new Position(i,j),"noir");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/cavaliern.gif"));
					}
					else if((type=="pieces.Dame")&&(color=="noir")){
						p.getEchiquier().getTableau()[i][j]= new Dame(new Position(i,j),"noir");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/damen.gif"));
					}
					else if((type=="pieces.Roi")&&(color=="noir")){
						p.getEchiquier().getTableau()[i][j]= new Roi(new Position(i,j),"noir");
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/roin.gif"));
					}
					else{
						System.out.println("erreur : "+type +color);
					}
				}
				else if(ech.getTableau()[i][j]==null){
					tabBoutton[i][j] = new JButton();
				}


				if((i%2==0 && j%2 == 0) || (i%2==1 && j%2 == 1)){
					tabBoutton[i][j].setBackground(Color.darkGray);
				}	
				else{
					tabBoutton[i][j].setBackground(Color.lightGray);
				}

				if(tabBoutton[i][j].getAction()==null)
					tabBoutton[i][j].addActionListener(new EcouteurEchiquier());

				pan.add(tabBoutton[i][j]);				
			}

		}

		JTextField txt = new JTextField("null");
		if(p.getTour()%2 == 0){
			txt.setText("Noirs jouent");
		}
		else if(p.getTour()%2 ==1){
			txt.setText("Blancs jouent");
		}
		pan.add(txt);
		
		return pan;
	}

	public static void afficherPartieStandard(){

		/*if(cont!=null)
			cont.removeAll();
		
		cont = fenEchiquierStand.getContentPane();*/

		//panEchiquier = afficherEchiquier(p.getEchiquier());
		panEchiquier.setLayout(new GridLayout(9,8));

		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1,4));
		revenir.addActionListener(new EcouteurChoixPartie());
		aideBoutton.addActionListener(new EcouteurAide());
		creer.addActionListener(new EcouteurMenu());
		pan2.add(revenir);
		pan2.add(aideBoutton);
		pan2.add(creer);
		pan2.add(timer);
		pan2.setSize(50,20);

		monPanel.setLayout(new GridLayout(2,1));
		panEchiquier = afficherEchiquier(p.getEchiquier());
		monPanel.add(panEchiquier);
		monPanel.add(pan2);

		fenEchiquier.getContentPane().add(monPanel);

		fenEchiquier.setSize(400,400);

		fenEchiquier.pack();
		fenEchiquier.setVisible(true);
	}

	public static  void afficherPartiePersonnalisee()
	{
		/*if(cont!=null)
			cont.removeAll();
		
		cont = fenEchiquierPerso.getContentPane();*/

		JPanel panPiece = tabPieces();
		//panEchiquier = afficherEchiquier(p.getEchiquier());

		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1,2));
		revenir.addActionListener(new EcouteurChoixPartie());
		commencer.addActionListener(new EcouteurEchiquier());
		pan2.add(revenir);
		pan2.add(commencer);
		pan2.setSize(50,20);

		monPanel.setLayout(new GridLayout(2,2));
		panEchiquier = afficherEchiquier(p.getEchiquier());
		monPanel.add(panEchiquier);
		monPanel.add(panPiece);
		monPanel.add(pan2);

		fenEchiquier.getContentPane().add(monPanel);

		fenEchiquier.setSize(400,400);

		fenEchiquier.pack();
		fenEchiquier.setVisible(true);

	}	

	public static class EcouteurMenu implements ActionListener{

		public void actionPerformed(ActionEvent e){ 
			if (e.getSource() == creer){
				fenMenu.dispose();
				menuJoueurs();
			}
			if (e.getSource() == revoir){
				System.out.println("revoir"); 
			}
			if (e.getSource() == exit){
				System.exit(0); 
			}
		}
	}

	public  static class EcouteurChoixJoueur implements ActionListener{
		public void actionPerformed(ActionEvent e){ 
			if (e.getSource() == ok){
				p.getJoueur1().setNom(j1.getText());
				p.getJoueur1().setCouleur("blanc");
				p.getJoueur2().setNom(j2.getText());
				p.getJoueur2().setCouleur("noir");
				fenMenuJoueur.dispose();
				menuPartie();  
			}
			if (e.getSource() == revenir){
				fenMenuJoueur.dispose(); 
				menuPrincipal();
			}
		}
	}

	public  static class EcouteurChoixPartie implements ActionListener{

		public void actionPerformed(ActionEvent e){ 
			if (e.getSource() == partieS ){
				fenMenuPartie.dispose();
				p.E.echiquierStandard();
				afficherPartieStandard(); 

			}
			if (e.getSource() == partieP){
				fenMenuPartie.dispose();
				afficherPartiePersonnalisee();  
			}
			if (e.getSource() == revenir){
				fenMenuPartie.dispose();
				fenEchiquierStand.dispose();
				fenEchiquier.dispose();
				menuPrincipal();
			}
		}

	}

	public  static class EcouteurEchiquier implements ActionListener{
		public void actionPerformed(ActionEvent e){


			if (e.getSource() == commencer){
				fenEchiquier.dispose();
				afficherPartieStandard();	
			}

			for(int i=0; i<8; i++){
				for(int j=0; j<8 ; j++){
					if (e.getSource() == tabBoutton[i][j]){
						p.setCaseCliquee(new Position(i,j));
						//p.getEchiquier().getTableau()[i][j].setPositionPossible();
						System.out.println(p.getCaseCliquee().getI()+ " "+p.getCaseCliquee().getJ());

						for(int i1=0; i1<8; i1++){
							for(int j1=0; j1<8 ; j1++){
								if((i1%2==0 && j1%2 == 0) || (i1%2==1 && j1%2 == 1)){
									tabBoutton[i1][j1].setBackground(Color.darkGray);
								}	
								else{
									tabBoutton[i1][j1].setBackground(Color.lightGray);
								}	
							}
						}

						if (aide==true){
							afficherAide();
						}

						panEchiquier=afficherEchiquier(p.getEchiquier());
						monPanel.updateUI();

					}
				}
			}

		}
	}

	public  static class EcouteurPiece implements ActionListener{
		public void actionPerformed(ActionEvent e){ 
			if (e.getSource() == tabPiece[0][0]){
				p.setNomPiece("pieces.Roi");
				p.setCouleurPiece("noir");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[0][1]){
				p.setNomPiece("pieces.Roi");
				p.setCouleurPiece("blanc");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[1][0]){
				p.setNomPiece("pieces.Dame");
				p.setCouleurPiece("noir");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[1][1]){
				p.setNomPiece("pieces.Dame");
				p.setCouleurPiece("blanc");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[2][0]){
				p.setNomPiece("pieces.Tour");
				p.setCouleurPiece("noir");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[2][1]){
				p.setNomPiece("pieces.Tour");
				p.setCouleurPiece("blanc");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[3][0]){
				p.setNomPiece("pieces.Fou");
				p.setCouleurPiece("noir");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[3][1]){
				p.setNomPiece("pieces.Fou");
				p.setCouleurPiece("blanc");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[4][0]){
				p.setNomPiece("pieces.Cavalier");
				p.setCouleurPiece("noir");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[4][1]){
				p.setNomPiece("pieces.Cavalier");
				p.setCouleurPiece("blanc");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[5][0]){
				p.setNomPiece("pieces.Pion");
				p.setCouleurPiece("noir");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
			if (e.getSource() == tabPiece[5][1]){
				p.setNomPiece("pieces.Pion");
				p.setCouleurPiece("blanc");
				System.out.println(p.getNomPiece() + " "+ p.getCouleurPiece());
			}
		}
	}

	public  static class EcouteurAide implements ActionListener{
		public void actionPerformed(ActionEvent e){ 
			if (e.getSource() == aideBoutton){
				if (aide == true){
					for(int i=0; i<8; i++){
						for(int j=0; j<8 ; j++){
							if((i%2==0 && j%2 == 0) || (i%2==1 && j%2 == 1)){
								tabBoutton[i][j].setBackground(Color.darkGray);
							}	
							else{
								tabBoutton[i][j].setBackground(Color.lightGray);
							}	
						}
					}
				}
				aide =! aide;
				System.out.println(aide);
			}
		}
	}

	public static void main(String[] args) {

		menuPrincipal();
		p.jouerPartie();

		//menuPrincipal();
		//choixDeLaPartie();
		//menuFinDePartie();
		//choixDesJoueur();

		//tabPieces();
		//afficherEchiquier();

		//ech.echiquierStandard();
		//afficherEchiquier(ech);
		//afficherPartiePersonnalisee();
		//afficherPartieStandard();
		//afficherPartieStandard();


	}

}