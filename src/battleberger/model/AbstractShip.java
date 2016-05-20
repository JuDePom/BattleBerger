package battleberger.model;

import java.util.Map;

import battleberger.model.Ship.Orientation;
import battleberger.model.Ship.StatType;
import battleberger.model.Ship.TypeShip;

public abstract class AbstractShip {
	
	
	protected int cost;
	protected String name;
	protected Map<StatType,Integer> upgrade;
	
	public enum TimeSpace{Default,MoyenAge,SheepAge};
	public abstract int getPower();
	public abstract int getArmor();
	public abstract int getMovSpeed();
	public abstract int getCooldown();
	public abstract boolean[][] getShape() ;
	public abstract void setShapeNorth(boolean[][] shape, Orientation or);
	public abstract Orientation getOrient() ;
	public abstract void setOrient(Orientation orient) ;
	public abstract String getImagepath() ;
	public abstract void setImagepath(String imagepath) ;
	public abstract int[][] getLives() ;
	public abstract void setLives(int[][] lives) ;
	public abstract int getPositionX() ;
	public abstract void setPositionX(int positionX) ;
	public abstract int getPositionY() ;
	public abstract void setPositionY(int positionY) ;
	public abstract int[][] getFireshape() ;
	public abstract void setFireshape(int[][] fireshape) ;
	public abstract int getNbEquipementmax() ;
	public abstract void setNbEquipementmax(int nbEquipementmax) ;
	public abstract Map<StatType, Integer> getStatmax() ;
	public abstract int getStatmax(StatType type);
	public abstract void setStatmax(Map<StatType, Integer> statmax) ;
	public abstract int getTimereload() ;
	public abstract void setTimereload(int timereload) ;
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract TypeShip getType();
	public abstract int getUpgrade(StatType stat);
	public abstract void addUpgrade(StatType stat);
	public abstract Map<StatType, Integer> upgrade();
	/**
	 * function a utiliser juste pour les decorateurs
	 */
	public abstract StatType getStat();
	public abstract int getCostUpgrade();
	
	public AbstractShip(){
		cost = 1;
	}
	
	public abstract int isReadyToFireIn();
	
	public boolean isReadyToFire(){
		return isReadyToFireIn() <= 0;
	}
	
	public abstract void setReadyToFireIn(int i);
	
	public void endOfTurnProcessing(){
		setReadyToFireIn(isReadyToFireIn() - 1);
	}
	
	public abstract int shipValue();
	
	public abstract boolean toucher(int x, int y, int degat);
	public abstract boolean overlap(int x, int y);
	public abstract boolean overlap(Square s);
	public abstract boolean isAlive();	
}
