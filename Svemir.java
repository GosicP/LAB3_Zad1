package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable{
	
	ArrayList<NebeskoTelo> lista_tela = new ArrayList<>();
 	
	private Kometa kometa = new Kometa(150,20,Color.GRAY,15);
	private Color lineColor = Color.BLACK;
	private long sleepTime = 100;
	private Thread thread;
	private Igrac igrac;
	
	public Svemir() {
		this.setBackground(Color.BLACK);
	}
	
	public synchronized void dodajTelo(NebeskoTelo k) {
		lista_tela.add(k);
	}
	
	public synchronized void dodajIgraca(NebeskoTelo k) {
		igrac=(Igrac) k;
	}
	
	public void pomeriIgraca(int n) {
		igrac.promeniX(n);
	}
	
	@Override
	public void paint(Graphics g) {
		//kometa.crtaj(g);
		for(int i=0; i<lista_tela.size(); i++) {
			 igrac.crtaj(g);
			 lista_tela.get(i).crtaj(g);
			 lista_tela.get(i).promeniY(5);
			
		}
	}
	
	public synchronized void kreni() {
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stani() {
		thread.interrupt();
	}
	

	@Override
	public void run() {
		
		try {
			while(!thread.interrupted()) {
				repaint();
				thread.sleep(100);
			}
					
		}catch (InterruptedException e) {}
		
		
	}
	

}
