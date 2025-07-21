package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandling implements KeyListener{

	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	public KeyHandling(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		// Restart Game
		if(gp.gameThread == null && code == KeyEvent.VK_SPACE) {
			gp.gameThread = new Thread(gp);
			gp.startGameThread();
			gp.player.x = 100;
			gp.player.y = 100;
			gp.appleCount = 0;
			gp.player.direction = "down";
			gp.enemy.x[0] = 0;
			gp.enemy.x[1] = gp.ScreenWidth-gp.tileSize;
			gp.enemy.x[2] = 0;
			gp.enemy.x[3] = gp.ScreenWidth-gp.tileSize;
			
			gp.enemy.y[0] = 0;
			gp.enemy.y[1] = gp.ScreenHeight-gp.tileSize;
			gp.enemy.y[2] = 0;
			gp.enemy.y[3] = gp.ScreenHeight-gp.tileSize;
			
			gp.enemy.countX = 0;
			gp.enemy.countY = 0;
			
			gp.enemy.turnX = true;
			gp.enemy.turnY = true;
			
			gp.enemy.goLeft[0] = false;
			gp.enemy.goRight[0] = true;
			gp.enemy.goLeft[1] = true;
			gp.enemy.goRight[1] = false;
			
			gp.enemy.goUp[0] = false;
			gp.enemy.goDown[0] = true;
			gp.enemy.goUp[1] = true;
			gp.enemy.goDown[1] = false;
			
		}
		
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
