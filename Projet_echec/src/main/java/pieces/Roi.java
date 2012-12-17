package pieces;

public class Roi extends Piece {

	private boolean Echec;
	private boolean DejaDeplace;
	private int positionDuMechant;

	public Roi() {

	}

	public boolean setPositionPossible(int i, int j) {
		return true;
	}

	public boolean estEchec() {

		return true;
	}

	public boolean estMat() {
		return true;

	}
}
