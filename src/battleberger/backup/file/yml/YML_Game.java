package battleberger.backup.file.yml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

import battleberger.model.Game;
import battleberger.backup.DAO;

public class YML_Game implements DAO<Game> {
	
	private YML_Game() {}
	
	private static YML_Game instance = null;
	public static DAO<Game> getInstance() {
		if ( instance == null) {
			instance = new YML_Game();
		}
		return instance;
	}
	
	@Override
	public Game load(String filepath) {
		Game game = null;
		YamlReader reader;
		try {
			reader = new YamlReader(new FileReader(filepath));
			game = (Game) reader.read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (YamlException e) {
			e.printStackTrace();
		}
		return game;
	}
	
	@Override
	public boolean save(Game obj, String filepath) {
		boolean success = true;
		try {
			YamlWriter writer = new YamlWriter(new FileWriter(filepath));
			writer.write(obj);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			success = false;
		} catch (YamlException e) {
			e.printStackTrace();
			success = false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return success;
	}
}