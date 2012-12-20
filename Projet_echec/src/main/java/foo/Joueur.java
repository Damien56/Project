package foo;

import java.io.Serializable;

import javax.swing.Timer;

public class Joueur
{
	
	// Attributs de la classe
	
	private String Nom;
	private String Couleur;
	private int Score;
	private long tempsEcoule;
	
	
	// Constructeur de la classe Joueur
	public Joueur(String nom, String couleur, int s)
	{
		this.Nom = nom;
		this.Couleur = couleur;
		this.Score = s;
		this.tempsEcoule = 0;
	}
	
	public Joueur(String nom, String couleur)
	{
		this(nom, couleur, 0);
	}
	
	public Joueur()
	{
		this("Nompardefaut", "Couleurpardefaut", 0);
	}
	

	// Méthodes de la classe 
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
	
	public String toString()
	{
		StringBuffer res = new StringBuffer("");
		res.append("Le joueur ");
		res.append(this.getNom());
		res.append(" joue avec les pieces ");
		res.append(this.getCouleur());
		res.append(" et a actuellement ");
		res.append(this.getScore());
		res.append(" point(s).");
		return res.toString();
	}
	
	public long getTempsEcoule()
	{
		return this.tempsEcoule;
	}
	
	public void setTempsEcoule(long t)
	{
		this.tempsEcoule = t;
	}
}
