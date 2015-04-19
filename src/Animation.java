import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Animation extends JPanel {

	private int posX = 0;
    private int posY = 0;
    private int size = 0;
    
    public Animation(int x, int y, int size){
    	
    	posX = x;
    	posY = y;
    	this.size = size;
    }
    
    public void paintComponent(Graphics g){
    	
        g.setColor(Color.blue);
        g.fillRect(this.posX, this.posY, size, size);
            
            
    }
}
