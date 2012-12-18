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
		boolean isOk = false;
		String couleur = "noir";
		
		// Premiere ligne des pieces noires - Premiere ligne echiquier
		this.tableau[0][0] = new Tour(new Position(0,0), couleur); 
		this.tableau[0][1] = new Cavalier(new Position(0,1), couleur);
		this.tableau[0][2] = new Fou(new Position(0,2), couleur);
		this.tableau[0][3] = new Dame(new Position(0,3), couleur);
		this.tableau[0][4] = new Roi(new Position(0,4),couleur);
		this.tableau[0][5] = new Fou(new Position(0,5), couleur);
		this.tableau[0][6] = new Cavalier(new Position(0,6), couleur);
		this.tableau[0][7] = new Tour(new Position(0,7), couleur);
		
		// Deuxieme ligne des pieces noires - Deuxieme ligne echiquier
		this.tableau[1][0] = new Pion(new Position(1, 0), couleur);
		this.tableau[1][1] = new Pion(new Position(1, 1), couleur);
		this.tableau[1][2] = new Pion(new Position(1, 2), couleur);
		this.tableau[1][3] = new Pion(new Position(1, 3), couleur);
		this.tableau[1][4] = new Pion(new Position(1, 4), couleur);
		this.tableau[1][5] = new Pion(new Position(1, 5), couleur);
		this.tableau[1][6] = new Pion(new Position(1, 6), couleur);
		this.tableau[1][7] = new Pion(new Position(1, 7), couleur);
		
		couleur = "blanc";
		
		// Premiere ligne des pieces blanches - Huitieme ligne echiquier
		this.tableau[7][0] = new Tour(new Position(7, 0), couleur);
		this.tableau[7][1] = new Cavalier(new Position(7, 1), couleur);
		this.tableau[7][2] = new Fou(new Position(7, 2), couleur);
		this.tableau[7][3] = new Dame(new Position(7, 3), couleur);
		this.tableau[7][4] = new Roi(new Position(7, 4), couleur);
		this.tableau[7][5] = new Fou(new Position(7, 5), couleur);
		this.tableau[7][6] = new Cavalier(new Position(7, 6), couleur);
		this.tableau[7][7] = new Tour(new Position(7, 7), couleur);
		
		// Deuxieme ligne des pieces blanches - Septieme ligne echiquier
		/*this.tableau[6][0] = new Pion(new Position(6, 0), couleur);
		this.tableau[6][1] = new Pion(new Position(6, 1), couleur);
		this.tableau[6][2] = new Pion(new Position(6, 2), couleur);
		this.tableau[6][3] = new Pion(new Position(6, 3), couleur);
		this.tableau[6][4] = new Pion(new Position(6, 4), couleur);
		this.tableau[6][5] = new Pion(new Position(6, 5), couleur);
		this.tableau[6][6] = new Pion(new Position(6, 6), couleur);
		this.tableau[6][7] = new Pion(new Position(6, 7), couleur);*/
		
		return true;		
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
	
	/*public boolean ajouterPiece(String nom, Position p, String couleur)
	{
		boolean isOk = false;
		
		this.tableau[p.getI()][p.getJ()] = Class.forName(nom).getConstructor(p, couleur).newInstance();
		
		if(this.tableau[p.getI()][p.getJ()].getClass().getName() == nom)
			isOk = true;
		
		return isOk;
	}*/
	
	public void ajouterPiece(Piece piece)
	{
		this.tableau[piece.getPosition().getI()][piece.getPosition().getJ()] = piece;
	}
	
	public boolean supprimerPiece(Position p)
	{
		boolean isOk = false;
		tableau[p.getI()][p.getJ()] = null;
		if(tableau[p.getI()][p.getJ()] == null)
		{
			isOk = true;
		}
		
		return isOk;
	}
	
	public String toString()
	{
		StringBuffer res = new StringBuffer("");
		String piece = "";
		String couleur = "";
	
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{	
				if(this.tableau[i][j] == null)
				{
					piece = "Case vide";
					couleur = "";
				}
				else
				{
					piece = this.tableau[i][j].getClass().getName();
					couleur = this.tableau[i][j].getCouleur();
					
				}			
				
				res.append(" [ ");
				res.append(piece);
				res.append(" ");
				res.append(couleur);
				res.append(" ] ");
			}
			res.append("\n");
		}
		return res.toString();
	}	
	
	
	public Vector<Position> destinationPossible(Piece piece)
	{
		Vector<Position> dest = new Vector<Position>();
		
		
		
		return dest;
	}
	
	
	public boolean estBloquee(Piece p)
	{
		Piece sauv = p;
		boolean isOk = false;
		
		supprimerPiece(p.getPosition());
		if (estPrenable(new Piece(new Position(5, 5), p.getCouleur())))	/*roi de la meme couleur*/
		{
			isOk = true;
		}
			
		ajouterPiece(sauv); 
		return isOk;
	}

	public boolean estPrenable(Piece r)
	{
		boolean bool = false;
		Vector<Position> destinationPossibleAdverse;
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (this.tableau[i][j].getCouleur() != r.getCouleur())
				{
					destinationPossibleAdverse = destinationPossible(tableau[i][j]);
					for (Position pos : destinationPossibleAdverse)
					{
						if (pos == r.getPosition())
						{
							r.setPositionDuMechant(pos);
							bool = true;
						}
					}
				}
			}
		}
		return bool;
	}
}