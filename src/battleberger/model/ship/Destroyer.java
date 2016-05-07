package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.FireShape;

public class Destroyer extends Ship {

	public Destroyer(Orientation ori, int x, int y,String chemin){
		
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false,false},{false,true,true},{true,false,false}};
		int[][] vie={{1,0,0},{0,2,1},{1,0,0}};
		lives=vie;
		setShapeNorth(b, ori);
		
		imagepath=chemin;
		fireshape=FireShape.crossShape();
		this.confStatMax(4, 2, 2, 2);
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
	public int getCooldown() {
		return 3;
	}
	
}
