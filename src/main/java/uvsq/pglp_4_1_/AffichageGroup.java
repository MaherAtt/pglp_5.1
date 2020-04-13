package uvsq.pglp_4_1_;

import java.util.ArrayList;
import java.util.Iterator;

public class AffichageGroup {

	ArrayList<GroupPersonnels> grp=new ArrayList<GroupPersonnels>();
	GroupPersonnels groupedepers;
	public AffichageGroup(GroupPersonnels prem)
	{
		groupedepers=prem;
	}
	
	public Iterator iterator()
	{
		return new GrpIterator(groupedepers) ;
	}
	
	private class GrpIterator implements Iterator {
		int index;

		public GrpIterator(GroupPersonnels groupedepers)
		{
			grp.add(groupedepers);
			int verif=0;
			while(verif<grp.size())
			{ 	
				
				
			if(grp.get(verif) instanceof CompositePersonnels)
			for(int i=0;i<((CompositePersonnels) grp.get(verif)).personnes.size();i++)
			{
				grp.add(((CompositePersonnels) grp.get(verif)).personnes.get(i));
			}
			verif++;
			}
			
		}
		public boolean hasNext() {
			if(index>=grp.size())
			return false; else return true;
		}

		public Object next() {
			return grp.get(index++);
		}
		
		
	}
	
}
