package foo;


public class Partie implements java.io.Serializable {
	
	public Joueur J1;
	public Joueur J2 ;
	public Echiquier E;
	
	
	public Partie(){
		this.J1 = new Joueur();
		this.J2 = new Joueur();
		this.E = new Echiquier();
	}
	
	
	public void rejeuPartie(){
		
	}
	
	public void reglerTimer(){
		
	}

}
