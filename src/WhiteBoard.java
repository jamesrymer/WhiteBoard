import java.awt.Color;
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
		canvas = new Canvas();

		this.setBounds(100, 100, 800, 400);
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		// this.setLayout(flowLayout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(canvas);
		JButton rect = new JButton("rect");
		rect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Random rand = new Random();

				DRectModel rectModel = new DRectModel(10,10,40,40,Color.GRAY);//rand.nextInt(400), rand.nextInt(400), rand.nextInt(400),
						//rand.nextInt(400), Color.GRAY);
				DRect dr = new DRect();
				dr.shapeModel = rectModel;
				// dr.setAll(rectModel.getX(), rectModel.getY(), rectModel.getWidth(),
				// rectModel.getHeight(), rectModel.getColor());
				canvas.addShape(dr);
			}
		});
		JButton oval = new JButton("oval");
		oval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				DOvalModel ovalModel = new DOvalModel(10,10,20,20,Color.GRAY);//rand.nextInt(400), rand.nextInt(400), rand.nextInt(400),
						//rand.nextInt(400), Color.GRAY);
				DOval dov = new DOval();
				dov.shapeModel = ovalModel;
				// dr.setAll(rectModel.getX(), rectModel.getY(), rectModel.getWidth(),
				// rectModel.getHeight(), rectModel.getColor());
				canvas.addShape(dov);

			}
		});
		JButton line = new JButton("line");
		line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JButton text = new JButton("text");

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
		JPanel content = new JPanel();

		content.add(line);
		content.add(text);
		content.add(rect);
		// this.add(rect);
		content.add(oval);
		// content.add(colorChooser);

		// content.setLayout(m);
		this.add(content);

	};

	// canvas.addMouseListener(mouseAdapter);

}
