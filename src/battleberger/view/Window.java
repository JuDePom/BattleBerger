package battleberger.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.border.Border;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShip.TimeSpace;
import battleberger.model.Game;
import battleberger.model.player.Computer;
import battleberger.model.player.Human;
import battleberger.model.player.Player;
import battleberger.model.player.Shot;
import sun.util.calendar.Era;

@SuppressWarnings("serial")
public class Window extends JFrame implements Serializable, IDisplay {
	

	private PlacementShipPanel shippan;
	private ShopPanel shoppan;
	private GamePanel gamepan;
	private StatusPanel statspan;
	private StartPanel startpan;
	private EndScreen endpan;
	private MenuBar menubar; 
	private EraPanel eraPanel;
	Game game;

	
	public Window() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setPreferredSize(new Dimension(1000, 600));
		 
	}



	@Override
	public void repaint() {
		super.repaint();
		eraPanel.repaint();
		gamepan.repaint();
		statspan.repaint();
		shippan.repaint();
		shoppan.repaint();
		endpan.repaint();
	}

	@Override
	public void setGame(Game g) {
		this.game = g;

		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		if(eraPanel != null) remove(eraPanel);
		if(shippan != null) remove(shippan);
		if(gamepan != null) remove(gamepan);
		if(shoppan != null) remove(shoppan);
		if(statspan != null) remove(statspan);
		if(startpan != null) remove(startpan);
		if(menubar != null) remove(menubar);

		shippan = new PlacementShipPanel(game);
		gamepan = new GamePanel(game);
		shoppan = new ShopPanel(game);
		statspan = new StatusPanel(game);
		startpan = new StartPanel(game);
		endpan = new EndScreen(game);
		menubar = new MenuBar(game, this);
		
		eraPanel = new EraPanel();
		
		
		
		loadWindow();
	}

	
	private void loadWindow(){
		this.remove(eraPanel);
		switch(game.gameState){
		case EraSelection:
			add(eraPanel, BorderLayout.CENTER);
			break;
		case Preparing:
			this.add(gamepan, BorderLayout.CENTER);
			this.add(shoppan, BorderLayout.EAST);
			this.add(shippan, BorderLayout.NORTH);
			setJMenuBar(menubar);
			break;
		case Playing:
			setJMenuBar(menubar);
			this.add(gamepan, BorderLayout.CENTER);
			this.add(shoppan, BorderLayout.EAST);
			add(statspan, BorderLayout.NORTH);
			gamepan.setLock(true);
			
			break;
		case EndScreen:
			add(endpan);
			endpan.refresh();
			break;			
		}
		
		
		this.pack();
		this.setVisible(true);

		this.repaint();
	}
	
	
	@Override
	public TimeSpace getEra() {
		loadWindow();
		return eraPanel.getEra();
	}

	@Override
	public void selectGridDimension() {
		game.setWidth(20);
		game.setHeight(20);
		loadWindow();

	}

	@Override
	public void updateGameGrid() {
		repaint();

	}

	@Override
	public AbstractShip selectShip(Player p) {
		this.remove(shippan);
		this.remove(statspan);

		this.add(shippan, BorderLayout.NORTH);

		shippan.setBuyable(p.getMaxShipValue());
		AbstractShip choosen = null;
		
		do
			choosen = shippan.getChoosen();
		while (choosen == null);
		
		return choosen;
	}

	private boolean overlap(List<AbstractShip> ships) {
		for (AbstractShip ship : ships){
			boolean[][] shape = ship.getShape();
			int x = ship.getPositionX();
			int y = ship.getPositionY();
			for(int i = 0 ;i < shape.length ; i++){
				for(int j = 0 ; j < shape[0].length ; j++){
					if(shape[i][j]){
						for(AbstractShip sship : ships){
							if(ship != sship && sship.overlap(x + i, y + j)){
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}
	
	

	@Override
	public void endOfGame() {
		clean();
		this.add(endpan);
		endpan.refresh();
		
	}

	@Override
	public void placeShips(List<AbstractShip> ships) {
		this.remove(shippan);
		this.remove(statspan);


		this.add(startpan, BorderLayout.NORTH);
		
		while ( !startpan.start() ) {
			if ( overlap(ships) )
				startpan.setDisable();
			else
				startpan.setEnable();
			
			startpan.repaint();
		}
		gamepan.lock = true;
		
		this.remove(startpan);
		this.add(statspan, BorderLayout.NORTH);
		
		
		return;
	}

	@Override
	public void refresh() {
		updateGameGrid();
	}

	@Override
	public Shot getShot(Human h) {
		AbstractShip sel = null;
		Shot shot = null;
		gamepan.startTurn();
		while (!gamepan.isTurnEnded()){
			sel = gamepan.getSelectedShip();
			shoppan.refresh(sel);
			statspan.refresh(sel);
			Point spos = gamepan.getShotPos();
			
			if (sel != null && spos != null){
				shot = new Shot( spos.x, spos.y, sel);
				break;
			}
		}
		return shot;
	}
	
	@Override
	public void fire(Player p, Shot s) {
		gamepan.fire(p, s);
	}

	
	
	
	
	
	
	public PlacementShipPanel getShippan() {
		return shippan;
	}

	public void setShippan(PlacementShipPanel shippan) {
		this.shippan = shippan;
	}

	public ShopPanel getShoppan() {
		return shoppan;
	}

	public void setShoppan(ShopPanel shoppan) {
		this.shoppan = shoppan;
	}

	public GamePanel getGamepan() {
		return gamepan;
	}

	public void setGamepan(GamePanel gamepan) {
		this.gamepan = gamepan;
	}

	public StatusPanel getStatspan() {
		return statspan;
	}

	public void setStatspan(StatusPanel statspan) {
		this.statspan = statspan;
	}

	public StartPanel getStartpan() {
		return startpan;
	}

	public void setStartpan(StartPanel startpan) {
		this.startpan = startpan;
	}

	public MenuBar getMenubar() {
		return menubar;
	}

	public void setMenubar(MenuBar menubar) {
		this.menubar = menubar;
	}

	public Game getGame() {
		return game;
	}

	
	public void clean() {
		remove(shoppan);
		remove(gamepan);
		remove(statspan);
	}

	@Override
	public void replay() {
		remove(endpan);
		
		this.setMenubar(null);
		game=new Game(new Human(),new Computer(),this);
		Thread t=new Thread(){
			@Override
			public void run(){
				game.play();
			}
		};
		t.start();
	}


}
