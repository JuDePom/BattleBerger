package battleberger;

import battleberger.model.Game;
import battleberger.model.player.Computer;
import battleberger.model.player.Human;
import battleberger.view.Window;

public class Main {

	public static void main(String[] args) {
		Game g = new Game( new Human(), new Computer(), new Window());
		g.play();
	}

}
