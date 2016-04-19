package battleberger;

import java.util.Observable;

import battleberger.model.Player;
import battleberger.model.World;

public class Game extends Observable {
	World world;
	Player[] players = new Player[2];
}
