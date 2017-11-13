package com.queryexe.view;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;


public class Bar extends JToolBar{

	private static final long serialVersionUID = 7952430063380416797L;
	private JButton execution;
	private JButton connection;
	
	
	public Bar() {
		
		super();
		initButton();
		initBar();
	}
	
	public void initBar() {
		
		this.setBackground(Color.WHITE);
		this.add(this.execution);
		this.add(this.connection);
		
	}
	
	public void initButton() {
		
		this.execution = new JButton(new ImageIcon("images/execution.png"));
		this.connection = new JButton(new ImageIcon("images/connection.png"));		
	
	}
	
	public JButton getExecution() {
		
		return this.execution;
		
	}
	
	public JButton getConnection() {
		
		return this.connection;
		
	}
	
}
