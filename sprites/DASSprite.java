import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DASSprite implements DisplayableSprite, MovableSprite {
	
	private double centerX = 0;
	private double centerY = 0;
	
	private Image spriteImage;
	private double velocityX;
	private double velocityY;
	
	private int score = 0;
	private String proximityMessage;
	private boolean isAtExit;

	public DASSprite(int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;
		
	}

	public void setCenterY(double centerY) {
		this.centerY = centerY;
		
	}

	public void setVelocityX(double pixelsPerSecond) {
		velocityX = pixelsPerSecond;
		
	}

	public void setVelocityY(double pixelsPerSecond) {
		velocityY = pixelsPerSecond;
		
	}

	public Image getImage() {
		try {
	        File imageFile = new File("res/CzechBall.png");
	        return ImageIO.read(imageFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
		
	}

	public boolean getVisible() {
		return true;
	}


	public double getMinX() {
		return centerX - getWidth() / 2;

	}

	public double getMaxX() {
		return centerX + getWidth() / 2;

	}

	public double getMinY() {
		return centerY - getHeight() / 2;

	}

	public double getMaxY() {
		return centerY + getHeight() / 2;

	}

	public double getHeight() {
		if(spriteImage != null) {
            return Math.min(50, Math.max(spriteImage.getHeight(null), 50));
        }
        return 50;
    }

	public double getWidth() {
		if(spriteImage != null) {
            return Math.min(50, Math.max(spriteImage.getWidth(null), 50));
        }
        return 50;
    }
	
	public double getCenterX() {
		return centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	public boolean getDispose() {
		return false;
	}

public void setDispose(boolean dispose) {
		
		
	}

	@Override
	public void update(Universe universe, long actual_delta_time) {
		  double deltaSeconds = actual_delta_time / 1000.0;
		    centerX += velocityX * deltaSeconds;
		    centerY += velocityY * deltaSeconds;
		
	}
	
}
