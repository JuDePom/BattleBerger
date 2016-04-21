package battleberger.model.ship;

import battleberger.model.AbstractShip;
import battleberger.model.FireShape;
import battleberger.model.AbstractShip.Orientation;

public class SubMarine extends AbstractShip {

	public SubMarine(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false,true,false,true}};
		shape=b;
		int[][] vie={{2,0,2,0,2}};
		lives=vie;
		
		imagepath=chemin;
		fireshape=FireShape.standardShape();
		calculeNbEqiupMax();
		Name();
	}

	@Override
	public int getPower() {
		return 4;
	}

	@Override
	public int getArmor() {
		return 1;
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
