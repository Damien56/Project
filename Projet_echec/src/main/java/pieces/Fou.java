package pieces;




public class Fou extends Piece{

	public Fou(Position position,String couleur) {
		super(position,couleur);
		this.setPositionPossible();
		this.Image="image dame de cette couleur";
	}

	public boolean setPositionPossible() {
		int i = this.position.getI();
		int j = this.position.getJ();

		
		
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

	
	public void toStringFou() {
		this.setPosition(position);
		System.out.println("Fou [position=" + position.getI()+ " " + position.getJ() + ", Couleur=" + Couleur
				+ ", Image=" + Image + ", PositionPossible=");
				 this.toStringPositionPossible();
	}

	
}	
	