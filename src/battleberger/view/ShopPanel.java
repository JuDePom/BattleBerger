package battleberger.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.Ship.StatType;
import battleberger.model.decorateur.Armory;

@SuppressWarnings("serial")
public class ShopPanel extends JPanel{
	AbstractShip currentship;
	Game battle;
	Armory armory;
	public ShopPanel(Game game) {
		this.setPreferredSize(new Dimension(250, 100));
		battle=game;
		armory=new Armory();
		StatType[] stat=StatType.values();
		JPanel[] upgrade=new JPanel[stat.length];
		JLabel title=new JLabel("SHOP");
		title.setPreferredSize(new Dimension(250,20));
		add(title);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		for(int i=0;i<stat.length;i++){
			StatType type=stat[i];
			JButton buy=new JButton("Buy");
			buy.setPreferredSize(new Dimension(30,10));
			
			upgrade[i]=new JPanel();
			
			buy.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					battle.getCurrentplayer().upgrade(armory.buildUpgrade(type, currentship),currentship);
				}
			});
			JLabel cost=new JLabel("Cost : noEntry");
			JLabel name=new JLabel(type.name());
			upgrade[i].setBorder(BorderFactory.createLineBorder(Color.black));
			upgrade[i].setLayout(new GridLayout());
			upgrade[i].add(name);
			upgrade[i].add(cost);
			upgrade[i].add(buy);
			
			
			add(upgrade[i]);
			
		}
	}
	
}
