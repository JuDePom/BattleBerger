package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class Spy extends Ship {

	public Spy(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false},{false,true}};
		shape=b;
		int[][] vie={{1,0},{0,1}};
		lives=vie;
		imagepath=chemin;
		fireshape=FireShape.standardShape();
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
		return 2;
	}

	@Override
	public int getReloadSpeed() {
		return 2;
	}
	
}
