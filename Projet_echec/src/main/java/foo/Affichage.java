package foo;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	
	public void optionCreerPartie(){
		
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
		 
		 JPanel pan =new JPanel();
		 pan.setSize(400, 100);
		 pan.setLayout(new GridLayout(8,8));
		 
		for(int i=0; i<8; i++){
			for(int j=0; j<8 ; j++){
				tab[i][j] = new JButton();
				pan.add(tab[i][j]);
			}
		}
			
		
		fen.getContentPane().add(pan);
		fen.pack();
		fen.setVisible(true); 
			
			
		}
	
	public void afficherPosition(){
		
	}
	
	public static void affichageTotal(){
		
	}
	
	public static void main(String[] args) {
		
		//menuPrincipal();
		//choixDeLaPartie();
		afficherEchiquier();
	}
}
