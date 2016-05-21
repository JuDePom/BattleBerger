package battleberger.model.ship;

import battleberger.model.Ship;

import battleberger.model.FireShape;

public class BlackPearl extends Ship{
	public BlackPearl(Orientation ori, int x, int y,String chemin){
		cost=7;
		positionX = x;
		positionY = y;
		lives =	new int[][]{ {1,2,0,0}, {0,3,2,1}, {1,2,0,0} };
		setShapeNorth(new boolean[][]{{true,true,false,false},{false,true,true,true},{true,true,false,false}}, ori);
		type=TypeShip.BlackPearl;
		
		instanceUpgrade();
		imagepath = chemin;
		fireshape = FireShape.plusShape();
		this.confStatMax(4, 3, 2,2);
		calculeNbEquipMax();
		Name();
	}

	@Override
	public int getPower() {
		return 6+getUpgrade(StatType.Power);
	}

	@Override
	public int getArmor() {
		return 2+getUpgrade(StatType.Armor);
	}

	@Override
	public int getMovSpeed() {
		return 2+getUpgrade(StatType.MovSpeed);
	}

	@Override
	public int getCooldown() {
		int res=4-getUpgrade(StatType.ReloadSpeed);
		if(res<1)res=1;
		return res;
	}
	
}
