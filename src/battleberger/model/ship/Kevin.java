package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class Kevin extends Ship {

	public Kevin(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		shape=new boolean[1][1];
		lives=new int[1][1];
		shape[0][0]=true;
		lives[0][0]=1;
		imagepath=chemin;
		fireshape=FireShape.standardShape();
		this.confStatMax(1, 1, 1, 1);
		calculeNbEquipMax();
		Name();
	}

	@Override
	public int getPower() {
		return 1;
	}

	@Override
	public int getArmor() {
		return 0;
	}

	@Override
	public int getMovSpeed() {
		return 4;
	}

	@Override
	public int getReloadSpeed() {
		return 1;
	}
	
}
