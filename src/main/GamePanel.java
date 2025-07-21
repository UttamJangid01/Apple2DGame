package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import FileHandling.Score;
import FileHandling.updateFile;
import entity.Apple;
import entity.Enemy;
import entity.Player;
import sound.Sound;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	// SCREEN SETTINGS
	final int originalTileSize = 16;
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 15;
	public final int maxScreenRow = 14;
	public final int ScreenWidth = tileSize * maxScreenCol;
	public final int ScreenHeight = tileSize * maxScreenRow;
	
	public Thread gameThread;
	
	KeyHandling keyH = new KeyHandling(this);
	Player player = new Player(this, keyH);
	TileManager tileM = new TileManager(this);
	public Apple apple = new Apple(this);
	Enemy enemy = new Enemy(this, player);
	public updateFile file = new updateFile(this);
	Score score = new Score(this);
	Sound sound = new Sound();
	
	int FPS = 60;
	public int appleCount=0;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
		this.setBackground(Color.black);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 1){
                update();
                collision();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS : "+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
	}
	
	public void update() {
		player.update();
		enemy.update();
	}
	
	public void collision() {
		
		int px = player.x;
		int py = player.y;
		int ax = apple.appleX + 5;
		int ay = apple.appleY + 5;
		
		if(((px >= ax && px <= ax+tileSize-10) || (px+tileSize-5 >= ax && px+tileSize-5 <= ax+tileSize-5)) && ((py >= ay && py <= ay+tileSize-10) || (py+tileSize-5 >= ay && py+tileSize-5 <= ay+tileSize-5))) {
			appleCount++;
			sound.playSound("apple_bite.wav");
			apple.getNextApple();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		apple.draw(g2);
		player.draw(g2);
		enemy.draw(g2);
			
		score.draw(g2);
		
		g2.dispose();
	}
}