package foo;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;



public class Affichage {
	//Interface Affichage
	private static JButton tab[][] = new JButton[8][8];
	private static JFrame fen = new JFrame("Jeu D'échec");
	private static JPanel pan = new JPanel();
	private static JButton cavaliern = new JButton("Cavalier Noir");
	
	public Affichage(){
	}
	
	public static void menuPrincipal(){
	 JFrame fen = new JFrame("Jeu D'échec");
	 fen.setLocationRelativeTo(null);
	 
	 
	 JPanel pan =new JPanel();
	 pan.setSize(400, 100);
	 pan.setLayout( new BoxLayout(pan,3));
	 
	 JButton creer =new JButton("Créer Partie");
	 creer.setSize(400, 50);
	 JButton revoir =new JButton("Revoir la Partie");
	 revoir.setSize(400, 50);
	 JButton exit =new JButton("Quitter la partie");
	 exit.setSize(400, 50);
	 
	 pan.add(creer);
	 pan.add(revoir);
	 pan.add(exit);
	 
	 fen.getContentPane().add(pan);
	 fen.pack();
	 fen.setVisible(true);
	
	}
		
	
	
	public static void choixDeLaPartie(){
		
		JFrame fen = new JFrame("Jeu D'échec");
		 fen.setLocationRelativeTo(null);
		 
		 JPanel pan =new JPanel();
		 pan.setSize(400, 100);
		 pan.setLayout( new BoxLayout(pan,3));
		 
		 JButton standard =new JButton("Partie Standard");
		 standard.setSize(400, 50);
		 JButton perso =new JButton("Partie Personnalisée");
		 perso.setSize(400, 50);
		 JButton retour =new JButton("Revenir au menu principal");
		 retour.setSize(400, 50);
		 
		 pan.add(standard);
		 pan.add(perso);
		 pan.add(retour);
		 
		 fen.getContentPane().add(pan);
		 fen.pack();
		 fen.setVisible(true);
		
	}
	
	public static void optionChoixJoueur(){
		
		JFrame fen = new JFrame("Jeu d'échec - Créer Partie");
		Container cont = fen.getContentPane();
		JTextField j1 = new JTextField("Joueur 1");
		JTextField j2 = new JTextField("Joueur 2");
		
		j1.setColumns(10);
		j2.setColumns(10);
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2,1));
		pan1.add(new JButton("Blanc"));
		pan1.add(j1);
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(2,1));
		pan2.add(new JButton("Noir"));
		pan2.add(j2);
	    JPanel pan3 = new JPanel();
	    pan3.add(pan1);
		pan3.add(pan2);
		cont.add(pan3);
		
		fen.setSize(400,400);
		fen.setVisible(true);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	public void optionFinDePartie(){
		
		
		 JFrame fenetre = new JFrame("Fin de partie");
		 fenetre.setLocationRelativeTo(null);
		 
		 JPanel panel = new JPanel();
		 panel.setSize(400, 100);
		 panel.setLayout( new BoxLayout(panel,3));
		 
		 JButton revoir = new JButton("Revoir une partie");
		 revoir.setSize(400, 50);
		 JButton rejouer = new JButton("Rejouer une partie ");
		 rejouer.setSize(400, 50);
		 JButton quitter = new JButton("Quitter");
		 quitter.setSize(400, 50);
		 
		 panel.add(revoir);
		 panel.add(rejouer);
		 panel.add(quitter);
		 
		 fenetre.getContentPane().add(panel);
		 fenetre.pack();
		 fenetre.setVisible(true);
			
		
	}
	
	public void ListePieces(){
		
		//JFrame fen = new JFrame("Pieces disponibles");
		//JPanel pan = new JPanel();
		pan.setSize(400, 100);
	
		pan.setLayout(new GridLayout(6,2));
		
		//JButton cavaliern = new JButton("Cavalier Noir");
		cavaliern.setSize(200, 16);
		cavaliern.addActionListener(new Ecouteur2());
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
	
	public  static class Ecouteur2 implements ActionListener{
		public void actionPerformed(ActionEvent e){ 
				if (e.getSource() == cavaliern){
						System.out.println("proute"); 
					}
				}
	}
			
		
	
	
	/* A modifier */
	
	
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
		 fen.setLocationRelativeTo(null);
		 Container cont = fen.getContentPane();
		 
		 JPanel pan =new JPanel();
		 pan.setSize(400, 100);
		 pan.setLayout(new GridLayout(8,8));
		 
		 
		for(int i=0; i<8; i++){
			for(int j=0; j<8 ; j++){
				tab[i][j] = new JButton();
				if((i%2==0 && j%2 == 0) || (i%2==1 && j%2 == 1))
					tab[i][j].setBackground(Color.gray);
				else
					tab[i][j].setBackground(Color.white);
				tab[i][j].addActionListener(new Ecouteur());
				pan.add(tab[i][j]);
			}
		}
		cont.add(pan);
		fen.setSize(400,400);
		fen.getContentPane().add(pan);
		//fen.pack();
		fen.setVisible(true); 	
			
	}
		

	public  static class Ecouteur implements ActionListener{
		public void actionPerformed(ActionEvent e){ 
			for(int i=0; i<8; i++){
				for(int j=0; j<8 ; j++){
					if (e.getSource() == tab[i][j]){
						System.out.println("proute"); 
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {		
		//menuPrincipal();
		//choixDeLaPartie();
		//optionChoixJoueur();
		Affichage a = new Affichage();
		
		a.ListePieces();
	}

}
