package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Apple extends Entity{
	
	GamePanel gp;
	BufferedImage image;
	Random r = new Random();
	
	int randNumCol, randNumRow;
	
	public Apple(GamePanel gp) {
		
		this.gp = gp;
		getAppleImage();
		getNextApple();	
	}
	
	public void getAppleImage() {
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/apple.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getNextApple() {
		
		randNumCol = r.nextInt(14)+1;
		randNumRow = r.nextInt(13)+1;
		
		appleX = randNumCol * gp.tileSize;
		appleY = randNumRow * gp.tileSize;
	}
	
	public void draw(Graphics2D g2) {
		
		g2.drawImage(image, appleX, appleY, gp.tileSize, gp.tileSize, null);
	}
}
