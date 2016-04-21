package battleberger.model;

public abstract class AbstractAbstractShip {
	protected int cost;
	protected String name;
	public enum TimeSpace{};
	public abstract int getPower();
	public abstract int getArmor();
	public abstract int getMovSpeed();
	public abstract int getReloadSpeed();
	
}
