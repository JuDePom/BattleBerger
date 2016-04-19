package battleberger.backup.file.yml;

import battleberger.backup.DAO;
import battleberger.model.World;

public class YML_World implements DAO<World> {
	
	//private YML file;
	private YML_World() {}
	
	private static YML_World instance = null;
	public static DAO<World>  getInstance() {
		if ( instance == null) {
			instance = new YML_World();
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
