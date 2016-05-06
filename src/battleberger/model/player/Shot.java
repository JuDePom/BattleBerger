package battleberger.model.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	
	
	public String toString(){
		String s = "";
		for(Entry<Square, Integer> sq : squares.entrySet()){
			s +=  sq.getKey().toString() +" damage: " + sq.getValue().toString() + "\n";
		}
		return s;
		
		
	}
	
}
