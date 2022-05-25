package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable{
	
	ArrayList<NebeskoTelo> lista_tela = new ArrayList<>();
 	
	private Kometa kometa = new Kometa(150,0,Color.GRAY,15);
	private Color lineColor = Color.BLACK;
	private long sleepTime = 100;
	private Thread thread;
	
	
	public Svemir() {
		this.setBackground(Color.BLACK);
	}
	
	public void dodajTelo(NebeskoTelo k) {
		lista_tela.add(k);
	}
	
	@Override
	public void paint(Graphics g) {
		kometa.crtaj(g);
		/*for(int i=0; i<lista_tela.size(); i++) {
	
			 lista_tela.get(i).paint(g);
			 lista_tela.get(i).promeniY(5);
			
		}*/
	}
	
	public synchronized void kreni() {
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stani() {
		if(thread != null) {
			thread.interrupt();
		}
		while (thread != null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
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
