package battleberger;

import battleberger.model.Game;
import battleberger.model.player.Human;
import battleberger.view.Console;

public class Main {

	public static void main(String[] args) {
		Game g = new Game( new Human(), new Human(), new Console());
		g.play();
	}

}
