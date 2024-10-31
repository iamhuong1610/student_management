package DAO;

import java.util.List;

public interface DAO<T> {
	public List<T> getALL();
	public boolean add(T t);
	public boolean update(T t);
	public boolean delete(int id);
}
