package battleberger.model;

public class FireShape {
	
	
	public static int[][] standardShape(){
		int[][] shape={{100}};
		return shape;
	}
	public static int[][] plusShape(){
		int[][] shape = {{0,50,0},{50,100,50},{0,50,0}};
		return shape;
	}
	public static int[][] crossShape(){
		int[][] shape= {{50,0,50},{0,75,0},{50,0,50}};
		return shape;
	}
	public static int[][] nuclearShape(){
		int[][] shape = {{10,25,40,25,10},{25,40,70,40,25},{40,70,100,70,40},{25,40,70,40,25},{10,25,40,25,10}};
		return shape;
	}
	public static int[][] lineShape(){
		int[][] shape ={{50,50,50,50,50}};
		return shape;
	}
	public static int[][] norisShape(){
		int[][] shape={{80,0,40},{60,100,60},{40,0,80}};
		return shape;		
	}
	public static int[][] bigShape(){
		int[][] shape={{25,50,25},{50,75,25},{25,50,25}};
		return shape;
	}
	
}
