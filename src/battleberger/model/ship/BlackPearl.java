package battleberger.model.ship;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShip.Orientation;
import battleberger.model.FireShape;

public class BlackPearl extends AbstractShip{
	public BlackPearl(Orientation ori, int x, int y,String chemin){
		orient=ori;
		positionX=x;
		positionY=y;
		boolean[][] b={{true,true,false,false},{false,true,true,true},{true,true,false,false}};
		shape=b;
		int[][]vie ={{1,2,0,0,},{0,3,2,1},{1,2,0,0}};
		lives=vie;
		imagepath=chemin;
		FireShape.plusShape();
		 calculeNbEqiupMax();
		 Name();
	}

	@Override
	public int getPower() {
		return 4;
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
		return 3;
	}
}
