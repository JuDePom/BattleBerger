package battleberger.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Ship extends AbstractShip{
	public enum Orientation {North,South,East,West};
	public enum TypeShip{Frigate,Commander,Spy,Kevin,Destroyer,SubMarine,Elisabeth,GrosseBerta,ChuckNoris,ShipDefault,BlackPearl}
	public enum StatType{Power,Armor,MovSpeed,ReloadSpeed};
	
	protected boolean[][] shape;
	protected Orientation orient;
	protected String imagepath;
	protected int[][] lives; 
	protected int positionX;
	protected int positionY;
	protected int[][] fireshape;
	protected int nbEquipementmax;
	protected Map<StatType,Integer> statmax;
	protected int timereload=0;
	protected boolean mouv;
	
	protected void confStatMax(int maxPower,int maxArmor,int maxMovSpeed, int maxReloadSpeed){
		statmax = new HashMap<StatType,Integer>();
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
	@Override
	public boolean[][] getShape() {
		return shape;
	}
	@Override
	public void setShape(boolean[][] shape) {
		this.shape = shape;
	}
	@Override
	public Orientation getOrient() {
		return orient;
	}
	@Override
	public void setOrient(Orientation orient) {
		this.orient = orient;
	}
	@Override
	public String getImagepath() {
		return imagepath;
	}
	@Override
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	@Override
	public int[][] getLives() {
		return lives;
	}
	@Override
	public void setLives(int[][] lives) {
		this.lives = lives;
	}
	@Override
	public int getPositionX() {
		return positionX;
	}
	@Override
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	@Override
	public int getPositionY() {
		return positionY;
	}
	@Override
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	@Override
	public int[][] getFireshape() {
		return fireshape;
	}
	@Override
	public void setFireshape(int[][] fireshape) {
		this.fireshape = fireshape;
	}
	@Override
	public int getNbEquipementmax() {
		return nbEquipementmax;
	}
	@Override
	public void setNbEquipementmax(int nbEquipementmax) {
		this.nbEquipementmax = nbEquipementmax;
	}
	@Override
	public Map<StatType, Integer> getStatmax() {
		return statmax;
	}
	@Override
	public void setStatmax(Map<StatType, Integer> statmax) {
		this.statmax = statmax;
	}
	@Override
	public int getTimereload() {
		return timereload;
	}
	@Override
	public void setTimereload(int timereload) {
		this.timereload = timereload;
	}

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getArmor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMovSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getReloadSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		
		return shape[0].length;
	}

	@Override
	public int getHeight() {
		return shape.length;
	}
	
	
	
	@Override
	public boolean overlap(int x, int y){
		boolean res=false;
		int c=positionX;
		while(c<(positionX+getWidth())){
			if(c==x){
				c=positionY;
				while(c<(positionY+getHeight())){
					if(c==y)
							res=true;
				}
			}
		}
		return res;
		
	}
	@Override
	public boolean toucher(int x, int y, int degat){
		boolean res=false;
		if(overlap(x,y)){
				if(lives[y-positionY][x-positionX]>0){
					int armor = getArmor();
					lives[y-positionY][x-positionX]-=armor-degat;
					res=true;
				}
		}
		return res;
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
