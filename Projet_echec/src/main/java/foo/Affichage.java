package foo;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Affichage {
	//Interface Affichage
	
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
		
	}
	
	
	
	public void confirmExit(){
		
	}
	
	public static void afficherEchiquier()
	{
		 
		 JButton tab[][] = new JButton[8][8];
		 JFrame fen = new JFrame("Jeu D'échec");
		 fen.setLocationRelativeTo(null);
		 Container cont = fen.getContentPane();
		 
		 JPanel pan =new JPanel();
		 pan.setSize(400, 100);
		 pan.setLayout(new GridLayout(8,8));
		 
		for(int i=0; i<8; i++){
			for(int j=0; j<8 ; j++){
				tab[i][j] = new JButton();
				pan.add(tab[i][j]);
			}
		}
		
		cont.add(pan);
		fen.setSize(400,400);
		fen.getContentPane().add(pan);
		//fen.pack();
		fen.setVisible(true); 
			
			
		}
	
	public void afficherPosition(){
		
	}
	
	public static void affichageTotal(){
		
	}
	
	public static void main(String[] args) {
		
		//menuPrincipal();
		//choixDeLaPartie();
		//optionChoixJoueur();
		afficherEchiquier();
	}
}
