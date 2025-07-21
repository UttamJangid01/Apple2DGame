package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Enemy extends EnemyToolkit{
	
	GamePanel gp;
	Player player;

	public Enemy(GamePanel gp, Player player) {
		
		this.gp = gp;
		this.player = player;
		
		x = new int[4];
		y = new int[4];
		
		goLeft = new boolean[2];
		goRight = new boolean[2];
		
		goUp = new boolean[2];
		goDown = new boolean[2];
		
		setDefaultValues();
		getEnemyImage();
	}
	
	public void setDefaultValues() {
		
//		x[0] = 0;
//		x[1] = gp.ScreenWidth-gp.tileSize;
//		x[2] = 60;
//		x[3] = gp.ScreenWidth-60-gp.tileSize;
//		
//		y[0] = 60;
//		y[1] = gp.ScreenHeight-60-gp.tileSize;
//		y[2] = 0;
//		y[3] = gp.ScreenHeight-gp.tileSize
		
		x[0] = 0;
		x[1] = gp.ScreenWidth-gp.tileSize;
		x[2] = 0;
		x[3] = gp.ScreenWidth-gp.tileSize;
		
		y[0] = 0;
		y[1] = gp.ScreenHeight-gp.tileSize;
		y[2] = 0;
		y[3] = gp.ScreenHeight-gp.tileSize;
		
		speed = 4;
		
		countX = 0;
		countY = 0;
		
		turnX = true;
		turnY = true;
		
		goLeft[0] = false;
		goRight[0] = true;
		goLeft[1] = true;
		goRight[1] = false;
		
		goUp[0] = false;
		goDown[0] = true;
		goUp[1] = true;
		goDown[1] = false;
	}
	
	public void getEnemyImage() {
		
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/res/tiles/goomba1.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/res/tiles/goomba2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(y[0]+gp.tileSize <= gp.tileSize * gp.maxScreenRow && temp) {			
			enemyDirection();
			if(y[0]+gp.tileSize == gp.tileSize * gp.maxScreenRow) {
				temp = false;
			}
		}else {
			enemyDirection1();
			if(y[0] == 0) {
				temp = true;
			}
		}
		
		playerOut();
		
		spriteCounter++;
		if(spriteCounter > 12) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
	public void enemyDirection() {
		
		// x[0]
		if(x[0]+gp.tileSize < gp.maxScreenCol * gp.tileSize && goRight[0]) {
			x[0] += speed;
			if(x[0]+gp.tileSize >= gp.maxScreenCol * gp.tileSize) {
				y[0] += gp.tileSize;
				goLeft[0] = true;
				goRight[0] = false;
			}
		}
		else if(x[0] > 0 && goLeft[0]) {
			x[0] -= speed;
			if(x[0] <= 0) {
				y[0] += gp.tileSize;
				goLeft[0] = false;
				goRight[0] = true;
			}
		}
		
		// x[1]
		if(x[1] > 0 && goLeft[1]) {
			x[1] -= speed;
			if(x[1] <= 0) {
				y[1] -= gp.tileSize;
				goLeft[1] = false;
				goRight[1] = true;
			}
		}
		else if(x[1]+gp.tileSize < gp.maxScreenCol * gp.tileSize && goRight[1]) {
			x[1] += speed;
			if(x[1]+gp.tileSize >= gp.maxScreenCol * gp.tileSize) {
				y[1] -= gp.tileSize;
				goLeft[1] = true;
				goRight[1] = false;
			}
		}
		
		// y[2]
		if(y[2]+gp.tileSize < gp.maxScreenRow * gp.tileSize && goDown[0]) {
			y[2] += speed;
			if(y[2]+gp.tileSize >= gp.maxScreenRow * gp.tileSize) {
				x[2] += gp.tileSize;
				goUp[0] = true;
				goDown[0] = false;
			}
		}
		else if(y[2] > 0 && goUp[0]) {
			y[2] -= speed;
			if(y[2] <= 0) {
				x[2] += gp.tileSize;
				goUp[0] = false;
				goDown[0] = true;
			}
		}
		
		// y[3]
		if(y[3] > 0 && goUp[1]) {
			y[3] -= speed;
			if(y[3] <= 0) {
				x[3] -= gp.tileSize;	
				goUp[1] = false;
				goDown[1] = true;
			}
		}
		else if(y[3]+gp.tileSize < gp.maxScreenRow * gp.tileSize && goDown[1]) {
			y[3] += speed;
			if(y[3]+gp.tileSize >= gp.maxScreenRow * gp.tileSize) {
				x[3] -= gp.tileSize;
				goUp[1] = true;
				goDown[1] = false;
			}
		}
	}
	
	public void enemyDirection1() {
		
		// x[0]
				if(x[0]+gp.tileSize < gp.maxScreenCol * gp.tileSize && goRight[0]) {
					x[0] += speed;
					if(x[0]+gp.tileSize >= gp.maxScreenCol * gp.tileSize) {
						y[0] -= gp.tileSize;
						goLeft[0] = true;
						goRight[0] = false;
					}
				}
				else if(x[0] > 0 && goLeft[0]) {
					x[0] -= speed;
					if(x[0] <= 0) {
						y[0] -= gp.tileSize;
						goLeft[0] = false;
						goRight[0] = true;
					}
				}
				
				// x[1]
				if(x[1] > 0 && goLeft[1]) {
					x[1] -= speed;
					if(x[1] <= 0) {
						y[1] += gp.tileSize;
						goLeft[1] = false;
						goRight[1] = true;
					}
				}
				else if(x[1]+gp.tileSize < gp.maxScreenCol * gp.tileSize && goRight[1]) {
					x[1] += speed;
					if(x[1]+gp.tileSize >= gp.maxScreenCol * gp.tileSize) {
						y[1] += gp.tileSize;
						goLeft[1] = true;
						goRight[1] = false;
					}
				}
				
				// y[2]
				if(y[2]+gp.tileSize < gp.maxScreenRow * gp.tileSize && goDown[0]) {
					y[2] += speed;
					if(y[2]+gp.tileSize >= gp.maxScreenRow * gp.tileSize) {
						x[2] -= gp.tileSize;
						goUp[0] = true;
						goDown[0] = false;
					}
				}
				else if(y[2] > 0 && goUp[0]) {
					y[2] -= speed;
					if(y[2] <= 0) {
						x[2] -= gp.tileSize;
						goUp[0] = false;
						goDown[0] = true;
					}
				}
				
				// y[3]
				if(y[3] > 0 && goUp[1]) {
					y[3] -= speed;
					if(y[3] <= 0) {
						x[3] += gp.tileSize;	
						goUp[1] = false;
						goDown[1] = true;
					}
				}
				else if(y[3]+gp.tileSize < gp.maxScreenRow * gp.tileSize && goDown[1]) {
					y[3] += speed;
					if(y[3]+gp.tileSize >= gp.maxScreenRow * gp.tileSize) {
						x[3] += gp.tileSize;
						goUp[1] = true;
						goDown[1] = false;
					}
				}
	}
	
	public void playerOut() {
		
		if(((player.x >= x[0] && player.x <= x[0]+gp.tileSize-10) || (player.x+gp.tileSize-7 >= x[0] && player.x+gp.tileSize-5 <= x[0]+gp.tileSize-5)) && ((player.y >= y[0] && player.y <= y[0]+gp.tileSize-5) || (player.y+gp.tileSize >= y[0] && player.y+gp.tileSize-5 <= y[0]+gp.tileSize-5))
		|| ((player.x >= x[1] && player.x <= x[1]+gp.tileSize-10) || (player.x+gp.tileSize-7 >= x[1] && player.x+gp.tileSize-5 <= x[1]+gp.tileSize-5)) && ((player.y >= y[1] && player.y <= y[1]+gp.tileSize-5) || (player.y+gp.tileSize >= y[1] && player.y+gp.tileSize-5 <= y[1]+gp.tileSize-5))
		|| ((player.x >= x[2] && player.x <= x[2]+gp.tileSize-10) || (player.x+gp.tileSize-7 >= x[2] && player.x+gp.tileSize-5 <= x[2]+gp.tileSize-5)) && ((player.y >= y[2] && player.y <= y[2]+gp.tileSize-5) || (player.y+gp.tileSize >= y[2] && player.y+gp.tileSize-5 <= y[2]+gp.tileSize-5))
		|| ((player.x >= x[3] && player.x <= x[3]+gp.tileSize-10) || (player.x+gp.tileSize-7 >= x[3] && player.x+gp.tileSize-5 <= x[3]+gp.tileSize-5)) && ((player.y >= y[3] && player.y <= y[3]+gp.tileSize-5) || (player.y+gp.tileSize >= y[3] && player.y+gp.tileSize-5 <= y[3]+gp.tileSize-5))) {
			gp.gameThread = null;
		}
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		if(spriteNum == 1) {
			image = image1;
		}
		else if(spriteNum == 2) {
			image = image2;
		}
		
		g2.drawImage(image, x[0], y[0], gp.tileSize, gp.tileSize, null);
		g2.drawImage(image, x[1], y[1], gp.tileSize, gp.tileSize, null);
		g2.drawImage(image, x[2], y[2], gp.tileSize, gp.tileSize, null);
		g2.drawImage(image, x[3], y[3], gp.tileSize, gp.tileSize, null);
	}
}
