package battleberger.backup.serialization;

import battleberger.backup.AbstractDAOFactory;
import battleberger.backup.DAO;
import battleberger.model.Game;

public class Serialization_Factory extends AbstractDAOFactory{

	@Override
	public DAO<Game> getGameDAO() {
		return new Serialization_Game();
	}

}
