package colorrectangle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
	

	public Window () {
		// ‘super’ calls a function inherited from the parent class (JFrame)
		super ();
		setTitle("Callbacks"); setSize(new Dimension(900, 900));
		// Make sure the window appears in the middle of your screen
		setLocationRelativeTo(null);
		// Determines what should happen when the frame is closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Chooses a certain layout type for the elements in this frame
		getContentPane().setLayout(new BorderLayout());
		DrawPanel rp = new DrawPanel (Color.BLACK);
		InputHandler ih = new InputHandler (rp);
		ButtonPanel bp = new ButtonPanel (rp,ih);
		rp.addMouseListener(ih);
		rp.addMouseMotionListener(ih);
		// Places the DrawPanel in the center of the frame
		getContentPane().add(rp, BorderLayout.CENTER);
		// Places the ButtonPanel in the top of the frame
		getContentPane().add(bp, BorderLayout.NORTH);
		// Set the window to visible! Yup... This is necessary
		setVisible(true); }
	  
}
