package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.Ship.StatType;
import battleberger.model.FireShape;

public class ShipDefault extends Ship {

	public ShipDefault(Orientation ori, int x, int y,String chemin){
		cost=2;
		positionX=x;
		positionY=y;
		boolean[][] b = new boolean[1][2];
		lives=new int[1][2];
		for(int i=0;i< b.length;i++){
			for(int j=0;j < b[0].length;j++){
				b[i][j]=true;
				lives[i][j]=1;
			}
		}
		setShapeNorth(b, ori);
		type=TypeShip.ShipDefault;
		
		imagepath=chemin;
		fireshape = FireShape.standardShape();
		this.confStatMax(2, 2, 1, 2);
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
		return 2+getUpgrade(StatType.MovSpeed);
	}

	@Override
	public int getCooldown() {
		int res=2-getUpgrade(StatType.ReloadSpeed);
		if(res<1)res=1;
		return res;
	}
	
}
