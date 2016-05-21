package battleberger.view;

import java.util.List;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShip.TimeSpace;
import battleberger.model.Game;
import battleberger.model.player.Human;
import battleberger.model.player.Player;
import battleberger.model.player.Shot;

public interface IDisplay {

	void endOfGame();

	void selectGridDimension();
	
	void setGame(Game g);
	
	void updateGameGrid();
	
	void fire(Player p, Shot s);
	
	public AbstractShip selectShip(Player p);

	void placeShips(List<AbstractShip> ships);
	
	Shot getShot(Human h);

	void clean();
	void replay();
	
	TimeSpace getEra();
	
	void refresh();
}
