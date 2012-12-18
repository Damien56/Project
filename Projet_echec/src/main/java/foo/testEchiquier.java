package foo;

import pieces.Position;

public class testEchiquier {

	public static void main(String args[])
	{
		Echiquier e = new Echiquier();
		e.echiquierStandard();
		System.out.println(e.toString());
		e.deplacerPiece(e.getTableau()[1][1], new Position(2,1));
		System.out.println(e.toString());
	}
	
}
