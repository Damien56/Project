package pieces;

public class Dame extends Piece {

	public Dame() {
		super();
		this.Image="image dame de cette couleur";
	}

	public boolean setPositionPossible() {
		int i = this.Position[0];
		int j = this.Position[1];

		
		for (int a =0 ; a<8 ; a++){
			PositionPossible[a][j]=1;
		}
		
		for (int a =0 ; a<8 ; a++){
			PositionPossible[i][a]=1;
		}
		
		while (i!=8 && j!=8){
			PositionPossible[i][j]=1;
			i++;
			j++;
		}
		
		while (i!=0 && j!=8){
			PositionPossible[i][j]=1;
			i--;
			j++;
		}
		
		while (i!=8 && j!=0){
			PositionPossible[i][j]=1;
			i++;
			j--;
		}
		
		while (i!=0 && j!=0){
			PositionPossible[i][j]=1;
			i--;
			j--;
		}
			
			
	return true;		
	
	}
}
