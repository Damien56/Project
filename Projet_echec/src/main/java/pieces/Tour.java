package pieces;

public class Tour extends Piece {

	private boolean DejaDeplace ;

	public Tour(Position position, String couleur) {
		super(position, couleur);
		this.setPositionPossible();
		this.Image = "image tour de cette couleur";
		this.DejaDeplace = false;
	}

	
	public boolean setPositionPossible() {
			
			for (int a =0 ; a<8 ; a++){
				PositionPossible[a][this.position.getJ()]=1;
			}
			
			for (int a =0 ; a<8 ; a++){
				PositionPossible[this.position.getI()][a]=1;
			}
			
		 
		PositionPossible[this.position.getI()][this.position.getJ()]=0;		
				
		return true;		
		
		}
	
		public boolean isDejaDeplace() {
			return DejaDeplace;
		}

		public void setDejaDeplace(boolean dejaDeplace) {
			DejaDeplace = dejaDeplace;
	
	
	}

	public void toStringTour() {// affiche les caracteristique de la Tour
		System.out.println("Dame [position=" + position.getI()
				+ position.getJ() + ", Couleur=" + Couleur + "]"
				+ "Deja Deplace= " + this.DejaDeplace + " PositionPossible= ");
		this.toStringPositionPossible();
	}

}
