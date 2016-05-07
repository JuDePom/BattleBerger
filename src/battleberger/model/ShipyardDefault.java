package battleberger.model;

import battleberger.model.Ship.Orientation;
import battleberger.model.Ship.TypeShip;
import battleberger.model.ship.*;

public class ShipyardDefault extends AbstractShipyard {
	
	public ShipyardDefault(){
		
	}
	public AbstractShip buildShip(TypeShip ship,int x, int y) {
		AbstractShip sheep;
		switch(ship){
		case ShipDefault :
			 sheep = new ShipDefault(Orientation.North, x, y, "assets/images/epoque1/Default");
			 break;
		case Kevin :
			sheep = new Kevin(Orientation.North,x,y,"assets/images/epoque1/Kevin");
			break;
		case Frigate :
			sheep = new Frigate(Orientation.North,x,y,"assets/images/epoque1/Frigate");
			break;
		case BlackPearl : 
			sheep = new BlackPearl(Orientation.North,x,y,"assets/images/epoque1/BlackPearl");
			break;
		case ChuckNoris :
			sheep = new ChuckNoris(Orientation.North,x,y,"assets/images/epoque1/ChuckNoris");
			break;
		case Commander :
			sheep = new Commander(Orientation.North,x,y,"assets/images/epoque1/Commander");
			break;
		case Destroyer :
			sheep = new Destroyer(Orientation.North,x,y,"assets/images/epoque1/Destroyer");
			break;
		case Elisabeth :
			sheep = new Elisabeth(Orientation.North,x,y,"assets/images/epoque1/Elisabeth");
			break;
		case GrosseBerta :
			sheep = new GrosseBerta(Orientation.North,x,y,"assets/images/epoque1/GrosseBerta");
			break;
		case Spy :
			sheep = new Spy(Orientation.North,x,y,"assets/images/epoque1/Spy");
			break;
		case SubMarine :
			sheep = new SubMarine(Orientation.North,x,y,"assets/images/epoque1/SubMarine");
			break;
		default :
			sheep=null;		 
		}
		
		return sheep;
	}
	
}
