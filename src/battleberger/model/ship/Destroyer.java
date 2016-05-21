package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.Ship.StatType;
import battleberger.model.FireShape;

public class Destroyer extends Ship {

	public Destroyer(Orientation ori, int x, int y,String chemin){
		cost=5;
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false,false},{false,true,true},{true,false,false}};
		int[][] vie={{1,0,0},{0,2,1},{1,0,0}};
		lives=vie;
		setShapeNorth(b, ori);
		type=TypeShip.Destroyer;
		imagepath=chemin;
		fireshape=FireShape.crossShape();
		this.confStatMax(4, 2, 2, 2);
		calculeNbEquipMax();
		Name();
		instanceUpgrade();
		setName(type.name());
	}

	@Override
	public int getPower() {
		return 4+getUpgrade(StatType.Power);
	}

	@Override
	public int getArmor() {
		return 1+getUpgrade(StatType.Armor);
	}

	@Override
	public int getMovSpeed() {
		return 1+getUpgrade(StatType.MovSpeed);
	}

	@Override
	public int getCooldown() {
		int res=3-getUpgrade(StatType.ReloadSpeed);;
		if(res<1)res=1;
		return res;
	}
	
}
