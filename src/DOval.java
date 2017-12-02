import java.awt.Graphics;

public class DOval extends DShape{
	
	public DOval(){
		super();
	}
	
	public void draw(Graphics g) {
        
        g.setColor(shapeModel.getColor());
        
        g.fillOval(shapeModel.getX(),shapeModel.getY(),shapeModel.getWidth(),shapeModel.getHeight());
    }
}
