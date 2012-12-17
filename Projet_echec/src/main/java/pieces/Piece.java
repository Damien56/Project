package pieces;

public class Piece {

	private int Position;
	private String couleur;
	protected String Image;
	private int PositionPossible[][];
	
	public Piece(){
		
	}
	
	public boolean estbloquer(){
		
		return true;
	}
	
}
