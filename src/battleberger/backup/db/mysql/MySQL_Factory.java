package battleberger.backup.db.mysql;

import battleberger.backup.AbstractDAOFactory;
import battleberger.backup.DAO;
import battleberger.model.World;

public class MySQL_Factory extends AbstractDAOFactory {

	@Override
	public DAO<Game> getGameDAO() {
		return MySQL_Game.getInstance();
	}
	
}
