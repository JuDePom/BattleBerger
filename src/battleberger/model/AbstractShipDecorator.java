package battleberger.model;

import battleberger.model.AbstractShip.StatType;

public abstract class AbstractShipDecorator extends AbstractAbstractShip {
// faire une augmentation expodentiel du prisx de l'amrure a chaque achat 
	protected AbstractAbstractShip next;
	protected StatType stat; 
	@Override
	public int getPower() {
		return next.getPower();
	}

	@Override
	public int getArmor() {		
		return next.getArmor();
	}

	@Override
	public int getMovSpeed() {
		return next.getMovSpeed();
	}
	
	@Override
	public int getReloadSpeed(){
		return next.getReloadSpeed();
	}
}
