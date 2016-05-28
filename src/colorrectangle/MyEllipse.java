package colorrectangle;

	import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


	public class MyEllipse implements Drawable {

		private double x1, y1, x2, y2;
		private Ellipse2D e;
		private Color fillcolor = new Color(0,0,0,0);
		private Color linecolor = Color.BLACK;
		private int diktte = 2;
		
		public MyEllipse() {
		}

		public MyEllipse(double x1, double y1, double x2, double y2,Color fillcolor, Color linecolor,int diktte) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.fillcolor = fillcolor;
			this.linecolor = linecolor;
			this.diktte = diktte;
					
		}

		@Override
		public void draw(Graphics2D g) {
			double x = getStartX();
			double y = getStartY();
			double width = getWidth();
			double height = getHeight();
			e = new Ellipse2D.Double(x, y, width, height);
			g.setColor(fillcolor);
			g.fill(e);
			g.setColor(linecolor);
			g.setStroke(new BasicStroke(diktte));
			g.draw(e);
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
		return e.contains(x, y);
		
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
			diktte = diktte + 1;
		}

		public void dunner(){
			diktte = diktte -1;
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
			return this.diktte;
		}
		
		
		
		
	}