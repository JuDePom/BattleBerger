package battleberger.model;

import java.util.Map;

import battleberger.model.Ship.Orientation;
import battleberger.model.Ship.StatType;
import battleberger.model.Ship.TypeShip;

public abstract class AbstractShipDecorator extends AbstractShip {
// faire une augmentation expodentiel du prisx de l'amrure a chaque achat 
	protected AbstractShip next;
	protected StatType stat; 
	protected int costUpgrade;
	
	@Override
	public int getCostUpgrade() {
		return costUpgrade;
	}
	
	@Override
	public StatType getStat() {
		return stat;
	}
	
	@Override
	public int isReadyToFireIn() {
		return next.isReadyToFireIn();
	}

	@Override
	public void setReadyToFireIn(int i) {
		next.setReadyToFireIn(i);
	}

	@Override
	public int shipValue() {
		return cost + next.shipValue();
	}

	@Override
	public boolean isAlive() {
		return next.isAlive();
	}

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
	public int getCooldown(){
		return next.getCooldown();
	}

	@Override
	public boolean[][] getShape() {
		return next.getShape();
	}

	@Override
	public void setShapeNorth(boolean[][] shape, Orientation or) {
		next.setShapeNorth(shape, or);
	}

	@Override
	public Orientation getOrient() {
		return next.getOrient();
	}

	@Override
	public void setOrient(Orientation orient) {
		next.setOrient(orient);
	}

	@Override
	public String getImagepath() {
		return next.getImagepath();
	}

	@Override
	public void setImagepath(String imagepath) {
		next.setImagepath(imagepath);
	}

	@Override
	public int[][] getLives() {
		return next.getLives();
	}

	@Override
	public void setLives(int[][] lives) {
		next.setLives(lives);
	}

	@Override
	public int getPositionX() {
		return next.getPositionX();
	}

	@Override
	public void setPositionX(int positionX) {
		next.setPositionX(positionX);
		
	}

	@Override
	public int getPositionY() {
		return next.getPositionY();
	}

	@Override
	public void setPositionY(int positionY) {
		next.setPositionY(positionY);
	}
	
	@Override
	public int[][] getFireshape() {
		return next.getFireshape();
	}

	@Override
	public void setFireshape(int[][] fireshape) {
		next.setFireshape(fireshape);
	}

	@Override
	public int getNbEquipementmax() {
		return next.getNbEquipementmax();
	}

	@Override
	public void setNbEquipementmax(int nbEquipementmax) {
		next.setNbEquipementmax(nbEquipementmax);
	}

	@Override
	public Map<StatType, Integer> getStatmax() {
		return next.getStatmax();
	}

	@Override
	public void setStatmax(Map<StatType, Integer> statmax) {
		next.setStatmax(statmax);
	}

	@Override
	public int getTimereload() {
		return next.getTimereload();
	}

	@Override
	public void setTimereload(int timereload) {
		next.setTimereload(timereload);
	}

	@Override
	public int getWidth() {
		return next.getWidth();
	}

	@Override
	public int getHeight() {
		return next.getHeight();
	}
	

	@Override
	public boolean toucher(int x, int y, int degat){
		return next.toucher(x, y, degat);
	}
	@Override
	public boolean overlap(int x, int y){
		return next.overlap(x, y);
	}
	@Override
	public boolean overlap(Square s){
		return next.overlap(s);
	}
	@Override
	public TypeShip getType(){
		return next.getType();
	}
	@Override
	public int getUpgrade(StatType type){
		return next.getUpgrade(type);
	}
	@Override
	public void addUpgrade(StatType type){
		next.addUpgrade(type);
	}
	@Override
	public Map<StatType, Integer> upgrade(){
		return next.upgrade();
	}
	@Override
	public int getStatmax(StatType type){
		return next.getStatmax(type);
	}
	@Override
	public String getName(){
		return next.getName();
	}
	@Override
	public void setName(String s){
		 next.setName(s);
	}
}
