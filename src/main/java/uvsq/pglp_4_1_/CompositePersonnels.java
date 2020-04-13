package uvsq.pglp_4_1_;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
public class CompositePersonnels implements GroupPersonnels,Serializable {

	
	int id;
	ArrayList<GroupPersonnels> personnes= new ArrayList<GroupPersonnels>();
	public CompositePersonnels(int id)
	{
		this.id=id;
	}
	public void add(GroupPersonnels grp)
	{
		personnes.add(grp);
	}
	
	public void remove(GroupPersonnels grp)
	{
		personnes.remove(grp);
	}
	
	public void print() {
		System.out.println(id);
		for(int k=0;k<personnes.size();k++)
		{
			personnes.get(k).print();
		}
	}
	
	public void serialize(String fileDest)
	{
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream(fileDest);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/employee.ser");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static CompositePersonnels deserialize(String fileDest)
	{
		CompositePersonnels e=null;
		try {
	         FileInputStream fileIn = new FileInputStream(fileDest);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (CompositePersonnels) in.readObject();
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
