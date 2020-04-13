package uvsq.pglp_4_1_;

import java.io.FileNotFoundException;

public class DaoFactory {

	public static Dao<GroupPersonnels> getGroupDao() throws FileNotFoundException
	{
		return new PersonnelsDao();
	}
}
