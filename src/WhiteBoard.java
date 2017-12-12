/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiteboard;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WhiteBoard extends JFrame {
	Canvas canvas;
        final WhiteBoard frame = this;
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
                JComboBox textBox = new JComboBox();
                String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
                String[] defNames = new String[]{ "Dialog"};
                for(String fts: fonts)
                    textBox.addItem(fts);
                for(String name :defNames )
                    textBox.setSelectedItem(name);
                JTextField textField = new JTextField("WOW!");
                textField.setColumns(10);
		JButton text = new JButton("Text");
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()){
                                    DTextModel textModel;
                                    textModel = new DTextModel(25,25,75,50, Color.LIGHT_GRAY);
                                    String text = "hello";
                                    DText txt = new DText();
                                    txt.setAll(textModel.getX(), textModel.getY(), textModel.getWidth(),textModel.getHeight(), textModel.getColor());
                                    txt.setInput(text);
                                    canvas.addShape(txt);
                                    
                                }
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
                
		/*JButton addX = new JButton("Shift-X");
		addX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.addX();
			}
		})
                */
		//Sean's buttons for save/load and networking...
		JButton save = new JButton("Save");
		JButton open = new JButton("Open");
		JButton serverStart = new JButton("$ S e r v e r  S t a r t $");
		JButton clientStart = new JButton("$ C l i e n t  S t a r t $");
                
                JButton setColorButton = new JButton("Color");
                Box colorBox = new Box(BoxLayout.X_AXIS);
                colorBox.add(setColorButton);

		setColorButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				Color initialColor = Color.GRAY; 
				final JColorChooser chooser = new JColorChooser(initialColor);
				JColorChooser.createDialog(
					canvas, "Pick a color", true, chooser, 
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (canvas.getSelected() != null)
								canvas.getSelected().getDShapeModel().setColor(chooser.getColor());
						}
					}, 
                                        null).setVisible(true);
			}
		});
		JPanel content = new JPanel();
                content.add(rect);
                content.add(line);
                content.add(oval);
                content.add(setColorButton);
                content.add(textField);
                content.add(text);
                content.add(textBox);
                content.add(delete);
		content.add(moveToFront);
		content.add(moveToBack);
		// this.add(rect);
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
                            try {
                                canvas.clientStart();
                            } catch (IOException ex) {
                                Logger.getLogger(WhiteBoard.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(WhiteBoard.class.getName()).log(Level.SEVERE, null, ex);
                            }

			}
		});
		// content.setLayout(m);
		this.add(content);
                this.setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setResizable(false);
		/*
		for (JButton comp : content.getComponent(i)) {
			((JButton)comp).setAlignmentX(this.LEFT_ALIGNMENT);
			}
		*/
	};
	// canvas.addMouseListener(mouseAdapter);
}