package battleberger.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShipyard;
import battleberger.model.Game;
import battleberger.model.Ship.StatType;
import battleberger.model.Ship.TypeShip;
import battleberger.view.ShopPanel.Picture;

@SuppressWarnings("serial")
public class StatusPanel extends JPanel{
	AbstractShip currentship;
	Map<TypeShip,ImageIcon> pictureship=new HashMap<TypeShip,ImageIcon>();
	JLabel[] stat=new JLabel[4];
	JLabel[] info=new JLabel[2];
	JLabel[] statmax=new JLabel[4];
	JLabel[] currentstat=new JLabel[4];
	JLabel[] nbmaxupgrade=new JLabel[6];
	public StatusPanel(Game game) {
		initPicture();
		this.setPreferredSize(new Dimension(0, 150));
		StatType[] type=StatType.values();
		JPanel pan=new JPanel();
		//pan.setPreferredSize(new Dimension(110,150));
		pan.setBorder(BorderFactory.createLineBorder(Color.black));
		pan.setLayout(new BoxLayout(pan,BoxLayout.Y_AXIS));
		JPanel pan2=new JPanel();
		JPanel information=new JPanel();
		pan2.setLayout(new GridLayout(6,1));
		pan2.setPreferredSize(new Dimension(230,60));
		//pan2.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		for(int i=0;i<type.length;i++){
			stat[i]=new JLabel();
			stat[i].setPreferredSize(new Dimension(110,20));
			
			statmax[i]=new JLabel();
			currentstat[i]=new JLabel();
			
			
			//stat[i].setBorder(BorderFactory.createLineBorder(Color.black));
			JPanel tmp=new JPanel();
			JPanel[] p=new JPanel[3];
			for(int j=0;j<3;j++){
				p[j]=new JPanel();
				p[j].setBorder(BorderFactory.createLineBorder(Color.black));
				
				switch(i){
				case 0:
					p[j].setBackground(new Color(231,145,119));
					break;
				case 1:
					p[j].setBackground(new Color(138,208,248));
					break;
				case 2: 
					p[j].setBackground(new Color(178,255,178));
					break;
				case 3:
					p[j].setBackground(new Color(245,255,178));
					break;
					default :
						
				}
				tmp.add(p[j]);
				
			}
			p[0].add(stat[i]);
			p[1].add(statmax[i]);
			p[2].add(currentstat[i]);
			tmp.setBorder(BorderFactory.createLineBorder(Color.black));
			tmp.setLayout(new BoxLayout(tmp,BoxLayout.X_AXIS));
			for(int j=0;j<3;j++)
			tmp.add(p[j]);
			
			pan.add(tmp);
		}
		for(int i=0;i<info.length;i++){
			info[i]=new JLabel();
			
		}
		information.add(pan);
		for(int i=0;i<6;i++){
			JPanel tmp=new JPanel();
			nbmaxupgrade[i]=new JLabel();
			//tmp.setLayout(new BoxLayout(tmp,BoxLayout.Y_AXIS));
			tmp.setLayout(new BoxLayout(tmp,BoxLayout.X_AXIS));
			tmp.setPreferredSize(new Dimension(20,100));
			tmp.add(nbmaxupgrade[i]);
			
			
			pan2.add(tmp);
		}
			
		
		add(info[0],BorderLayout.WEST);
		add(information);
		add(pan2);
		add(info[1]);
	
	
		refresh(currentship);
	}
	
	public void refresh(AbstractShip ship){
		if(ship!=null){
			currentship=ship;
			info[0].setText(currentship.getName());
			TypeShip type=currentship.getType();
			info[0].setIcon(pictureship.get(type));
			StatType[] st=StatType.values();
			stat[0].setText(""+st[0].name()+" : " + currentship.getPower());
			stat[1].setText(""+st[1].name()+" : " + currentship.getArmor());
			stat[2].setText(""+st[2].name()+" : " + currentship.getMovSpeed());
			stat[3].setText(""+st[3].name()+" : " + currentship.getCooldown());
			statmax[0].setText("Nombre max : " + currentship.getStatmax(StatType.Power));
			statmax[1].setText("Nombre max : " + currentship.getStatmax(StatType.Armor));
			statmax[2].setText("Nombre max : " + currentship.getStatmax(StatType.MovSpeed));
			statmax[3].setText("Nombre max : " + currentship.getStatmax(StatType.ReloadSpeed));
			currentstat[0].setText("Nombre d'amelioration courante : "+ currentship.getUpgrade(StatType.Power));
			currentstat[1].setText("Nombre d'amelioration courante : "+ currentship.getUpgrade(StatType.Armor));
			currentstat[2].setText("Nombre d'amelioration courante : "+ currentship.getUpgrade(StatType.MovSpeed));
			currentstat[3].setText("Nombre d'amelioration courante : "+ currentship.getUpgrade(StatType.ReloadSpeed));
			nbmaxupgrade[0].setText("Nombre");
			nbmaxupgrade[1].setText("d'amelioration");
			nbmaxupgrade[2].setText("possede : "+ currentship.calculeNbEquipement());
			nbmaxupgrade[3].setText("Nombre");
			nbmaxupgrade[4].setText("maximal d'amelioration");
			nbmaxupgrade[5].setText("possible : "+ currentship.getNbEquipementmax());
			info[1].setText("Temps avant de pouvoir retirer : "+currentship.getTimereload());
			}
		
	}
	public void initPicture(){
		TypeShip[] pictur=TypeShip.values();
		for(TypeShip p : pictur){
			if(p==TypeShip.Spy)
				pictureship.put(p,new ImageIcon(RessourceManager.getImage("./assets/images/"+AbstractShipyard.getTimeSpace().name()+"/"+p.name()+"2")));
			else
				pictureship.put(p,new ImageIcon(RessourceManager.getImage("./assets/images/"+AbstractShipyard.getTimeSpace().name()+"/"+p.name())));
		}
	}
}
