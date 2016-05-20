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
	JLabel[] cost=new JLabel[4];
	JButton[] buy=new JButton[4];
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
			 buy[i]=new JButton("Buy");
			buy[i].setPreferredSize(new Dimension(30,10));
			
			upgrade[i]=new JPanel();
			
			buy[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(currentship!=null)
					battle.getCurrentplayer().upgrade(armory.buildUpgrade(type, currentship),currentship);
					//System.out.println("kaboum!");
				}
			});
			cost[i]=new JLabel("Cost : noEntry");
			JLabel name=new JLabel(type.name());
			upgrade[i].setBorder(BorderFactory.createLineBorder(Color.black));
			upgrade[i].setLayout(new GridLayout());
			upgrade[i].add(name);
			upgrade[i].add(cost[i]);
			upgrade[i].add(buy[i]);
			
			
			add(upgrade[i]);
			
		}
	}
	public void setCost(AbstractShip ship){
		StatType[] type=StatType.values();
		for(int i=0;i<type.length;i++){
			
			int money=ship.getUpgrade(type[i])*ship.getCostUpgrade();;
			cost[i].setText("Cost : "+money);
		}
	}
	
}
