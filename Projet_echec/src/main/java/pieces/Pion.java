package pieces;

public class Pion extends Piece{

	private int NombreDeDeplacement ;
	
	public Pion(Position position, String couleur) {
		super(position, couleur);
		this.setPositionPossible();
		this.Image="image dame de cette couleur";
		this.NombreDeDeplacement = 0;
	}
	
	
	public boolean setPositionPossible() {//a modifier pour la dernière case
	
		
		if (this.NombreDeDeplacement == 0){
			if(this.getCouleur()=="noir"){//positions pour un pion noir
				PositionPossible[this.position.getI()+1][this.position.getJ()] = 1 ;
				PositionPossible[this.position.getI()+2][this.position.getJ()] = 1 ;
			}
			else if(this.getCouleur()=="blanc"){
				PositionPossible[this.position.getI()-1][this.position.getJ()] = 1 ;
				PositionPossible[this.position.getI()-2][this.position.getJ()] = 1 ;
			}
		}
		else if(this.getCouleur()=="noir" && this.position.getI()!=7){
			PositionPossible[this.position.getI()+1][this.position.getJ()] = 1 ;
		}
		else if(this.getCouleur()=="blanc" && this.position.getI()!=0){
			PositionPossible[this.position.getI()-1][this.position.getJ()] = 1 ;
		}
				
		
		return true;
		
	}

	
	public void toStringPion() {// affiche les caracteristique du Pion
		System.out.println("Pion [position=" + position.getI()
				+ position.getJ() + ", Couleur=" + Couleur + "]"
				+ "Deja Deplace= " + this.NombreDeDeplacement  + " PositionPossible= ");
		this.toStringPositionPossible();
	}
}
