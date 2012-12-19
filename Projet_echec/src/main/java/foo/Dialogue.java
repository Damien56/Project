package foo;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;


//Interface Dialogue

public class Dialogue {
	
	public Dialogue() {
		
		Partie p = new Partie();
			
	}
		/* Enregistrement d'une partie dans un fichier */
	
	public void SerialisePartie (Partie pa){
		
		FileOutputStream fos = null ;
		
		try {
			fos = new FileOutputStream ("partiesauvegardee.csv");
			} 
		
		catch (FileNotFoundException e) {
			
			 System.out.println("Le fichier dans lequel vous voulez sauvegarder la partie n'existe pas !");
			 e.printStackTrace();
			}
		
		
		DataOutputStream dos = new DataOutputStream(fos);
		BufferedOutputStream bos = new BufferedOutputStream(dos);		
		
		ObjectOutputStream oos = null ;
		
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(bos));
		} 
		
		catch (IOException e) {
			
			System.out.println("erreur");
			e.printStackTrace();
		}
		
		try {
			oos.writeObject(pa);
			} 
		
		catch (IOException e) {
			System.out.println("Verifier l'existence et/ou l'ouverture du fichier");
			e.printStackTrace();
		}
		try {
			oos.close();
			} 
		catch (IOException e) {
			System.out.println("Le fichier n'existe pas ou n'est pas ouvert");
			e.printStackTrace();
				}
				
	}
		
	/* Chargement d'une partie depuis un fichier */
	
	public Partie DeserialisePartie( Partie pa) {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("partiesauvegardee.csv");
			} 
		
		catch (FileNotFoundException e2) {
			System.out.println("Le fichier que vous voulez charger n'existe pas !");
			e2.printStackTrace();
		}
		
		DataInputStream dis = new DataInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(dis);
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new BufferedInputStream(bis));
		} 
		catch (IOException e1) {
			System.out.println("erreur");
			e1.printStackTrace();
		}
		try {
			
			Partie pb = (Partie)ois.readObject();
			
		} 
		catch (ClassNotFoundException e) {
			
			
			e.printStackTrace();
		} 
		catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
		try {
			ois.close();
		} 
		catch (IOException e) {
			System.out.println("Le fichier n'existe pas ou n'est pas ouvert");
			e.printStackTrace();
		}
		return pb;
		
	}

}

public static void main(String[] args) {	
	
	Partie p = new Partie();
	p.SerialisePartie();
	p.DeserialisePartie();
}
