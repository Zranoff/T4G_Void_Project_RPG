import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Laser {
	
	private int posX = 0;
    private int posY = 0;
    private Direction direction;
    private static int size = 10;
    
	public static int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Laser(int x, int y, Direction d){
		
    	posX = x;
    	posY = y;
    	direction = d;
    }
	
	public Direction getDirection(){
		
    	return direction;
    }

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
}