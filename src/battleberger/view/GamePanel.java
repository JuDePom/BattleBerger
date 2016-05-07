package battleberger.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.Ship.Orientation;
import battleberger.model.player.Player;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	private Game game;
	private BufferedImage ocean;
	private Point mouse;
	
	int gw, gh, pw, ph, wpc, hpc, cs, dw, dh;

	public GamePanel(Game game) {
		this.game = game;
		this.setBackground(Color.BLACK);
		try {
			this.ocean = ImageIO.read(new File("./assets/images/ocean.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				movMouse(e.getPoint());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {}
		});
	}

	protected void movMouse(Point point) {
		mouse = point;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		gw = game.getWidth();
		gh = game.getHeight();

		pw = (this.getWidth()-1)/2;
		ph = this.getHeight();

		wpc = pw/gw;
		hpc = ph/gh;

		cs = (wpc < hpc ? wpc : hpc);

		if (cs < wpc)
			dw = pw - gw*cs;
		else
			dw = pw%cs;

		if (cs < hpc)
			dh = (ph - gh*cs)/2;
		else
			dh = (ph%cs)/2;

		g.drawImage(ocean, 0, 0, this.getWidth(), this.getHeight(), null);
		
		drawMyField(g);
		drawEnemyField(g);
		
		drawShips(g);
		
		drawMouse(g);
	}
	
	public void drawMyField(Graphics g){
		g.setColor(Color.CYAN);
		for (int x = 1; x<gw; x++){
			g.drawLine(dw + x*cs, dh, dw + x*cs, dh + 5);
			g.drawLine(dw + x*cs, dh + gh*cs, dw + x*cs, dh + gh*cs - 5);
		}

		for (int y = 1; y<gh; y++){
			g.drawLine(dw, dh + y*cs, dw + 5, dh + y*cs);
			g.drawLine(dw + gh*cs, dh + y*cs, dw + gh*cs - 5, dh + y*cs);
		}
	}
	
	public void drawEnemyField(Graphics g){
		g.setColor(Color.RED);
		for (int x = 1; x<gw; x++){
			g.drawLine(pw + x*cs, dh, pw + x*cs, dh + 5);
			g.drawLine(pw + x*cs, dh + gh*cs, pw + x*cs, dh + gh*cs - 5);
		}

		for (int y = 1; y<gh; y++){
			g.drawLine(pw, dh + y*cs, pw + 5, dh + y*cs);
			g.drawLine(pw + gh*cs, dh + y*cs, pw + gh*cs - 5, dh + y*cs);
		}
	}
	
	public void drawShips(Graphics g){
		g.setColor(Color.GRAY);
		List<Player> players = game.getPlayers();
		
		Player me = players.get(0);
		for (int n = 0; n < me.nbShips(); n++){	
			AbstractShip ship = me.getShip(n);
			
			int x = ship.getPositionX();
			int y = ship.getPositionY();
			
			boolean[][] shape = ship.getShape();
			
			BufferedImage img = RessourceManager.getImage(ship.getImagepath());
			
			int imgCW = 0;
			int imgCH = 0;
			
			if (img != null) {
				img = setOrientation(img, ship.getOrient());
				
				imgCW = img.getWidth() / shape.length;
				imgCH = img.getHeight() / shape[0].length;
			}
			
			for (int i = 0; i < shape.length; i++){
				for (int j = 0; j < shape[i].length; j++){
					if (shape[i][j]){
						if (img != null){
							BufferedImage sub = img.getSubimage(i*imgCW, j*imgCH, imgCW, imgCH);
							g.drawImage(sub, dw + (x + i)* cs, dh + (y + j) * cs, cs, cs, null);
						}else{
							g.fillRect(dw + (x + i)* cs, dh + (y + j) * cs, cs, cs);
						}
					}
				}
			}
		}
		
		Player enemy = players.get(1);
		for (int n = 0; n < enemy.nbShips(); n++){	
			AbstractShip ship = enemy.getShip(n);
			
			int x = ship.getPositionX();
			int y = ship.getPositionY();
			
			boolean[][] shape = ship.getShape();
			
			for (int i = 0; i < shape.length; i++){
				for (int j = 0; j < shape[i].length; j++){
					if (shape[i][j]){
						g.fillRect(pw + (x + i)* cs, dh + (y + j) * cs, cs, cs);
					}
				}
			}
		}
	}
	
	private BufferedImage setOrientation(BufferedImage img, Orientation orient) {
		int w = img.getWidth();
	    int h = img.getHeight();
	    
		BufferedImage imgFlip;
		switch (orient){
		case North:
			imgFlip = img;
			break;
		case East:
			imgFlip = new BufferedImage(h, w, img.getType());
			for(int i=0; i<w; i++)
		        for(int j=0; j<h; j++)
		            imgFlip.setRGB(h-1-j, w-1-i, img.getRGB(i, j));
			break;
		case South:
			imgFlip = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
			for(int i=0; i<w; i++)
		        for(int j=0; j<h; j++)
		            imgFlip.setRGB(w-1-i, h-1-j, img.getRGB(i, j));
			break;
		case West:
			imgFlip = new BufferedImage(img.getHeight(), img.getWidth(), img.getType());
			for(int i=0; i<w; i++)
		        for(int j=0; j<h; j++)
		            imgFlip.setRGB(j, w-1-i, img.getRGB(i, j));
			break;
		default:
			imgFlip = img;
		}
		
		return imgFlip;
	}

	public void drawMouse(Graphics g){
		Color myColour = new Color(0, 255, 255, 50);
		Color enemyColour = new Color(255, 0, 0, 100);
		
		
		if ( mouse != null){
			if (mouse.x < pw){
				g.setColor(myColour);
				mouse.x -= dw; mouse.y -= dh;
				mouse.x /= cs; mouse.y /= cs;

				if ( mouse.x >= 0 && mouse.x < gw && mouse.y >= 0 && mouse.y < gh)
					g.fillRect(dw + mouse.x*cs, dh + mouse.y*cs, cs, cs);
			} else {
				g.setColor(enemyColour);
				mouse.x -= pw; mouse.y -= dh;
				mouse.x /= cs; mouse.y /= cs;

				if ( mouse.x >= 0 && mouse.x < gw && mouse.y >= 0 && mouse.y < gh)
					g.fillRect(pw + mouse.x*cs, dh + mouse.y*cs, cs, cs);
			}
		}
	}
}
