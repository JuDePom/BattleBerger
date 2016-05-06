package battleberger.model.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import battleberger.model.Game;
import battleberger.model.Square;

public class Shot {
	
	private Map<Square,Integer> squares;
	

	public Shot(int[][] shape, int x, int y){
		
		squares = new HashMap<Square, Integer>();

		for(int i = x ; i < Math.min(Game.getWidth(), x + shape.length) ; i++){//TODO vérifier que ça va bien jusqu'au bout
			for(int j = y ; j < Math.min(Game.getHeight(), y + shape[0].length) ; j++){//TODO idem
				if(shape[i - x][j -y] > 0 ){
					squares.put(new Square(i,j), shape[i-x][j-y]);
				}
			}
		}
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
