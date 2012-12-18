package pieces;


public class Piece {

	protected Position position = new Position();
	protected String Couleur;
	protected String Image;
	protected int[][] PositionPossible = new int[8][8];
	private Position positionDuMechant;

	
	public Piece(Position position, String couleur) {

		this.position = position;
		this.Couleur = couleur;
		this.Image = " ";
		this.positionDuMechant=null;
		
		 for (int i = 0 ; i<8 ; i++){ for(int j = 0 ; j<8 ; j++){
			 this.PositionPossible[i][j]= 0; } }
		
	}

	
	public String getCouleur() {
		return Couleur;
	}


	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void toStringPositionPossible() {//affiche le tableau des position possible les & represente les cases possibles
		int cpt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (cpt == 8) {
					System.out.println();
					cpt = 0;
				}
				cpt++;
				System.out.print(PositionPossible[i][j]);
			}
		}

	}

	public int[][] getPositionPossible() {
		return PositionPossible;
	}
	public Position getPositionDuMechant() {
		return positionDuMechant;
	}


	public void setPositionDuMechant(Position positionDuMechant) {
		this.positionDuMechant = positionDuMechant;}
	
	

}
