package main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bird {
	Rectangle area;
	double yPos,xPos,yVel=0;
	boolean pressing=false;
	public Bird() {
		// TODO Auto-generated constructor stub
		area=new Rectangle((Configure.SCREEN_WIDTH-Configure.BIRD_WIDTH)/2, (Configure.SCREEN_HEIGHT-Configure.BIRD_HEIGHT)/2
							, Configure.BIRD_WIDTH, Configure.BIRD_HEIGHT);
		yPos=area.getY();
		xPos=area.getX();
	}
	public boolean loop(GameScene scene){ //return false if the bird dies
		if(!pressing){
			yVel+=Configure.GRAVITY*Configure.LOOP_PERIOD;
		}
		yPos+=yVel;
		area.setLocation((int)xPos,(int)yPos);
		if(yPos<0||yPos>Configure.SCREEN_HEIGHT) return false;
		if(scene.checkIntersection(area)) return false;
		return true;
	}
	public void mousePress(){
		yVel=Configure.SUDDEN_VEL_AFTER_TAP;
		pressing=true;
	}
	public void mouseRelease(){
		pressing=false;
	}
	public void draw(Graphics g){
		g.drawImage(Resourse.Img.birdImg, (int)xPos, (int)yPos, null);
	}
}
