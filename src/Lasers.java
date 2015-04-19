import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;


public class Lasers extends Vector {

	private int width = 0;
	private int height = 0;
	
	public Lasers(int width, int height){
		this.width = width;
		this.height = height;
    }

	public void newLaser(int x, int y, Direction d) {

		this.add(new Laser(x, y, d));
	}
	
	public Laser getLaser(int index)
	{
		return (Laser)this.get(index);
	}

	public void update() {

		for (int i = 0; i < this.size(); i++) {
			if (updateLaser((Laser)this.get(i)))
			{
				this.remove(i);
				i--;
			}
		}
	}
	
	private boolean updateLaser(Laser laser) {
		
		if (laser.getDirection() == Direction.RIGHT)
		{
			if (laser.getPosX() < width-laser.getSize())
				{
					laser.setPosX(laser.getPosX()+1);
					return false;
				}
				else
				{
					return true;
				}
		}
		if (laser.getDirection() == Direction.LEFT)
		{
			if (laser.getPosX() > laser.getSize())
			{
				laser.setPosX(laser.getPosX()-1);
				return false;
			}
			else
			{
				return true;
			}
		}
		if (laser.getDirection() == Direction.DOWN)
		{
			if (laser.getPosY() < height-laser.getSize())
			{
				laser.setPosY(laser.getPosY()+1);
				return false;
			}
			else
			{
				return true;
			}
		}
		if (laser.getDirection() == Direction.UP)
		{
			if (laser.getPosY() > laser.getSize())
			{
				laser.setPosY(laser.getPosY()-1);
				return false;
			}
			else
			{
				return true;
			}
		}
	return false;
	}
}
