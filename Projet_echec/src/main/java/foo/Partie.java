package foo;

import java.util.Vector;

import pieces.*;

public class Partie implements java.io.Serializable
{
	public Joueur J1, J2 ;
	public Echiquier E;

	public boolean isStd;

	public Vector<Position> mesPositions, mesDestinations;
	public Echiquier eDepart;
	public Position caseCliquee, caseCliqueeMenu;
	public String nomPiece, couleurPiece;
	public boolean suivant;
	public int tour;
	public boolean persoFinie;


	// Le constructeur
	public Partie(Joueur j1, Joueur j2, Echiquier e)
	{
		this.J1 = j1;
		this.J2 = j2;
		this.E = e;
		this.eDepart = e;
		this.mesPositions = new Vector<Position>();
		this.mesDestinations = new Vector<Position>();
		this.caseCliquee = null;
		this.caseCliqueeMenu = null;
		this.nomPiece = "";
		this.couleurPiece = "";
		this.suivant = false;
		this.tour = 1;
	}

	public Partie()
	{
		this(new Joueur(), new Joueur(), new Echiquier());		
	}	


	public Echiquier getEchiquier() {
		return E;
	}

	public Joueur getJoueur1() {
		return this.J1;
	}

	public Joueur getJoueur2() {
		return this.J2;
	}

