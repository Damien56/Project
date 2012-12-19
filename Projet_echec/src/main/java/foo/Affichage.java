package foo;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pieces.Position;




public class Affichage extends JFrame{
	
	private static JFrame fenMenu = new JFrame("Jeu D'échec - Menu");
	private static JButton creer =new JButton("Créer Partie");
	private static JButton revoir =new JButton("Revoir la Partie");
	private static JButton exit =new JButton("Quitter la partie");
	
	
	
	private static JFrame fenChoixJoueur = new JFrame("Jeu D'échec - Création des joueurs");
	private static JTextField j1 = new JTextField("Joueur 1");
	private static JTextField j2 = new JTextField("Joueur 2");
	private static JButton ok =new JButton("Confirmer");
	
	
	private static JFrame fenChoixPartie = new JFrame("Jeu D'échec - Création de la Partie");
	private static JButton partieS =new JButton("Partie Standard");
	private static JButton partieP =new JButton("Partie Personnalisée");
	private static JButton revenir =new JButton("Revenir au menu principale");
	
	private static JButton tabBoutton[][] = new JButton[8][8];
	private static EcouteurEchiquier tabEcouteur[][] = new EcouteurEchiquier[8][8];
	
	
	
	private static String J1;
	private static String J2;
	private static Position CaseCliquee = new Position();
	private static Position CaseCliqueeMenu = new Position(); 
	
	public Affichage(){
	}
	public static String getJ2() {
		return J2;
	}
	public static void setJ2(String j2) {
		J2 = j2;
	}
	public Position getCaseCliquee() {
		return CaseCliquee;
	}

	public static void setCaseCliquee(Position caseCliquee) {
		CaseCliquee = caseCliquee;
	}
	
	
	
