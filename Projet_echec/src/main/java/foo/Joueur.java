package foo;

public class Joueur {
	
	// Attributs de la classe
	
	private String Nom;
	private String Couleur;
	private int Score;
	
	
	// Méthodes de la classe 
	
	public Joueur() // Constructeur de la classe Joueur
	{ 
		
		this.Nom = "Joueurdéfaut";
		this.Couleur = "Couleurdéfaut";
		this.Score=0;
	}
	
	public Joueur(String nom, String couleur)
	{
		this.Nom = nom;
		this.Couleur = couleur;
		this.Score=0;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getCouleur() {
		return Couleur;
	}

	public void setCouleur(String couleur) {
		Couleur = couleur;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}
	
	

}
