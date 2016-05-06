package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class Commander extends Ship {

	public Commander(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false,false,false},{true,true,true,true},{true,false,false,false}};
		shape=b;
		int[][] vie={{1,0,0,0},{3,2,2,1},{1,0,0,0}};
		lives=vie;
		
		imagepath=chemin;
		fireshape=FireShape.lineShape();
		this.confStatMax(3, 3, 1, 2);
		calculeNbEquipMax();
		Name();
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
	public int getReloadSpeed() {
		return 3;
	}
	
}
