package battleberger.view;

import java.awt.Dimension;

import javax.swing.JPanel;

import battleberger.model.Game;

@SuppressWarnings("serial")
public class ShopPanel extends JPanel{
	public ShopPanel(Game game) {
		this.setPreferredSize(new Dimension(250, 0));
	}
}
