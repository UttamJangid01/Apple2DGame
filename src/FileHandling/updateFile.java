package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.GamePanel;

public class updateFile {
	
	GamePanel gp;
	public int maxScore;
	
	public updateFile(GamePanel gp) {
		this.gp = gp;
	}
		
	public boolean updateScore() {
		
		try {
			File file = new File("src/res/AppleFile/appleFile.txt");
	
			if(file.createNewFile())
				System.out.println("File is created.");
			else
				System.out.println("File is exist.");

			BufferedReader reader = new BufferedReader(new FileReader(file));
			maxScore = Integer.parseInt(reader.readLine());
			reader.close();
			
			if(gp.appleCount > maxScore) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(""+gp.appleCount);
				writer.close();
				return true;
			}

		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
