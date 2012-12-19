package foo;

import pieces.Position;

public class testEchiquier {

	public static void main(String args[])
	{
		Echiquier e = new Echiquier();
		e.echiquierStandard();
<<<<<<< HEAD
		Affichage aff = new Affichage();
		
		aff.afficherEchiquier(e);
		
=======
		System.out.println("1");
		System.out.println(e.toString());
		System.out.println("2");
		e.destinationPossible(e.getTableau()[1][1]);
		System.out.println("3");
		//e.deplacerPiece(e.getTableau()[1][1], new Position(2,1));
		//System.out.println(e.toString());
>>>>>>> bbf361fa00f8d344db3c61779b9035707b06cb7f
	}
	
}
