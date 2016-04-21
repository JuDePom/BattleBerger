package battleberger.model.decorateur;

import battleberger.model.AbstractAbstractShip;
import battleberger.model.AbstractShipDecorator;

public class ReloadSpeed extends AbstractShipDecorator{
	public ReloadSpeed(AbstractAbstractShip ship){
		next=ship;
		name="reloadSpeed";
	}
	@Override
	public int getReloadSpeed() {		
		return 1+next.getReloadSpeed();
	}
}
