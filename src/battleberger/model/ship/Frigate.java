package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.Ship.StatType;
import battleberger.model.FireShape;

public class Frigate extends Ship {

	public Frigate(Orientation ori, int x, int y,String chemin){
		cost=3;
		positionX=x;
		positionY=y;
		boolean[][] b = new boolean[1][4];
		lives=new int[1][4];
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b[0].length;j++){
				b[i][j]=true;
				lives[i][j]=1;
			}
		}
		setShapeNorth(b, ori);
		type=TypeShip.Frigate;
		imagepath=chemin;
		fireshape=FireShape.standardShape();
		this.confStatMax(3, 3, 1, 2);
		calculeNbEquipMax();
		Name();
		instanceUpgrade();
		setName(type.name());
	}

	@Override
	public int getPower() {
		return 2+getUpgrade(StatType.Power);
	}

	@Override
	public int getArmor() {
		return 0+getUpgrade(StatType.Armor);
	}

	@Override
	public int getMovSpeed() {
		return 1+getUpgrade(StatType.MovSpeed);
	}

	@Override
	public int getCooldown() {
		int res=2-getUpgrade(StatType.ReloadSpeed);
		if(res<1)res=1;
		return res;
	}
	
}
