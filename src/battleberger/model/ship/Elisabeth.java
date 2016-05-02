package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class Elisabeth extends Ship {

	public Elisabeth(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		boolean[][] b={{false,true,true},{true,true,false},{true,true,false},{false,true,true}};
		shape=b;
		int[][] vie={{0,2,1},{2,4,0},{2,4,0},{0,2,1}};
		lives=vie;
		
		imagepath=chemin;
		fireshape=FireShape.bigShape();
		calculeNbEqiupMax();
		Name();
	}

	@Override
	public int getPower() {
		return 8;
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
		return 6;
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
