package main;

public class Configure {
	public static final int SCREEN_WIDTH=1024;
	public static final int SCREEN_HEIGHT=576;
	
	public static final int BIRD_WIDTH=70;
	public static final int BIRD_HEIGHT=70;
	
	public static final int X_SPEED_PER_SEC=100;
	public static final double LOOP_PERIOD=0.02;
	public static final double GRAVITY=10;
	
	public static final double SUDDEN_VEL_AFTER_TAP=-5;
	
	public static final int BLOCK_TYPES=2;
	public static final int MAX_BLOCK_PAIR_CNT=3;
	
	public static final int MIN_BLOCK_PAIR_X_DEL=300;//2对障碍x方向的最小距离
	public static final int BLOCK_PAIR_X_RANGE=200;//2对障碍x方向的变化范围
	
	public static final int MIN_BLOCK_PAIR_Y_DEL=150;//最小的障碍间隙
	public static final int BLOCK_PAIR_Y_RANGE=100; //y方向的变化范围
	
}
