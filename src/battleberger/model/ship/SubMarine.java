package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.FireShape;


public class SubMarine extends Ship {

	public SubMarine(Orientation ori, int x, int y,String chemin){
		
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false,true,false,true}};
		shapeNorth=b;
		int[][] vie={{2,0,2,0,2}};
		lives=vie;
		setOrient(ori);
		
		
		imagepath=chemin;
		fireshape=FireShape.standardShape();
		this.confStatMax(3, 3, 2, 2);
		calculeNbEquipMax();
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
