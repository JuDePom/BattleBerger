package battleberger.model.decorateur;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShipDecorator;
import battleberger.model.Ship.StatType;

public class ReloadSpeed extends AbstractShipDecorator{
	public ReloadSpeed(AbstractShip ship){
		next=ship;
		name="reloadSpeed";
		costUpgrade=10;
		if(ship!=null)
		ship.addUpgrade(StatType.ReloadSpeed);
	}
	@Override
	public int getCooldown() {	
		int rs=next.getCooldown()-1;
		if(rs<1)rs=1;
		return rs;
	}
}
