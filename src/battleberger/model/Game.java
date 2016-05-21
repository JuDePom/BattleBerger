package battleberger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;

import battleberger.model.player.Computer;
import battleberger.model.player.Player;
import battleberger.model.player.Shot;
import battleberger.model.player.strategy.IStrategy;
import battleberger.model.player.strategy.StrategyDiagonal;
import battleberger.model.player.strategy.StrategyWithMemory;
import battleberger.model.player.strategy.StrategyYolo;
import battleberger.view.IDisplay;

public class Game extends Observable {

	public enum State {nothing, touched, sinked};
	private List<Player> players;
	private static int width, height;
	private boolean end=false;
	private IDisplay display;
	public IDisplay getDisplay() {
		return display;
	}
	public Player currentPlayer;

	private static List<IStrategy> strategies;
	static {
		strategies = new ArrayList<>();
		strategies.add(new StrategyYolo());
		strategies.add(new StrategyDiagonal());
		strategies.add(new StrategyWithMemory());
	}
	
	
	public Game(Player p1, Player p2, IDisplay disp){
		players = new ArrayList<>();
		addPlayer(p1);
		addPlayer(p2);
		setDisplay(disp);
		
	}


	public void play(){

		display.selectGridDimension();

		for(IStrategy strat : strategies){
			strat.setDim(width, height);
		}
		
		
		for(Player p : players){
			if(p instanceof Computer){
				((Computer)p).setStrat(strategies.get(2));
			}
			p.selectShips(display);
		}
		
		long start;
		while( ! isEndOfGame() ){
			start = System.currentTimeMillis();
			for(Player p : players){
				currentPlayer = p;
				Shot s;
				do{
					s = p.play(this);
					
				}while(s == null ||  s.getShip().getTimereload() > 0);
				//si le joueur ne passe pas son tour
				display.fire(p, s);
				p.setState(s, fire(p, s));
				s.getShip().setTimereload(s.getShip().getCooldown());
				
				if(isEndOfGame()) break;

				p.endOfTurnProcessing();
			}
			currentPlayer = null;
			

			display.updateGameGrid();
			
			waitfps(start);
		}
		
		end=true;
		
	}
	
	
	public void setStrategy(Strategies strat){
		Computer ia = null;
		for(Player p : players){
			if( p instanceof Computer){
				ia = (Computer)p;
			}
		}
		
		IStrategy strategy = null;
		switch(strat){
		case Yolo:
			strategy = strategies.get(0);
		case Diagonal:
			strategy = strategies.get(1);
		default:
			System.out.println("t'as oublié de gérer une stratégie monsieur le programmeur"); 
			//erreur
		}
		ia.setStrat(strategy);		
	}

	public State fire(Player p, Shot s){
		State ret = State.nothing;
		for(Player p2 : players){
			if(p2 != p){
				List<AbstractShip> toRemove = new ArrayList<>();
				for(AbstractShip ship : p2.getShips()){
					for(Entry<Square, Integer> sq : s.getSquares().entrySet()){
						if( ship.toucher(sq.getKey().getX(), sq.getKey().getY(), sq.getValue())){
							ret = State.touched;
							if( ! ship.isAlive()){
								toRemove.add(ship);
							}
						}
					}
				}
				for(AbstractShip ship : toRemove){
					p2.remove(ship);
					ret = State.sinked;
				}
			}
		}
		return ret;
	}
	
	private void waitfps(long start){
		try {
			Thread.sleep((long) Math.max( 100./6 - (System.currentTimeMillis() - start), 0)); //on fait du 60 fps
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	private boolean isEndOfGame(){
		int count = 0 ;
		for(Player p : players){
			if(p.nbShips() > 0){
				count++;
			}
		}
		return count == 1;
	}

	



	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public void setWidth(int width) {
		Game.width = width;
	}

	public void setHeight(int height) {
		Game.height = height;
	}


	public void setDisplay(IDisplay disp){
		display = disp;
		display.setGame(this);
	}
	
	public void addPlayer(Player p){
		players.add(p);
		p.setGame(this);
	}
	
	
	public static int getWidth(){
		return width;
	}
	
	public static int getHeight(){
		return height;
	}

	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	/**
	 * 
	 * @return la taille totale d'un terrain en nombre de case
	 */
	public int getWorldSize() {
		return getWidth() * getHeight();
	}
	
	public boolean end(){
		return end;
	}

}
