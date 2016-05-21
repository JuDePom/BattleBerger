package battleberger.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

import javax.swing.JPanel;

import battleberger.model.Game;

@SuppressWarnings("serial")
public class StartPanel extends JPanel implements Serializable{
	
	Color color = Color.GRAY;
	boolean possible = false;
	boolean start = false;
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isPossible() {
		return possible;
	}

	public void setPossible(boolean possible) {
		this.possible = possible;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public StartPanel(Game game) {
		this.setPreferredSize(new Dimension(0, 150));
		
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
				if (possible)
					start = true;
			}
		});
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		g.drawString("START", this.getWidth()/2 - 25 , this.getHeight() / 2);
	}

	public boolean start() {
		return start;
	}

	public void setDisable() {
		color = Color.GRAY;
		possible = false;
	}
	
	public void setEnable() {
		color = Color.YELLOW;
		possible = true;
	}
}
