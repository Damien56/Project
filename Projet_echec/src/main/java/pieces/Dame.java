package pieces;

public class Dame extends Piece
{
	public Dame(Position position, String couleur)
	{
		super(position,couleur);
		this.setPositionPossible();
		this.Image = "Image d'une dame de cette couleur";
	}

	public void setPositionPossible()
	{
		for(int a=0; a<8; a++)
		{
			for(int b=0; b<8; b++){
				this.PositionPossible[a][b]=0;
			}
		}
		
		int i = this.position.getI();
		int j = this.position.getJ();
	
		for (int a = 0 ; a < 8 ; a++)
			PositionPossible[a][j] = 1;

		for (int a = 0 ; a < 8 ; a++)
			PositionPossible[i][a] = 1;
		
		while (i < 8 && j < 8)
		{
			PositionPossible[i][j] = 1;
			i++;
			j++;
		}
		
		 i = this.position.getI();
		 j = this.position.getJ();
		  
		while (i >= 0 && j < 8)
		{
			PositionPossible[i][j] = 1;
			i--;
			j++;
		}
		
		 i = this.position.getI();
		 j = this.position.getJ();
		 
		while (i < 8 && j >= 0)
		{
			PositionPossible[i][j] = 1;
			i++;
			j--;
		}
		
		 i = this.position.getI();
		 j = this.position.getJ();
		
		while (i >= 0 && j >= 0)
		{
			PositionPossible[i][j] = 1;
			i--;
			j--;
		}
		
		i = this.position.getI();
		j = this.position.getJ();
		 
		PositionPossible[i][j] = 0;				
	}
	
	public String toString()
	{	
		StringBuffer res = new StringBuffer("");
		
		res.append("Dame [ Position = ");
		res.append(position.getI());
		res.append(position.getJ());
		res.append(", Couleur = ");
		res.append(this.Couleur);
		res.append(" PositionPossible = ");
		res.append(this.toStringPositionPossible());
		
		return res.toString();
	}	
}
