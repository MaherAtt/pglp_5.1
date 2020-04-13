package uvsq.pglp_4_1_;
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
}
