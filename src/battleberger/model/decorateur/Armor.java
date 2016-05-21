package battleberger.model.decorateur;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShipDecorator;
import battleberger.model.Ship.StatType;

public class Armor extends AbstractShipDecorator{
	
	public Armor(AbstractShip ship){
		next=ship;
		name="Armor";
		costUpgrade=10;
		if(ship!=null)
		ship.addUpgrade(StatType.Armor);
	}
	@Override
	public int getArmor() {		
		return next.getArmor();
	}
	
	
}
