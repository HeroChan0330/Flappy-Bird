package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

public class GameScene {
	private LinkedList<BlockPair> blockPairs=new LinkedList<>();
	Random random=new Random();
	int xOffset=0,bgWidth;
	public GameScene() {
		// TODO Auto-generated constructor stub
		bgWidth=Resourse.Img.bgImg.getWidth(null);
	}
	public void loop(){
		java.util.Iterator<BlockPair> iterator=blockPairs.iterator();
		while (iterator.hasNext()) {
			BlockPair blockPair=iterator.next();
			if(!blockPair.loop()){
				iterator.remove();
			}
		}
		
		if(blockPairs.size()<Configure.MAX_BLOCK_PAIR_CNT){
			if(blockPairs.size()==0){
				addNewBlock();
			}else{
				BlockPair blockPair=blockPairs.getLast();
				if(blockPair.blockUp.getX()<Configure.SCREEN_WIDTH-Configure.MIN_BLOCK_PAIR_X_DEL){				
					addNewBlock();
				}
			}
		}
		xOffset+=Configure.X_SPEED_PER_SEC*Configure.LOOP_PERIOD;
		if(bgWidth-xOffset<=0) xOffset=0;
	}
	private void addNewBlock(){
		BlockPair blockPair=BlockPair.randomBlockPair();
		blockPairs.add(blockPair);
	}
	public void draw(Graphics g){
		//±³¾°»æÖÆ
		g.drawImage(Resourse.Img.bgImg, -xOffset, 0, null);
		if(bgWidth-xOffset<Configure.SCREEN_WIDTH){
			g.drawImage(Resourse.Img.bgImg,bgWidth-xOffset, 0, null);
		}
		//g.drawImage(Resourse.Img.bgImg, 0, 0, null);
		for(BlockPair blockPair:blockPairs){
			blockPair.draw(g);
		}
	}
	public boolean checkIntersection(Rectangle rect){
		for(BlockPair blockPair:blockPairs){
			if(blockPair.blockUp.intersects(rect)||blockPair.blockBottom.intersects(rect))
				return true;
		}
		return false;
	}
}
