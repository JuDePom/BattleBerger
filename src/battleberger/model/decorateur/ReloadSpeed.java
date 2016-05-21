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
		return next.getCooldown();
		
	}
}
