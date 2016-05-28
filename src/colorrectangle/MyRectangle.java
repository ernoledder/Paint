package colorrectangle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class MyRectangle implements Drawable {

	private double x1, y1, x2, y2;
	private Rectangle2D r;
	private Color fillcolor = new Color(0,0,0,0);
	private Color linecolor = Color.BLACK;
	private int dikttte = 2;
	public MyRectangle() {
	}

	public MyRectangle(double x1, double y1, double x2, double y2, Color fillcolor, Color linecolor,int diktte) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.fillcolor = fillcolor;
		this.linecolor = linecolor;
		this.dikttte = diktte;
				
	}

	@Override
	public void draw(Graphics2D g) {
		double x = getStartX();
		double y = getStartY();
		double width = getWidth();
		double height = getHeight();
		r = new Rectangle2D.Double(x, y, width, height);
		g.setColor(fillcolor);
		g.fill(r);
		g.setColor(linecolor);
		g.setStroke(new BasicStroke(dikttte));
		g.draw(r);
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

	public boolean contains(double x, double y){
	return r.contains(x, y);
	}

	@Override
	public void refillLineColor(Color color) {
		this.linecolor = color;
		
	}

	@Override
	public void refillColor(Color color) {
		this.fillcolor = color;
		
	}
	public void dikker(){
		dikttte = dikttte + 1;
	}

	public void dunner(){
		dikttte = dikttte -1;
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
		return this.dikttte;
	}
	
	
	
}
