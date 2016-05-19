package battleberger.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.Ship;
import battleberger.model.Ship.TypeShip;
import battleberger.model.ShipyardDefault;

@SuppressWarnings("serial")
public class PlacementShipPanel extends JPanel{
	Map<TypeShip, AbstractShip> ships = new HashMap<TypeShip, AbstractShip>();
	
	int credits;
	boolean buyable = false;
	int cs = 0; // pour me simplifier la vie
	AbstractShip choosen = null;
	
	public PlacementShipPanel(Game game) {
		this.setPreferredSize(new Dimension(0, 150));
		
		for (TypeShip type : Ship.TypeShip.values()){
			ships.put(type, ShipyardDefault.orderShip(type));
		}
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				actionIn(e.getX(), e.getY());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		int h = this.getHeight();
		
		cs = h / 7;
		
		int x = 1;
		int y = 1;
		
		for (AbstractShip ship : ships.values()){
			boolean[][] shape = ship.getShape();
			
			BufferedImage img = RessourceManager.getImage(ship.getImagepath());
			int imgCW = 0;
			int imgCH = 0;
			
			if (img != null) {
				imgCW = img.getWidth() / shape.length;
				imgCH = img.getHeight() / shape[0].length;
			}
			
			
			
			if (buyable) {
				if (ship.shipValue() <= credits)
					g.setColor(Color.ORANGE);
				else
					g.setColor(Color.LIGHT_GRAY);
				g.fillRect(x*cs -cs/2, h-cs, ship.getWidth()*cs + cs, cs);
				
				g.setColor(Color.BLACK);
				g.drawRect(x*cs -cs/2, h-cs, ship.getWidth()*cs + cs, cs-1);
				
				g.drawString("Cost: "+ship.shipValue(), x*cs + ship.getWidth()*cs/2 - 17, h-5);
			}
			
			g.drawString(ship.getClass().getSimpleName(), x*cs - cs/2, 1*cs - 5);
			
			for (int i = 0; i < shape.length; i++, x++){
				for (int j = 0; j < shape[0].length; j++){
					ship.setPositionX(x);
					ship.setPositionY(y);
					if (shape[i][j]){
						if (img != null){
							BufferedImage sub = img.getSubimage(i*imgCW, j*imgCH, imgCW, imgCH);
							g.drawImage(sub, x*cs, (y+j) * cs, cs, cs, null);
						}else{
							g.fillRect((x)*cs, (y+j) * cs, cs, cs);
						}
					}
				}
			}
			
			x += 2;
		}
	}

	public void setBuyable(int maxShipValue) {
		credits = maxShipValue;
		buyable = true;
		repaint();
	}
	
	public void actionIn(int mouseX, int mouseY){
		int x = 1;
		int h = this.getHeight();
		
		for (AbstractShip ship : ships.values()){
			
			if (ship.shipValue() <= credits){
				if (mouseX > x*cs - cs/2
					&& mouseX < x*cs + ship.getWidth()*cs + cs/2
					&& mouseY > h-cs)
					choosen = ShipyardDefault.orderShip(ship.getType());
				}
			
			x += 2 + ship.getWidth();
		}
	}

	public AbstractShip getChoosen() {
		AbstractShip tmp = null;
		do {
			tmp = choosen;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {}
		} while (tmp == null);
		choosen = null;
		return tmp;
	}
}
