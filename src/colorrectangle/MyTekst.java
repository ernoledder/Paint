package colorrectangle;

import java.awt.Color;
import java.awt.Graphics2D;

public class MyTekst implements Drawable{
		public String text;
		public int x,y;
		private int dikte = 2;
	
	
	public MyTekst(String s, int x, int y){
		this.text = s;
		this.x = x;
		this.y = y;
		
	}
	@Override
	public void draw(Graphics2D g) {
		g.drawString(text, x, y);
		
	}

	@Override
	public double getX1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getX2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(double x1, double y1) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void refillColor(Color color) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void refillLineColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	public void dikker(){
		dikte = dikte + 1;
	}

	public void dunner(){
		dikte = dikte -1;
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
