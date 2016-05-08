package battleberger.view;

import java.util.List;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.player.Player;
import battleberger.model.player.Shot;

public interface IDisplay {

	

	void selectGridDimension();
	
	void setGame(Game g);
	
	void updateGameGrid();
	
	void fire(Player p, Shot s);
	
	public AbstractShip selectShip(Player p);

	List<AbstractShip> placeShips(int maxShipValue);
}
