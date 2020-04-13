package uvsq.pglp_4_1_;

public class DaoFactory {

	public Dao<GroupPersonnels> getGroupDao()
	{
		return new PersonnelsDao();
	}
}
