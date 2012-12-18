package foo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;



public class Dialogue {
	
	//Interface Dialogue
	
	
		/* Enregistrement d'une partie dans un fichier */
	
	public void SerialisePartie (Partie pa){
		
		FileOutputStream fos = new FileOutputStream ("savepartie.csv");
		DataOutputStream dos = new DataOutputStream(fos);
		BufferedOutputStream bos = new BufferedOutputStream(dos);		
		
		ObjectOutputStream oos =  new ObjectOutputStream(new BufferedOutputStream(bos)) ;
		
		oos.writeObject(pa);
		oos.close();
		
	}
		
	/* Chargement d'une partie depuis un fichier */
	
	public void DeserialisePartie( Partie pa) {
		
		FileInputStream fis = new FileInputStream("partie.csv");
		DataInputStream dis = new DataInputStream(fis);
		BufferedInputStream bis = new BufferedInputStream(dis);
		
		ObjectInputStream ois =  new ObjectInputStream(new BufferedInputStream(bis));
		Partie pa = (Partie)ois.readObject() ;
		System.out.println(pa) ;
		
	}

}
