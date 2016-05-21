package battleberger.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.plaf.basic.BasicComboBoxRenderer;

import battleberger.backup.AbstractDAOFactory;
import battleberger.backup.DAO;
import battleberger.backup.ExportType;
import battleberger.model.Game;
import battleberger.model.Strategies;
import battleberger.model.player.strategy.StrategyDiagonal;
import battleberger.model.player.strategy.StrategyWithMemory;

public class MenuBar extends JMenuBar {
	List<JButton> button = new ArrayList<JButton>();
	Game game;
	JComboBox<String> jcb=new JComboBox<String>();
	public MenuBar(Game g){
		game=g;
		
		for(Strategies s : Strategies.values()){
			jcb.addItem(s.name());
		}
		jcb.setPreferredSize(new Dimension(100,10));
		jcb.setSelectedItem(jcb.getItemAt(0));
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
				DAO<Game> save=AbstractDAOFactory.getAbstractDAOFactory(ExportType.MySQL).getGameDAO();
				save.save(game, "./save");
			}
			
		});
		save.setFocusable(false);
		button.add(save);
		JButton load= new JButton("Load");
		load.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser=new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				chooser.setDialogTitle("Choisir un dossier");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (chooser.getSelectedFile().isFile()) {
						File file =chooser.getSelectedFile();
						DAO<Game> load = AbstractDAOFactory.getAbstractDAOFactory(ExportType.MySQL).getGameDAO();
						load.load(file.getAbsolutePath());
					}
				}
					
			}
			
		});
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
}



