import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class DASBackground implements Background {

	public static final int TILE_HEIGHT = 50;
	public static final int TILE_WIDTH = 50;
	
	private int maxCols = 0;
    private int maxRows = 0;
	
	private Image NRAFlag;
	private Image CNTFAIFlag;
	private Image TuvanFlag;
	
	private int map[][] = null; 
	
   public DASBackground() {
	   int[][] background = CSVReader.importFromCSV("res/MappedBackgroundBackgroundThingy.csv");
	   map = background;
	   
	   try {
   		this.NRAFlag = ImageIO.read(new File("res/NRAFlag.png"));
   		this.CNTFAIFlag = ImageIO.read(new File("res/CNTFAIFlag.png"));
   		this.TuvanFlag = ImageIO.read(new File("res/TuvanFlag.png"));
   	}
   	catch (IOException e) {
   		//System.out.println(e.toString());
   	}
	   
   }

	public ArrayList<DisplayableSprite> getBarriers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Tile getTile(int col, int row) {
		//Check why three nulls are needed
		Image image = null;
		
		if (row < 0 || row > maxRows || col < 0 || col > maxCols) {
			image = null;
		} else if (map[row][col] == 0) {
			image = NRAFlag;
		} else if (map[row][col] == 1) {
			image = CNTFAIFlag;
		} else if (map[row][col] == 2) {
			image = TuvanFlag;
		} else {
			image = null;
		}
		return null;
		
	}

	public int getCol(double x) {
		int col = 0;
		if(TILE_WIDTH != 0) {
			col = (int) (x / TILE_WIDTH);
			if(x < 0) {
				return col - 1;
			} else {
				return col;
			}
		} else {
			return 0;
		}
	}

	public int getRow(double y) {
int row = 0;
		
		if (TILE_HEIGHT != 0) {
			row = (int) (y / TILE_HEIGHT);
			if (y < 0) {
				return row - 1;
			}
			else {
				return row;
			}
		}
		else {
			return 0;
		}
	}

	public double getShiftX() {
		return 0;
	}

	public double getShiftY() {
		return 0;
	}

	public void setShiftX(double shiftX) {
		
	}

	public void setShiftY(double shiftY) {
		
		
	}

	public void update(Universe universe, long actual_delta_time) {
		
	}
}
