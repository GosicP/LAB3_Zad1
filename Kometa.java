package gui;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {
	


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
	/*int i=0;
	int steps = 5;	
	g.translate(getX(), getY());
	double angle = 0;
	double inc = 2*Math.PI/steps;
	g.setColor(Color.GRAY);
	int xn[] = new int[5];
	int yn[] = new int[5];
	int endX, endY;
	for (;i<5; angle+=inc, i++) {
		endX = (int) (poluprecnik_pikseli*Math.cos(angle));
		endY = (int) (poluprecnik_pikseli*Math.sin(angle));
		g.drawLine(xn[i], yn[i], endX, endY);
		xn[i] = endX;
		yn[i] = endY;
	}
		g.fillPolygon(xn, yn, 5);*/
		double a=36./180*Math.PI;
		Color prev=g.getColor();
		int steps = 5;	
		double inc = 2*Math.PI/steps;
		//g.translate(getX(),getY());
		g.setColor(color);
		double angle=0;
		int endX,endY,i=0;
		int xp[]=new int[5],yp[]=new int[5];
		for(angle = 0; angle < 2 * Math.PI; angle += inc) {
			endX = (int)(poluprecnik_pikseli* Math.cos(a+angle)+getX());
			endY = (int)(poluprecnik_pikseli * Math.sin(a+angle)+getY());
			g.drawLine(xp[i], yp[i], endX, endY);
			xp[i]=endX;
			yp[i]=endY;
			i++;
	}

	}

}
