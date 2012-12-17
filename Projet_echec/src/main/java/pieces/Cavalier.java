package pieces;

public class Cavalier extends Piece{

	public Cavalier(Position position,String couleur) {
		super(position,couleur);
		this.setPositionPossible();
		this.Image="image Cavalier de cette couleur";
	}

	public boolean setPositionPossible() {
		int i = this.position.getI();
		int j = this.position.getJ();

		if (i<)
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
	
	
	

	
	public void toStringCavalier() {//affiche les caracteristique du cavalier
		System.out.println("Cavalier [position=" + position.getI() + position.getJ() + ", Couleur=" + Couleur + "]"+"PositionPossible= " );
		this.toStringPositionPossible();
	}
	
}
