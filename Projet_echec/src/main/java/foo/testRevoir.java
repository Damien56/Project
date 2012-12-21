package foo;

import pieces.Position;

public class testRevoir {
	//fonction pour tester notre fonction revoir la parte
	public static void main(String[] args) {
		
		Joueur j1 = new Joueur("Boule","blanc");
		Joueur j2 = new Joueur("Bil","noir");
		Echiquier e = new Echiquier();
		e.echiquierStandard();
		
		Partie p =new Partie (j1,j2,e);
		Affichage.afficherPartieStandard();
		Affichage.setP(p);
		System.out.println("A");
		p.jouerPartie();
		
		Affichage.getPartie().rejeuPartie();
		Affichage.revoirPartie();
		
		
		
	}

}
