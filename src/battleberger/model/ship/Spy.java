package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class Spy extends Ship {

	public Spy(Orientation ori, int x, int y,String chemin){
		
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false},{false,true}};
		shapeNorth=b;
		int[][] vie={{1,0},{0,1}};
		lives=vie;
		setOrient(ori);
		
		
		imagepath=chemin;
		fireshape=FireShape.standardShape();
		this.confStatMax(2, 2, 2, 1);
		calculeNbEquipMax();
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
		return 2;
	}

	@Override
	public int getReloadSpeed() {
		return 2;
	}
	
}
