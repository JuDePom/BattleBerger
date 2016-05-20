package battleberger.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShipyard;
import battleberger.model.Game;
import battleberger.model.Ship.StatType;
import battleberger.model.Ship.TypeShip;
import battleberger.model.decorateur.Armory;
import battleberger.model.player.Human;
import battleberger.model.player.Player;

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
		JLabel title=new JLabel(new ImageIcon("./assets/images/shop.png"));
		this.setBackground(new Color(130,155,189));
		title.setPreferredSize(new Dimension(250,50));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		add(title);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		//currentship=armory.buildUpgrade(StatType.Power, armory.buildUpgrade(StatType.ReloadSpeed, armory.buildUpgrade(StatType.Power, AbstractShipyard.orderShip(TypeShip.BlackPearl))));
		for(int i=0;i<stat.length;i++){
			StatType type=stat[i];
			buy[i]=new JButton();
			buy[i].setIcon(new ImageIcon("./assets/images/buyshop.png"));
			buy[i].setBackground(new Color(177,207,248));
			buy[i].setFocusable(false);
			buy[i].setPreferredSize(new Dimension(30,10));
			buy[i].setEnabled(true);
			buy[i].setBorder(BorderFactory.createLineBorder(Color.black));
			upgrade[i]=new JPanel();
			buy[i].setDisabledIcon(new ImageIcon("./assets/images/closeshop.png"));
			buy[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(currentship!=null){
						
						int nbupgrade=currentship.getUpgrade(type);
						battle.getCurrentPlayer().upgrade(armory.buildUpgrade(type, currentship),currentship);
						battle.getCurrentPlayer().gainMoney(-(nbupgrade*currentship.getCostUpgrade()));
					
					}
					//buy[0].setEnabled(!buy[0].isEnabled());
					
					//System.out.println("kaboum!");
				}
			});
			
			cost[i]=new JLabel("Cost : "/*+(int)(armory.buildUpgrade(type, null).getCostUpgrade()*Math.pow(2,currentship.getUpgrade(type)))*/);
			JLabel name=new JLabel();
			name.setIcon(new ImageIcon("./assets/images/"+type.name()+".png"));
			upgrade[i].setBorder(BorderFactory.createLineBorder(Color.black));
			upgrade[i].setLayout(new GridLayout());
			upgrade[i].add(name);
			upgrade[i].add(cost[i]);
			upgrade[i].add(buy[i]);
			
			
			add(upgrade[i]);
			
		}
		upgrade[0].setBackground(new Color(231,145,119));
		upgrade[1].setBackground(new Color(138,208,248));
		upgrade[2].setBackground(new Color(178,255,178));
		upgrade[3].setBackground(new Color(245,255,178));
		refresh(currentship);
		
	}
	public void setCost(AbstractShip ship){
		currentship=ship;
		StatType[] type=StatType.values();
		int money;
		for(int i=0;i<type.length;i++){
			if(ship!=null)
			 money=(int)(ship.getCostUpgrade()*Math.pow(2,ship.getUpgrade(type[i])));
			else 
				money=(armory.buildUpgrade(type[i], null)).getCostUpgrade();
			//System.out.println(""+type[i] + ship.getUpgrade(type[i]));
			
			cost[i].setText("Cost : "+money);
		}
	}
	public void enabledButton(){
		Player p=battle.getCurrentPlayer();
		//p=new Human();
		StatType[] type=StatType.values();
		int money=Integer.MAX_VALUE;
		for(int i=0;i<StatType.values().length;i++){
			if(currentship!=null)
				money=(int)Math.pow(2, currentship.getUpgrade(type[i]))*currentship.getCostUpgrade();
			if(p!=null){
				if(p.getMoney()<=money){
					buy[i].setEnabled(false);
					
					buy[i].setIcon(buy[i].getDisabledIcon());
				}
				else{
					buy[i].setEnabled(true);
					
					buy[i].setIcon(new ImageIcon("./assets/images/buyshop.png"));
				}
					
			}
		}
	}
	public void refresh(AbstractShip ship){
		setCost(ship);
		enabledButton();
		
	}
	
}
