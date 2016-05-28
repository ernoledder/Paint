package colorrectangle;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	private DrawPanel dp;
	private InputHandler ih;
	
public ButtonPanel(DrawPanel dp, InputHandler ih) {
		super();
		this.dp = dp;
		this.ih = ih;
		//JButton b = new JButton ("Change color!");
		//add (b);
		//b.addActionListener(ih);
		
		JButton c = new JButton ("Mod");
		//add (c);
		c.addActionListener(ih);
		
		JButton d = new JButton ("Add");
		//add (d);
		d.addActionListener(ih);
		
		JButton e = new JButton ("EraseLast");
		add (e);
		e.addActionListener(ih);
		
		JButton f = new JButton ("Rect");
		add (f);
		f.addActionListener(ih);
		
		JButton g = new JButton ("Line");
		add (g);
		g.addActionListener(ih);
		
		JButton h = new JButton ("Elli");
		add (h);
		h.addActionListener(ih);
		
		JButton i = new JButton("Erase");
		add (i);
		i.addActionListener(ih);
		
		JButton k = new JButton("Plaatje");
		add (k);
		k.addActionListener(ih);
		
		JButton l = new JButton("Drag");
		add (l);
		l.addActionListener(ih);
		
		JButton m = new JButton("Text");
		add (m);
		m.addActionListener(ih);
		
		JButton n = new JButton("Kleurlijn");
		add(n);
		n.addActionListener(ih);
		
		JButton o = new JButton("Kleurin");
		add(o);
		o.addActionListener(ih);
		
		JButton p = new JButton("dikker");
		add(p);
		p.addActionListener(ih);
		
		JButton q = new JButton("dunner");
		add(q);
		q.addActionListener(ih);
		
	}

}
