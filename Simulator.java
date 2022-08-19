package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {
	
	
	
	public void populateWindow() {
		
		Svemir svemir = new Svemir();
		Panel svemirPanel= new Panel();
		Panel controlPanel = new Panel();
		Button dugme_pokreni = new Button("Pokreni!");
		Generator generator = new Generator(svemir);
		//Igrac igrac = new Igrac();
		
		svemirPanel.add(svemir);
		svemirPanel.setBackground(Color.black);
		add(svemir, BorderLayout.CENTER);
		
		controlPanel.add(dugme_pokreni);
		add(controlPanel, BorderLayout.SOUTH);
		
		dugme_pokreni.addActionListener((ae) -> {
			svemir.kreni();
			generator.kreni();
			svemir.requestFocus();
			dugme_pokreni.setEnabled(false);
		});

		svemir.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char key = Character.toUpperCase(e.getKeyChar());
				switch (key){
				case KeyEvent.VK_A:{ 
					System.out.println("usao sam");
					svemir.pomeriIgraca(-5);
					break;
				}
				
				case KeyEvent.VK_D: {
					System.out.println("usao sam");
					svemir.pomeriIgraca(5);
					break;	
				}
					}
				
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				svemir.stani();
				generator.stani();
				dispose();
			}
		});
	}
	
	public Simulator() {
		
		setBounds(700, 200, 200, 400);
		setResizable(false);
		
		populateWindow();
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Simulator();
	}
}
