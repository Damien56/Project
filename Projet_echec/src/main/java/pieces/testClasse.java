package pieces;

public class testClasse {
	
	public static void main(String[] args) {
		Dame dame = new Dame(new Position(4,3),"blanc");
		dame.toStringDame();
		Fou fou = new Fou(new Position(4,3),"blanc");
		fou.toStringFou();
		Tour tour = new Tour (new Position(4,3), "blanc");
		tour.toStringTour();
		Pion pion = new Pion (new Position(4,3), "blanc");
		pion.toStringPion();
		Roi Roi =new Roi(new Position(4,3),"blanc");
		Roi.toStringRoi();
		Roi Roi2 =new Roi(new Position(0,0),"blanc");
		Roi2.toStringRoi();
		Roi Roi3 =new Roi(new Position(0,7),"blanc");
		Roi3.toStringRoi();
		Cavalier Cavalier = new Cavalier (new Position(4,3), "blanc");
		Cavalier.toStringCavalier();
		Cavalier Cavalier1 = new Cavalier (new Position(0,0), "blanc");
		Cavalier1.toStringCavalier();
		Cavalier Cavalier2 = new Cavalier (new Position(1,1), "blanc");
		Cavalier2.toStringCavalier();
		Cavalier Cavalier3 = new Cavalier (new Position(1,6), "blanc");
		Cavalier3.toStringCavalier();
		Cavalier Cavalier4 = new Cavalier (new Position(0,7), "blanc");
		Cavalier4.toStringCavalier();
		
	}

}
