package pieces;

public class Roi extends Piece {

	private boolean Echec;
	private boolean DejaDeplace;
	

	public Roi(Position position,String couleur) {
		super(position,couleur);
		this.setPositionPossible();
		this.Image="image dame de cette couleur";
		this.Echec =false;
		this.DejaDeplace =false;
		
	}
	
	
	public boolean setPositionPossible() {//à modifier pour les bords
		int i = this.position.getI();
		int j = this.position.getJ();
		
		if ((i<7 && i>1) && (j<7 && j>1) ){
			PositionPossible[i+1][j+1] = 1 ;
			PositionPossible[i+1][j] = 1 ;
			PositionPossible[i+1][j-1] = 1 ;
			PositionPossible[i][j+1] = 1 ;
			PositionPossible[i][j-1] = 1 ;
			PositionPossible[i-1][j+1] = 1 ;
			PositionPossible[i-1][j] = 1 ;
			PositionPossible[i-1][j-1] = 1 ;
		}
		
		if (i==0 && (j<8 && j>=0)){
			if(j!=0){
				PositionPossible[i][j-1] = 1 ;
				PositionPossible[i+1][j-1] = 1 ;
			}
			if(j!=7){
				PositionPossible[i][j+1] = 1 ;
				PositionPossible[i+1][j+1] = 1 ;
			}
			PositionPossible[i+1][j] = 1 ;
			
		}
		
		if (i==7 &&(j<8 && j>=0)){			
			if (j != 0){
				PositionPossible[i][j-1] = 1 ;
				PositionPossible[i-1][j-1] = 1 ;
			}
			if (j != 7){
				PositionPossible[i-1][j+1] = 1 ;
				PositionPossible[i][j+1] = 1 ;
			}
			PositionPossible[i-1][j] = 1 ;
		}
		
		if (j==0 && (j<7 && j>0)){
				PositionPossible[i-1][j] = 1 ;
				PositionPossible[i+1][j] = 1 ;
				PositionPossible[i][j+1] = 1 ;
				PositionPossible[i+1][j+1] = 1 ;
				PositionPossible[i-1][j+1] = 1 ;
		}
		
		
		if (j==7 &&(i<7 && i>0)){
			PositionPossible[i-1][j] = 1 ;
			PositionPossible[i+1][j] = 1 ;
			PositionPossible[i][j-1] = 1 ;
			PositionPossible[i+1][j-1] = 1 ;
			PositionPossible[i-1][j-1] = 1 ;
			
		}
		PositionPossible[i][j] = 0 ;
		return true;
}

	
	public void toStringRoi() {// affiche les caracteristique de la Tour
		System.out.println("Roi [position=" + position.getI()
				+ position.getJ() + ", Couleur=" + Couleur + "]"
				+ "Deja Deplace= " + this.DejaDeplace + "Echec= " + this.Echec + " PositionPossible= ");
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


	
	


	
	
	
	public boolean estMat() {
		return true;

	}
}
