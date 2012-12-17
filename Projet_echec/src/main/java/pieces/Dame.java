package pieces;

public class Dame extends Piece {

	public Dame(Position position,String couleur) {
		super(position,couleur);
		this.Image="image dame de cette couleur";
	}

	public boolean setPositionPossible() {
		int i = this.position.getI();
		int j = this.position.getJ();

		
		for (int a =0 ; a<8 ; a++){
			PositionPossible[a][j]=1;
		}
		
		for (int a =0 ; a<8 ; a++){
			PositionPossible[i][a]=1;
		}
		
		while (i<8 && j<8){
			PositionPossible[i][j]=1;
			i++;
			j++;
		}
		
		 i = this.position.getI();
		 j = this.position.getJ();
		 
		 
		while (i>=0 && j<8){
			PositionPossible[i][j]=1;
			i--;
			j++;
		}
		
		 i = this.position.getI();
		 j = this.position.getJ();
		 
		while (i<8 && j>=0){
			PositionPossible[i][j]=1;
			i++;
			j--;
		}
		
		 i = this.position.getI();
		 j = this.position.getJ();
		
		while (i>=0 && j>=0){
			PositionPossible[i][j]=1;
			i--;
			j--;
		}
		
		i = this.position.getI();
		j = this.position.getJ();
		 
	PositionPossible[i][j]=0;		
			
	return true;		
	
	}
	
	
	

	
	public String toStringDame() {//affiche les caracteristique de la dame
		return "Dame [position=" + position.getI() + position.getJ() + ", Couleur=" + Couleur + "]";
	}
	
	
	
	public static void main(String[] args) {
		Position pos = new Position(0,0);
		
		Dame dame = new Dame(pos,"blanc");
		dame.setPositionPossible();
		System.out.print(dame.toStringDame()+"\n");
		dame.toStringPositionPossible();
	}
	
}
