package battleberger.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Ship extends AbstractShip{
	

	protected int readyToFireIn;

	public enum Orientation {North,East,South,West};
	public enum TypeShip{Frigate,Commander,Spy,Kevin,Destroyer,SubMarine,Elisabeth,GrosseBerta,ChuckNoris,ShipDefault,BlackPearl}
	public enum StatType{Power,Armor,MovSpeed,ReloadSpeed};

	protected TypeShip type;
	protected boolean[][] shapeNorth;
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
	
	public boolean isAlive(){
		boolean alive = false;
		for(int[] i : lives){
			for(int j : i){
				if(j > 0){
					alive = true;
					break;
				}
			}
			if(alive)break;
		}
		return alive;
	}
	
	
	public int shipValue(){
		return cost;
	}
	
	protected void confStatMax(int maxPower,int maxArmor,int maxMovSpeed, int maxReloadSpeed){
		statmax = new HashMap<StatType,Integer>();
		statmax.put(StatType.Power,maxPower);
		statmax.put(StatType.Armor,maxArmor);
		statmax.put(StatType.MovSpeed,maxMovSpeed);
		statmax.put(StatType.ReloadSpeed,maxReloadSpeed);
	}
	
	protected void calculeNbEquipMax(){
		int res=0;
		for(int i=0;i<shapeNorth.length;i++){
			for(int j=0;j<shapeNorth[0].length;j++){
				if(shapeNorth[i][j])res++;
			}
		}
		nbEquipementmax=res;
	}
	
	protected void Name(){
		name = this.getClass().getName();
	}
	@Override
	public boolean[][] getShape() {
		return shape;
	}
	
	
	@Override
	public void setShapeNorth(boolean[][] shape, Orientation or) {
		this.shapeNorth = shape;
		this.orient =or;
		this.shape = shape;
		setOrient(or);
	}
	@Override
	public Orientation getOrient() {
		return orient;
	}
	@Override
	public void setOrient(Orientation orient) {
		
		if(orient == this.orient){
			//rien à faire
			return;
		}
		int[][] tmpL;
		boolean[][] tmpS;
		//TODO: j'ai sûrement inversé rotation 90 et -90, à vérifier
		if(	(orient == Orientation.North && this.orient == Orientation.East)
				||	(orient == Orientation.East && this.orient == Orientation.South)
				||	(orient == Orientation.South && this.orient == Orientation.West)
				||	(orient == Orientation.West && this.orient == Orientation.North)){
			//rotation 90°
			tmpL = new int[lives[0].length][lives.length];
			tmpS = new boolean[shape[0].length][shape.length];
			for(int i = 0 ; i < lives[0].length ; i++){
				for(int j = 0 ; j < lives.length ; j++){
					tmpL[i][j] = lives[j][i];
					tmpS[i][j] = shape[j][i];
				}
			}
			lives = tmpL;
			shape = tmpS;
		}
		else if(	(orient == Orientation.North && this.orient == Orientation.South)
				||	(orient == Orientation.East && this.orient == Orientation.West)
				||	(orient == Orientation.South && this.orient == Orientation.North)
				||	(orient == Orientation.West && this.orient == Orientation.East)){
			//rotation 180°
			tmpL = new int[lives.length][lives[0].length];
			tmpS = new boolean[lives.length][lives[0].length];
			for(int i = 0 ; i < lives.length ; i++){
				for(int j = 0 ; j < lives[0].length ; j++){
					tmpL[i][j] = lives[i][lives[0].length - 1 - j];
					tmpS[i][j] = shape[i][lives[0].length - 1 - j];
				}
			}
			lives = tmpL;
			shape = tmpS;
			
		}	
		else if(	(orient == Orientation.North && this.orient == Orientation.West)
				||	(orient == Orientation.East && this.orient == Orientation.North)
				||	(orient == Orientation.South && this.orient == Orientation.East)
				||	(orient == Orientation.West && this.orient == Orientation.South)){
			//rotation -90°
			tmpL = new int[lives[0].length][lives.length];
			tmpS = new boolean[shape[0].length][shape.length];
			for(int i = 0 ; i < lives[0].length ; i++){
				for(int j = 0 ; j < lives.length ; j++){
					tmpL[i][j] = lives[lives.length - 1 - j ][lives[0].length - 1 - i];
					tmpS[i][j] = shape[lives.length - 1 - j][lives[0].length - 1 - i];
				}
			}
			lives = tmpL;	
			shape = tmpS;		
			
		}
		else if(this.orient == null){
			//rien à faire
		}
		else{
			System.out.println("cas non géré: " +  orient + " " + this.orient);
		}

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
	public int isReadyToFireIn() {
		return readyToFireIn;
	}


	@Override
	public void setReadyToFireIn(int i) {
		readyToFireIn = i;
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
	public int getCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		
		return shape.length;
	}

	@Override
	public int getHeight() {
		return shape[0].length;
	}
	
	
	
	@Override
	public boolean overlap(int x, int y){
		return  x >= positionX && x < positionX + getWidth()
				&& y >= positionY && y < positionY + getHeight()
				&& shape[x-positionX][y-positionY];		
	}
	@Override
	public boolean overlap(Square s){
		return overlap(s.getX(), s.getY());
	}
	@Override
	public boolean toucher(int x, int y, int degat){
		boolean res=false;
		if(overlap(x,y)){
			if(lives[x-positionX]
					[y-positionY]>0){
				if( getArmor() < degat){
					lives[x-positionX][y-positionY]+= getArmor()-degat;
					res=true;
				}
			}
		}
		return res;
	}
	
	@Override
	public TypeShip getType(){
		return type;
	}
	
	@Override
	public void addUpgrade(StatType type){
		int nb=upgrade.get(type)+1;
		upgrade.put(type, nb);
	}
	
	@Override
	public int getUpgrade(StatType type){
		return upgrade.get(type);
	}
	
	@Override
	public Map<StatType,Integer> upgrade(){
		return upgrade();
	}
	
	@Override 
	public int getStatmax(StatType type){
		return statmax.get(type);
	}
	@Override 
	public int getCostUpgrade(){
		return 0;
	}
	@Override
	public StatType getStat(){
		return null;
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
