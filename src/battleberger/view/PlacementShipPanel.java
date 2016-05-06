package battleberger.view;

import java.awt.Dimension;
import java.awt.Graphics;
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
	
	public PlacementShipPanel(Game game) {
		this.setPreferredSize(new Dimension(0, 150));
		
		
		for (TypeShip type : Ship.TypeShip.values()){
			ships.put(type, ShipyardDefault.orderShip(type));
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		int h = this.getHeight();
		
		int cs = h / 7;
		
		int x = 1;
		int y = 1;
		
		for (AbstractShip ship : ships.values()){
			boolean[][] shape = ship.getShape();
			
			g.drawString(ship.getClass().getSimpleName(), x*cs - cs/2, 1*cs - 5);
			for (int i = 0; i < shape.length; i++, x++){
				for (int j = 0; j < shape[0].length; j++){
					ship.setPositionX(x);
					ship.setPositionY(y);
					if (shape[i][j])
						g.fillRect((x)*cs, (y+j) * cs, cs, cs);
				}
			}
			
			x += 2;
		}
	}
}
