package gui;

import java.awt.Color;
import java.awt.Graphics;

public class NebeskoTelo extends Objekat {

	protected int poluprecnik_pikseli;
	
	public NebeskoTelo(int x, int y, Color color, int pol) {
		super(x, y, color);
		poluprecnik_pikseli=pol;
		
	}

	public void paint(Graphics g) {}

}
