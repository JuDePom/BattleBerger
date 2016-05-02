package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class ChuckNoris extends Ship {

	public ChuckNoris(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		boolean[][] b = {{true,true,true},{true,false,false},{true,true,true}};
		shape=b;
		int[][] vie={{3,2,2},{3,0,0},{3,2,2}};
		lives= vie;
		
		imagepath=chemin;
		fireshape=FireShape.norisShape();
		calculeNbEqiupMax();
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
	@Override
	public boolean toucher(int x, int y, int degat){
		boolean res=false;
		int c=positionX;
		while(c<(positionX+getWidth())){
			if(c==x){
				c=positionY;
				while(c<(positionY+getHeight())){
					if(c==y)
						if(lives[y-positionY][x-positionX]>0){
							int armor = getArmor();
							lives[y-positionY][x-positionX]-=armor-degat;
							res=true;
						}
				}
			}
		}
		return res;
	}
}
