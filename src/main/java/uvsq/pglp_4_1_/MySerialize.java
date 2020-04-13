package uvsq.pglp_4_1_;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MySerialize {

	public static void serialize(ArrayList<GroupPersonnels> lstP,String fileDest)
	{
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream(fileDest);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(lstP);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/employee.ser");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static ArrayList<GroupPersonnels> deserialize(String fileDest)
	{
		ArrayList<GroupPersonnels> e=null;
		try {
	         FileInputStream fileIn = new FileInputStream(fileDest);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (ArrayList<GroupPersonnels>) in.readObject();
	         in.close();
	         fileIn.close();
	         return e;
	      } catch (IOException i) {
	         i.printStackTrace();
	         return null;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return null;
	      }
	    
	}
	
	
}
