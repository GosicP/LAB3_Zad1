package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Igrac extends NebeskoTelo {
	Polygon p;
	public Igrac() {
		super(95, 330, Color.RED, 10);
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
	public Point getVrh() {
		int x[] = new int[3];
		int y[] = new int[3];
		x=p.xpoints;
		y=p.ypoints;
		int xx=x[1];
		int yy=y[1];
		Point p = new Point(xx, yy);
		return p;
	}
	
	public void crtaj(Graphics g) {
		int i=0;
		int steps = 3;	
		double angle = Math.PI/6;
		double inc = 2*Math.PI/steps;
		g.setColor(Color.RED);
		int xn[] = new int[3];
		int yn[] = new int[3];
		int endX, endY;
		for (;i<3; angle+=inc, i++) {
			endX = (int) (poluprecnik_pikseli*Math.cos(angle))+getX();
			endY = (int) (poluprecnik_pikseli*Math.sin(angle))+getY();
			
			xn[i] = endX;
			yn[i] = endY;
		}
			g.fillPolygon(xn, yn, 3);
			p = new Polygon(xn, yn, 3);
	}

}
