package FileHandling;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.GamePanel;

public class Score {
	
	GamePanel gp;
	
	public Score(GamePanel gp) {
		this.gp = gp;
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setColor(Color.white);
		g2.setFont(new Font("Arile", Font.PLAIN, 35));
		if(gp.gameThread != null) {
			g2.drawString(""+String.valueOf((int)gp.appleCount), 10, 35);
		}else {
			g2.drawString("Game Over : "+String.valueOf((int)gp.appleCount), 10, 35);
			if(gp.file.updateScore()) {
				g2.drawString("You are create new score : "+gp.appleCount, (gp.ScreenWidth/2)-225, 296);
				g2.drawString("Old score : "+gp.file.maxScore, (gp.ScreenWidth/2)-225, 336);
			}else {
				g2.drawString("Your score : "+gp.appleCount, (gp.ScreenWidth/2)-225, 296);
				g2.drawString("Max score  : "+gp.file.maxScore, (gp.ScreenWidth/2)-225, 336);
			}
			g2.drawString("Play again to press spacebar", (gp.ScreenWidth/2)-225, 376);
		}
	}
}
