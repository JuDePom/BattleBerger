package battleberger.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.player.Human;
import battleberger.model.player.Player;
import battleberger.model.player.Shot;

@SuppressWarnings("serial")
public class Window extends JFrame implements Observer, IDisplay {
	private PlacementShipPanel shippan;
	private ShopPanel shoppan;
	private GamePanel gamepan;
	private StatusPanel statspan;
	private StartPanel startpan;

	Game game;

	public Window() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setPreferredSize(new Dimension(1000, 600));
	}

	@Override
	public void update(Observable o, Object arg) {
		/*if ( game.isPlacing() ){
			this.add(shippan, BorderLayout.NORTH);
		} else {
			this.add(statspan, BorderLayout.NORTH);
		}*/
	}

	@Override
	public void repaint() {
		super.repaint();
		gamepan.repaint();
		statspan.repaint();
		shippan.repaint();
		shoppan.repaint();
	}

	@Override
	public void setGame(Game g) {
		this.game = g;

		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		shippan = new PlacementShipPanel(game);
		gamepan = new GamePanel(game);
		shoppan = new ShopPanel(game);
		statspan = new StatusPanel(game);
		startpan = new StartPanel(game);

		this.add(gamepan, BorderLayout.CENTER);
		this.add(shoppan, BorderLayout.EAST);

		this.pack();
		this.setVisible(true);

		this.repaint();
	}

	@Override
	public void selectGridDimension() {
		// TODO Auto-generated method stub
		game.setWidth(20);
		game.setHeight(20);

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

	private boolean overlay(List<AbstractShip> ships) {
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
	public void placeShips(List<AbstractShip> ships) {
		this.remove(shippan);
		this.remove(statspan);


		this.add(startpan, BorderLayout.NORTH);
		
		while ( !startpan.start() ) {
			if ( overlay(ships) )
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
			Point spos = gamepan.getShotPos();
			
			if (sel != null && spos != null){
				shot = new Shot(sel.getFireshape(), spos.x, spos.y);
				break;
			}
		}
		return shot;
	}
	
	@Override
	public void fire(Player p, Shot s) {
		gamepan.fire(p, s);
	}


}
