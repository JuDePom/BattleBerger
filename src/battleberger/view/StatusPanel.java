package battleberger.view;

import java.awt.Dimension;

import javax.swing.JPanel;

import battleberger.model.Game;

@SuppressWarnings("serial")
public class StatusPanel extends JPanel{
	public StatusPanel(Game game) {
		this.setPreferredSize(new Dimension(0, 150));
	}
}
