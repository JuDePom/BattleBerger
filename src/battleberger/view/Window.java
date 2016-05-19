package battleberger.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.player.Player;
import battleberger.model.player.Shot;

@SuppressWarnings("serial")
public class Window extends JFrame implements Observer,IDisplay {
	private PlacementShipPanel shippan;
	private ShopPanel shoppan;
	private GamePanel gamepan;
	private StatusPanel statspan;

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
	public void fire(Player p, Shot s) {
		// TODO Auto-generated method stub

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

		this.add(statspan, BorderLayout.NORTH);
		
		while (overlay(ships))
			;
		return;
	}


}
