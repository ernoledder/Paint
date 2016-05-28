package colorrectangle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class MyLine implements Drawable {

	private double x1, y1, x2, y2;
	private Line2D l;
	private Color fillcolor = new Color(0,0,0,0);
	private Color linecolor = Color.BLACK;
	private int dikte = 2;
	
	
	
	public MyLine() {
	}

	public MyLine(double x1, double y1, double x2, double y2,Color fillcolor, Color linecolor,int dikte) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.fillcolor = fillcolor;
		this.linecolor = linecolor;
		this.dikte = dikte;		
	}

	@Override
	public void draw(Graphics2D g) {

		l = new Line2D.Double(x1, y1, x2, y2);
		g.draw(l);
		g.setColor(linecolor);
		g.setStroke(new BasicStroke(dikte));
		g.draw(l);
		
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

	public boolean contains(double x, double y) {
		return l.ptSegDist(x, y) < 10;
		
		/*float beginx = (float) Math.min(x1, x2);
		float beginy = (float) Math.min(y1, y2);
		float eindx = (float) Math.max(x1, x2);
		float eindy = (float) Math.max(y1, y2);

		float hel = (eindy - beginy) / (eindx - beginx);
		float klikhel = (float) ((y - beginy) / (x - beginx));

		return Math.abs(klikhel - hel) < 0.3;*/
	}

	@Override
	public void refillColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refillLineColor(Color color) {
		this.linecolor = color;		
	}
	
	public void dikker(){
		dikte = dikte + 1;
	}

	public void dunner(){
		dikte = dikte -1;
	}
	
	public Color getLC(){
		return this.linecolor;
	}
	
	public Color getFC(){
		return this.fillcolor;
	}

	@Override
	public int getDikte() {
		// TODO Auto-generated method stub
		return this.dikte;
	}
	
	
	
}