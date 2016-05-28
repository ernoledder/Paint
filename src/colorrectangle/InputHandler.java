package colorrectangle;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;

public class InputHandler implements ActionListener, MouseListener, MouseMotionListener {

	private DrawPanel dp;
	public Tool a;
	private Point mousePoint;
	private Point oldDragMousePoint;
	private Point origin;
	public int qqq;
	public Color fillcolor;
	public Color linecolor;
	

	public InputHandler(DrawPanel dp) {
		this.dp = dp;
		print();

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Change color!")) {
			dp.changeColor();
		} else if (e.getActionCommand().equals("Add")) {
			dp.addRandomShape();
		} /*else if (e.getActionCommand().equals("Mod")) {
			dp.alterNextShape();*/

		else if (e.getActionCommand().equals("EraseLast")) {
			dp.EraseLast();
		}

		else if (e.getActionCommand().equals("Rect")) {
			// dp.getRect();
			a = Tool.PLACINGR;

		}

		else if (e.getActionCommand().equals("Line")) {
			// dp.addLine();
			a = Tool.PLACINGL;

		}

		else if (e.getActionCommand().equals("Elli")) {
			// dp.addElli();
			a = Tool.PLACINGE;
		} else if (e.getActionCommand().equals("Erase")) {
			a = Tool.DELETE;
		} else if (e.getActionCommand().equals("Plaatje")) {
			a = Tool.IMAGE;

		} else if (e.getActionCommand().equals("Drag")) {
			a = Tool.DRAG;
		
		} else if (e.getActionCommand().equals("Text")) {
			a = Tool.TEXT;
		}
		else if (e.getActionCommand().equals("Kleurlijn")){
			a = Tool.LINE;
		}
		else if(e.getActionCommand().equals("Kleurin")){
			a = Tool.FILL;
		}
		else if (e.getActionCommand().equals("dikker")){
			a = Tool.DIKKER;
		}
		else if (e.getActionCommand().equals("dunner")){
			a = Tool.DUNNER;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mousePoint = e.getPoint();
		
		double newX = e.getX();
		double newY = e.getY();
		switch (a) 
		{
		case PLACINGR:
			if(qqq!=0){
				dp.EraseLast();
			}

			dp.getRect(origin.x, origin.y, mousePoint.x, mousePoint.y);
			qqq = 1;
			break;

		case IMAGE:
			//System.out.println("PLacePlaatje");
			if(qqq!=0){
				dp.EraseLast();
			}
			dp.getPic(origin.x, origin.y, mousePoint.x, mousePoint.y);
			qqq=1;
			break;
			
		case PLACINGE:

			if(qqq!=0){
				dp.EraseLast();
			}
			dp.addElli(origin.x, origin.y, mousePoint.x, mousePoint.y);
			qqq=1;
			break;
		case PLACINGL:

			if(qqq!=0){
				dp.EraseLast();
			}
			dp.addLine(origin.x, origin.y, mousePoint.x, mousePoint.y);
			qqq=1;
			break;

		case DRAG:

			dp.dragF(oldDragMousePoint.x, oldDragMousePoint.y, mousePoint.x, mousePoint.y);
			break;
		case DIKKER:
			dp.maakDikker(origin.x,origin.y);
			break;
		case DUNNER:
			dp.maakDunner(origin.x,origin.y);
			break;

		default:
			
			break;
		}
		oldDragMousePoint = e.getPoint();
System.out.println("DRAGGED");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		switch (a) {
		case DELETE:
			dp.erase(x, y);
//			a = null;
			break;
		case PLAATJE:

			// URL imageUrl = new URL
			// ("http://s9.postimage.org/n92phj9tr/image1.jpg");
			

			break;
		case TEXT:
			dp.tekst(x,y);
			break;
		case LINE:
			dp.fillLineCollins(x, y);
			System.out.println(" Kleur");
			break;
		case FILL:
			dp.fillCollins(x, y);
			break;
		case DIKKER:
			dp.maakDikker(x,y);
			break;
		case DUNNER:
			dp.maakDunner(x,y);
			break;
		default:

		}
		// System.out.println("1");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePoint = e.getPoint();
		int x2 = e.getX();
		int y2 = e.getY();
		int x = e.getX() - mousePoint.x;
		int y = e.getY() - mousePoint.y;
		origin = e.getPoint();
		origin.setLocation(origin.x + x, origin.y + y);
		
		oldDragMousePoint = e.getPoint();

		// Line2D clickedLine = dp.getClickedLine(x2, y2);
		if (a == Tool.DRAG) 
		{
			dp.dragShape(origin.x, origin.y, mousePoint.x, mousePoint.y);

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		qqq=0;
		switch (a) {
//		case PLACINGR:
//
//			a = null;
//			break;
//		case PLACINGE:
//
//			a = null;
//			break;
//		case PLACINGL:
//
//			a = null;
//			break;
//
//		case DRAG:
//
//			a = null;
//			break;
//
//		case TEXT:
//			
//			a=null;
//			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void print()
	{
		System.out.println("PRINT");
	}
}
