package battleberger.backup;

import battleberger.backup.db.mysql.MySQL_Factory;
import battleberger.backup.file.yml.YML_Factory;
import battleberger.backup.serialization.Serialization_Factory;
import battleberger.model.Game;

public abstract class AbstractDAOFactory {
	public abstract DAO<Game> getGameDAO();
	
	public static AbstractDAOFactory getAbstractDAOFactory(ExportType type){
		switch (type){
		case YML:
			return new YML_Factory();
		case MySQL:
			return new MySQL_Factory();
		case Serialize:
			return new Serialization_Factory();
		default:
			System.out.println("le programmeur a oublié une façon de sauvegarder/charger les fichier: " + type.toString());
		}
		
		return null;
	}
}
