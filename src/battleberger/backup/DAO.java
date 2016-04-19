package battleberger.backup;

public interface DAO<T> {
	public T load(int id);
	public boolean save(T object);
}
