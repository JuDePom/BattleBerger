package battleberger.backup.db.mysql;

import battleberger.backup.DAO;
import battleberger.model.Game;

public class MySQL_Game implements DAO<Game> {
	
	//private MySQL mysql;
	private MySQL_Game() {}
	
	private static MySQL_Game instance = null;
	public static DAO<Game> getInstance() {
		if ( instance == null) {
			instance = new MySQL_Game();
		}
		return instance;
	}
	
	@Override
	public Game load(String filepath) {
		return null;
	}
	
	@Override
	public boolean save(Game obj, String filepath) {
		return false;
	}
}
