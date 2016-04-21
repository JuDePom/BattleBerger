package battleberger.model.decorateur;

import battleberger.model.AbstractAbstractShip;
import battleberger.model.AbstractShipDecorator;

public class Armor extends AbstractShipDecorator{
	
	public Armor(AbstractAbstractShip ship){
		next=ship;
		name="Armor";
	}
	@Override
	public int getArmor() {		
		return 1+next.getArmor();
	}
}
