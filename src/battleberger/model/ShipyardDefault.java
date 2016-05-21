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
			 sheep = new ShipDefault(Orientation.North, x, y, "/images/Default/ShipDefault");
			 break;
		case Kevin :
			sheep = new Kevin(Orientation.North,x,y,"/images/Default/Kevin");
			break;
		case Frigate :
			sheep = new Frigate(Orientation.North,x,y,"/images/Default/Frigate");
			break;
		case BlackPearl : 
			sheep = new BlackPearl(Orientation.North,x,y,"/images/Default/BlackPearl");
			break;
		case ChuckNoris :
			sheep = new ChuckNoris(Orientation.North,x,y,"/images/Default/ChuckNoris");
			break;
		case Commander :
			sheep = new Commander(Orientation.North,x,y,"/images/Default/Commander");
			break;
		case Destroyer :
			sheep = new Destroyer(Orientation.North,x,y,"/images/Default/Destroyer");
			break;
		case Elisabeth :
			sheep = new Elisabeth(Orientation.North,x,y,"/images/Default/Elisabeth");
			break;
		case GrosseBerta :
			sheep = new GrosseBerta(Orientation.North,x,y,"/images/Default/GrosseBerta");
			break;
		case Spy :
			sheep = new Spy(Orientation.North,x,y,"/images/Default/Spy");
			break;
		case SubMarine :
			sheep = new SubMarine(Orientation.North,x,y,"/images/Default/SubMarine");
			break;
		default :
			sheep=null;		 
		}
		
		return sheep;
	}
	
}
