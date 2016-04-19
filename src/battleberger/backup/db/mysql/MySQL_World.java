package battleberger.backup.db.mysql;

import battleberger.backup.DAO;
import battleberger.model.World;

public class MySQL_World implements DAO<World> {
	
	//private MySQL mysql;
	private MySQL_World() {}
	
	private static MySQL_World instance = null;
	public static DAO<World> getInstance() {
		if ( instance == null) {
			instance = new MySQL_World();
		}
		return instance;
	}
	
	@Override
	public World load(int id) {
		return null;
	}
	
	@Override
	public boolean save(World obj) {
		return false;
	}
}
