package battleberger.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;

import battleberger.backup.AbstractDAOFactory;
import battleberger.backup.DAO;
import battleberger.backup.ExportType;
import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.Strategies;

public class MenuBar extends JMenuBar implements Serializable {
	
	class LoadListener implements ActionListener{

		Window parent;
		public LoadListener(Window p ) {
			parent = p;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser=new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			chooser.setDialogTitle("Choisir un fichier");
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setAcceptAllFileFilterUsed(false);
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				if (chooser.getSelectedFile().isFile()) {
					File file =chooser.getSelectedFile();
					DAO<Game> load = AbstractDAOFactory.getAbstractDAOFactory(ExportType.Serialize).getGameDAO();
					Game g = load.load(file.getAbsolutePath());
					
					game.getPlayers().get(0).setShips(new ArrayList<AbstractShip>()); //Termine le jeu de départ
					
					g.setDisplay(parent);
					Thread t = new Thread(){

						@Override
						public void run() {
							parent.game.play();
						}
						
						
					};
					t.start();
				}
			}
				
		}
		
	}
	
	List<JButton> button = new ArrayList<JButton>();
	Game game;
	
	JComboBox<String> jcb=new JComboBox<String>();
	
	Window parent;

	public MenuBar(Game g, Window p) {
		this.parent = p;
		game=g;
		
		for(Strategies s : Strategies.values()){
			jcb.addItem(s.name());
		}
		jcb.setPreferredSize(new Dimension(100,10));
		jcb.setSelectedItem(jcb.getItemAt(2));
		jcb.addActionListener(new ActionListener () {
			 public void actionPerformed(ActionEvent e) {
				 game.setStrategy(getSelectStrat());
			 }
		});
		
		JButton quit=new JButton("Quit");
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		quit.setFocusable(false);
		button.add(quit);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser=new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				chooser.setDialogTitle("Choisir un fichier");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file =chooser.getSelectedFile();
					DAO<Game> save = AbstractDAOFactory.getAbstractDAOFactory(ExportType.Serialize).getGameDAO();
					save.save(game, file.getAbsolutePath());
				}
			}
			
		});
		save.setFocusable(false);
		button.add(save);
		JButton load= new JButton("Load");
		load.addActionListener( new LoadListener(parent));
		load.setFocusable(false);
		button.add(load);
		for(JButton b : button)
		this.add(b);
		add(jcb);
	}
	
	public Strategies getSelectStrat(){
		String selectitem=(String)jcb.getSelectedItem();
		Strategies res;
		switch(selectitem){
		case "Yolo" :
			res=Strategies.Yolo;
			break;
		case "Diagonal" :
			res=Strategies.Diagonal;
			break;
		case "StrategyWithMemory" :
			res=Strategies.StrategyWithMemory;
			break;
			default : 
				res=null;
		}
		return res;
	}
	
	
	public List<JButton> getButton() {
		return button;
	}

	public void setButton(List<JButton> button) {
		this.button = button;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public JComboBox<String> getJcb() {
		return jcb;
	}

	public void setJcb(JComboBox<String> jcb) {
		this.jcb = jcb;
	}

}



