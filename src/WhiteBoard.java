import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhiteBoard extends JFrame {

	Canvas canvas;

	public static void main(String[] args) {
		WhiteBoard frame = new WhiteBoard();
		frame.setVisible(true);
	}
	public WhiteBoard() {
                super("WhiteBoard Application");
		canvas = new Canvas();
                this.setLayout(new GridLayout(1,2,10,3));
		this.setBounds(500, 500, 1000, 400);
		this.add(canvas).setLocation(300,80);
		JButton rect = new JButton("Rect");
		rect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Random rand = new Random();

				DRectModel rectModel = new DRectModel(10,10,40,40,Color.GRAY);//rand.nextInt(400), rand.nextInt(400), rand.nextInt(400),rand.nextInt(400), Color.GRAY);
				DRect dr = new DRect();
				dr.shapeModel = rectModel;
//				 dr.setAll(rectModel.getX(), rectModel.getY(), rectModel.getWidth(),
//				 rectModel.getHeight(), rectModel.getColor());
				canvas.addShape(dr);
			}
		});
		JButton oval = new JButton("Oval");
		oval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				DOvalModel ovalModel = new DOvalModel(10,10,60,20,Color.GRAY);//rand.nextInt(400), rand.nextInt(400), rand.nextInt(400),
						//rand.nextInt(400), Color.GRAY);
				DOval dov = new DOval();
				dov.shapeModel = ovalModel;
				// dr.setAll(rectModel.getX(), rectModel.getY(), rectModel.getWidth(),
				// rectModel.getHeight(), rectModel.getColor());
				canvas.addShape(dov);

			}
		});
		JButton line = new JButton("Line");
		line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Random rand = new Random();

				DLineModel rectModel = new DLineModel(10,0,200,200,Color.GRAY);//rand.nextInt(400), rand.nextInt(400), rand.nextInt(400),rand.nextInt(400), Color.GRAY);
				DLine dl = new DLine();
				dl.shapeModel = rectModel;
//				 dr.setAll(rectModel.getX(), rectModel.getY(), rectModel.getWidth(),
//				 rectModel.getHeight(), rectModel.getColor());
				canvas.addShape(dl);
			}
		});
		JButton text = new JButton("Text");

		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		// JButton colorChooser = new JButton("ChangeColor");
		// line.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// JColorChooser jcc = new JColorChooser();
		// canvas.getSelected().setColor(jcc.showDialog(null, "Pick a Color",
		// Color.GRAY));
		// }
		// });
		JButton delete = new JButton("Delete Item");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.delete();

			}
		});
		JButton moveToFront = new JButton("Move To Front");
		moveToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.MoveToFront();
			}
		});
		JButton moveToBack = new JButton("Move To Back");
		moveToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.MoveToBack();
			}
		});
		JButton addX = new JButton("Shift-X");
		addX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.addX();
			}
		});
		//Sean's buttons for save/load and networking...
		JButton save = new JButton("Save");
		JButton open = new JButton("Open");
		JButton serverStart = new JButton("$ S e r v e r  S t a r t $");
		JButton clientStart = new JButton("$ C l i e n t  S t a r t $");
		
		JPanel content = new JPanel();
                content.add(rect);
                content.add(line);
                content.add(oval);
		content.add(addX);
                content.add(text);
                content.add(delete);
		content.add(moveToFront);
		content.add(moveToBack);
		// this.add(rect);
		// content.add(colorChooser);
		
		//stuff for save and open
		content.add(save);
		content.add(open);
		//networking stuff
		content.add(serverStart);
		content.add(clientStart);
                
		
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.save();

			}
		});
		
		content.add(open);
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.open();

			}
		});
		serverStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.serverStart();

			}
		});
		clientStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.clientStart();

			}
		});
		this.add(content); //add the buttons.  Without a layout this looks bad and conflicts with whiteboard

	};

	// canvas.addMouseListener(mouseAdapter);

}
