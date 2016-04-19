package battleberger.backup.db.mysql;

import battleberger.backup.AbstractDAOFactory;
import battleberger.backup.DAO;
import battleberger.model.World;

public class MySQL_Factory extends AbstractDAOFactory {

	@Override
	public DAO<World> getWorldDAO() {
		return MySQL_World.getInstance();
	}
	
}
