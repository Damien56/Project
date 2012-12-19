package foo;

import java.io.*;

//Interface Dialogue

public class Dialogue
{
	public Dialogue()
	{
		// Methodes statiques => constructeur vide !
	}
	
	/* Enregistrement d'une partie dans un fichier */
	
	public static void serialiserPartie(Partie p, String url)
	{	
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(url));
			oos.writeObject(p);
			oos.flush();
			oos.close();
		}
		
		catch (IOException e)
		{
			System.out.println("Erreur lors de l'ecriture dans le fichier");
		}	
	}
		
	/* Chargement d'une partie depuis un fichier */
	
	public static Partie deserialiserPartie(String url)
	{	
		Partie p = null;
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(url));
			p = (Partie)ois.readObject();
			ois.close();
		}

		catch (IOException e)
		{
			System.out.println("Erreur lors de la lecture du fichier");
		}

		catch (ClassNotFoundException e)
		{
			System.out.println("Classe non trouvee");
		}
		
		return p;		
	}
}