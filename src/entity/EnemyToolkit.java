package entity;

import java.awt.image.BufferedImage;

public class EnemyToolkit {
	
	public int x[], y[];
	public int speed;
	
	public int countX;
	public int countY;
	
	public boolean turnX;
	public boolean turnY;
	public boolean temp = true;		// for return before place 
	
	public boolean goLeft[], goRight[];
	public boolean goUp[], goDown[];

	public BufferedImage image1, image2;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
}
