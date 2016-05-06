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
		int rs=next.getReloadSpeed()-1;
		if(rs<1)rs=1;
		return rs;
	}
}
