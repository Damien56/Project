package pieces;


public class Piece
{
	protected Position position = new Position();
	protected Position positionOld = new Position();
	protected String Couleur;
	protected String Image;
	protected int[][] PositionPossible = new int[8][8];
	private Position positionDuMechant;
	
	public Piece(Position position, String couleur)
	{
		this.position = position;
		this.Couleur = couleur;
		this.Image = "";
		this.positionDuMechant = null;
		
		 for (int i = 0 ; i < 8 ; i++)
			 for(int j = 0 ; j < 8 ; j++)
				 this.PositionPossible[i][j] = 0;	
	}

	public Position getPositionOld()
	{
		return this.positionOld;
	}
	
	public String getCouleur()
	{
		return this.Couleur;
	}


	public Position getPosition()
	{
		return this.position;
	}

	public void setPosition(Position position)
	{
		this.positionOld = this.position;
		this.position = position;
	}

	public String toStringPositionPossible()
	{
		// affiche le tableau des positions possible les & represente les cases possibles
		
		int cpt = 0;
		StringBuffer res = new StringBuffer("");
		
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
			{
				if (cpt == 8)
					cpt = 0;
				cpt++;
				res.append(PositionPossible[i][j]);
			}
		
		return res.toString();
	}

	public int[][] getPositionPossible()
	{
		return this.PositionPossible;
	}
	
	public Position getPositionDuMechant()
	{
		return this.positionDuMechant;
	}

	public void setPositionDuMechant(Position positionDuMechant)
	{
		this.positionDuMechant = positionDuMechant;
	}
}
