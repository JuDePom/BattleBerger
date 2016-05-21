package battleberger.model.decorateur;

import java.io.Serializable;

import battleberger.model.AbstractShip;
import battleberger.model.Ship.StatType;

public class Armory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Armory(){
		
	}
	
	public AbstractShip buildUpgrade(StatType type,AbstractShip ship){
		AbstractShip sheep;
		switch(type){
		case Armor:
			sheep = new Armor(ship);
			break;
		case MovSpeed :
			sheep = new MovSpeed(ship);
			break;
		case Power :
			sheep = new Power(ship);
			break;
		case ReloadSpeed : 
			sheep = new ReloadSpeed(ship);
			break;
			default : sheep =null;
		}
		return sheep;
	}
}
