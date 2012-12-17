package pieces;

public class Piece {

	protected int[] Position;
	protected String Couleur;
	protected String Image;
	protected int[][] PositionPossible;
	
	
	public Piece() {
		
		this.Position = {0,0};
		this.Couleur = "rouge";
		
		// TODO Auto-generated constructor stub
	}

	public Piece(int[] position,String couleur){
		
		this.Position = position;
		this.Couleur = couleur;
		this.Image = " ";
		for (int i = 0 ; i<8 ; i++){
			for(int j = 0 ; j<8 ; j++)
				this.PositionPossible[i][j] = 0;
		}
	}
	
	


	
	public int[][] getPositionPossible() {
		return PositionPossible;
	}
	public boolean estbloquer(){
		
		return true;
	}
	
}
