package battleberger.model.player;

import java.util.HashMap;
import java.util.Map;

import battleberger.model.Square;

public class Shot {
	
	private Map<Square,Integer> squares;
	

	public Shot(){
		squares = new HashMap<Square, Integer>();
	}

	
	public Shot(HashMap<Square, Integer> sqrs){
		squares = sqrs;
	}
	
	public Map<Square, Integer> getSquares() {
		return squares;
	}

	public void addSquare(Square square, int damage) {
		this.squares.put(square, damage);
	}
	
}
