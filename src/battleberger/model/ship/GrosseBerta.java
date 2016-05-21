package battleberger.model.ship;

import battleberger.model.Ship;
import battleberger.model.Ship.StatType;
import battleberger.model.FireShape;

public class GrosseBerta extends Ship {

	public GrosseBerta(Orientation ori, int x, int y,String chemin){
		cost=12;
		positionX=x;
		positionY=y;
		boolean[][] tmpS = new boolean[2][4];
		lives=new int[2][4];
		for(int i=0;i<tmpS.length;i++){
			for(int j=0;j<tmpS[0].length;j++){
				tmpS[i][j]=true;
				lives[i][j]=2;
			}
		}
		type=TypeShip.GrosseBerta;
		setShapeNorth(tmpS, ori);
		imagepath=chemin;
		fireshape=FireShape.nuclearShape();
		this.confStatMax(8, 1, 1, 5);
		calculeNbEquipMax();
		Name();
		instanceUpgrade();
		setName(type.name());
	}

	@Override
	public int getPower() {
		return 14+getUpgrade(StatType.Power);
	}

	@Override
	public int getArmor() {
		return 4+getUpgrade(StatType.Armor);
	}

	@Override
	public int getMovSpeed() {
		return 1+getUpgrade(StatType.MovSpeed);
	}

	@Override
	public int getCooldown() {
		int res=10-getUpgrade(StatType.ReloadSpeed);
		if(res<1)res=1;
		return res;
	}
	
}
