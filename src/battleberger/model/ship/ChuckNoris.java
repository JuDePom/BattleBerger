package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.Ship.StatType;
import battleberger.model.FireShape;

public class ChuckNoris extends Ship {

	public ChuckNoris(Orientation ori, int x, int y,String chemin){
		cost=7;
		positionX = x;
		positionY = y;
		boolean[][] b = {{true,true,true},{true,false,false},{true,true,true}};
		int[][] vie = {{3,2,2},{3,0,0},{3,2,2}};
		lives = vie;
		setShapeNorth(b, ori);
		type=TypeShip.ChuckNoris;
		imagepath = chemin;
		fireshape = FireShape.norisShape();
		this.confStatMax(5, 3, 3, 2);
		calculeNbEquipMax();
		Name();
		instanceUpgrade();
		setName(type.name());
	}

	@Override
	public int getPower() {
		return 7+getUpgrade(StatType.Power);
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
