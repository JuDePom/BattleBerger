package battleberger.backup.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import battleberger.backup.DAO;
import battleberger.model.Game;

public class Serialization_Game implements DAO<Game>  {

	@Override
	public Game load(String filepath) {
	      Game g = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream(filepath);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         g = (Game) in.readObject();
	         
	         in.close();
	         fileIn.close();
	      } catch(IOException i)
	      {
	         i.printStackTrace();
	      } catch(ClassNotFoundException c)
	      {
	         System.out.println("Sauvegarde corrompue");
	         c.printStackTrace();
	      }
	      return g;

	}

	@Override
	public boolean save(Game object, String filepath) {
		 try
	      {
	         FileOutputStream fileOut = new FileOutputStream(filepath);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(object);
	         out.close();
	         fileOut.close();
	         return true;
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	          return false;
	      }
	}

}
