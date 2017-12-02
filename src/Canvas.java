import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private ArrayList<DShape> shapes;
	private DShape selected;

	public Canvas() {
		this.setBounds(10, 10, 200, 200);
		this.setBackground(Color.WHITE);
		shapes = new ArrayList<>();
		final MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// point = e.getPoint();
				selected.setColor(Color.GRAY);
				setSelected(e.getX(), e.getY());
				repaint();
			}

			public void mouseClicked(MouseEvent e) {
				// point = e.getPoint();
				setSelected(e.getX(), e.getY());
				repaint();
			}
		};
		this.addMouseListener(mouseAdapter);
	}

	public void addShape(DShape shape) {
		this.shapes.add(shape);
		this.repaint();
	}

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

	public void setSelected(DShape shape) {
		this.selected = shape;
	}

	public void setSelected(int x, int y) {
		for (DShape shape : shapes) {
			if (x >= shape.getX() && x <= shape.getX() + shape.getWidth() && y >= shape.getY()
					&& y <= shape.getY() + shape.getHeight()) {
				this.selected = shape;

			}
		}
		selected.setColor(Color.MAGENTA);
		;
	}

	public DShape getSelected() {
		return selected;
	}
}
