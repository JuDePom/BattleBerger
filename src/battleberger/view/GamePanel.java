package battleberger.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.Game.State;
import battleberger.model.Square;
import battleberger.model.Ship.Orientation;
import battleberger.model.player.Player;
import battleberger.model.player.Shot;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Serializable{
	private Game game;
	private transient BufferedImage ocean;
	private transient BufferedImage fail;
	private transient BufferedImage hit;
	private transient BufferedImage sinked;

	private List<Pair> shots = Collections.synchronizedList(new ArrayList<Pair>());

	private Point cmouse = new Point();
	private Point mouse, shot;

	boolean lock = false;
	boolean drag = false;
	boolean play = false;

	AbstractShip shipSel = null;

	int gw, gh, pw, ph, wpc, hpc, cs, dw, dh;

	public GamePanel(Game game) {
		this.game = game;
		fail=RessourceManager.getImage("./assets/images/Fail");
		hit=RessourceManager.getImage("./assets/images/Hit");
		sinked=RessourceManager.getImage("./assets/images/Sinked");
		
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
			public void mouseDragged(MouseEvent e) {
				dragMouse(e.getPoint());
			}
		});

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}
		});
	}

	protected void movMouse(Point point) {
		mouse = point;
		cmouse.x = mouse.x - dw; cmouse.y = mouse.y - dh;
		cmouse.x /= cs; cmouse.y /= cs;
		drag = false;
		
		this.updateUI();
	}

	protected void dragMouse(Point point) {
		mouse = point;
		cmouse.x = mouse.x - dw; cmouse.y = mouse.y - dh;
		cmouse.x /= cs; cmouse.y /= cs;

		if (lock) return;

		List<Player> players = game.getPlayers();
		Player me = players.get(0);

		if (!drag){
			for (AbstractShip ship : me.getShips()){	
				if ( ship.overlap(cmouse.x, cmouse.y) )
					shipSel = ship;
			}
		}

		if (shipSel != null){
			drag = true;

			if (cmouse.x >= 0 && cmouse.x + shipSel.getWidth() <= gw)
				shipSel.setPositionX(cmouse.x);
			if (cmouse.y >= 0 && cmouse.y + shipSel.getHeight() <= gh) 
				shipSel.setPositionY(cmouse.y);
		}

		this.updateUI();
	}

	protected void click(){
		List<Player> players = game.getPlayers();
		Player me = players.get(0);

		for (AbstractShip ship : me.getShips()){	
			if ( ship.overlap(cmouse.x, cmouse.y) )
				shipSel = ship;
		}

		if(!lock && shipSel != null){ // rotation car placement


			Orientation or = shipSel.getOrient();
			Orientation[] ors = Orientation.values();
			boolean chg = false;
			for (int i = 0; i < ors.length - 1; i++) {
				if (ors[i] == or){
					shipSel.setOrient(ors[i+1]);
					chg = true;
				}
			}

			if (!chg)
				shipSel.setOrient(ors[0]);
		}

		if (lock) { // SHOT
			cmouse.x = mouse.x - pw - dw; cmouse.y = mouse.y - dh;
			cmouse.x /= cs; cmouse.y /= cs;

			if (cmouse.x >= 0 && cmouse.x <= gw && cmouse.y >= 0 && cmouse.y <= gw)
				shot = cmouse;
		}

		this.updateUI();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		gw = Game.getWidth();
		gh = Game.getHeight();

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
		
		drawFireShape(g);
	}

	private void drawFireShape(Graphics g) {
		if (shipSel!=null && lock){
			if (mouse.x > pw){
				cmouse.x = mouse.x - pw - dw; cmouse.y = mouse.y - dh;
				cmouse.x /= cs; cmouse.y /= cs;
				
				int[][] shape = shipSel.getFireshape();
				
				for (int i = 0; i < shape.length; i++){
					for (int j = 0; j < shape[i].length; j++){
						if (shape[i][j] > 0){
							g.setColor(Color.CYAN);
							g.drawRect(pw + (cmouse.x + i)* cs, dh + (cmouse.y + j) * cs, cs, cs);
							g.setColor(new Color(0, 150, 255, 100));
							g.fillRect(pw + (cmouse.x + i)* cs, dh + (cmouse.y + j) * cs, cs, cs);
						}
					}
				}
			}
		}
	}

	public void drawMyField(Graphics g){
		g.setColor(new Color(255, 0, 0, 50));
		for (Pair sh : shots)
			if (sh.player == game.getPlayers().get(1))
				for ( Square sq : sh.shot.getSquares().keySet() )
					if (sq.getX() >= 0 && sq.getX() <= gw && sq.getY() >= 0 && sq.getY() <= gh){
						g.fillRect(dw + sq.getX()* cs, dh + sq.getY() * cs, cs, cs);
					}
						
					

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
		g.setColor(new Color(255, 0, 0, 50));
		for (Pair sh : shots)
			if (sh.player == game.getPlayers().get(0))
				for ( Square sq : sh.shot.getSquares().keySet() )
					if (sq.getX() >= 0 && sq.getX() <= gw && sq.getY() >= 0 && sq.getY() <= gh)
						
						switch(game.state()[sq.getX()][sq.getY()]){
						case nothing:
							//g.setColor(new Color(255, 0, 0, 50));
							//g.fillRect(pw + sq.getX()* cs, dh + sq.getY() * cs, cs, cs);
							g.drawImage(fail, pw + sq.getX()* cs, dh+ sq.getY() * cs, cs, cs, null);
							break;
						case touched :
						//	g.setColor(new Color(0,255,0,255));
							//g.fillRect(pw + sq.getX()* cs, dh + sq.getY() * cs, cs, cs);
							g.drawImage(hit, pw + sq.getX()* cs, dh+ sq.getY() * cs, cs, cs, null);
							break;
						case sinked: 
						//	g.setColor(new Color(0,0,255,255));
						//	g.fillRect(pw + sq.getX()* cs, dh + sq.getY() * cs, cs, cs);
							g.drawImage(sinked, pw + sq.getX()* cs, dh+ sq.getY() * cs, cs, cs, null);
							break;
						}
						
		
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
			BufferedImage imgDmg = RessourceManager.getImage(ship.getImagepath()+"_0");

			int imgCW = 0;
			int imgCH = 0;

			if (img != null) {
				img = setOrientation(img, ship.getOrient());

				if (imgDmg != null)
					imgDmg = setOrientation(imgDmg, ship.getOrient());

				imgCW = img.getWidth() / shape.length;
				imgCH = img.getHeight() / shape[0].length;
			}

			for (int i = 0; i < shape.length; i++){
				for (int j = 0; j < shape[i].length; j++){
					if (shape[i][j]){
						if (img != null){
							if (ship.getLives()[i][j] <= 0 && imgDmg != null){
								BufferedImage sub = imgDmg.getSubimage(i*imgCW, j*imgCH, imgCW, imgCH);
								g.drawImage(sub, dw + (x + i)* cs, dh + (y + j) * cs, cs, cs, null);
							} else {	
								BufferedImage sub = img.getSubimage(i*imgCW, j*imgCH, imgCW, imgCH);
								g.drawImage(sub, dw + (x + i)* cs, dh + (y + j) * cs, cs, cs, null);
							}
						}else{
							g.fillRect(dw + (x + i)* cs, dh + (y + j) * cs, cs, cs);
						}
					}
				}
			}
		}
