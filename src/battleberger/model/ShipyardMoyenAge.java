package battleberger.model;

import battleberger.model.Ship.Orientation;
import battleberger.model.Ship.TypeShip;
import battleberger.model.ship.BlackPearl;
import battleberger.model.ship.ChuckNoris;
import battleberger.model.ship.Commander;
import battleberger.model.ship.Destroyer;
import battleberger.model.ship.Elisabeth;
import battleberger.model.ship.Frigate;
import battleberger.model.ship.GrosseBerta;
import battleberger.model.ship.Kevin;
import battleberger.model.ship.ShipDefault;
import battleberger.model.ship.Spy;
import battleberger.model.ship.SubMarine;

public class ShipyardMoyenAge extends AbstractShipyard {
	
	public ShipyardMoyenAge(){
		
	}
	public AbstractShip buildShip(TypeShip ship,int x, int y) {
		AbstractShip sheep;
		switch(ship){
		case ShipDefault :
			 sheep =new ShipDefault(Orientation.North,x,y,"battleberger/texture");
			 break;
		case Kevin :
			sheep =new Kevin(Orientation.North,x,y,"battleberger/texture");
			break;
		case Frigate :
			sheep =new Frigate(Orientation.North,x,y,"battleberger/texture");
			break;
		case BlackPearl : 
			sheep =new BlackPearl(Orientation.North,x,y,"battleberger/texture");
			break;
		case Commander :
			sheep =new Commander(Orientation.North,x,y,"battleberger/texture");
			break;
		case Destroyer :
			sheep =new Destroyer(Orientation.North,x,y,"battleberger/texture");
			break;
		case Spy :
			sheep =new Spy(Orientation.North,x,y,"battleberger/texture");
			break;
			 default :
		sheep=null;		 
		}
		
		return sheep;
	}
	
}
