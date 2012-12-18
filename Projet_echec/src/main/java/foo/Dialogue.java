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



public class Dialogue {
	
	//Interface Dialogue
	
	
		/* Enregistrement d'une partie dans un fichier */
	
	public void SerialisePartie (Partie pa){
		
		FileOutputStream fos = null ;
		
		try {
			fos = new FileOutputStream ("savepartie.csv");
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
		} catch (IOException e) {
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
	
	public void DeserialisePartie( Partie pa) {
		
		FileInputStream fis = new FileInputStream("partieacharger.csv");
		DataInputStream dis = new DataInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(dis);
		
		ObjectInputStream ois =  new ObjectInputStream(new BufferedInputStream(bis));
		Partie pa = (Partie)ois.readObject() ;
		System.out.println(pa) ;
		
	}

}
