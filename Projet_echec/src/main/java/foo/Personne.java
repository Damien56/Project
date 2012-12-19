package foo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Personne implements java.io.Serializable
{
	private String nom = "";
	private String prenom = "";
	private int taille = 0;

	public Personne(String nom, String prenom, int taille) {

		this.nom = nom;
		
		this.taille = taille;
		
		this.prenom = prenom;

}

 

public String getNom() {

return nom;

}

 

public void setNom(String nom) {

this.nom = nom;

}

 

public int getTaille() {

return taille;

}

 

public void setTaille(int taille) {

this.taille = taille;

}

 

public String getPrenom() {

return prenom;

}

 

public void setPrenom(String prenom) {

this.prenom = prenom;

}



public static void main(String argv[]) {

Personne personne = new Personne("Dupond","Jean",175);

try {

ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Cyril\\Desktop\\personne.txt"));

oos.writeObject(personne);

oos.flush();

oos.close();

}

catch (java.io.IOException e) {

e.printStackTrace();
}



}