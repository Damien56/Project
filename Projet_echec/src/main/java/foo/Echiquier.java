package foo;
import pieces.*;

import java.util.Vector;

/* Cyril Mazouyer */
/* 17 Decembre 2012 */
/* Classe Echiquier */

public class Echiquier
{
	/* Declaration des attributs de la classe */
	private Piece tableau[][];
	private boolean aide;
	
	/* Declaration du constructeur de la classe */
	
	public Echiquier()
	{
		tableau = new Piece[8][8];
	}
	
	/* Declaration des methodes de la classe */
	
	public boolean echiquierStandard()
	{
		Piece tabStd[][] = new Piece[8][8];
		
		String couleur = "noir";
		
		// Premiere ligne des pieces noires - Premiere ligne echiquier
		tabStd[0][0] = new Tour(new Position(0,0), couleur); 
		tabStd[0][1] = new Cavalier(new Position(0,1), couleur);
		tabStd[0][2] = new Fou(new Position(0,2), couleur);
		tabStd[0][3] = new Dame(new Position(0,3), couleur);
		tabStd[0][4] = new Roi(new Position(0,4),couleur);
		tabStd[0][5] = new Fou(new Position(0,5), couleur);
		tabStd[0][6] = new Cavalier(new Position(0,6), couleur);
		tabStd[0][7] = new Tour(new Position(0,7), couleur);
		
		// Deuxieme ligne des pieces noires - Deuxieme ligne echiquier
		tabStd[1][0] = new Pion(new Position(1, 0), couleur);
		tabStd[1][1] = new Pion(new Position(1, 1), couleur);
		tabStd[1][2] = new Pion(new Position(1, 2), couleur);
		tabStd[1][3] = new Pion(new Position(1, 3), couleur);
		tabStd[1][4] = new Pion(new Position(1, 4), couleur);
		tabStd[1][5] = new Pion(new Position(1, 5), couleur);
		tabStd[1][6] = new Pion(new Position(1, 6), couleur);
		tabStd[1][7] = new Pion(new Position(1, 7), couleur);
		
		couleur = "blanc";
		
		// Premiere ligne des pieces blanches - Huitieme ligne echiquier
		tabStd[7][0] = new Tour(new Position(7, 0), couleur);
		tabStd[7][1] = new Cavalier(new Position(7, 1), couleur);
		tabStd[7][2] = new Fou(new Position(7, 2), couleur);
		tabStd[7][3] = new Dame(new Position(7, 3), couleur);
		tabStd[7][4] = new Roi(new Position(7, 4), couleur);
		tabStd[7][5] = new Fou(new Position(7, 5), couleur);
		tabStd[7][6] = new Cavalier(new Position(7, 6), couleur);
		tabStd[7][7] = new Tour(new Position(7, 7), couleur);
		
		// Deuxieme ligne des pieces blanches - Septieme ligne echiquier
		tabStd[6][0] = new Pion(new Position(6, 0), couleur);
		tabStd[6][1] = new Pion(new Position(6, 1), couleur);
		tabStd[6][2] = new Pion(new Position(6, 2), couleur);
		tabStd[6][3] = new Pion(new Position(6, 3), couleur);
		tabStd[6][4] = new Pion(new Position(6, 4), couleur);
		tabStd[6][5] = new Pion(new Position(6, 5), couleur);
		tabStd[6][6] = new Pion(new Position(6, 6), couleur);
		tabStd[6][7] = new Pion(new Position(6, 7), couleur);
		
		return this.setTableau(tabStd);		
	}
	
	public Piece[][] getTableau()
	{
		return this.tableau;
	}
	
	public boolean setTableau(Piece tab[][])
	{
		boolean isOk = true;
		
		while(isOk == true)
		{
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					this.tableau[i][j] = tab[i][j];
					
					if(this.tableau[i][j] != tab[i][j])
					{
						isOk = false;
					}
				}
			}
		}
		
		return isOk;
	}
	
	public boolean deplacerPiece(Piece piece, Position destination)
	{
		boolean isOk = false;
		
		piece.setPosition(destination);
		
		if(piece.getPosition() == destination)
		{
			isOk = true;
		}
		
		return isOk;
		
	}
	
	
	
	public boolean ajouterPiece(String nom, Position p, String couleur)
	{
		boolean isOk = false;
		
		this.tableau[p.getI()][p.getJ()] = Class.forName(nom).getConstructor(p, couleur).newInstance();
		
		if(this.tableau[p.getI()][p.getJ()].getClass().getName() == nom)
			isOk = true;
		
		return isOk;
	}
	
	public boolean supprimerPiece(int i, int j)
	{
		boolean isOk = false;
		
		tableau[i][j] = null;
		
		if(tableau[i][j] == null)
		{
			isOk = true;
		}
		
		return isOk;
	}
	
	public Vector<Position> destinationPossible(Piece piece)
	{
		Vector<Position> dest = new Vector<Position>();
		return dest;
	}
	
	public String toString()
	{
		StringBuffer res = "";
		
		for(int j = 0; j < 8; j++)
		{
			for(int i = 0; i < 8; i++)
			{
				
			}
			res+= "\n";
		}
		
		return res;		
	}

	
	
	
	
	
	
	
	
	
	
	
	

}