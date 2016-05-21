package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.Ship.StatType;
import battleberger.model.FireShape;

public class Kevin extends Ship {

	public Kevin(Orientation ori, int x, int y,String chemin){

		type=TypeShip.Kevin;
		positionX=x;
		positionY=y;
		boolean[][] b = new boolean[][]{{true}};
		lives=new int[1][1];
		lives[0][0]=1;
		setShapeNorth(b, ori);
		
		imagepath=chemin;
		fireshape=FireShape.standardShape();
		this.confStatMax(1, 1, 1, 0);
		calculeNbEquipMax();
		Name();
		instanceUpgrade();
		setName(type.name());
	}

	@Override
	public int getPower() {
		return 1+getUpgrade(StatType.Power);
	}

	@Override
	public int getArmor() {
		return 0+getUpgrade(StatType.Armor);
	}

	@Override
	public int getMovSpeed() {
		return 4+getUpgrade(StatType.MovSpeed);
	}

	@Override
	public int getCooldown() {
		
		return 1;
	}
	
}
