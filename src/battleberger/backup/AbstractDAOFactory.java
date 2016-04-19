package battleberger.backup;

import battleberger.backup.db.mysql.MySQL_Factory;
import battleberger.backup.file.yml.YML_Factory;
import battleberger.model.World;

public abstract class AbstractDAOFactory {
	public abstract DAO<World> getWorldDAO();
	
	public static AbstractDAOFactory getAbstractDAOFactory(ExportType type){
		if (type == ExportType.YML) {
			return new YML_Factory();
		}
		
		if (type == ExportType.MySQL) {
			return new MySQL_Factory();
		}
		
		return null;
	}
}
