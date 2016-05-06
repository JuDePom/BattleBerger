package battleberger;

import battleberger.model.Game;
import battleberger.model.player.Computer;
import battleberger.model.player.Human;
import battleberger.model.player.strategy.StrategyYolo;
import battleberger.view.Window;

public class Main {

	public static void main(String[] args) {
		Game g = new Game( new Computer(new StrategyYolo()), new Computer(new StrategyYolo()), new Window());
		g.play();
	}

}
