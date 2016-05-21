package battleberger.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.Ship.StatType;
import battleberger.model.decorateur.Armory;
import battleberger.model.player.Player;

@SuppressWarnings("serial")
public class ShopPanel extends JPanel implements Serializable{
	public enum Picture{Shop,Closeshop,Buyshop,Power,Armor,MovSpeed,ReloadSpeed}
	AbstractShip currentship;
	Game battle;



	public AbstractShip getCurrentship() {
		return currentship;
	}
	public void setCurrentship(AbstractShip currentship) {
		this.currentship = currentship;
	}
	public Game getBattle() {
		return battle;
	}
	public void setBattle(Game battle) {
		this.battle = battle;
	}
	public Armory getArmory() {
		return armory;
	}
	public void setArmory(Armory armory) {
		this.armory = armory;
	}
	public JLabel[] getCost() {
		return cost;
	}
	public void setCost(JLabel[] cost) {
		this.cost = cost;
	}
	public JButton[] getBuy() {
		return buy;
	}
	public void setBuy(JButton[] buy) {
		this.buy = buy;
	}
	public JLabel getMoney() {
		return money;
	}
	public void setMoney(JLabel money) {
		this.money = money;
	}
	public Map<Picture, ImageIcon> getImageshop() {
		return imageshop;
	}
	public void setImageshop(Map<Picture, ImageIcon> imageshop) {
		this.imageshop = imageshop;
	}
	Armory armory;
	JLabel[] cost=new JLabel[4];
	JButton[] buy=new JButton[4];
	JLabel money=new JLabel("Money : ??? ");
	Map<Picture,ImageIcon> imageshop=new HashMap<Picture,ImageIcon>();
	public ShopPanel(Game game) {
		instancePicture();
		this.setPreferredSize(new Dimension(250, 100));
		battle=game;
		armory=new Armory();
		StatType[] stat=StatType.values();
		JPanel[] upgrade=new JPanel[stat.length];
		JPanel entete=new JPanel();
		JLabel title=new JLabel(imageshop.get(Picture.Shop));
		Picture[] picto=Picture.values();
		entete.setBackground(new Color(130,155,189));
		entete.setPreferredSize(new Dimension(250,50));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		entete.setBorder(BorderFactory.createLineBorder(Color.black));
		entete.add(money);
		entete.add(title);

		add(entete);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		//currentship=armory.buildUpgrade(StatType.Power, armory.buildUpgrade(StatType.ReloadSpeed, armory.buildUpgrade(StatType.Power, AbstractShipyard.orderShip(TypeShip.BlackPearl))));
		for(int i=0;i<stat.length;i++){
			final StatType type=stat[i];
			buy[i]=new JButton();
			buy[i].setIcon(imageshop.get(Picture.Buyshop));
			buy[i].setBackground(new Color(177,207,248));
			buy[i].setFocusable(false);
			buy[i].setPreferredSize(new Dimension(30,10));
			buy[i].setEnabled(false);
			buy[i].setBorder(BorderFactory.createLineBorder(Color.black));
			upgrade[i]=new JPanel();
			buy[i].setDisabledIcon(imageshop.get(Picture.Closeshop));
			buy[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(currentship!=null){

						int nbupgrade=currentship.getUpgrade(type);
						if(nbupgrade<currentship.getStatmax(type)){

							AbstractShip up=armory.buildUpgrade(type, currentship);

							battle.getCurrentPlayer().upgrade(up,currentship);
							battle.getCurrentPlayer().gainMoney(-((int)Math.pow(2, nbupgrade)*currentship.getCostUpgrade()));

							currentship=up;


							currentship.setNbEquipement(currentship.calculeNbEquipement());
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}


							//refresh(ship);
						}
					}
					//buy[0].setEnabled(!buy[0].isEnabled());

					//System.out.println("kaboum!");
				}
			});

			cost[i]=new JLabel("Cost : "/*+(int)(armory.buildUpgrade(type, null).getCostUpgrade()*Math.pow(2,currentship.getUpgrade(type)))*/);
			JLabel name=new JLabel();
			for(Picture p : picto){
				if(p.name()==type.name())name.setIcon(imageshop.get(p));
			}
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

		if(ship!=null){
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
	}
	public void enabledButton(){
		Player p=battle.getCurrentPlayer();


		StatType[] type=StatType.values();
		int money=Integer.MAX_VALUE;
		for(int i=0;i<StatType.values().length;i++){
			if(i!=2){
				if(currentship != null){
					money=(int)Math.pow(2, currentship.getUpgrade(type[i]))*currentship.getCostUpgrade();
					if(p!=null){
						this.money.setText("Money : "+p.getMoney());
						if(currentship.getNbEquipementTotal() < currentship.getNbEquipementmax()){
							if(currentship.getUpgrade(type[i])<currentship.getStatmax(type[i])){
								if(p.getMoney()<money){
									buy[i].setEnabled(false);

									buy[i].setIcon(buy[i].getDisabledIcon());
								}
								else{
									buy[i].setEnabled(true);

									buy[i].setIcon(imageshop.get(Picture.Buyshop));
								}
							}else{
								buy[i].setEnabled(false);
							}
						}else{

							buy[i].setEnabled(false);
						}
					}
				}else{
					buy[i].setEnabled(false);
				}
			}
		}
	}
	public void refresh(AbstractShip ship){
		setCost(ship);
		enabledButton();

	}
	public void instancePicture(){
		Picture[] pictur=Picture.values();
		for(Picture p : pictur){
			imageshop.put(p,new ImageIcon(RessourceManager.getImage("/images/"+p.name())));
		}
	}
	public AbstractShip getCurrentShip(){
		return currentship;
	}

}
