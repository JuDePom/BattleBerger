package battleberger.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import battleberger.model.AbstractShip.TimeSpace;

public class EraPanel extends JPanel{

	TimeSpace ts;
	boolean selected = false;
	
	public EraPanel(){
		super();
		JButton m_a = new JButton("Moyen age");

		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JButton sheep = new JButton("L'age des moutons");
		sheep.setPreferredSize(new Dimension(200,50));
		sheep.setFocusable(false);
		this.setBackground(Color.black);
		JButton troll = new JButton("Troll ?!");
		
		troll.setPreferredSize(new Dimension(200,50));
		troll.setFocusable(false);
		JPanel tmp=new JPanel();
		JPanel tmp2=new JPanel();
		tmp.setBackground(Color.black);
		tmp2.setBackground(Color.black);
		//add(m_a);
		for(int i=0;i<5;i++)
		{
			JPanel tmp3=new JPanel();
			tmp3.setBackground(Color.black);
			add(tmp3);
		}
		this.setBackground(Color.black);
		tmp.add(sheep);
		add(tmp);
		tmp2.add(troll);
		add(tmp2);
		for(int i=0;i<5;i++){
			JPanel tmp3=new JPanel();
			tmp3.setBackground(Color.black);
			add(tmp3);
		}
		
		m_a.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ts = TimeSpace.MoyenAge;
				selected = true;
			}
		});
		
		sheep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ts = TimeSpace.SheepAge;
				selected = true;
				
			}
		});

		
		troll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ts = TimeSpace.Default;
				selected = true;
			}
		});
	}
	
	TimeSpace getEra(){
		while(! selected)
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		return ts;
	}
	
}
