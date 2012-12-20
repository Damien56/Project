package foo;

import java.util.Vector;

import pieces.*;

public class Partie implements java.io.Serializable
{
	public Joueur J1, J2 ;
	public Echiquier E;

	public boolean isStd=false;

	public Vector<Position> mesPositions, mesDestinations;
	public Echiquier eDepart;
	public Position caseCliquee, caseCliqueeMenu;
	public String nomPiece, couleurPiece;
	public boolean suivant;
	
	
	// Le constructeur
	public Partie(Joueur j1, Joueur j2, Echiquier e, boolean isStd)
	{
		this.J1 = j1;
		this.J2 = j2;
		this.E = e;
		this.eDepart = e;
		this.isStd = isStd; 
		this.mesPositions = new Vector<Position>();
		this.mesDestinations = new Vector<Position>();
		this.caseCliquee = null;
		this.caseCliqueeMenu = null;
		this.nomPiece = "";
		this.couleurPiece = "";
		this.suivant = false;
		
		if(isStd)
		{
			this.E.echiquierStandard();
			this.eDepart.echiquierStandard();
		}
	}
	
	public Partie()
	{
		this(new Joueur(), new Joueur(), new Echiquier(), true);		
	}	
	
	
	public Echiquier getE() {
		return E;
	}

	public Joueur getJ1() {
		return this.J1;
	}

	public Joueur getJ2() {
		return this.J2;
	}

	public boolean isStd() {
		return this.isStd;
	}

	public Position getCaseCliquee() {
		return this.caseCliquee;
	}

	public Position getCaseCliqueeMenu() {
		return this.caseCliqueeMenu;
	}

	public String getNomPiece() {
		return this.nomPiece;
	}

	public String getCouleurPiece() {
		return this.couleurPiece;
	}

	public boolean isSuivant() {
		return this.suivant;
	}

	public void setJ1(Joueur j1) {
		this.J1 = j1;
	}

	public void setJ2(Joueur j2) {
		this.J2 = j2;
	}

	public void setStd(boolean isStd) {
		this.isStd = isStd;
	}

	public void setCaseCliquee(Position caseCliquee) {
		this.caseCliquee = caseCliquee;
	}

	public void setCaseCliqueeMenu(Position caseCliqueeMenu) {
		this.caseCliqueeMenu = caseCliqueeMenu;
	}

	public void setNomPiece(String nomPiece) {
		this.nomPiece = nomPiece;
	}

	public void setCouleurPiece(String couleurPiece) {
		this.couleurPiece = couleurPiece;
	}

	public void setSuivant(boolean suivant) {
		this.suivant = suivant;
	}

	
	
	// Gestion du deplacement des pieces jusqu'à la fin de la partie.
	public void jouerPartie()
	{
		boolean fini = false, estMat = false, loop=false;
		int tour = 1;
		Piece pieceSelected = null;
		Piece monRoi;
		Position pos = null;
			
		System.out.println(this.E.toString());//Affichage Echiquier de depart
			
		while(!fini && !estMat)
		{			
			monRoi = selectMonRoi(tour);
					
			// Test si le roi de ma couleur est mat
			/*if(monRoi!=null)
				if(this.E.estMat((Roi)monRoi))
					estMat = true;

			else*/
				// Selectionne la piece cliquee et
				// verifie si elle a la couleur attendue en fonction du tour
				pieceSelected = selectPieceJouable(tour);
				
				// Demande une position de destination tant qu'elle n'est
				// pas conforme aux destinations possibles pour cette pièce.
				
			while(loop==false){
				pos=this.getCaseCliquee();
				if(pos!=null)
					if(pieceSelected!=null)
						for(int i=0;i<this.E.destinationPossible(pieceSelected).size();i++){
							if(pos.isEqual(this.E.destinationPossible(pieceSelected).get(i))){
								this.E.deplacerPiece(pieceSelected, pos);
								System.out.println(this.E.toString());//Nouvel Echiquier en affichage console
								loop=true;
							}
						}
				if(this.E.destinationPossible(pieceSelected).size()==0){
					loop=true;
					tour++;
				}
			}

				loop=false;
				if(pos!=null && pieceSelected!=null){
					this.mesPositions.add(pieceSelected.getPosition());
					this.mesDestinations.add(pos);
				}
			
			tour++;
		}		
	}
	
	// Selectionne sur l'echiquier la piece cliquee,
	// et verifie si elle a la couleur attendue en fonction du tour
	// (INIT : les blancs commencent, tour = 1)
	public Piece selectPieceJouable(int tour)
	{
		Position pos=null;
		Piece pieceSelected=null;
		boolean stop=false;
		
		do
		{
			pos = this.getCaseCliquee();
			if(pos!=null)
				if(this.E.getTableau()[pos.getI()][pos.getJ()]!=null)
					if(((tour%2 != 0) && (this.E.getTableau()[pos.getI()][pos.getJ()].getCouleur() == "blanc")) || ((tour%2 == 0) && (this.E.getTableau()[pos.getI()][pos.getJ()].getCouleur() == "noir"))){
						pieceSelected = this.E.getTableau()[pos.getI()][pos.getJ()];
						stop=true;
					}
		}
		while(stop==false);

		return pieceSelected;
	}
	
	// Recherche le roi de ma couleur en fonction du tour
	// (INIT : les blancs commencent, tour = 1)
	public Piece selectMonRoi(int tour)
	{
		Piece monRoi = null;
		
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(this.E.getTableau()[i][j]!=null)
					if(this.E.getTableau()[i][j].getClass().getName() == "pieces.Roi")
						if((this.E.getTableau()[i][j].getCouleur() == "blanc") && ((tour%2 != 0)) ||
								(this.E.getTableau()[i][j].getCouleur() == "noir") && ((tour%2 == 0)))
							monRoi = this.E.getTableau()[i][j];	

		return monRoi;
	}
	
	public void rejeuPartie()
	{
		this.E = this.eDepart;
		
		for(int i = 0; i < this.mesPositions.size(); i++)
		{
			this.E.deplacerPiece(this.E.getTableau()[this.mesPositions.elementAt(i).getI()][this.mesPositions.elementAt(i).getJ()], this.mesDestinations.elementAt(i));
			
			// A chaque clic sur le bouton suivant
			do
			{
			}
			while(!this.isSuivant());
		}
	}

	
	public String toString()
	{
		StringBuffer res = new StringBuffer("");
		return res.toString();
	}
}
