package pieces;

public class Pion extends Piece
{
	
	
	public Pion(Position position, String couleur)
	{
		super(position, couleur);
		if(this.position.getI()==6 || this.position.getI()==1)
			NombreDeDeplacement=0;
		else 
			NombreDeDeplacement=1;
		this.setPositionPossible();
		
		this.Image = "Image d'une dame de cette couleur";
		
	}
	
	//a modifier pour la dernière case
	public void setPositionPossible()
	{	
		for(int a=0; a<8; a++)
		{
			for(int b=0; b<8; b++){
				this.PositionPossible[a][b]=0;
			}
		}
				
		if (this.NombreDeDeplacement == 0)
		{
			//positions pour un pion noir
			if(this.getCouleur() == "noir")
			{
				if (this.position.getI()<7)
					this.PositionPossible[this.position.getI() + 1][this.position.getJ()] = 1 ;
				if (this.position.getI()<6 )
					this.PositionPossible[this.position.getI() + 2][this.position.getJ()] = 1 ;
				if(this.position.getJ()<7)
					this.PositionPossible[this.position.getI() + 1][this.position.getJ()+1]=1;
				if (this.position.getJ()>0)
					this.PositionPossible[this.position.getI() + 1][this.position.getJ()-1]=1;
			}
			
			else if(this.getCouleur() == "blanc")
			{
				if (this.position.getI()>0)
					this.PositionPossible[this.position.getI() - 1][this.position.getJ()] = 1 ;
				if (this.position.getI()>1)
					this.PositionPossible[this.position.getI() - 2][this.position.getJ()] = 1 ;
				if(this.position.getJ()<7)
					this.PositionPossible[this.position.getI() - 1][this.position.getJ()+1]=1;
				if (this.position.getJ()>0)
					this.PositionPossible[this.position.getI() - 1][this.position.getJ()-1]=1;
				
			}
		}

		
		else if(this.getCouleur() == "noir" && this.position.getI() != 7){
			this.PositionPossible[this.position.getI() + 1][this.position.getJ()] = 1 ;
				if(this.position.getJ()<7)
					this.PositionPossible[this.position.getI() + 1][this.position.getJ()+1]=1;
				if (this.position.getJ()>0)
					this.PositionPossible[this.position.getI() + 1][this.position.getJ()-1]=1;
		}
		else if(this.getCouleur() == "blanc" && this.position.getI() != 0){
				this.PositionPossible[this.position.getI() - 1][this.position.getJ()] = 1 ;
				if(this.position.getJ()<7)
					this.PositionPossible[this.position.getI() - 1][this.position.getJ()+1]=1;
				if (this.position.getJ()>0)
					this.PositionPossible[this.position.getI() - 1][this.position.getJ()-1]=1;
		}
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
