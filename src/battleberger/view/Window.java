package battleberger.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.player.Player;
import battleberger.model.player.Shot;

@SuppressWarnings("serial")
public class Window extends JFrame implements Observer,IDisplay {
	
	@Override
	public void selectGridDimension() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGame(Game g) {
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

	private ShopPanel shoppan;
	private GamePanel gamepan;
	private StatusPanel statspan;
	
	@Override
	public AbstractShip selectShip(Player p) {
		// TODO Auto-generated method stub
		return null;
	}

	public Window(Game game) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setPreferredSize(new Dimension(1000, 600));
		
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		
		gamepan = new GamePanel(game);
		shoppan = new ShopPanel(game);
		statspan = new StatusPanel(game);
		
		this.add(gamepan, BorderLayout.CENTER);
		this.add(shoppan, BorderLayout.EAST);
		this.add(statspan, BorderLayout.NORTH);
		
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {}

}
