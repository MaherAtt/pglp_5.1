package uvsq.pglp_4_1_;

import java.sql.Connection;

public interface Dao<T> {
	   
	  
	   
	 
	  
	  public abstract boolean create(T obj);
	
	  
	  public abstract boolean delete(T obj);

	 
	  public abstract boolean update(T obj);

	  
	  public abstract T find(int id);
	
	
}
