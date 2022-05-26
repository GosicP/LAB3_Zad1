package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {
	
	
	public void populateWindow() {
		
		Svemir svemir = new Svemir();
		Panel svemirPanel= new Panel();
		Panel controlPanel = new Panel();
		Button dugme_pokreni = new Button("Pokreni!");
		Generator generator = new Generator(svemir);
		
		svemirPanel.add(svemir);
		svemirPanel.setBackground(Color.black);
		add(svemir, BorderLayout.CENTER);
		
		controlPanel.add(dugme_pokreni);
		add(controlPanel, BorderLayout.SOUTH);
		
		dugme_pokreni.addActionListener((ae) -> {
			svemir.kreni();
			generator.kreni();
			dugme_pokreni.setEnabled(false);
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