	public boolean isStandard() {
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

	public boolean getSuivant() {
		return this.suivant;
	}

	public void setJoueur1(Joueur j1) {
		this.J1 = j1;
	}

	public void setJoueur2(Joueur j2) {
		this.J2 = j2;
	}

	public void setStandard(boolean isStd) {
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
	
	public void setPersoFinie(boolean b)
	{
		this.persoFinie = b;
	}
	
	public boolean getPersoFinie()
	{
		return this.persoFinie;
	}



	// Gestion du deplacement des pieces jusqu'à la fin de la partie.
	public void jouerPartie()
	{
		boolean fini = false, isMat = false, loop = false;
		Piece pieceSelected = null;
		Roi monRoi;
		Position pos = null;

		System.out.println(this.E.toString()); //Affichage Echiquier de depart

		while(!fini && !isMat)
		{			
			monRoi = selectMonRoi(this.tour);

			// Test si le roi de ma couleur est mat
			/*if(monRoi != null)
				if(this.E.estMat(monRoi))
					isMat = true;

			else*/
			// Selectionne la piece cliquee et
			// verifie si elle a la couleur attendue en fonction du tour
			pieceSelected = selectPieceJouable(this.tour);

			// Demande une position de destination tant qu'elle n'est
			// pas conforme aux destinations possibles pour cette pièce.

			while(loop == false)
			{
				pos = this.getCaseCliquee();

				if(pos != null){
					if(pieceSelected!=null){
						for(int i = 0; i < this.E.destinationPossible(pieceSelected).size(); i++){
							if(pos.isEqual(this.E.destinationPossible(pieceSelected).get(i))){
								this.E.deplacerPiece(pieceSelected, pos);
								System.out.println(this.E.toString());//Nouvel Echiquier en affichage console
								loop = true;
							}
							else if(this.E.getTableau()[pos.getI()][pos.getJ()]!=null){ 
								if(this.E.getTableau()[pos.getI()][pos.getJ()].getCouleur()==pieceSelected.getCouleur()){
									pieceSelected = this.E.getTableau()[pos.getI()][pos.getJ()];//sinon si pos = piece de la même couleur alors pieceSelected = pos
								}
							}

						}
						if(this.E.destinationPossible(pieceSelected).size() == 0)
						{
							loop = true;
							this.tour++;
						}
					}
				}
			}

			loop = false;

			if(pos != null && pieceSelected != null)
			{
				this.mesPositions.add(pieceSelected.getPosition());
				this.mesDestinations.add(pos);
			}	

			this.tour++;
		}		
	}

	// Gestion du deplacement des pieces jusqu'à la fin de la partie.
	public void jouerPartiePersonnalisee()
	{
		while(!getPersoFinie())
		{
			if(this.getNomPiece() == "piece.Roi") {
				this.E.ajouterPiece(new Roi(this.getCaseCliquee(), this.getCouleurPiece()));
			}
			
			else if(this.getNomPiece() == "piece.Dame") {
				this.E.ajouterPiece(new Dame(this.getCaseCliquee(), this.getCouleurPiece()));
			}
			else if(this.getNomPiece() == "piece.Tour") {
				this.E.ajouterPiece(new Tour(this.getCaseCliquee(), this.getCouleurPiece()));
			}
			else if(this.getNomPiece() == "piece.Fou") {
				this.E.ajouterPiece(new Fou(this.getCaseCliquee(), this.getCouleurPiece()));
			}
			else if(this.getNomPiece() == "piece.Cavalier") {
				this.E.ajouterPiece(new Cavalier(this.getCaseCliquee(), this.getCouleurPiece()));
			}
			else if(this.getNomPiece() == "piece.Pion") {
				this.E.ajouterPiece(new Pion(this.getCaseCliquee(), this.getCouleurPiece()));
			}
		}
		
		this.jouerPartie();
	}

			

	// Selectionne sur l'echiquier la piece cliquee,
	// et verifie si elle a la couleur attendue en fonction du tour
	// (INIT : les blancs commencent, tour = 1)
	public Piece selectPieceJouable(int tour)
	{
		Position pos = null;
		Piece pieceSelected = null;
		boolean stop = false;

		do
		{
			pos = this.getCaseCliquee();
			if(pos != null)
				if(this.E.getTableau()[pos.getI()][pos.getJ()] != null)
					if(((tour%2 != 0) && (this.E.getTableau()[pos.getI()][pos.getJ()].getCouleur() == "blanc"))
							|| ((tour%2 == 0) && (this.E.getTableau()[pos.getI()][pos.getJ()].getCouleur() == "noir")))
					{
						pieceSelected = this.E.getTableau()[pos.getI()][pos.getJ()];
						stop = true;
					}
		}
		while(stop == false);

		return pieceSelected;
	}

	// Recherche le roi de ma couleur en fonction du tour
	// (INIT : les blancs commencent, tour = 1)
	public Roi selectMonRoi(int tour)
	{
		Roi monRoi = null;

		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(this.E.getTableau()[i][j]!=null)
					if(this.E.getTableau()[i][j].getClass().getName() == "pieces.Roi")
						if((this.E.getTableau()[i][j].getCouleur() == "blanc") && ((tour%2 != 0)) ||
								(this.E.getTableau()[i][j].getCouleur() == "noir") && ((tour%2 == 0)))
							monRoi = (Roi)this.E.getTableau()[i][j];

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
			while(!this.getSuivant());
			this.setSuivant(false);
		}
	}


	public String toString()
	{
		StringBuffer res = new StringBuffer("");
		return res.toString();
	}

	public boolean defilerTemps(Joueur j)

	{	
		/* Methode qui compare le temps du systeme au temp de jeu d'un joueur.
		 * Met fin à la partie si le temps de jeu est ecoule. */

		// MAJ temps
		boolean fini = false;
		long tempsSystemDebut = System.currentTimeMillis();
		long tempsEcoule = 0;

		do
		{
			tempsEcoule = System.currentTimeMillis() - tempsSystemDebut;

			// peut devenir source de probleme, le temps ne se decompte pas.
			// jouer sur les transtypages int/long
			if((int)tempsEcoule == 1)
			{
				j.setTempsEcoule(j.getTempsEcoule() - tempsEcoule);
				tempsSystemDebut = System.currentTimeMillis();
				if(j.getTempsEcoule() <= 0)
					fini = true;
			}
		}
		while(!((j.getCouleur() == "blanc" && this.tour%2 != 0 && this.caseCliquee == this.mesDestinations.lastElement())
				|| (j.getCouleur() == "noir" && this.tour%2 == 0 && this.caseCliquee == this.mesDestinations.lastElement()))
				&& j.getTempsEcoule() > 0);


		fini = true;
		return fini;

	}
	public void GererTour(){
		// Temps max pour test
		this.J1.setTempsEcoule(30);
		this.J2.setTempsEcoule(30);

		//while (1)
		{


			J1.getTempsEcoule();
			J2.getTempsEcoule();
		}

	}

	public int getTour() {
		return this.tour;
	}	
}

