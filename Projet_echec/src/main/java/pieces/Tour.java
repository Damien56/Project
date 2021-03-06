package pieces;

public class Tour extends Piece
{

	public Tour(Position position, String couleur)
	{
		super(position, couleur);
		this.setPositionPossible();
		this.Image = "Image d'une tour de cette couleur";
	}

	
	public void setPositionPossible()
	{		
		for(int a=0; a<8; a++)
		{
			for(int b=0; b<8; b++){
				this.PositionPossible[a][b]=0;
			}
		}
		
		for (int a = 0 ; a < 8 ; a++)
			this.PositionPossible[a][this.position.getJ()] = 1;
		
		for (int a = 0 ; a < 8 ; a++)
			this.PositionPossible[this.position.getI()][a] = 1;
		 
		this.PositionPossible[this.position.getI()][this.position.getJ()]=0;				
	}
	
		
	public String toString()
	{
		StringBuffer res = new StringBuffer("");
		
		res.append("Dame [ Position = ");
		res.append(this.position.getI());
		res.append(this.position.getJ());
		res.append(", Couleur = ");
		res.append(this.Couleur);
		res.append(" ], Deja Deplace = ");
		res.append(this.DejaDeplace);
		res.append(" PositionPossible = ");
		res.append(this.toStringPositionPossible());
		
		return res.toString();
	}
}
