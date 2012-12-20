package pieces;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Piece
{
	protected Position position = new Position();
	protected Position positionOld = new Position();
	protected String Couleur;
	protected String Image;
	protected int[][] PositionPossible = new int[8][8];
	protected Position positionDuMechant;
	protected boolean DejaDeplace;
	protected int NombreDeDeplacement;
	
	
	public Piece(Position position, String couleur)
	{
		this.position = position;
		this.Couleur = couleur;
		this.Image = "";
		this.positionDuMechant = null;
		this.DejaDeplace = false;
		this.NombreDeDeplacement = 0;
		
		 for (int i = 0 ; i < 8 ; i++)
			 for(int j = 0 ; j < 8 ; j++)
				 this.PositionPossible[i][j] = 0;	
	}

	public Position getPositionOld()
	{
		return this.positionOld;
	}
	
	/*public void setPositionPossible(Piece p){
		
		
		
	}*/
	
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
	
	/*public void setPositionPossible(int[][] PosPossible)
	{
		this.PositionPossible=PosPossible;
	}*/
	
	public Position getPositionDuMechant()
	{
		return this.positionDuMechant;
	}

	public void setPositionDuMechant(Position positionDuMechant)
	{
		this.positionDuMechant = positionDuMechant;
	}

	public void setDejaDeplace(boolean dejaDeplace)
	{
		this.DejaDeplace = dejaDeplace;
	}
	
	public boolean getDejaDeplace()
	{
		return this.DejaDeplace;
	}
	
	public void setNombreDeDeplacement(int i)
	{
		this.NombreDeDeplacement = i;
	}
	
	public int getNombreDeDeplacement()
	{
		return this.NombreDeDeplacement;
	}
	
}
