package foo;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private static JButton exit1 =new JButton("Quitter la partie");
	private static JButton suivant = new JButton ("Coup Suivant");


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

	//attributs de menuExit()
	private static JFrame fenMenuExit = new JFrame("Jeu D'échec - Partie Terminer");



	//attribut afficherEchiquier()
	private static JFrame fenEchiquier = new JFrame("Jeu D'échec ");
	private static JPanel panEchiquier = new JPanel();
	private static JPanel monPanel = new JPanel();

	//attributs afficherPartieStandard et partie perso
	private static JFrame fenEchiquierStand = new JFrame("Jeu D'échec ");
	private static JButton  commencer = new JButton ("Commencer la partie");

	private static boolean commencerBool = false;
	private static JButton terminer= new JButton ("Terminer la partie");

	//attribut afficherAide()
	private static boolean aide = false;
	private static JButton aideBoutton = new JButton("Aide");


	private static JButton tabBoutton[][] = new JButton[8][8];
	private static JButton tabPiece[][] = new JButton[6][2];


	private static Partie p = new Partie();


	public Affichage(){

	}

	public static void setP(Partie p) {
		Affichage.p = p;
	}

	public static boolean isCommencerBool() {
		return commencerBool;
	}

	public static void setCommencerBool(boolean commencerBool) {
		Affichage.commencerBool = commencerBool;
	}

	public static Partie getPartie()
	{
		return p;
	}
	public static void menuPrincipal(){


		JPanel pan = new JPanel();

		creer.setSize(200,60);
		creer.addActionListener(new EcouteurMenu());


		revoir.setSize(200,60);
		revoir.addActionListener(new EcouteurMenu());


		exit1.setSize(200,60);
		exit1.addActionListener(new EcouteurMenu());

		pan.setLayout(new GridLayout(3,1));
		pan.add(creer);
		pan.add(revoir);
		pan.add(exit1);


		fenMenu.getContentPane().add(pan);
		confirmExit(fenMenu);
		fenMenu.pack();
		fenMenu.setSize(400,400);
		fenMenu.setVisible(true);


	}

	public static void menuJoueurs(){

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
		confirmExit(fenMenuJoueur);
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
		confirmExit(fenMenuPartie);
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




		return pan;

	}

	public static void menuExit (){


		JPanel pan = new JPanel();

		revenir.setSize(200,60);
		revenir.addActionListener(new EcouteurChoixPartie());

		exit1.setSize(200,60);
		exit1.addActionListener(new EcouteurMenu());

		pan.setLayout(new GridLayout(2,1));
		pan.add(revenir);
		pan.add(exit1);

		fenMenuExit.getContentPane().add(pan);
		confirmExit(fenMenuExit);
		fenMenuExit.pack();
		fenMenuExit.setSize(400,400);
		fenMenuExit.setVisible(true);


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
						Pion pion = (Pion)p.getEchiquier().getTableau()[i][j];
						pion.setPosition(new Position(i,j));
						p.getEchiquier().getTableau()[i][j] = pion;
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/pionb.gif"));

					}
					else if((type=="pieces.Tour") && (color=="blanc")){
						Tour tour = (Tour)p.getEchiquier().getTableau()[i][j];
						tour.setPosition(new Position(i,j));
						p.getEchiquier().getTableau()[i][j] = tour;
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
						Roi roi = (Roi)p.getEchiquier().getTableau()[i][j];
						roi.setPosition(new Position(i,j));
						p.getEchiquier().getTableau()[i][j] = roi;						
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/roib.gif"));
					}
					else if((type=="pieces.Pion")&&(color=="noir")){
						Pion pion = (Pion)p.getEchiquier().getTableau()[i][j];
						pion.setPosition(new Position(i,j));
						p.getEchiquier().getTableau()[i][j] = pion;						
						tabBoutton[i][j] = new JButton(new ImageIcon("src//main/java/images/pionn.gif"));
					}
					else if((type=="pieces.Tour") && (color=="noir")){
						Tour tour = (Tour)p.getEchiquier().getTableau()[i][j];
						tour.setPosition(new Position(i,j));
						p.getEchiquier().getTableau()[i][j] = tour;
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
						Roi roi = (Roi)p.getEchiquier().getTableau()[i][j];
						roi.setPosition(new Position(i,j));
						p.getEchiquier().getTableau()[i][j] = roi;
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
				if(p.getCaseCliquee() != null)
					tabBoutton[p.getCaseCliquee().getI()][p.getCaseCliquee().getJ()].setBackground(Color.green);
				if(tabBoutton[i][j].getAction()==null)
					tabBoutton[i][j].addActionListener(new EcouteurEchiquier());

				pan.add(tabBoutton[i][j]);				
			}

		}

		if (aide==true){
			afficherAide();
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

		panEchiquier.setLayout(new GridLayout(9,8));

		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1,5));
		revenir.addActionListener(new EcouteurChoixPartie());
		aideBoutton.addActionListener(new EcouteurAide());
		creer.addActionListener(new EcouteurMenu());
		terminer.addActionListener(new EcouteurDebutFin());

		pan2.add(revenir);
		pan2.add(aideBoutton);
		pan2.add(creer);
		pan2.add(terminer);
		pan2.setSize(50,20);


		monPanel.setLayout(new GridLayout(2,1));
		panEchiquier = afficherEchiquier(p.getEchiquier());
		monPanel.add(panEchiquier);
		monPanel.add(pan2);


		fenEchiquier.getContentPane().add(monPanel);
		confirmExit(fenEchiquier);
		fenEchiquier.setSize(400,400);
		fenEchiquier.pack();
		fenEchiquier.setVisible(true);
	}

	public static  void afficherPartiePersonnalisee()
	{
		JPanel panPiece = tabPieces();

		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1,2));
		revenir.addActionListener(new EcouteurChoixPartie());
		commencer.addActionListener(new EcouteurDebutFin());
		pan2.add(revenir);
		pan2.add(commencer);
		pan2.setSize(50,20);

		monPanel.setLayout(new GridLayout(2,2));
		panEchiquier = afficherEchiquier(p.getEchiquier());
		monPanel.add(panEchiquier);
		monPanel.add(panPiece);
		monPanel.add(pan2);

		fenEchiquier.getContentPane().add(monPanel);
		confirmExit(fenEchiquier);
		fenEchiquier.setSize(400,400);


		confirmExit(fenEchiquier);

		fenEchiquier.pack();
		fenEchiquier.setVisible(true);

	}	

	public static void revoirPartie(){

		panEchiquier.setLayout(new GridLayout(9,8));

		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1,5));
		suivant.addActionListener(new EcouteurAide());
		revenir.addActionListener(new EcouteurChoixPartie());

		pan2.add(suivant);
		pan2.add(revenir);

		monPanel.setLayout(new GridLayout(2,1));
		panEchiquier = afficherEchiquier(p.getEchiquier());
		monPanel.add(panEchiquier);
		monPanel.add(pan2);

		fenEchiquier.getContentPane().add(monPanel);
		confirmExit(fenEchiquier);
		fenEchiquier.setSize(400,400);
		fenEchiquier.pack();
		fenEchiquier.setVisible(true);
	}

	public static void confirmExit (final JFrame fen){
		fen.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int reponse = JOptionPane.showConfirmDialog(fen,
						"Voulez-allez quitter l'application, Voulez-vous enregistrer",
						"Confirmation",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (reponse==JOptionPane.YES_OPTION){
					Dialogue.serialiserPartie(p, "Partie.txt"); 
					fen.dispose();
					fen.setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
				if (reponse==JOptionPane.NO_OPTION){
					fen.setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
			}
		});	
	}


	public static class EcouteurMenu implements ActionListener{

		public void actionPerformed(ActionEvent e){ 
			if (e.getSource() == creer){
				fenMenu.dispose();
				menuJoueurs();
			}
			if (e.getSource() == revoir){
				Dialogue.deserialiserPartie("Partie.txt");
				revoirPartie();
			}
			if (e.getSource() == exit1){
				Dialogue.serialiserPartie(p, "Partie.txt");
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
				setCommencerBool(true);
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



			for(int i=0; i<8; i++){
				for(int j=0; j<8 ; j++){
					if (e.getSource() == tabBoutton[i][j]){
						if (isCommencerBool()){
							p.setCaseCliquee(new Position(i,j));
							System.out.println(p.getCaseCliquee().getI()+ " "+p.getCaseCliquee().getJ());
							tabBoutton[i][j].setBackground(Color.green);
							panEchiquier=afficherEchiquier(p.getEchiquier());
							monPanel.updateUI();
						}
						else{
							p.setCaseCliquee(new Position(i,j));
							System.out.println(p.getCaseCliquee().getI()+ " "+p.getCaseCliquee().getJ());
							p.personnaliserPartie();
							panEchiquier=afficherEchiquier(p.getEchiquier());
							monPanel.updateUI();
							p.setNomPiece(null);
							p.setCouleurPiece(null);
						}
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

	public static class EcouteurSuivant implements ActionListener{
		public void actionPerformed(ActionEvent e){ 
			if (e.getSource() == suivant){
				p.setCoupSuivant(p.getCoupSuivant()+1);
				System.out.println(p.getCoupSuivant());
				revoirPartie();
			}

		}
	}


	public static class EcouteurDebutFin implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == commencer){
				setCommencerBool(true);
				fenEchiquier.dispose();
				monPanel.removeAll();
				afficherPartieStandard();	
			}
			if (e.getSource() == terminer){
				fenEchiquier.dispose();
				Partie.setFinDePartie(true);
				menuExit();

			}



		}

	}

}





