package battleberger.model;

import java.util.Map;

public abstract class AbstractShip extends AbstractAbstractShip{
	protected boolean[][] shape;
	public enum Orientation {North,South,East,West};
	public enum TypeShip{Frigate,Commander,Spy,Kevin,Destroyer,SubMarine,Elisabeth,GrosseBerta,ChuckNoris,ShipDefault}
	public enum StatType{Power,Armor,MovSpeed,ReloadSpeed};
	protected Orientation orient;
	protected String imagepath;
	protected int[][] lives; 
	protected int positionX;
	protected int positionY;
	protected int[][] fireshape;
	protected int nbEquipementmax;
	protected Map<StatType,Integer> statmax;
	protected int timereload=0;
	
	protected void confStatMax(int maxPower,int maxArmor,int maxMovSpeed, int maxReloadSpeed){
		statmax.put(StatType.Power,maxPower);
		statmax.put(StatType.Armor,maxArmor);
		statmax.put(StatType.MovSpeed,maxMovSpeed);
		statmax.put(StatType.ReloadSpeed,maxReloadSpeed);
	}
	protected void calculeNbEqiupMax(){
		int res=0;
		for(int i=0;i<shape.length;i++){
			for(int j=0;j<shape[0].length;j++){
				if(shape[i][j])res++;
			}
		}
		nbEquipementmax=res;
	}
	protected void Name(){
		name=this.getClass().getName();
	}
	//savoir si il est vivant ou non sera calculer avec lives 
	//potentiellement si une case brule ou non => tableau de boolean  
	// un truc pour avoir une époque qui ne change pas 
	//potentiellement a chaque tour, on peut bouger un bateau ou son orientation
	// le nombre d'armement de chaque type sera calculer
	
	/*public AbstractShip(Orientation ori, String chemin, int x, int y){
		orient=ori;
		imagepath=chemin;
		for(int i=0;i<shape.length;i++){
			for(int j=0;j<shape[0].length;j++){
				if(shape[i][j])lives[i][j]=1;
			}
		}
		positionX=x;
		positionY=y;
	}*/
	
}
