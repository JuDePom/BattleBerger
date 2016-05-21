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
		
		
		
		m_a.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ts = TimeSpace.MoyenAge;
				selected = true;
			}
		});
		
		JButton sheep = new JButton("L'âge des moutons");
		sheep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ts = TimeSpace.SheepAge;
				selected = true;
				
			}
		});

		
		JButton troll = new JButton("Troll ?!");
		troll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ts = TimeSpace.Default;
				selected = true;
			}
		});
		
		add(m_a);
		
		add(sheep);
		
		add(troll);
	}
	TimeSpace getEra(){
		while(! selected){
			
		}
		return ts;
	}
	
}
