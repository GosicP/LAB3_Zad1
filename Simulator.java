package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class Simulator extends Frame {
	
	
	public void populateWindow() {
		
		Svemir svemir = new Svemir();
		Panel svemirPanel= new Panel();
		Panel controlPanel = new Panel();
		Button dugme_pokreni = new Button("Pokreni!");
		Generator generator = new Generator(svemir);
		
		svemirPanel.add(svemir);
		svemirPanel.setBackground(Color.black);
		add(svemirPanel, BorderLayout.CENTER);
		
		controlPanel.add(dugme_pokreni);
		add(controlPanel, BorderLayout.SOUTH);
		
		dugme_pokreni.addActionListener((ae) -> {
			svemir.kreni();
			generator.kreni();
		});
		
		
	}
	
	public Simulator() {
		
		setBounds(700, 200, 400, 300);
		setResizable(false);
		
		populateWindow();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Simulator();
	}
}
