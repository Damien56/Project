package pieces;

public class Fou extends Piece
{
	public Fou(Position position, String couleur)
	{
		super(position, couleur);
		this.setPositionPossible();
		this.Image = "Image d'un fou de cette couleur";
	}

	public void setPositionPossible()
	{
		int i = this.position.getI();
		int j = this.position.getJ();
		
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
		
		res.append("Fou [ Position = ");
		res.append(position.getI());
		res.append(position.getJ());
		res.append(", Couleur = ");
		res.append(this.Couleur);
		res.append(" PositionPossible = ");
		res.append(this.toStringPositionPossible());
		
		return res.toString();
	}
}	
	