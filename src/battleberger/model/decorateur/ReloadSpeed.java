package battleberger.model.decorateur;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShipDecorator;

public class ReloadSpeed extends AbstractShipDecorator{
	public ReloadSpeed(AbstractShip ship){
		next=ship;
		name="reloadSpeed";
	}
	@Override
	public int getReloadSpeed() {		
		return 1+next.getReloadSpeed();
	}
}
