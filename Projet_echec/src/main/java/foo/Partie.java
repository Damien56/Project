package foo;

import java.util.Vector;

import pieces.*;

public class Partie implements java.io.Serializable
{
	public Joueur J1;
	public Joueur J2 ;
	public Echiquier E;
	public Affichage A;
	public Vector<Position> mesPositions, mesDestinations;
	
	// Le constructeur
	public Partie(Joueur j1, Joueur j2, Echiquier e, Affichage a)
	{
		this.J1 = j1;
		this.J2 = j2;
		this.E = e;
		this.A = a;
		this.mesPositions = new Vector<Position>();
		this.mesDestinations = new Vector<Position>();
	}
	
	// Gestion du deplacement des pieces jusqu'à la fin de la partie.
	public void jouerPartie()
	{
		boolean fini = false, estMat = false;
		int tour = 1;
		Piece pieceSelected = null;
		Piece monRoi;
		Position pos = null;
		
		while(!fini && !estMat)
		{			
			monRoi = selectMonRoi(tour);
					
			// Test si le roi de ma couleur est mat
			if(this.E.estMat((Roi)monRoi))
				estMat = true;
			
			else
				// Selectionne la piece cliquee et
				// verifie si elle a la couleur attendue en fonction du tour
				pieceSelected = selectPieceJouable(tour);
				
				// Demande une position de destination tant qu'elle n'est
				// pas conforme aux destinations possibles pour cette pièce.
				do
				{
					pos = this.A.getCaseCliquee();	
					this.E.deplacerPiece(pieceSelected, pos);
				}
				while(!this.E.deplacerPiece(pieceSelected, pos));		
			
			tour++;
		}		
	}
	
	// Selectionne sur l'echiquier la piece cliquee,
	// et verifie si elle a la couleur attendue en fonction du tour
	// (INIT : les blancs commencent, tour = 1)
	public Piece selectPieceJouable(int tour)
	{
		Position pos;
		Piece pieceSelected;
		
		do
		{
			pos = this.A.getCaseCliquee();
			pieceSelected = this.E.getTableau()[pos.getI()][pos.getJ()];
		}
		
		while(((tour%2 != 0) && (pieceSelected.getCouleur() == "blanc")) ||
				((tour%2 == 0) && (pieceSelected.getCouleur() == "noir")));
		
		return pieceSelected;
	}

	
	// Recherche le roi de ma couleur en fonction du tour
	// (INIT : les blancs commencent, tour = 1)
	public Piece selectMonRoi(int tour)
	{
		Piece monRoi = null;
		
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(this.E.getTableau()[i][j].getClass().getName() == "Roi")
					if((this.E.getTableau()[i][j].getCouleur() == "blanc") && ((tour%2 != 0)) ||
							(this.E.getTableau()[i][j].getCouleur() == "noir") && ((tour%2 == 0)))
						monRoi = this.E.getTableau()[i][j];	
		
		return monRoi;
	}
	
	public void rejeuPartie()
	{
		
	}
	
	public void reglerTimer()
	{
		
	}
	
	public String toString()
	{
		StringBuffer res = new StringBuffer("");
		
		return res.toString();
	}
}
