package pieces;

public class testClasse {
	
	public static void main(String[] args) {
		Dame dame = new Dame(new Position(4,3),"blanc");
		dame.toStringDame();
		Fou fou = new Fou(new Position(4,3),"blanc");
		fou.toStringFou();
		Tour tour = new Tour (new Position(4,3), "blanc");
		tour.toStringTour();
		Roi roi = new Roi (new Position(4,3), "blanc");
		roi.toStringRoi();
		Pion pion =new Pion(new Position(4,3),"blanc");
		pion.toStringPion();
	}

}
