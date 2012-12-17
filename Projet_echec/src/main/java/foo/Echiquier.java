package foo;
import pieces.Piece;

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
		
	}
	
	/* Declaration des methodes de la classe */
	public Echiquier echiquierStandard()
	{
		String couleur = "noir";
		
		// Première ligne des pièces noires - Première ligne echiquier
		tableau[0][0] = new Tour(Position(0,0), couleur, DejaDeplace = false); 
		tableau[0][1] = new Cavalier(Position(0,1), couleur);
		tableau[0][2] = new Fou(Position(0,2), couleur);
		tableau[0][3] = new Dame(Position(0,3), couleur);
		tableau[0][4] = new Roi(Position(0,4),couleur, DejaDeplace = false, chec = false, Positiondumechant = null);
		tableau[0][5] = new Fou(Position(0,5), couleur);
		tableau[0][6] = new Cavalier(Position(0,6), couleur);
		tableau[0][7] = new Tour(Position(0,7), couleur, DejaDepace = false);
		
		// Deuxième ligne des pièces noires - Deuxième ligne echiquier
		tableau[1][0] = new Pion (Position(1,0),couleur, Nombrededeplacement = 0);
		tableau[1][1] = new Pion (Position(1,1),couleur, Nombrededeplacement = 0);
		tableau[1][2] = new Pion (Position(1,2),couleur, Nombrededeplacement = 0);
		tableau[1][3] = new Pion (Position(1,3),couleur, Nombrededeplacement = 0);
		tableau[1][4] = new Pion (Position(1,4),couleur, Nombrededeplacement = 0);
		tableau[1][5] = new Pion (Position(1,5),couleur, Nombrededeplacement = 0);
		tableau[1][6] = new Pion (Position(1,6),couleur, Nombrededeplacement = 0);
		tableau[1][7] = new Pion (Position(1,7),couleur, Nombrededeplacement = 0);
		
		String couleur1 = "blanc";
		
		// Première ligne des pièces blanches - Huitième ligne echiquier
		tableau[7][0] = new Tour(Position(7,0), couleur1, DejaDeplace = false);
		tableau[7][1] = new Cavalier(Position(7,1), couleur1);
		tableau[7][2] = new Fou(Position(7,2), couleur1);
		tableau[7][3] = new Dame(Position(7,3), couleur1);
		tableau[7][4] = new Roi(Position(7,4),couleur1, DejaDeplace = false, Echec = false, Positiondumechant = null);
		tableau[7][5] = new Fou(Position(7,5), couleur1);
		tableau[7][6] = new Cavalier(Position(7,6), couleur1);
		tableau[7][7] = new Tour(Position(7,7), couleur1, DejaDeplace = false);
		
		// Deuxième ligne des pièces blanches - Septième ligne echiquier
		tableau[6][0] = new Pion (Position(6,0),couleur1, Nombrededeplacement = 0);
		tableau[6][1] = new Pion (Position(6,1),couleur1, Nombrededeplacement = 0);
		tableau[6][2] = new Pion (Position(6,2),couleur1, Nombrededeplacement = 0);
		tableau[6][3] = new Pion (Position(6,3),couleur1, Nombrededeplacement = 0);
		tableau[6][4] = new Pion (Position(6,4),couleur1, Nombrededeplacement = 0);
		tableau[6][5] = new Pion (Position(6,5),couleur1, Nombrededeplacement = 0);
		tableau[6][6] = new Pion (Position(6,6),couleur1, Nombrededeplacement = 0);
		tableau[6][7] = new Pion (Position(6,7),couleur1, Nombrededeplacement = 0);
	}
	
	public boolean deplacerPiece(Piece piece, String destination)
	{
	
	}
	
	public boolean ajouterPiece(String nom, Position p, String couleur)
	{
		this.tableau[p.getI()][p.getJ()] = Class.forName(nom).getConstructor(p, couleur).newInstance();
	}
	
	public boolean supprimerPiece(int i, int j)
	{
		tableau[i][j] = null;
	}
	
	public Vector<> destinationPossible
}
