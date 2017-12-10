import java.awt.Graphics;
import java.io.Serializable;

public class DOval extends DShape implements Serializable{
	
	public DOval(){
		super();
	}
	
	public void draw(Graphics g) {
        
        g.setColor(shapeModel.getColor());
        
        g.fillOval(shapeModel.getX(),shapeModel.getY(),shapeModel.getWidth(),shapeModel.getHeight());
    }
}
