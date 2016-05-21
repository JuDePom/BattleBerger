package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.Ship.StatType;
import battleberger.model.FireShape;

public class Spy extends Ship {

	public Spy(Orientation ori, int x, int y,String chemin){
		cost=3;
		positionX=x;
		positionY=y;
		boolean[][] b={{true,false},{false,true}};
		int[][] vie={{1,0},{0,1}};
		lives=vie;
		setShapeNorth(b, ori);
		
		type=TypeShip.Spy;
		imagepath=chemin;
		fireshape=FireShape.standardShape();
		this.confStatMax(2, 2, 2, 1);
		calculeNbEquipMax();
		Name();
		instanceUpgrade();
		setName(type.name());
	}

	@Override
	public int getPower() {
		return 3+getUpgrade(StatType.Power);
	}

	@Override
	public int getArmor() {
		return 0+getUpgrade(StatType.Armor);
	}

	@Override
	public int getMovSpeed() {
		return 2+getUpgrade(StatType.MovSpeed);
	}

	@Override
	public int getCooldown() {
		int res=2-getUpgrade(StatType.ReloadSpeed);
		if(res<1)res=1;
		return res;
	}
	
}
