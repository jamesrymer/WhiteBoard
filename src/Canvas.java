import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Popup;
/*
 * Used for displaying shapes
 */
public class Canvas extends JPanel implements ModelListener {
	private ArrayList<DShape> shapes; //Holds shapes
	private DShape selected; //Holds the selected shape
	/*
	 * Constructor: initializes canvas display size and adds a few mouse listeners.
	 *
	 *
	 */
	public Canvas() {
		this.setBounds(10, 10, 200, 200);
		this.setBackground(Color.WHITE);
		shapes = new ArrayList<>();
		
		//TODO Add drag support
		this.addMouseMotionListener(new MouseMotionListener() { 

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				moveSelected(e.getX(), e.getY());
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		final MouseAdapter mouseAdapter = new MouseAdapter() { // Checks to see if mouse click is inside the bounds of a shape. If so, sets a selected shape.
			@Override
			public void mousePressed(MouseEvent e) {
				// point = e.getPoint();
				if(selected != null) {
					selected.setColor(Color.gray);
				}
				
				setSelected(e.getX(), e.getY());
				repaint();
			}

//			public void mouseClicked(MouseEvent e) {
//				// point = e.getPoint();
//				setSelected(e.getX(), e.getY());
//				repaint();
//			}
		};
		this.addMouseListener(mouseAdapter);
		
	}
	
	public void moveSelected(int x, int y) { //Will be used to move shape.
		
	}
	/*
	 * Adds a shape to the list then calls repaint to display it on the canvas.
	 */
	public void addShape(DShape shape) {
		shape.getDShapeModel().setListener(this);
		this.shapes.add(shape);
		this.repaint();
	}
	/*
	 * Tells shapes to draw themselves. If shape is selected, draws knobs on each corner which will be used for resizing.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (DShape shape : shapes) {
			shape.draw(g);
			if (shape == selected) {
				for (Rectangle rectangle : shape.getKnobs()) {
					g.setColor(Color.black);
					g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

				}
			}
		}
	}
	/*
	 * Sets selected shape;
	 */
	public void setSelected(DShape shape) {
		this.selected = shape;
	}
	/*
	 * Sets selected shape;
	 */
	public void setSelected(int x, int y) {
		for (DShape shape : shapes) {
			if (x >= shape.getX() && x <= shape.getX() + shape.getWidth() && y >= shape.getY()
					&& y <= shape.getY() + shape.getHeight()) {
				this.selected = shape;

			}
			System.out.println(selected.getX());
		}
		selected.setColor(Color.MAGENTA);
		
		
	}
	/*
	 * Returns selected shape;
	 */
	public DShape getSelected() {
		return selected;
	}

	/*
	 * Its complicated... 
	 */
	@Override
	public void ModelChanged(DShapeModel model) {
		// TODO Auto-generated method stub
		selected.shapeModel = model;
		this.repaint();
		
	}
	
	/*
	 * Deletes selected shape;
	 */
	public void delete() {
		for (DShape shape : shapes) {
			if(shape == selected) {
				shapes.remove(shape);
				this.repaint();
			}
			
		}
		
	}
	/*
	 * Sets selected shape to the front most position (The last element of the array);
	 */
	public void MoveToFront() {
		shapes.add(selected);
		shapes.remove(selected);
		this.repaint();
		
	}
	/*
	 * Sets selected shape to the back most position (The first element of the array);
	 */
	public void MoveToBack() {
		shapes.remove(selected);
		shapes.add(0, selected);
		
		this.repaint();
		
	}
	//SAVING AND LOADING FEATURE METHODS
	//button for saving
	public void save() {
		System.out.println("the save button has been pressed...");
		//JMenu menu = new JMenu("Save As");
		//Object[] possibilities = {null};
		Component frame = null;
		Icon icon = null;
		String s = (String)JOptionPane.showInputDialog(
		                    frame,
		                    "Enter Filename:\n",
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    icon,
		                    null,
		                    "WhiteBoard");

		//If a string was returned, say so.
		if ((s != null) && (s.length() > 0)) {
		    System.out.println("Saving file as:  " + s);
		    try{
		    	
		        FileOutputStream fos= new FileOutputStream(s);
		        ObjectOutputStream oos= new ObjectOutputStream(fos);
		        oos.writeObject(shapes);
		        oos.close();
		        fos.close();
		        System.out.println("save completed!");
		    }catch(IOException ioe){
		    	System.out.println("filestream failed attempting to save...");
		    	ioe.printStackTrace();
		            
		    }
		    return;
		}
		//If you're here, the return value was null/empty.
		System.out.println("Cannot save without file name!");
		
	}
	
	public void open() {
		System.out.println("the open button has been pressed...");
		//do stuff to open a desired file 
	}
	/*
	 * Used for testing
	 */
	public void addX() {
		System.out.println(selected.getX());
		selected.setX(selected.getX() + 50);
		System.out.println(selected.getX());
		//this.repaint();
		
	}
}
