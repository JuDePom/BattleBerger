package battleberger.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import battleberger.model.AbstractShip.TimeSpace;

public class EraPanel extends JPanel{

	TimeSpace ts;
	boolean selected = false;
	
	public EraPanel(){
		super();
		JButton m_a = new JButton("Moyen age");
		JButton sheep = new JButton("L'âge des moutons");

		JButton troll = new JButton("Troll ?!");
		
		add(m_a);
		add(sheep);
		add(troll);
		
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
