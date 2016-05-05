package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.FireShape;

public class Destroyer extends Ship {

	public Destroyer(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false,false},{false,true,true},{true,false,false}};
		shape=b;
		int[][] vie={{1,0,0},{0,2,1},{1,0,0}};
		lives=vie;
		imagepath=chemin;
		fireshape=FireShape.crossShape();
		calculeNbEqiupMax();
		Name();
	}

	@Override
	public int getPower() {
		return 3;
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
		return 3;
	}
	
}
