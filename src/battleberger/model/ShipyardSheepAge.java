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

public class ShipyardSheepAge extends AbstractShipyard {
	
	public ShipyardSheepAge(){
		
	}
	public AbstractShip buildShip(TypeShip ship,int x, int y) {
		AbstractShip sheep;
		switch(ship){
		case ShipDefault :
			 sheep =new ShipDefault(Orientation.North,x,y,"/images/SheepAge/ShipDefault");
			 break;
		case Kevin :
			sheep =new Kevin(Orientation.North,x,y,"/images/SheepAge/Kevin");
			break;
		case Frigate :
			sheep =new Frigate(Orientation.North,x,y,"/images/SheepAge/Frigate");
			break;
		case BlackPearl : 
			sheep =new BlackPearl(Orientation.North,x,y,"/images/SheepAge/BlackPearl");
			break;
		case ChuckNoris :
			sheep =new ChuckNoris(Orientation.North,x,y,"/images/SheepAge/ChuckNoris");
			break;
		case Commander :
			sheep =new Commander(Orientation.North,x,y,"/images/SheepAge/Commander");
			break;
		case Destroyer :
			sheep =new Destroyer(Orientation.North,x,y,"/images/SheepAge/Destroyer");
			break;
		case Elisabeth :
			sheep =new Elisabeth(Orientation.North,x,y,"/images/SheepAge/Elisabeth");
			break;
		case GrosseBerta :
			sheep =new GrosseBerta(Orientation.North,x,y,"/images/SheepAge/GrosseBerta");
			break;
		case Spy :
			sheep =new Spy(Orientation.North,x,y,"/images/SheepAge/Spy");
			break;
		case SubMarine :
			sheep =new SubMarine(Orientation.North,x,y,"/images/SheepAge/SubMarine");
			break;
			 default :
		sheep=null;		 
		}
		
		return sheep;
	}
	
}

