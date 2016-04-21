package battleberger.backup.file.yml;

import battleberger.backup.AbstractDAOFactory;
import battleberger.backup.DAO;
import battleberger.model.Game;

public class YML_Factory extends AbstractDAOFactory {

	@Override
	public DAO<Game> getGameDAO() {
		return YML_Game.getInstance();
	}
	
}
