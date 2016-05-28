package colorrectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	private InputHandler ih;
	private Color color;
	public Drawable shape;
	public ArrayList<Drawable> shapesList = new ArrayList<Drawable>();
	public ArrayList<Integer> soort = new ArrayList<Integer>();
	public Random rand = new Random();
	public boolean z = true;
	public int plek;
	public Color fillcolor;
	public Color linecolor;
	


	public DrawPanel(Color color) {
		super();
		this.color = color;

	}

	public int index = 0;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);

		Graphics2D h = (Graphics2D) g;
		super.paintComponent(h);

		// g.fillRect(100, 30, 200, 200);

		Graphics2D g2d = (Graphics2D) g;
		for (Drawable s : shapesList) {
			s.draw(g2d);

		}
		

	}

	public void dragShape(int x1, int y1, int x2, int y2) {
		for (int i = 0; i < shapesList.size(); i++) {

			if (shapesList.get(i).contains(x1, y1)) {
				plek = i;
			}
		}
	}

	public void dragF(int oldX, int oldY, int newX, int newY) {

		Drawable m = shapesList.get(plek);

		double x1 = m.getX1();
		double x2 = m.getX2();
		double y1 = m.getY1();
		double y2 = m.getY2();
		Color fc = m.getFC();
		Color lc = m.getLC();
		int dikte = m.getDikte();

		double differenceNewOldX = newX - oldX;
		double differenceNewOldY = newY - oldY;

		Drawable newShape = null;
		switch (soort.get(plek)) {
		case 1:
			newShape = new MyLine((x1 + (differenceNewOldX)), (y1 + (differenceNewOldY)), x2 + (differenceNewOldX),
					y2 + (differenceNewOldY),fc,lc,dikte);
			break;
		case 2:
			newShape = new MyRectangle(x1 + (differenceNewOldX), y1 + (differenceNewOldY), x2 + (differenceNewOldX),
					y2 + (differenceNewOldY),fc,lc,dikte);
			break;
		case 3:
			newShape = new MyEllipse(x1 + (differenceNewOldX), y1 + (differenceNewOldY), x2 + (differenceNewOldX),
					y2 + (differenceNewOldY),fc,lc,dikte);
			break;
		default:
		}
		shapesList.set(plek, newShape);
		repaint();

	}

	public void changeColor() {

		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		color = new Color(r, g, b);
		repaint();
	}

	/*public void changePlaatje(int x, int y) {
		int breedtePl = x;
		int lengtePl = y;
		BufferedImage bi = new BufferedImage(breedtePl, lengtePl, BufferedImage.TYPE_INT_RGB);
		try {

			BufferedImage plaatje1 = ImageIO.read(new File("/Users/maxvanlaarhoven/Desktop/1.png"));
			plaatjesList.add(plaatje1);

			Graphics f = bi.getGraphics();
			f.drawImage(plaatje1, 0, 0, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(plaatjesList.size());
		repaint();
	}*/

	public void addRandomShape() {
		double x1 = rand.nextInt(700);
		double y1 = rand.nextInt(700);

		switch (rand.nextInt(3)) {
		case 0:
			shape = new MyLine(x1, y1, x1 + 60, y1 + 60,new Color(0,0,0,0),Color.BLACK,2);
			soort.add(1);
			break;
		case 1:
			shape = new MyRectangle(x1, y1, x1 + 60, y1 + 60,new Color(0,0,0,0),Color.BLACK,2);
			soort.add(2);
			break;
		case 2:
			shape = new MyEllipse(x1, y1, x1 + 60, y1 + 60,new Color(0,0,0,0),Color.BLACK,2);
			soort.add(3);
			break;
		default:
		}
		shapesList.add(shape);
		repaint();
	}