	public static void menuPrincipal(){
		
	 fenMenu.setLocationRelativeTo(null);	
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
		
	public static class EcouteurMenu implements ActionListener{
		
		public void actionPerformed(ActionEvent e){ 
			if (e.getSource() == creer){
				fenMenu.dispose();
				choixDesJoueur();
			}
			if (e.getSource() == revoir){
				System.out.println("revoir"); 
			}
			if (e.getSource() == exit){
				System.exit(0); 
			}
		}
		
	}
	
	
	public static void choixDesJoueur(){
	
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
		
		
		fenChoixJoueur.getContentPane().add(pan);
		fenChoixJoueur.pack();
		fenChoixJoueur.setSize(400,400);
		fenChoixJoueur.setVisible(true);
		
		
	}
	
	
	public  static class EcouteurChoixJoueur implements ActionListener{
		public void actionPerformed(ActionEvent e){ 
			/*if (e.getSource() == j1){
				afficherEchiquier(); 
			}*/
			if (e.getSource() == ok){
				fenChoixJoueur.dispose();
				choixDeLaPartie();  
			}
			if (e.getSource() == revenir){
				fenChoixJoueur.dispose(); 
				menuPrincipal();
			}
		}
	}
	
	
	
	public static void choixDeLaPartie(){
			
		 fenChoixPartie.setTitle("Jeu D'échec-Création de partie");
		 JPanel pan = new JPanel();
		 fenChoixPartie.setLocationRelativeTo(null);
		 
		 
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
		 
		 
		 fenChoixPartie.getContentPane().add(pan);
		 fenChoixPartie.pack();
		 fenChoixPartie.setSize(400,400);
		 fenChoixPartie.setVisible(true);
	}

	public  static class EcouteurChoixPartie implements ActionListener{
		
		public void actionPerformed(ActionEvent e){ 
			if (e.getSource() == partieS ){
				fenChoixPartie.dispose();
				afficherEchiquier(); 
				
			}
			if (e.getSource() == partieP){
				fenChoixPartie.dispose();
				afficherEchiquier();  
			}
			if (e.getSource() == revenir){
				fenChoixPartie.dispose(); 
				menuPrincipal();
			}
		}
		
	}
	

	public static void optionFinDePartie(){
		
		
		JFrame fen = new JFrame("Jeu D'échec-Partie Terminée");
		 JPanel pan = new JPanel();
		 fen.setLocationRelativeTo(null);
		 
		 JButton creer =new JButton("Revoir Partie");
		 creer.setSize(200,60);
		 	 
		 JButton revoir =new JButton("Rejouer une Partie");
		 revoir.setSize(200,60);
		
		 JButton exit =new JButton("Quitter");
		 exit.setSize(200,60);
		 
		 pan.setLayout(new GridLayout(3,1));
		 pan.add(creer);
		 pan.add(revoir);
		 pan.add(exit);
		 
		 
		 fen.getContentPane().add(pan);
		 fen.pack();
		 fen.setSize(400,400);
		 fen.setVisible(true);
		
	}
	
	public static void ListePieces(){
		
		JFrame fen = new JFrame("Pieces disponibles");
		JPanel pan = new JPanel();
		pan.setSize(400, 100);
	
		pan.setLayout(new GridLayout(6,2));
		
		JButton cavaliern = new JButton("Cavalier Noir");
		cavaliern.setSize(200, 16);
		cavaliern.addActionListener(new EcouteurListe());
		JButton cavalierb = new JButton("Cavalier Blanc ");
		cavalierb.setSize(200, 16);
		JButton damen = new JButton("Dame Noire");
		damen.setSize(200, 16);
		JButton dameb = new JButton("Dame Blanche");
		dameb.setSize(200, 16);
		JButton foun = new JButton("Fou Noir");
		foun.setSize(200, 16);
		JButton foub = new JButton("Fou Blanc");
		foub.setSize(200, 16);
		JButton pionn = new JButton("Pion Noir");
		pionn.setSize(200, 16);
		JButton pionb = new JButton("Pion Blanc");
		pionb.setSize(200, 16);
		JButton roin = new JButton("Roi Noir");
		roin.setSize(200, 16);
		JButton roib = new JButton("Roi Blanc");
		roib.setSize(200, 16);
		JButton tourn = new JButton("Tour Noire");
		tourn.setSize(200, 16);
		JButton tourb = new JButton("Tour Blanche");
		tourb.setSize(200, 16);
		
		pan.add(cavaliern);
		pan.add(cavalierb);
		pan.add(tourn);
		pan.add(tourb);
		pan.add(roin);
		pan.add(roib);
		pan.add(damen);
		pan.add(dameb);
		pan.add(foun);
		pan.add(foub);
		pan.add(pionn);
		pan.add(pionb);
		
		
		 fen.getContentPane().add(pan);
		 fen.pack();
		 fen.setVisible(true);
		
			
	}
	
	public  static class EcouteurListe implements ActionListener{
		public void actionPerformed(ActionEvent e){ 
				if (e.getSource() == cavaliern){
						System.out.println("proute"); 
					}
				}
		}

	public void afficherPosition(){
		
	}
	
	public void affichageTotal(){	
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
	
	public static void afficherEchiquier()
	{
		JFrame fen = new JFrame("Jeux d'échec - Partie ");
		 fen.setLocationRelativeTo(null);
		 Container cont = fen.getContentPane();
		 
		 JPanel pan =new JPanel();
		 pan.setSize(400, 100);
		 pan.setLayout(new GridLayout(8,8));
		 
		 
		for(int i=0; i<8; i++){
			for(int j=0; j<8 ; j++){
				tabBoutton[i][j] = new JButton();
				if((i%2==0 && j%2 == 0) || (i%2==1 && j%2 == 1))
					tabBoutton[i][j].setBackground(Color.gray);
				else
					tabBoutton[i][j].setBackground(Color.white);
				
				tabEcouteur[i][j] = new EcouteurEchiquier();
				tabBoutton[i][j].addActionListener(tabEcouteur[i][j]);
				pan.add(tabBoutton[i][j]);
			}
		}
		cont.add(pan);
		fen.setSize(400,400);
		fen.getContentPane().add(pan);
		//fen.pack();
		fen.setVisible(true); 	
			
	}
		

	public  static class EcouteurEchiquier implements ActionListener{
		public void actionPerformed(ActionEvent e){ 
			for(int i=0; i<8; i++){
				for(int j=0; j<8 ; j++){
					if (e.getSource() == tabBoutton[i][j]){
						setCaseCliquee(new Position(i,j));
						System.out.println(CaseCliquee.getI()+ " "+CaseCliquee.getJ());
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) {		
		menuPrincipal();
		//choixDeLaPartie();
		//optionFinDePartie();
		//choixDesJoueur();
		//ListePieces();
		//afficherEchiquier();
	}

}
