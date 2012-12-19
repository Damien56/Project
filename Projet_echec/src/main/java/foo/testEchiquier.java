package foo;



public class testEchiquier {

	public static void main(String args[])
	{
		//tests de Quentin
		Joueur j1 = new Joueur("Georges","blanc");
		Joueur j2 = new Joueur("Gaspard","noir");
		Echiquier ech = new Echiquier();
		ech.echiquierStandard();
		Affichage aff = new Affichage();
		Partie ptest = new Partie(j1, j2, ech, true);

		ptest.jouerPartie();
		
		/*System.out.println(ech.toString());
		ech.ajouterPiece(new Pion(new Position(4,4),"blanc"));
		System.out.println(ech.toString());
		aff.afficherEchiquier(ech);*/
		
		//**************************************************************
		//tests de Damien
		/*Echiquier e = new Echiquier();
		e.echiquierStandard();
		//Affichage aff =new Affichage();
		Affichage.afficherEchiquier(e);
		*/
	}
	
}
