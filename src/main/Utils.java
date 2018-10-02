package main;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import main.Resourse.Img;

public class Utils {
	public static Image imgVerticalFlip(Image src){
		BufferedImage ret=null;
		AffineTransform transform = new AffineTransform(1, 0, 0, -1, 0,src.getHeight(null));// ´¹Ö±·­×ª
		AffineTransformOp op = new AffineTransformOp(transform,AffineTransformOp.TYPE_BILINEAR);
		ret = op.filter((BufferedImage) src, null);
		return ret;
	}
}
