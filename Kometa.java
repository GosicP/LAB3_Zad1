package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Kometa extends NebeskoTelo {
	
	private double angle = Math.random()*Math.PI*2/5;
	private Polygon p;
	public Kometa(int x, int y, Color color, int pol) {
		super(x, y, color, pol);
		this.color=color.GRAY;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void crtaj(Graphics g) {
	int i=0;
	int steps = 5;	

	double inc = 2*Math.PI/steps;
	g.setColor(Color.GRAY);
	int xn[] = new int[5];
	int yn[] = new int[5];
	int endX, endY;
	for (;i<5; angle+=inc, i++) {
		endX = (int) (poluprecnik_pikseli*Math.cos(angle))+getX();
		endY = (int) (poluprecnik_pikseli*Math.sin(angle))+getY();
		
		xn[i] = endX;
		yn[i] = endY;
	}
		g.fillPolygon(xn, yn, 5);
		Polygon p = new Polygon(xn, yn, 5);

	}
	
	public boolean proveriPreklapanje(int xx, int yy) {
	
		if(p.contains(new Point(xx, yy))==true) {
			return true;
		}else {
			return false;
		}
	}
}
