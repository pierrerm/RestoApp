package ca.mcgill.ecse223.resto.persistence;
/**
 * @authors Pierre, Paul, Anudruth
 *
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ca.mcgill.ecse223.resto.model.MenuItem;
import ca.mcgill.ecse223.resto.model.RestoApp;

public class PersistenceObjectStream {

	private static String filename = "menu.resto";

	public static void serialize(Object object) {
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("menu.resto");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(object);
			out.close();
			fileOut.close();
		} catch (Exception e) {
			throw new RuntimeException("Could not save data to file '" + filename + "'.");
		}

	}

	public static Object deserialize() {
		RestoApp app = null;
		ObjectInputStream in;
		try {
			FileInputStream fileIn = new FileInputStream("menu.resto");
			in = new ObjectInputStream(fileIn);
			app = (RestoApp) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return app;
	}
	
	public static void setFilename(String newFilename) {
		filename = newFilename;
	}

}