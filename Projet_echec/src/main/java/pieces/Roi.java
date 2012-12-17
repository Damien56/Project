package pieces;

public class Roi extends Piece {

	private boolean Echec;
	private boolean DejaDeplace;
	private Position positionDuMechant;

	public Roi(Position position,String couleur) {
		super(position,couleur);
		this.setPositionPossible();
		this.Image="image dame de cette couleur";
		this.Echec =false;
		this.DejaDeplace =false;
		this.positionDuMechant = null;
	}
	
	
	public boolean setPositionPossible() {
		int i = this.position.getI();
		int j = this.position.getJ();
		PositionPossible[i+1][j+1] = 1 ;
		PositionPossible[i+1][j] = 1 ;
		PositionPossible[i+1][j-1] = 1 ;
		PositionPossible[i][j+1] = 1 ;
		PositionPossible[i][j] = 0 ;
		PositionPossible[i][j-1] = 1 ;
		PositionPossible[i-1][j+1] = 1 ;
		PositionPossible[i-1][j] = 1 ;
		PositionPossible[i-1][j-1] = 1 ;
		return true;
		
		}

	
	public void toStringRoi() {// affiche les caracteristique de la Tour
		System.out.println("Roi [position=" + position.getI()
				+ position.getJ() + ", Couleur=" + Couleur + "]"
				+ "Deja Deplace= " + this.DejaDeplace + "Echec= " + this.Echec + "Position du mechant= " + this.positionDuMechant + " PositionPossible= ");
		this.toStringPositionPossible();
	}
	
	
	
	public boolean isEchec() {
		return Echec;
	}


	public void setEchec(boolean echec) {
		Echec = echec;
	}


	public boolean isDejaDeplace() {
		return DejaDeplace;
	}


	public void setDejaDeplace(boolean dejaDeplace) {
		DejaDeplace = dejaDeplace;
	}


	public Position getPositionDuMechant() {
		return positionDuMechant;
	}


	public void setPositionDuMechant(Position positionDuMechant) {
		this.positionDuMechant = positionDuMechant;
	}


	public boolean estEchec() {

		return true;
	}

	
	
	
	public boolean estMat() {
		return true;

	}
}
