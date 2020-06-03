package adaydoner.jpahibernatecourse05.dao;


public interface Dao<T>{
	
	public T findById(Long theId);
	
	public T save(T t);
	
	public void deleteById(Long theId);
	
	public void playWithEm();

}
