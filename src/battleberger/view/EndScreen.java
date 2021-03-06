package battleberger.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import battleberger.model.Game;
import battleberger.model.player.Human;
import battleberger.model.player.Player;

@SuppressWarnings("serial")
public class EndScreen extends JPanel{
	Game game;
	JLabel status=new JLabel();
	JButton[] screen = new JButton[2];
	Map<Status,ImageIcon> image=new HashMap<Status,ImageIcon>();
	
	public enum Status{Gagner,Gameover};
	public EndScreen(Game g){
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(1000,600));
		initImage();
		game=g;
		screen[0]=new JButton("Rejouer");
		screen[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				game.replay();
				
			}
				
		});
		screen[1]=new JButton("Quitter");
		screen[1].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		add(status);
		add(screen[0]);
		add(screen[1]);
	}
	public void refresh(){
		if(game.isEndOfGame()){
			
			Player player=game.getPlayers().get(0);
			if(player instanceof Human){
				if(player.nbShips()>0)
					status.setIcon(image.get(Status.Gagner));
				else
					status.setIcon(image.get(Status.Gameover));
			}else{
				if(player.nbShips()>0)
					status.setIcon(image.get(Status.Gameover));
				else					
					status.setIcon(image.get(Status.Gagner));
			}
		}
	}
	public void initImage(){
		Status[] type=Status.values();
		for(Status s: type){
			image.put(s, new ImageIcon(RessourceManager.getImage("/images/"+s.name())));
		}
	}
}
