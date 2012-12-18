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
	
	public Echiquier echiquierStandard()
	{
		String couleur = "noir";
		

		// Premiere ligne des pieces noires - Premiere ligne echiquier
		tableau[0][0] = new Tour(new Position(0,0), couleur); 
		tableau[0][1] = new Cavalier(new Position(0,1), couleur);
		tableau[0][2] = new Fou(new Position(0,2), couleur);
		tableau[0][3] = new Dame(new Position(0,3), couleur);
		tableau[0][4] = new Roi(new Position(0,4),couleur);
		tableau[0][5] = new Fou(new Position(0,5), couleur);
		tableau[0][6] = new Cavalier(new Position(0,6), couleur);
		tableau[0][7] = new Tour(new Position(0,7), couleur);
		
		// Deuxieme ligne des pieces noires - Deuxieme ligne echiquier
		tableau[1][0] = new Pion(new Position(1, 0), couleur);
		tableau[1][1] = new Pion(new Position(1, 1), couleur);
		tableau[1][2] = new Pion(new Position(1, 2), couleur);
		tableau[1][3] = new Pion(new Position(1, 3), couleur);
		tableau[1][4] = new Pion(new Position(1, 4), couleur);
		tableau[1][5] = new Pion(new Position(1, 5), couleur);
		tableau[1][6] = new Pion(new Position(1, 6), couleur);
		tableau[1][7] = new Pion(new Position(1, 7), couleur);

		
		String couleur1 = "blanc";
		

		// Premiere ligne des pieces blanches - Huitieme ligne echiquier
		tableau[7][0] = new Tour(new Position(7, 0), couleur);
		tableau[7][1] = new Cavalier(new Position(7, 1), couleur);
		tableau[7][2] = new Fou(new Position(7, 2), couleur);
		tableau[7][3] = new Dame(new Position(7, 3), couleur);
		tableau[7][4] = new Roi(new Position(7, 4), couleur);
		tableau[7][5] = new Fou(new Position(7, 5), couleur);
		tableau[7][6] = new Cavalier(new Position(7, 6), couleur);
		tableau[7][7] = new Tour(new Position(7, 7), couleur);
		
		// Deuxieme ligne des pieces blanches - Septieme ligne echiquier
		tableau[6][0] = new Pion(new Position(6, 0), couleur);
		tableau[6][1] = new Pion(new Position(6, 1), couleur);
		tableau[6][2] = new Pion(new Position(6, 2), couleur);
		tableau[6][3] = new Pion(new Position(6, 3), couleur);
		tableau[6][4] = new Pion(new Position(6, 4), couleur);
		tableau[6][5] = new Pion(new Position(6, 5), couleur);
		tableau[6][6] = new Pion(new Position(6, 6), couleur);
		tableau[6][7] = new Pion(new Position(6, 7), couleur);

	}
	
	public boolean deplacerPiece(Piece piece, Position destination)
	{
		
		piece.setPosition(destination);
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
		tableau[i][j] = null;
	}
	
<<<<<<< HEAD
	public Vector<Position> destinationPossible(Piece piece){
		Vector<Position> tab;
		return tab; 
	}
=======
	public Vector<> destinationPossible(Piece piece)
	
	{
	}

	
	
	
	
	
	
	
	
	
	
>>>>>>> 4b092114fc6785cf88f35e6b609af7816e447f7f
	
	public boolean estMat(Roi roi){
		boolean mat = false;
		Position positionTest = roi.getPosition();
		Vector<Position> destination = destinationPossible(roi);
		
		for(int i=0; i<destination.size();i++){
			roi.setPosition(destination.elementAt(i));					
			if(estEchec(roi)==false){
				roi.setPosition(positionTest);
				mat = false;
			}
		}
		
		String couleurDuMechant;
		if(roi.getCouleur()=="blanc"){
			couleurDuMechant="noir";
		}
		else if(roi.getCouleur()=="noir"){
			couleurDuMechant="blanc";
		}
		
		Piece mechant = new Piece(roi.getPositionDuMechant(), couleurDuMechant)
		
		if(estPrenable(mechant)){
			mat = false;
		}
		
		destination = destinationPossible(mechant);
		for(int i=0; i<destination.size(); i++){
			mechant.setPosition(destination.elementAt(i));
			if(estPrenable(mechant)){
				Position protection = mechant.getPositionDuMechant();
				deplacerPiece(tableau[protection.getI()][protection.getJ()],destination.elementAt(i));
				if(estEchec(roi)){
					mat = true;
				}
			}
		}
		
		return mat;	
	}
	
}