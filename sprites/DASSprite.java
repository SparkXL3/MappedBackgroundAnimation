import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DASSprite implements DisplayableSprite, MovableSprite {
	
	private final double VELOCITY = 200;
	
	private double centerX = 0;
	private double centerY = 0;
	
	private Image spriteImage;
	private double velocityX;
	private double velocityY;

	public DASSprite(double centerX, double centerY) {
		this.centerX = 100; 
	    this.centerY = 100;
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
	        File imageFile = new File("res/DAS/CzechBall.png");
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
            return Math.min(50, Math.max(spriteImage.getHeight(null), 32));
        }
        return 32;
    }

	public double getWidth() {
		if(spriteImage != null) {
            return Math.min(50, Math.max(spriteImage.getWidth(null), 32));
        }
        return 32;
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

public boolean barrierIntersects(BarrierSprite barrier) {
    return this.getMaxX() > barrier.getMinX() && this.getMinX() < barrier.getMaxX() && this.getMaxY() > barrier.getMinY() && this.getMinY() < barrier.getMaxY();
}

	public void update(Universe universe, long actual_delta_time) {
		double deltaSeconds = actual_delta_time / 1000.0;
		velocityX = 0;
		velocityY = 0;
		
		KeyboardInput keyboardInput = KeyboardInput.getKeyboard();
	for(DisplayableSprite sprite : universe.getSprites()) {
		if(sprite instanceof BarrierSprite) {
            BarrierSprite barrier = (BarrierSprite) sprite;
            if(this.barrierIntersects(barrier)) {
                centerX -= velocityX * deltaSeconds; 
                centerY -= velocityY * deltaSeconds;
            }
        } else {
    	
		if(keyboardInput.keyDown(37)) {
			velocityX = -VELOCITY;
		}
		if(keyboardInput.keyDown(38)) {
			velocityY = -VELOCITY;			
		}
		if(keyboardInput.keyDown(39)) {
			velocityX += VELOCITY;
		}
		if(keyboardInput.keyDown(40)) {
			velocityY += VELOCITY;			
		}

		this.centerX += actual_delta_time * 0.001 * velocityX;
		this.centerY += actual_delta_time * 0.001 * velocityY;
				
		
		
        	}	
		}
	}
}
	

