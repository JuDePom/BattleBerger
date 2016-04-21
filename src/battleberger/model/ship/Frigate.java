package battleberger.model.ship;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShip.Orientation;
import battleberger.model.FireShape;

public class Frigate extends AbstractShip {

	public Frigate(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		shape=new boolean[1][4];
		lives=new int[1][4];
		for(int i=0;i<shape.length;i++){
			for(int j=0;j<shape[0].length;j++){
				shape[i][j]=true;
				lives[i][j]=1;
			}
		}
		imagepath=chemin;
		fireshape=FireShape.standardShape();
		this.confStatMax(3, 3, 1, 2);
		calculeNbEqiupMax();
		Name();
	}

	@Override
	public int getPower() {
		return 2;
	}

	@Override
	public int getArmor() {
		return 0;
	}

	@Override
	public int getMovSpeed() {
		return 1;
	}

	@Override
	public int getReloadSpeed() {
		return 2;
	}
}
