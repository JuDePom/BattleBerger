package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.Ship.StatType;
import battleberger.model.FireShape;


public class SubMarine extends Ship {

	public SubMarine(Orientation ori, int x, int y,String chemin){
		cost=4;
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false,true,false,true}};
		int[][] vie={{2,0,2,0,2}};
		lives=vie;
		setShapeNorth(b, ori);
		type=TypeShip.SubMarine;
		
		imagepath=chemin;
		fireshape=FireShape.standardShape();
		this.confStatMax(3, 3, 2, 2);
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
		int res=3-getUpgrade(StatType.ReloadSpeed);
		if(res<1)res=1;
		return res;
	}
	
}
