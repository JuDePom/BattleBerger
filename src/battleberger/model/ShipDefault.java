package battleberger.model;

public class ShipDefault extends AbstractShip {

	public ShipDefault(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		shape=new boolean[1][2];
		lives=new int[1][2];
		for(int i=0;i<shape.length;i++){
			for(int j=0;j<shape[0].length;j++){
				shape[i][j]=true;
				lives[i][j]=1;
			}
		}
		imagepath=chemin;
	}
}
