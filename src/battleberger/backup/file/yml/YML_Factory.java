package battleberger.backup.file.yml;

import battleberger.backup.AbstractDAOFactory;
import battleberger.backup.DAO;
import battleberger.model.World;

public class YML_Factory extends AbstractDAOFactory {

	@Override
	public DAO<World> getWorldDAO() {
		return YML_World.getInstance();
	}
	
}
