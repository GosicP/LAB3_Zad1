package gui;

import java.awt.Color;

public class Generator implements Runnable{
	
	Svemir svemir=new Svemir();
	Thread thread;
	
	public Generator(Svemir s) {
		svemir=s;
		
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
		//ne radi random kako treba		
		try {
			while(!thread.interrupted()) {
				svemir.dodajTelo(new Kometa((int)(Math.random()*200), 0, Color.GRAY, (int)(Math.random()*20+10)));
				thread.sleep(900); 
			}
		} catch (InterruptedException e) {
		
		}
	}
}
