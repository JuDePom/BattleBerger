package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.FireShape;

public class ShipDefault extends Ship {

	public ShipDefault(Orientation ori, int x, int y,String chemin){
		
		positionX=x;
		positionY=y;
		shapeNorth=new boolean[1][2];
		lives=new int[1][2];
		for(int i=0;i<shapeNorth.length;i++){
			for(int j=0;j<shapeNorth[0].length;j++){
				shapeNorth[i][j]=true;
				lives[i][j]=1;
			}
		}
		setOrient(ori);
		
		
		imagepath=chemin;
		fireshape = FireShape.standardShape();
		this.confStatMax(2, 2, 1, 2);
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
		return 2;
	}

	@Override
	public int getReloadSpeed() {
		return 2;
	}
	
}
