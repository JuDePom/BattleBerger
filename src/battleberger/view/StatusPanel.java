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
	
	public StatusPanel(Game game) {
		initPicture();
		this.setPreferredSize(new Dimension(0, 150));
		StatType[] type=StatType.values();
		JPanel pan=new JPanel();
		pan.setPreferredSize(new Dimension(100,150));
		pan.setBorder(BorderFactory.createLineBorder(Color.black));
		pan.setLayout(new BoxLayout(pan,BoxLayout.Y_AXIS));
		JPanel pan2=new JPanel();
		JPanel information=new JPanel();
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		for(int i=0;i<type.length;i++){
			stat[i]=new JLabel();
			stat[i].setPreferredSize(new Dimension(100,20));
			//stat[i].setBorder(BorderFactory.createLineBorder(Color.black));
			JPanel tmp=new JPanel();
			tmp.setBorder(BorderFactory.createLineBorder(Color.black));
			tmp.setLayout(new GridLayout());
			tmp.add(stat[i]);
			switch(i){
			case 0:
				tmp.setBackground(new Color(231,145,119));
				break;
			case 1:
				tmp.setBackground(new Color(138,208,248));
				break;
			case 2: 
				tmp.setBackground(new Color(178,255,178));
				break;
			case 3:
				tmp.setBackground(new Color(245,255,178));
				break;
				default :
					
			}
			pan.add(tmp);
		}
		for(int i=0;i<info.length;i++){
			info[i]=new JLabel();
			
		}
		information.add(pan);
		
		add(info[0],BorderLayout.WEST);
		add(information);
		add(info[1]);
		add(new JPanel());
		add(new JPanel());
		add(new JPanel());
	
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
			info[1].setText("Temps avant de pouvoir retiré : "+currentship.getTimereload());
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
