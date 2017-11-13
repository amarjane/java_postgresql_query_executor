package com.queryexe.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectionFrame extends JFrame {
	
	private static final long serialVersionUID = -4654578848858464791L;
	
	private JPanel panel;

	private JLabel urlLabel;
	private JLabel passwordLabel;
	private JLabel userLabel;
	
	private JTextField url;
	private JTextField password;
	private JTextField user;
	
	private JButton buttonOK;
	
	public ConnectionFrame() {
		
		this.initComponents();
		this.init();
		//this.initAction();
		this.setVisible(true);
				
	}
	
	public void init() {
		
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setTitle("Connection to your database");
		this.setContentPane(this.getPanel());
		
	}
	
	public void initComponents() {
		
		this.setUrl(new JTextField("jdbc:postgresql://localhost:5432/Ecole"));		
		this.setUser(new JTextField("postgres"));
		this.setPassword(new JTextField("*********"));
		
		this.setUrlLabel(new JLabel("Enter url of your database"));		
		this.setUserLabel(new JLabel("Enter your username"));
		this.setPasswordLabel(new JLabel("Enter your password"));
		
		this.getUrl().setEditable(true);
		this.getUser().setEditable(true);
		this.getPassword().setEditable(true);
		
		this.setPanel(new JPanel());
		this.setButtonOK(new JButton("OK"));
		
		this.getPanel().setLayout(new GridLayout(7, 1));
		
		this.getPanel().add(this.getUrlLabel());
		this.getPanel().add(this.getUrl());
		this.getPanel().add(this.getUserLabel());
		this.getPanel().add(this.getUser());
		this.getPanel().add(this.getPasswordLabel());
		this.getPanel().add(this.getPassword());
		this.getPanel().add(this.getButtonOK());
		
	}
	
	public JTextField getUrl() {
		return this.url;
	}

	public void setUrl(JTextField url) {
		this.url = url;
	}

	public JTextField getPassword() {
		return this.password;
	}

	public void setPassword(JTextField password) {
		this.password = password;
	}

	public JTextField getUser() {
		return this.user;
	}

	public void setUser(JTextField user) {
		this.user = user;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getUrlLabel() {
		return urlLabel;
	}

	public void setUrlLabel(JLabel urlLabel) {
		this.urlLabel = urlLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JLabel getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}

	public JButton getButtonOK() {
		return this.buttonOK;
	}

	public void setButtonOK(JButton buttonOK) {
		this.buttonOK = buttonOK;
	}

}
