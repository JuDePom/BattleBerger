package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class GrosseBerta extends Ship {

	public GrosseBerta(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		shape=new boolean[2][4];
		lives=new int[2][4];
		for(int i=0;i<shape.length;i++){
			for(int j=0;j<shape[0].length;j++){
				shape[i][j]=true;
				lives[i][j]=2;
			}
		}
		imagepath=chemin;
		fireshape=FireShape.nuclearShape();
		calculeNbEqiupMax();
		Name();
	}

	@Override
	public int getPower() {
		return 10;
	}

	@Override
	public int getArmor() {
		return 5;
	}

	@Override
	public int getMovSpeed() {
		return 1;
	}

	@Override
	public int getReloadSpeed() {
		return 8;
	}
}
