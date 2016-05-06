package battleberger.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

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
		shippan.repaint();
		shoppan.repaint();
		gamepan.repaint();
		statspan.repaint();
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
		
		this.add(shippan, BorderLayout.NORTH);
		
		this.add(gamepan, BorderLayout.CENTER);
		this.add(shoppan, BorderLayout.EAST);
		
		this.pack();
		this.setVisible(true);
		
		this.repaint();
	}

	@Override
	public void selectGridDimension() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGameGrid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fire(Player p, Shot s) {
		// TODO Auto-generated method stub
		
	}

}
