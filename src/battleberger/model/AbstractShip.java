package battleberger.model;

public abstract class AbstractShip {
	protected boolean[][] shape;
	public enum Orientation {North,South,East,West};
	public enum TypeShip{BattleShip,CommanderShip,SpyShip,KevinShip,Destroyer,SubMarine,ElisabethShip,GrosseBertaShip,ChuckNorisShip,DefaultShip}
	protected Orientation orient;
	protected String imagepath;
	protected int[][] lives; // 
	protected int positionX;
	protected int positionY;
	//savoir si il est vivant ou non sera calculer avec lives 
	//potentiellement si une case brule ou non => tableau de boolean  
	// un truc pour avoir une époque qui ne change pas 
	//potentiellement a chaque tour, on peut bouger un bateau ou son orientation
	
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
