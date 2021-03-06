package pieces;

public class Cavalier extends Piece
{
	public Cavalier(Position position, String couleur)
	{
		super(position,couleur);  // Appeler le constructeur de la classe parente Piece
		this.setPositionPossible();
		this.Image="Image d'un cavalier de cette couleur";
	}

	public void setPositionPossible()
	{
		int i = this.position.getI();  
		int j = this.position.getJ();

		for(int a = 0; a < 8; a++)
			for(int b = 0; b < 8; b++)
				PositionPossible[a][b] = 0;

		//position actuelle du cavalier
		PositionPossible[i][j] = 0;
		
		//position en haut  droite
		i = i - 2;
		j++;
		
		//contrainte depassement de l'echiquier
		if(i >= 0 && j >= 0 && i <= 7 && j <= 7)
			PositionPossible[i][j] = 1;
		
		//position vers la droite en haut
		i++;
		j++;
		
		if(i >= 0 && j >= 0 && i <= 7 && j <= 7)
			PositionPossible[i][j] = 1;
		
		//position vers la droite en bas
		i = i + 2;
		if(i >= 0 && j >= 0 && i <= 7 && j <= 7)
			PositionPossible[i][j] = 1;
		
		//position vers le bas a droite
		i++;
		j--;
		if(i >= 0 && j >= 0 && i <= 7 && j <= 7)
			PositionPossible[i][j] = 1;
		
		//position vers le bas a gauche
		j = j - 2;
		if(i >= 0 && j >= 0 && i <= 7 && j <= 7)
			PositionPossible[i][j] = 1;
		
		//position vers la gauche en bas
		i--;
		j--;
		if(i >= 0 && j >= 0 && i <= 7 && j <= 7)
			PositionPossible[i][j] = 1;
		
		//position vers la gauche en haut
		i = i - 2;
		if(i >= 0 && j >= 0 && i <= 7 && j <= 7)
			PositionPossible[i][j] = 1;
		
		//position vers le haut a droite
		i--;
		j++;
		if(i >= 0 && j >= 0 && i <= 7 && j <= 7)
			PositionPossible[i][j] = 1;
	}
	
	public String toStringCavalier()
	{	
		StringBuffer res = new StringBuffer("");
		
		res.append("Cavalier [ Position = ");
		res.append(position.getI());
		res.append(position.getJ());
		res.append(", Couleur = ");
		res.append(this.Couleur);
		res.append(" PositionPossible = ");
		res.append(this.toStringPositionPossible());
		
		return res.toString();
	}
}
