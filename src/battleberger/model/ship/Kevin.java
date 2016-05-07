package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class Kevin extends Ship {

	public Kevin(Orientation ori, int x, int y,String chemin){


		positionX=x;
		positionY=y;
		shapeNorth=new boolean[1][1];
		lives=new int[1][1];
		shapeNorth[0][0]=true;
		lives[0][0]=1;
		setOrient(ori);
		
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
