package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class Commander extends Ship {

	public Commander(Orientation ori, int x, int y,String chemin){
		cost=4;
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false,false,false},{true,true,true,true},{true,false,false,false}};
		int[][] vie={{1,0,0,0},{3,2,2,1},{1,0,0,0}};
		lives=vie;
		setShapeNorth(b, ori);
		type=TypeShip.Commander;
		imagepath=chemin;
		fireshape=FireShape.lineShape();
		this.confStatMax(3, 3, 1, 2);
		calculeNbEquipMax();
		Name();
		instanceUpgrade();
		setName(type.name());
	}

	@Override
	public int getPower() {
		return 5;
	}

	@Override
	public int getArmor() {
		return 2;
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
