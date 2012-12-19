package pieces;

public class Pion extends Piece
{
	private int NombreDeDeplacement ;
	
	public Pion(Position position, String couleur)
	{
		super(position, couleur);
		this.setPositionPossible();
		this.Image = "Image d'une dame de cette couleur";
		this.NombreDeDeplacement = 0;
	}
	
	//a modifier pour la dernière case
	public void setPositionPossible()
	{	
		if (this.NombreDeDeplacement == 0)
		{
			//positions pour un pion noir
			if(this.getCouleur() == "noir")
			{
				this.PositionPossible[this.position.getI() + 1][this.position.getJ()] = 1 ;
				this.PositionPossible[this.position.getI() + 2][this.position.getJ()] = 1 ;
			}
			
			else if(this.getCouleur() == "blanc")
			{
				this.PositionPossible[this.position.getI() - 1][this.position.getJ()] = 1 ;
				this.PositionPossible[this.position.getI() - 2][this.position.getJ()] = 1 ;
			}
		}
		
		else if(this.getCouleur() == "noir" && this.position.getI() != 7)
			this.PositionPossible[this.position.getI() + 1][this.position.getJ()] = 1 ;
		
		else if(this.getCouleur()=="blanc" && this.position.getI()!=0)
			this.PositionPossible[this.position.getI() - 1][this.position.getJ()] = 1 ;		
	}

	public String toString()
	{
		StringBuffer res = new StringBuffer("");
		
		res.append("Pion [ Position = ");
		res.append(position.getI());
		res.append(position.getJ());
		res.append(", Couleur = ");
		res.append(this.Couleur);
		res.append(" ], Deja Deplace = ");
		res.append(this.NombreDeDeplacement);
		res.append(" PositionPossible = ");
		res.append(this.toStringPositionPossible());
		
		return res.toString();
	}
}
