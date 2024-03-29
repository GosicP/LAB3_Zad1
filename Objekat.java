package gui;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {
	
	int x, y;
	Color color;
	
	public Objekat (int x, int y, Color color) {
		this.x=x;
		this.y=y;
		this.color=color;
	}
	
	public void promeniX(int pomeraj) {x+=pomeraj;}
	
	public void promeniY(int pomeraj) {y+=pomeraj;}
	
	
	abstract public void crtaj(Graphics g);
	
	public boolean proveriPreklapanje(int x, int y) {
		if(this.x==x && this.y==y) {
			return true;
		}else {
			return false;
		}
	}
}