/*
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
		*/
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


		if ( cmouse != null){
			if (cmouse.x < pw){
				g.setColor(myColour);
				if ( cmouse.x >= 0 && cmouse.x < gw && cmouse.y >= 0 && cmouse.y < gh)
					g.fillRect(dw + cmouse.x*cs, dh + cmouse.y*cs, cs, cs);
			} else {
				g.setColor(enemyColour);

				if ( cmouse.x >= gw && cmouse.x < gw*2 && cmouse.y >= 0 && cmouse.y < gh)
					g.fillRect(pw + cmouse.x*cs, dh + cmouse.y*cs, cs, cs);
			}
		}
	}

	public void startTurn() {
		play = true;
	}

	public boolean isTurnEnded() {
		return !play;
	}

	public AbstractShip getSelectedShip() {
		return shipSel;
	}

	public Point getShotPos() {
		Point tmp = null;
		if (shot != null){
			tmp = shot;
			shot = null;
		}
		return tmp;
	}

	public void fire(Player p, Shot s) {
		shots.add(new Pair(p, s));
	}

	class  Pair implements Serializable{
		public Pair(Player p, Shot s) {
			shot = s;
			player = p;
		}
		Shot shot;
		Player player;
	}
	
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public BufferedImage getOcean() {
		return ocean;
	}

	public void setOcean(BufferedImage ocean) {
		this.ocean = ocean;
	}

	public List<Pair> getShots() {
		return shots;
	}

	public void setShots(List<Pair> shots) {
		this.shots = shots;
	}

	public Point getCmouse() {
		return cmouse;
	}

	public void setCmouse(Point cmouse) {
		this.cmouse = cmouse;
	}

	public Point getMouse() {
		return mouse;
	}

	public void setMouse(Point mouse) {
		this.mouse = mouse;
	}

	public Point getShot() {
		return shot;
	}

	public void setShot(Point shot) {
		this.shot = shot;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public boolean isDrag() {
		return drag;
	}

	public void setDrag(boolean drag) {
		this.drag = drag;
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public AbstractShip getShipSel() {
		return shipSel;
	}

	public void setShipSel(AbstractShip shipSel) {
		this.shipSel = shipSel;
	}

	public int getGw() {
		return gw;
	}

	public void setGw(int gw) {
		this.gw = gw;
	}

	public int getGh() {
		return gh;
	}

	public void setGh(int gh) {
		this.gh = gh;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

	public int getWpc() {
		return wpc;
	}

	public void setWpc(int wpc) {
		this.wpc = wpc;
	}

	public int getHpc() {
		return hpc;
	}

	public void setHpc(int hpc) {
		this.hpc = hpc;
	}

	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}

	public int getDw() {
		return dw;
	}

	public void setDw(int dw) {
		this.dw = dw;
	}

	public int getDh() {
		return dh;
	}

	public void setDh(int dh) {
		this.dh = dh;
	}
}
