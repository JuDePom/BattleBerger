package battleberger.backup;

public interface DAO<T> {
	public T load(String filepath);
	public boolean save(T object, String filepath);
}
