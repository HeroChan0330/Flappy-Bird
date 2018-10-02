package main;

import java.awt.Graphics;
import java.util.Random;

public class BlockPair {
	public Block blockUp,blockBottom;
	public BlockPair(int x1,int y1,int type1,int x2,int y2,int type2) {
		// TODO Auto-generated constructor stub
		blockUp=new Block(x1, y1, type1, 1);
		blockBottom=new Block(x2, y2, type2, -1);
	}
	public static BlockPair randomBlockPair() {
		Random random=new Random();
		int type1=random.nextInt(Configure.BLOCK_TYPES),type2=random.nextInt(Configure.BLOCK_TYPES);
		int x1=Configure.SCREEN_WIDTH+10,x2=x1+random.nextInt(20)-10;
		int y1=-random.nextInt(Configure.SCREEN_HEIGHT/2)-Configure.SCREEN_HEIGHT/3;
		int y2=y1+Resourse.Img.blockImg[type1].getHeight(null)
				+Configure.MIN_BLOCK_PAIR_Y_DEL+(int)((double)Configure.BLOCK_PAIR_Y_RANGE*random.nextDouble());
//		System.out.println(String.format("x1:%d x2:%d y1:%d y2:%d", x1,x2,y1,y2));
		return new BlockPair(x1, y1, type1, x2, y2, type2);
	}
	public boolean loop(){ //return false if block is out of sight
		if(!blockUp.loop()||!blockBottom.loop())return false;
		return true;
	}
	
	public void draw(Graphics g){
		blockUp.draw(g);
		blockBottom.draw(g);
	}
}
