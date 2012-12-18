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



public class Affichage {
	//Interface Affichage
	private static JButton tab[][] = new JButton[8][8];
	private static JFrame fen = new JFrame("Jeu D'échec");
	
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
		if (e.getSource() == tab[1][1]) 
		System.out.println("jaune"); 
		}
	}
	
	public static void main(String[] args) {		
		//menuPrincipal();
		//choixDeLaPartie();
		//optionChoixJoueur();
		Affichage a = new Affichage();
		a.afficherEchiquier();
	}

}
