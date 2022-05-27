package br.com.fiap.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MyTextField extends JTextField {
	private static final long serialVersionUID = 1L;
	
	public MyTextField() {
		super(20);
		init();
	}
	
	private void init() {
		this.setPreferredSize(new Dimension(200,30));
		this.setForeground(new Color(50,50,50));
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(new Color(26,108,163)));
		
	}
	
	

}
