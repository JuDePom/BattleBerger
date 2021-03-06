package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.Ship.StatType;
import battleberger.model.FireShape;

public class Elisabeth extends Ship {

	public Elisabeth(Orientation ori, int x, int y,String chemin){
		cost=12;
		positionX=x;
		positionY=y;
		boolean[][] b={{false,true,true},{true,true,false},{true,true,false},{false,true,true}};
		int[][] vie={{0,2,1},{2,3,0},{2,3,0},{0,2,1}};
		lives=vie;
		type=TypeShip.Elisabeth;
		setShapeNorth(b, ori);
		
		imagepath=chemin;
		fireshape=FireShape.bigShape();
		this.confStatMax(6, 3, 4, 2);
		calculeNbEquipMax();
		Name();
		instanceUpgrade();
		setName(type.name());
	}

	@Override
	public int getPower() {
		return 8+getUpgrade(StatType.Power);
	}

	@Override
	public int getArmor() {
		return 3+getUpgrade(StatType.Armor);
	}

	@Override
	public int getMovSpeed() {
		return 1+getUpgrade(StatType.MovSpeed);
	}

	@Override
	public int getCooldown() {
		int res=5-getUpgrade(StatType.ReloadSpeed);
		if(res<1)res=1;
		return res;
	}
	
}
