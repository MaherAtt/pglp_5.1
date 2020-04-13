package uvsq.pglp_4_1_;

import java.util.ArrayList;

public class PersonnelsDao implements Dao<GroupPersonnels> {

	public boolean create(GroupPersonnels obj) {
		ArrayList<GroupPersonnels> listPers=MySerialize.deserialize("personnel.txt");
		listPers.add(obj);
		MySerialize.serialize(listPers,"personnel.txt");	
		return true;
	}

	public boolean delete(int toDelete) {
		ArrayList<GroupPersonnels> listPers=MySerialize.deserialize("personnel.txt");
	    listPers.remove(toDelete);
		MySerialize.serialize(listPers,"personnel.txt");	
		return true;
	}

	public boolean update(GroupPersonnels obj,int pos) {
		ArrayList<GroupPersonnels> listPers=MySerialize.deserialize("personnel.txt");
	    listPers.set(pos, obj);
		MySerialize.serialize(listPers,"personnel.txt");
		return false;
	}

	public GroupPersonnels find(int id) {
		ArrayList<GroupPersonnels> listPers=MySerialize.deserialize("personnel.txt");
	    return listPers.get(id);
	}

	public boolean delete(GroupPersonnels obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(GroupPersonnels obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
