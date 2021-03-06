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


	/* Declaration du constructeur de la classe */

	public Echiquier()
	{
		tableau = new Piece[8][8];
	}

	/* Declaration des methodes de la classe */

	public boolean echiquierStandard()
	{

		String couleur = "noir";

		//Premiere ligne des pieces noires - Premiere ligne echiquier
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
		this.tableau[6][0] = new Pion(new Position(6, 0), couleur);
		this.tableau[6][1] = new Pion(new Position(6, 1), couleur);
		this.tableau[6][2] = new Pion(new Position(6, 2), couleur);
		this.tableau[6][3] = new Pion(new Position(6, 3), couleur);
		this.tableau[6][4] = new Pion(new Position(6, 4), couleur);
		this.tableau[6][5] = new Pion(new Position(6, 5), couleur);
		this.tableau[6][6] = new Pion(new Position(6, 6), couleur);
		this.tableau[6][7] = new Pion(new Position(6, 7), couleur);

		return true;		
	}

	public Piece[][] getTableau()
	{
		return this.tableau;
	}

	public boolean deplacerPiece(Piece p, Position pos)
	{
		if(p != null){
			if(p.getClass().getName() == "pieces.Roi" && p.getDejaDeplace() == false && this.tableau[pos.getI()][pos.getJ()+1] != null && this.tableau[pos.getI()][pos.getJ()+1].getClass().getName() == "pieces.Tour"){
				//Roc à droite

				this.supprimerPiece(p.getPosition());
				this.supprimerPiece(this.tableau[pos.getI()][pos.getJ()+1].getPosition());

				Roi r = (Roi)p;
				r.setPosition(pos);
				r.setDejaDeplace(true);
				r.setPositionPossible();

				Tour t = new Tour(new Position(p.getPosition().getI(), p.getPosition().getJ()-1), p.getCouleur());
				t.setDejaDeplace(true);
				t.setPositionPossible();

				this.ajouterPiece(r);
				this.ajouterPiece(t);

			}
			else if(p.getClass().getName() == "pieces.Roi" && p.getDejaDeplace() == false && this.tableau[pos.getI()][pos.getJ()-2] != null && this.tableau[pos.getI()][pos.getJ()-2].getClass().getName() == "pieces.Tour"){
				//Roc à gauche

				this.supprimerPiece(p.getPosition());
				this.supprimerPiece(this.tableau[pos.getI()][pos.getJ()-2].getPosition());

				Roi r = (Roi)p;
				r.setPosition(pos);
				r.setDejaDeplace(true);
				r.setPositionPossible();

				Tour t = new Tour(new Position(p.getPosition().getI(), p.getPosition().getJ()+1), p.getCouleur());
				t.setDejaDeplace(true);
				t.setPositionPossible();

				this.ajouterPiece(r);
				this.ajouterPiece(t);

			}
			else if(p.getClass().getName() == "pieces.Roi" && p.getDejaDeplace() == true){
				//Deplacement standard du roi
				this.supprimerPiece(p.getPosition());

				Roi r = (Roi)p;
				r.setPosition(pos);
				r.setDejaDeplace(true);
				r.setPositionPossible();

				this.ajouterPiece(r);
			}
			else if((p.getClass().getName() == "pieces.Pion")){

				if((p.getNombreDeDeplacement() != 1)&&(p.getClass().getName() == "pieces.Pion")){
					p.setNombreDeDeplacement(1);
				}
				else if((Math.abs(p.getPosition().getI() - pos.getI()) == 2) && (p.getNombreDeDeplacement() == 0) && (p.getClass().getName() == "pieces.Pion")){
					p.setNombreDeDeplacement(2);
				}

				this.supprimerPiece(p.getPosition());

				Pion newP = (Pion)p;
				newP.setPosition(pos);
				newP.setNombreDeDeplacement(p.getNombreDeDeplacement());
				newP.setPositionPossible();

				this.ajouterPiece(newP);
			}
			else
			{
				p.setPosition(pos);
				this.ajouterPiece(p);
				this.supprimerPiece(p.getPositionOld());
			}
		}
		
		return true;
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
		int i = 0, j = 0;
		if(piece != null){
			int[][] tabposition = piece.getPositionPossible();

			//deplacements pour le cavalier
			if(piece.getClass().getName() == "pieces.Cavalier")
			{
				for(i = 0; i < 8; i++)
				{//parcourir les lignes
					for(j=0; j<8; j++)
					{//parcourir les colonnes
						if(tabposition[i][j]==1)
						{
							if(this.tableau[i][j]==null)
							{
								dest.add(new Position(i,j));
							}
							else if((this.tableau[i][j]!=null) && (this.tableau[i][j].getCouleur()!=piece.getCouleur()))
							{
								dest.add(new Position(i,j));
							}
						}
					}
				}
			}

			// deplacement pour toutes les pièces sauf le cavalier
			// deplacement vers le bas

			else
			{
				i = piece.getPosition().getI(); //initialisation de la position de recherche
				j = piece.getPosition().getJ();

				do
				{
					//deplacement vers le bas
					if(i < 7)
					{
						i++;
						if(tabposition[i][j] == 1)
						{
							if(this.tableau[i][j] == null)
								dest.add(new Position(i, j));

							else if((this.tableau[i][j].getClass().getName() != "pieces.Pion") && (this.tableau[i][j] != null)){
								dest.add(new Position(i, j));
							}
							else if ((this.tableau[i][j].getClass().getName() != "pieces.Dame") && (this.tableau[i][j] != null) && (this.tableau[i][j].getCouleur() != piece.getCouleur())){
								dest.add(new Position(i,j));
							}
						}
					}	
				}

				while(this.tableau[i][j] == null && i < 7);			




				//deplacement vers le haut

				i = piece.getPosition().getI();//reinitialisation a la position de la piece a verifier

				do
				{
					if(i > 0)
					{
						i--;
						if(tabposition[i][j] == 1)
						{
							if(this.tableau[i][j] == null){
								dest.add(new Position(i,j));
							}
							else if((this.tableau[i][j].getClass().getName() != "pieces.Pion") && (this.tableau[i][j] != null)){
								dest.add(new Position(i, j));
							}
							else if ((this.tableau[i][j].getClass().getName() != "pieces.Dame") && (this.tableau[i][j] != null) && (this.tableau[i][j].getCouleur() != piece.getCouleur())){
								dest.add(new Position(i,j));
							}
						}
					}
				}

				while(this.tableau[i][j] == null && i > 0);


				//deplacement vers la droite
				i = piece.getPosition().getI();//reinit

				do
				{
					if(j < 7)
					{
						j++;
						if(tabposition[i][j] == 1)
						{
							if(this.tableau[i][j] == null){
								dest.add(new Position(i, j));
							}
							else if(this.tableau[i][j] != null){
								if(this.tableau[i][j].getCouleur() != piece.getCouleur()){
									dest.add(new Position(i, j));
								}
								else if((this.tableau[i][j].getClass().getName() == "pieces.Tour") && (!this.tableau[i][j].getDejaDeplace())){
									dest.add(new Position(i, j));
								}
							}
						}
					}
				}
				while(this.tableau[i][j] == null && j < 7);

				//deplacement vers la gauche
				j = piece.getPosition().getJ();//reinit

				do
				{
					if(j > 0)
					{
						j--;
						if(tabposition[i][j] == 1)
						{
							if(this.tableau[i][j] == null){
								dest.add(new Position(i,j));
							}
							else if(this.tableau[i][j] != null){
								if(this.tableau[i][j].getCouleur() != piece.getCouleur()){
									dest.add(new Position(i, j));
								}
								else if((this.tableau[i][j].getClass().getName() == "pieces.Tour") && (!this.tableau[i][j].getDejaDeplace())){
									dest.add(new Position(i, j));
								}
								else{

									int destJ = this.tableau[i][j].getPosition().getJ();

									if(piece.getClass().getName() == "pieces.Roi" && !piece.getDejaDeplace() && this.tableau[i][j].getClass().getName() == "pieces.Tour" && !this.tableau[i][j].getDejaDeplace()){

										for(int jDepart = piece.getPosition().getJ(); jDepart < destJ; jDepart++)
										{
											Roi r = new Roi(new Position(i, jDepart), piece.getCouleur());
											if((this.tableau[i][jDepart] == null) /*&& (!r.isEchec())*/)
											{
												dest.add(new Position(i, j));
											}
										}
									}
								}
							}
						}
					}
				}
				while(this.tableau[i][j] == null && j > 0);

				//deplacement diagonale gauche et haut
				i = piece.getPosition().getI();//reinit ligne
				j = piece.getPosition().getJ();//reinit colonne

				do
				{
					if(j > 0 && i > 0)
					{
						i--;//deplace ligne vers le haut
						j--;//deplace colonne vers la gauche
						if(tabposition[i][j] == 1)
						{

							if((this.tableau[i][j] == null) && (piece.getClass().getName() != "pieces.Pion")){
								dest.add(new Position(i, j));
							}
							else if((this.tableau[i][j] != null) && (this.tableau[i][j].getCouleur() != piece.getCouleur())){
								dest.add(new Position(i,j));		
							}
						}
					}
				}
				while(this.tableau[i][j] == null && j > 0 && i > 0);

				//deplacement diagonale gauche basse
				i = piece.getPosition().getI();//reinit ligne
				j = piece.getPosition().getJ();//reinit colonne

				do
				{
					if(j > 0 && i < 7)
					{
						i++;//deplace ligne vers le bas
						j--;//deplace colonne vers la gauche
						if(tabposition[i][j] == 1)
						{
							if((this.tableau[i][j] == null) && (piece.getClass().getName() != "pieces.Pion")){
								dest.add(new Position(i, j));
							}
							else if((this.tableau[i][j] != null) && (this.tableau[i][j].getCouleur() != piece.getCouleur())){
								dest.add(new Position(i, j));
							}
						}
					}
				}
				while(this.tableau[i][j] == null && j > 0 && i < 7);

				//deplacement diagonale droite basse
				i = piece.getPosition().getI();//reinit ligne
				j = piece.getPosition().getJ();//reinit colonne
				do
				{
					if(j < 7 && i < 7)
					{
						i++;//deplace ligne vers le bas
						j++;//deplace colonne vers la droite
						if(tabposition[i][j] == 1)
						{
							if((this.tableau[i][j] == null)&& (piece.getClass().getName() != "pieces.Pion")){
								dest.add(new Position(i, j));
							}
							else if((this.tableau[i][j] != null) && (this.tableau[i][j].getCouleur() != piece.getCouleur())){
								dest.add(new Position(i, j));
							}
						}
					}
				}
				while(this.tableau[i][j] == null && j < 7 && i < 7);
				//deplacement diagonale droite haute
				i = piece.getPosition().getI();//reinit ligne
				j = piece.getPosition().getJ();//reinit colonne
				do
				{
					if(j < 7 && i > 0)
					{
						i--;//deplace ligne vers le haut
						j++;//deplace colonne vers la droite
						if(tabposition[i][j] == 1)
						{
							if((this.tableau[i][j] == null)  && (piece.getClass().getName() != "pieces.Pion")){
								dest.add(new Position(i, j));
							}
							else if((this.tableau[i][j] != null) && (this.tableau[i][j].getCouleur() != piece.getCouleur())){
								dest.add(new Position(i, j));
							}
						}
					}
				}
				while(this.tableau[i][j] == null && j < 7 && i > 0);
			}
		}
		return dest;
	}

	public boolean estBloquee(Piece p)
	{
		Piece sauv = p;
		Piece monRoi = null;
		boolean isBloquee = false;

		// Recherche de mon roi dans l'echiquier
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (this.tableau[i][j].getCouleur() == p.getCouleur() &&
						this.tableau[i][j].getClass().getName() == "pieces.Roi")
				{
					monRoi = this.tableau[i][j];
				}
			}
		}

		// On supprime ma piece pour tester
		supprimerPiece(p.getPosition());	

		if (estEchec(monRoi))	/* Roi de la meme couleur que la piece */
		{
			isBloquee = true;
		}

		ajouterPiece(sauv); 
		return isBloquee;
	}

	public boolean estPrenable(Piece p)
	{
		boolean prenable = false;
		Vector<Position> destinationPossibleAdverse;

		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if(this.tableau[i][j] != null && this.tableau[i][j].getCouleur() != p.getCouleur())
				{
					destinationPossibleAdverse = destinationPossible(tableau[i][j]);
					for (Position pos : destinationPossibleAdverse)
					{
						if (pos == p.getPosition())
						{
							p.setPositionDuMechant(pos);
							prenable = true;
							System.out.println("estprenable : " + prenable);
						}
					}
				}
			}	
		}
		return prenable;			
	}


	public boolean estEchec(Piece roi)
	{
		return estPrenable(roi);
	}

	public boolean estMat(Piece roi)
	{

		boolean mat = false, estProtegeable = false;
		if(roi!=null){
			Position positionTest = roi.getPosition();
			Vector<Position> destination = destinationPossible(roi);
			String couleurDuMechant = "";
			Piece mechant;

			if(roi.getCouleur() == "blanc")
			{
				couleurDuMechant = "noir";
			}

			else
			{
				if(roi.getCouleur() == "noir")
				{
					couleurDuMechant = "blanc";
				}
			}

			mechant = new Piece(roi.getPositionDuMechant(), couleurDuMechant);

			// Si le roi peut toujours se déplacer :
			for(int i = 0; i < destination.size(); i++)
			{
				roi.setPosition(destination.elementAt(i));					
				if(estEchec(roi) == false)
				{
					roi.setPosition(destination.elementAt(i));					
					if(estEchec(roi) == false)
					{
						roi.setPosition(positionTest);
						mat = false;
					}
				}
			} // adapter destinations si estEchec


			if(mechant!=null){
				// si le roi peut etre protégé :
				destination = destinationPossible(mechant);
				if(destination != null){
				for(int i = 0; i < destination.size(); i++)
				{
					mechant.setPosition(destination.elementAt(i));
					if(estPrenable(mechant))
					{
						estProtegeable = true;
						//Position protection = mechant.getPositionDuMechant();
						//deplacerPiece(tableau[protection.getI()][protection.getJ()], destination.elementAt(i));
					}
				}
				}
				//si un mechant existe faire et n'est pas prenable, c'est perdu !
				if(estEchec(roi) && mechant != null && !estPrenable(mechant) && !estProtegeable)
				{
					mat = true;
				}
			}	
		}
		return mat;	
	}
}
