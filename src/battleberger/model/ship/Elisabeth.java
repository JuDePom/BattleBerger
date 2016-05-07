package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class Elisabeth extends Ship {

	public Elisabeth(Orientation ori, int x, int y,String chemin){
		
		positionX=x;
		positionY=y;
		boolean[][] b={{false,true,true},{true,true,false},{true,true,false},{false,true,true}};
		int[][] vie={{0,2,1},{2,3,0},{2,3,0},{0,2,1}};
		lives=vie;

		setShapeNorth(b, ori);
		
		imagepath=chemin;
		fireshape=FireShape.bigShape();
		this.confStatMax(6, 3, 4, 2);
		calculeNbEquipMax();
		Name();
	}

	@Override
	public int getPower() {
		return 8;
	}

	@Override
	public int getArmor() {
		return 3;
	}

	@Override
	public int getMovSpeed() {
		return 1;
	}

	@Override
	public int getCooldown() {
		return 5;
	}
	
}
