package colorrectangle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage implements Drawable {

	private double x1, y1, x2, y2;
	private Image image;

	public MyImage(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		try {
			
			image = ImageIO.read(new File("C:/Users/erno/workspace/MMI2/src/colorrectangle/eiffel.png"));
			//image = ImageIO.read(new File("C:/Users/erno/workspace/MMI2/src/colorrectangle/eiffel.png"));
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void draw(Graphics2D g) {
		double x = getStartX();
		double y = getStartY();
		double width = getWidth();
		double height = getHeight();
		g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);

	}

	@Override
	public void refillLineColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refillColor(Color color) {
		// TODO Auto-generated method stub

	}

	private double getWidth() {
		return Math.abs(x1 - x2);
	}

	private double getHeight() {
		return Math.abs(y1 - y2);
	}

	private double getStartX() {
		return Math.min(x1, x2);
	}

	private double getStartY() {
		return Math.min(y1, y2);
	}

	@Override
	public double getX1() {
		return this.x1;
	}

	@Override
	public double getX2() {
		return this.x2;
	}

	@Override
	public double getY2() {
		return this.y1;
	}

	@Override
	public double getY1() {
		return this.y2;
	}

	@Override
	public boolean contains(double x1, double y1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dikker() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dunner() {
		// TODO Auto-generated method stub

	}

	@Override
	public Color getFC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getLC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDikte() {
		// TODO Auto-generated method stub
		return 0;
	}

}
