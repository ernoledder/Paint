
package colorrectangle;
import java.awt.Color;
import java.awt.Graphics2D;

		public interface Drawable {
			public void draw(Graphics2D g);
			public void refillLineColor(Color color);
			public void refillColor(Color color);
			public double getX1();
			public double getX2();
			public double getY2();
			public double getY1();
			
			public boolean contains(double x1, double y1);
			public void dikker();
			public void dunner();
			public Color getFC();
			public Color getLC();
			public int getDikte();
			
			
			
			
	}


