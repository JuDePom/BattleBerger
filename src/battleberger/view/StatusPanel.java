package battleberger.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShip.TimeSpace;
import battleberger.model.AbstractShipyard;
import battleberger.model.Game;
import battleberger.model.Ship.StatType;
import battleberger.model.Ship.TypeShip;

@SuppressWarnings("serial")
public class StatusPanel extends JPanel implements Serializable{
	AbstractShip currentship;
	JLabel[] stat=new JLabel[4];
	JLabel[] info=new JLabel[2];
	public AbstractShip getCurrentship() {
		return currentship;
	}

	public void setCurrentship(AbstractShip currentship) {
		this.currentship = currentship;
	}

	public JLabel[] getStat() {
		return stat;
	}

	public void setStat(JLabel[] stat) {
		this.stat = stat;
	}

	public JLabel[] getInfo() {
		return info;
	}

	public void setInfo(JLabel[] info) {
		this.info = info;
	}

	public JLabel[] getStatmax() {
		return statmax;
	}

	public void setStatmax(JLabel[] statmax) {
		this.statmax = statmax;
	}

	public JLabel[] getCurrentstat() {
		return currentstat;
	}

	public void setCurrentstat(JLabel[] currentstat) {
		this.currentstat = currentstat;
	}

	public JLabel[] getNbmaxupgrade() {
		return nbmaxupgrade;
	}

	public void setNbmaxupgrade(JLabel[] nbmaxupgrade) {
		this.nbmaxupgrade = nbmaxupgrade;
	}
	JLabel[] statmax=new JLabel[4];
	JLabel[] currentstat=new JLabel[4];
	JLabel[] nbmaxupgrade=new JLabel[4];
	public StatusPanel(Game game) {
		this.setPreferredSize(new Dimension(0, 150));
		StatType[] type=StatType.values();
		JPanel pan=new JPanel();
		pan.setPreferredSize(new Dimension(540,150));
		pan.setBorder(BorderFactory.createLineBorder(Color.black));
		pan.setLayout(new BoxLayout(pan,BoxLayout.Y_AXIS));
		JPanel pan2=new JPanel();
		JPanel information=new JPanel();
		pan2.setLayout(new GridLayout(6,1));
		pan2.setPreferredSize(new Dimension(270,60));
		//pan2.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		for(int i=0;i<type.length;i++){
			stat[i]=new JLabel();
			stat[i].setPreferredSize(new Dimension(140,20));
			
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
		for(int i=0;i<4;i++){
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
		pan2.add(info[1]);
		add(pan2);
		
	
	
		refresh(currentship);
	}
	
	public void refresh(AbstractShip ship){
		if(ship!=null){
			currentship=ship;
			info[0].setText(currentship.getName());
			info[0].setIcon(new ImageIcon(RessourceManager.getImage(ship.getImagepath())));
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
			nbmaxupgrade[0].setText("Nombre d'amelioration");
			
			nbmaxupgrade[1].setText("possede : "+ currentship.calculeNbEquipement());
			nbmaxupgrade[2].setText("Nombre maximal ");
			
			nbmaxupgrade[3].setText("d'amelioration possible : "+ currentship.getNbEquipementmax());
			info[1].setText("Temps avant de pouvoir retirer : "+currentship.getTimereload());
			}
		
	}

	
}
