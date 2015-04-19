import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Animation extends JPanel {

	private int posX = 0;
    private int posY = 0;
    private int size = 10;
    private Lasers lasers;
    
    public Animation(){
    	
    }
    
    public void setLasers(Lasers lasers)
    {
    	this.lasers = lasers;
    }
    
    public void paintComponent(Graphics g){
    	
        g.setColor(Color.blue);
    	for(int i=0; i<lasers.size();i++)
        g.fillRect( ((Laser)this.lasers.get(i)).getPosX(), ((Laser)this.lasers.get(i)).getPosY(), size, size);
            
            
    }
}
