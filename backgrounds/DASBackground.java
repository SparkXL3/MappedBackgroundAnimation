import java.awt.Image;
import java.util.ArrayList;

public class DASBackground implements Background {

	public static final int TILE_HEIGHT = 50;
	public static final int TILE_WIDTH = 50;
	
	private int maxCols = 0;
    private int maxRows = 0;
	
	private Image DASBackground;
	
   

	public ArrayList<DisplayableSprite> getBarriers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tile getTile(int col, int row) {
		int x = (col * TILE_WIDTH);
		int y = (row * TILE_HEIGHT);
		Tile newTile = null;
		
		newTile = new Tile(DASBackground, x, y, TILE_WIDTH, TILE_HEIGHT, false);

		return newTile;
	}

	@Override
	public int getCol(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRow(double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getShiftX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getShiftY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setShiftX(double shiftX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setShiftY(double shiftY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Universe universe, long actual_delta_time) {
		// TODO Auto-generated method stub
		
	}

}
