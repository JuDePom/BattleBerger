package battleberger;

import battleberger.model.Game;
import battleberger.model.GameWrapper;
import battleberger.model.player.Computer;
import battleberger.model.player.Human;
import battleberger.view.Window;

public class Main {

	public static void main(String[] args) {
		GameWrapper gw = new GameWrapper(new Game( new Human(), new Computer(), new Window()));
		
		gw.play();
	}

}
