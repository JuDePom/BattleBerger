package battleberger.model;

import battleberger.model.AbstractShip.Orientation;
import battleberger.model.AbstractShip.TypeShip;
import battleberger.model.ship.*;

public class ShipyardDefault extends AbstractShipyard {
	
	public ShipyardDefault(){
		
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
		case ChuckNoris :
			sheep =new ChuckNoris(Orientation.North,x,y,"battleberger/texture");
			break;
		case Commander :
			sheep =new Commander(Orientation.North,x,y,"battleberger/texture");
			break;
		case Destroyer :
			sheep =new Destroyer(Orientation.North,x,y,"battleberger/texture");
			break;
		case Elisabeth :
			sheep =new Elisabeth(Orientation.North,x,y,"battleberger/texture");
			break;
		case GrosseBerta :
			sheep =new GrosseBerta(Orientation.North,x,y,"battleberger/texture");
			break;
		case Spy :
			sheep =new Spy(Orientation.North,x,y,"battleberger/texture");
			break;
		case SubMarine :
			sheep =new SubMarine(Orientation.North,x,y,"battleberger/texture");
			break;
			 default :
		sheep=null;		 
		}
		
		return sheep;
	}
	
}
