package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class GrosseBerta extends Ship {

	public GrosseBerta(Orientation ori, int x, int y,String chemin){
		
		positionX=x;
		positionY=y;
		boolean[][] tmpS = new boolean[2][4];
		lives=new int[2][4];
		for(int i=0;i<tmpS.length;i++){
			for(int j=0;j<tmpS[0].length;j++){
				tmpS[i][j]=true;
				lives[i][j]=2;
			}
		}
		setShapeNorth(tmpS, ori);
		imagepath=chemin;
		fireshape=FireShape.nuclearShape();
		this.confStatMax(8, 1, 1, 5);
		calculeNbEquipMax();
		Name();
	}

	@Override
	public int getPower() {
		return 14;
	}

	@Override
	public int getArmor() {
		return 4;
	}

	@Override
	public int getMovSpeed() {
		return 1;
	}

	@Override
	public int getReloadSpeed() {
		return 10;
	}
	
}
