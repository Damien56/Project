package pieces;

public class Roi extends Piece {

	private boolean Echec;
	
	

	public Roi(Position position,String couleur) {
		super(position,couleur);
		this.setPositionPossible();
		this.Image="image dame de cette couleur";
		this.Echec =false;
		
	}
	
	
	public void setPositionPossible() {//à modifier pour les bords
		int i = this.position.getI();
		int j = this.position.getJ();
		
		for(int a=0; a<8; a++)
		{
			for(int b=0; b<8; b++){
				this.PositionPossible[a][b]=0;
			}
		}
		
		if ((i < 7 && i > 1) && (j < 7 && j > 1) )
		{
			this.PositionPossible[i + 1][j + 1] = 1 ;
			this.PositionPossible[i + 1][j] = 1 ;
			this.PositionPossible[i + 1][j-1] = 1 ;
			this.PositionPossible[i][j + 1] = 1 ;
			this.PositionPossible[i][j - 1] = 1 ;
			this.PositionPossible[i - 1][j + 1] = 1 ;
			this.PositionPossible[i - 1][j] = 1 ;
			this.PositionPossible[i - 1][j - 1] = 1 ;
		}
		
		if (i == 0 && j < 8 && j >= 0)
		{
			if(j != 0)
			{
				this.PositionPossible[i][j-1] = 1 ;
				this.PositionPossible[i+1][j-1] = 1 ;
			}
			
			if(j != 7)
			{
				this.PositionPossible[i][j + 1] = 1 ;
				this.PositionPossible[i + 1][j + 1] = 1 ;
			}
			this.PositionPossible[i + 1][j] = 1 ;		
		}
		
		if (i == 7 && j < 8 && j >= 0)
		{			
			if (j != 0)
			{
				this.PositionPossible[i][j - 1] = 1 ;
				this.PositionPossible[i - 1][j - 1] = 1 ;
			}
			
			if (j != 7)
			{
				this.PositionPossible[i - 1][j + 1] = 1 ;
				this.PositionPossible[i][j + 1] = 1 ;
			}
			this.PositionPossible[i - 1][j] = 1 ;
		}
		
		if (j == 0 && j < 7 && j > 0)
		{
			this.PositionPossible[i - 1][j] = 1 ;
			this.PositionPossible[i + 1][j] = 1 ;
			this.PositionPossible[i][j + 1] = 1 ;
			this.PositionPossible[i + 1][j + 1] = 1 ;
			this.PositionPossible[i - 1][j + 1] = 1 ;
		}
		
		
		if (j == 7 && i < 7 && i > 0)
		{
			this.PositionPossible[i - 1][j] = 1 ;
			this.PositionPossible[i + 1][j] = 1 ;
			this.PositionPossible[i][j - 1] = 1 ;
			this.PositionPossible[i + 1][j - 1] = 1 ;
			this.PositionPossible[i - 1][j - 1] = 1 ;
			
		}
		this.PositionPossible[i][j] = 0 ;
		
		if(DejaDeplace==false){
				this.PositionPossible[i][j+2]=1;
				this.PositionPossible[i][j-2]=1;
			}
			
			
		
	}

	// affiche les caracteristiques du Roi
	public String toString()
	{
		StringBuffer res = new StringBuffer("");
		
		res.append("Roi [ Position = ");
		res.append(position.getI());
		res.append(position.getJ());
		res.append(", Couleur = ");
		res.append(this.Couleur);
		res.append(" ], Deja Deplace = ");
		res.append(this.DejaDeplace);
		res.append(" Echec = ");
		res.append(this.Echec);
		res.append(" PositionPossible = ");
		res.append(this.toStringPositionPossible());
		
		return res.toString();
	}
	
	
	
	public boolean isEchec()
	{
		return this.Echec;
	}


	public void setEchec(boolean echec)
	{
		this.Echec = echec;
	}


	
	
	
	public boolean estMat()
	{
		return true;
	}
}
