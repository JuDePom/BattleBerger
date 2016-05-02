package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.FireShape;


public class SubMarine extends Ship {

	public SubMarine(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false,true,false,true}};
		shape=b;
		int[][] vie={{2,0,2,0,2}};
		lives=vie;
		
		imagepath=chemin;
		fireshape=FireShape.standardShape();
		calculeNbEqiupMax();
		Name();
	}

	@Override
	public int getPower() {
		return 4;
	}

	@Override
	public int getArmor() {
		return 1;
	}

	@Override
	public int getMovSpeed() {
		return 1;
	}

	@Override
	public int getReloadSpeed() {
		return 3;
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
