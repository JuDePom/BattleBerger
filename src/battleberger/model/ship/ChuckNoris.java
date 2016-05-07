package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class ChuckNoris extends Ship {

	public ChuckNoris(Orientation ori, int x, int y,String chemin){
		
		positionX = x;
		positionY = y;
		boolean[][] b = {{true,true,true},{true,false,false},{true,true,true}};
		shapeNorth = b;
		int[][] vie = {{3,2,2},{3,0,0},{3,2,2}};
		lives = vie;
		setOrient(ori);
		
		imagepath = chemin;
		fireshape = FireShape.norisShape();
		this.confStatMax(5, 3, 3, 2);
		calculeNbEquipMax();
		Name();
	}

	@Override
	public int getPower() {
		return 7;
	}

	@Override
	public int getArmor() {
		return 2;
	}

	@Override
	public int getMovSpeed() {
		return 2;
	}

	@Override
	public int getReloadSpeed() {
		return 4;
	}
	
}