/*	public void alterNextShape() {
		if (shapesList.size() != 0) {
			if (index >= shapesList.size()) {
				index = 0;
			}
			Drawable s = shapesList.get(index);
			double x1 = s.getX1();
			double x2 = s.getX2();
			double y1 = s.getY1();
			double y2 = s.getY2();

			Drawable newShape = null;
			switch (rand.nextInt(3)) {
			case 0:
				newShape = new MyLine(x1, y1, x2, y2);
				soort.set(index, 1);
				break;
			case 1:
				newShape = new MyRectangle(x1, y1, x2, y2,new Color(0,0,0,0),Color.BLACK);
				soort.set(index, 2);
				break;
			case 2:
				newShape = new MyEllipse(x1, y1, x2, y2);
				soort.set(index, 3);
				break;
			default:
			}
			shapesList.set(index, newShape);
			repaint();
			index++;
		}
	}*/

	public void EraseLast() {
		if (shapesList.size() != 0) {
			shapesList.remove(shapesList.size() - 1);
			soort.remove(soort.size() - 1);
			repaint();
		}

		if (shapesList.size() == 0) {
			z = true;
		}
	}

	/*public void getRect() {
		int x1 = rand.nextInt(700);
		int y1 = rand.nextInt(700);
		shape = new MyRectangle(x1, y1, x1 + 60, y1 + 60,new Color(0,0,0,0),Color.BLACK);
		shapesList.add(shape);
		repaint();
	}*/

	public void getRect(int x1, int y1, int x2, int y2) {
		shape = new MyRectangle(x1, y1, x2, y2,new Color(0,0,0,0),Color.BLACK,2);
		shapesList.add(shape);
		soort.add(2);
		repaint();

	}
	
	public void getPic(int x1,int y1, int x2, int y2){
		shape = new MyImage(x1,y1,x2,y2);
		shapesList.add(shape);
		soort.add(4);
		repaint();
	}

	/*public void addLine() {
		int x1 = rand.nextInt(700);
		int y1 = rand.nextInt(700);
		shape = new MyLine(x1, y1, x1 + 60, y1 + 60);
		shapesList.add(shape);
		repaint();
	}
*/
	public void addLine(int x1, int y1, int x2, int y2) {
		shape = new MyLine(x1, y1, x2, y2,new Color(0,0,0,0),Color.BLACK,2);
		shapesList.add(shape);
		soort.add(1);
		repaint();
	}

	/*public void addElli() {
		int x1 = rand.nextInt(700);
		int y1 = rand.nextInt(700);
		shape = new MyEllipse(x1, y1, x1 + 60, y1 + 60);
		shapesList.add(shape);
		repaint();
	}*/

	public void addElli(int x1, int y1, int x2, int y2) {
		shape = new MyEllipse(x1, y1, x2, y2,new Color(0,0,0,0),Color.BLACK,2);
		shapesList.add(shape);
		soort.add(3);
		repaint();
	}

	public void erase(double x1, double y1) {
		boolean a = true;
		System.out.println(shapesList.size());
		int i = shapesList.size() - 1;
		while (a) {

			if (shapesList.get(i).contains(x1, y1)) {
				shapesList.remove(i);
				soort.remove(i);
				repaint();
				a = false;

			} else
				i--;

		}
		if (shapesList.size() == 0) {
			z = true;
		}
	}

	public void tekst(int x1, int y1) {
		String tekst = (String) JOptionPane.showInputDialog(this, "welke text wil je", "tekst",
				JOptionPane.PLAIN_MESSAGE);
		shape = new MyTekst(tekst, x1, y1);
		shapesList.add(shape);
		soort.add(4);
		repaint();
	}

	public void fillLineCollins(double x1, double y1) {
		boolean a = true;
		System.out.println(shapesList.size());
		int i = shapesList.size() - 1;
		while (a) {

			if (shapesList.get(i).contains(x1, y1)) {
				linecolor = JColorChooser.showDialog(null, "Kies een kleur", Color.RED);
				System.out.println(" checklinekleur");
				shapesList.get(i).refillLineColor(linecolor);

				repaint();
				a = false;

			} else
				i--;

		}
		if (shapesList.size() == 0) {
			z = true;
		}
	}

	public void fillCollins(double x1, double y1) {
		boolean a = true;
		System.out.println(shapesList.size());
		int i = shapesList.size() - 1;
		while (a) {

			if (shapesList.get(i).contains(x1, y1)) {
				fillcolor = JColorChooser.showDialog(null, "Kies een kleur", Color.RED);
				System.out.println(" checkfillkleur");
				shapesList.get(i).refillColor(fillcolor);

				repaint();
				a = false;

			} else
				i--;

		}
		if (shapesList.size() == 0) {
			z = true;
		}
	}

	public void maakDikker(double x1,double y1) {
		boolean a = true;
		System.out.println(shapesList.size());
		int i = shapesList.size() - 1;
		while (a) {

			if (shapesList.get(i).contains(x1, y1)) {
				
				System.out.println(" Dikker");
				shapesList.get(i).dikker();

				repaint();
				a = false;

			} else
				i--;

		}
		if (shapesList.size() == 0) {
			z = true;
		}
	}
	
	
	public void maakDunner(double x1, double y1 ){
		boolean a = true;
		System.out.println(shapesList.size());
		int i = shapesList.size() - 1;
		while (a) {

			if (shapesList.get(i).contains(x1, y1)) {
				
				System.out.println(" Dunner");
				shapesList.get(i).dunner();

				repaint();
				a = false;

			} else
				i--;

		}
		if (shapesList.size() == 0) {
			z = true;
		}
	}
	
	
}

// schiet en lanceer en verander KNOP
// public void dragShape(int x1, int y1, int x2, int y2) {
// for (int i = 0; i < shapesList.size(); i++) {
//
// if (shapesList.get(i).contains(x1, y1)) {
// plek = i;
// }
// }
// }
//
// public void dragF(int mo1, int mo2, int dragX, int dragY) {
//
// Drawable m = shapesList.get(plek);
// double x1 = m.getX1();
// double x2 = m.getX2();
// double y1 = m.getY1();
// double y2 = m.getY2();
//
// Drawable newShape = null;
// switch (soort.get(plek)) {
// case 0:
// newShape = new MyLine(x1+(dragX-mo1), y1+(dragY-mo2), x2+(dragX-mo1),
// y2+(dragY-mo2));
// break;
// case 1:
// newShape = new MyRectangle(x1+(dragX-mo1), y1+(dragY-mo2), x2+(dragX-mo1),
// y2+(dragY-mo2));
// break;
// case 2:
// newShape = new MyEllipse(x1+(dragX-mo1), y1+(dragY-mo2), x2+(dragX-mo1),
// y2+(dragY-mo2));
// break;
// default:
// }
// shapesList.set(plek, newShape);
// repaint();
//
// }