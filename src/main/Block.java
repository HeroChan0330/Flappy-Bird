package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import main.Resourse.Img;

public class Block extends Rectangle{
	double fX;
	int type;
	int dir;
	Image img;
	public Block(int x,int y,int type,int dir) {
		// TODO Auto-generated constructor stub
		super(x,y,Resourse.Img.blockImg[type].getWidth(null),Resourse.Img.blockImg[type].getHeight(null));
		this.type=type;
		this.dir=dir;
		fX=x;
		img=Resourse.Img.blockImg[type];
		if(dir==-1){
			img=Utils.imgVerticalFlip(img);
		}
		width=img.getWidth(null);
		height=img.getHeight(null);
	}
	public boolean loop(){ //return false if block is out of sight
		this.fX-=(double)Configure.X_SPEED_PER_SEC*Configure.LOOP_PERIOD;
		this.x=(int)fX;
		if(x+width<0) return false;
		return true;
	}
	
	public void draw(Graphics g){
		g.drawImage(img, this.x, this.y, null);
	}
}
