import java.awt.event.KeyEvent;


public class Displacement {

	private int speed_x;
	private int speed_y;
	private int x;
	private int y;
	
	public Displacement(int posX, int posY) {
		x = posX;
		y = posY;
	}

	public void input_treatment(KeyboardInput keyboard, Background pan) {
		
		// Si on avance, on incrémente la coordonnée
		if (keyboard.keyDown(KeyEvent.VK_RIGHT))
			speed_x = 10;
		// Sinon, on décrémente
		else if (keyboard.keyDown(KeyEvent.VK_LEFT))
			speed_x = -10;
		else
			speed_x = 0;
		// Idem pour l'axe Y
		if (keyboard.keyDown(KeyEvent.VK_DOWN))
			speed_y = 10;
			
		else if (keyboard.keyDown(KeyEvent.VK_UP))
			speed_y = -10;
		else
			speed_y = 0;
		
		if (speed_y !=0 && speed_x !=0){
			speed_y = Integer.signum(speed_y)*7;
			speed_x = Integer.signum(speed_x)*7;
		}
		
		y = y + speed_y;
		x = x + speed_x;
		
		if (y < 1)
			y = 0;
		else if ( y >= pan.getHeight() - 50)
			y = pan.getHeight() - 50;
		if ( x < 1)
			x = 0;
		else if ( x >= pan.getWidth() - 50 )
			x = pan.getWidth() - 50;
		
		pan.setPosY(y);
		pan.setPosX(x);
	}

	public int getSpeed_x() {
		return speed_x;
	}

	public void setSpeed_x(int speed_x) {
		this.speed_x = speed_x;
	}

	public int getSpeed_y() {
		return speed_y;
	}

	public void setSpeed_y(int speed_y) {
		this.speed_y = speed_y;
	}

	public int getNewX() {
		return x;
	}

	public int getNewY() {
		return y;
	}
	
	
}
