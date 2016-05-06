package battleberger.model;

import java.util.Map;

import battleberger.model.Ship.Orientation;
import battleberger.model.Ship.StatType;

public abstract class AbstractShip {
	protected int cost;
	protected String name;
	public enum TimeSpace{};
	public abstract int getPower();
	public abstract int getArmor();
	public abstract int getMovSpeed();
	public abstract int getReloadSpeed();
	public abstract boolean[][] getShape() ;
	public abstract void setShape(boolean[][] shape);
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
	public abstract void setStatmax(Map<StatType, Integer> statmax) ;
	public abstract int getTimereload() ;
	public abstract void setTimereload(int timereload) ;
	public abstract int getWidth();
	public abstract int getHeight();

	public abstract boolean toucher(int x, int y, int degat);
	public abstract boolean overlap(int x, int y);
	public abstract boolean overlap(Square s);
}
