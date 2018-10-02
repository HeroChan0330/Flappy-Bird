package main;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resourse {
	public static class Img{
		public static Image bgImg;
		public static Image birdImg;
		public static Image blockImg[]=new Image[Configure.BLOCK_TYPES];
	}
	public static void init() throws IOException{
		Img.bgImg=ImageIO.read(new File("Image/bg.jpg"));
		Img.birdImg=ImageIO.read(new File("Image/bird.png"));
		for(int i=0;i<Configure.BLOCK_TYPES;i++){
			Img.blockImg[i]=ImageIO.read(new File(String.format("Image/block_%d.png", i)));
		}
	}
}
