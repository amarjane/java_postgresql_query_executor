package com.queryexe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import com.queryexe.model.Executor;


public class Fenetre extends JFrame {

	private static final long serialVersionUID = -1791637207265360296L;
	
	private Bar bar;
	private JTextArea text;	
	private JTable table;	
	private JLabel label;
	
	private String url;
	private String password;
	private String user;
		
	private JPanel panelNorth;
	
	private JSplitPane split;
	private JPanel panel;
	
	private String messageTime;
	private Executor executor;
	private ConnectionFrame frame;	
	
	private Font fontLabel = new Font("Arial", Font.ITALIC, 16);
	private Font fontText = new Font("Arial", Font.BOLD, 18);
	
	private boolean newConnection;
		
	public Fenetre() {
		
		this.initComponents();
		this.initPanel();		
		this.initAction();
		this.initFenetre();
		
	}
	
	public void initComponents() {

		
		this.setBar(new Bar());
		
		if(this.text == null)
			this.text = new JTextArea("SELECT * FROM classe;");
		else
			this.text = new JTextArea("Enter your SQL query here ...\n\n\n");
		
		this.text.setEditable(true);
		this.text.setDragEnabled(true);
		
		if(this.getTable() == null)			
			this.setTable(new JTable());
		
		else			
			System.out.println("tableau plein");
		
		this.split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.text, new JScrollPane(this.table));
		
		if(this.messageTime == null)		
			this.label = new JLabel("No query executed !");
		
		else			
			this.label = new JLabel(this.messageTime);		
		
		this.label.setFont(this.fontLabel);
		
		this.text.setFont(this.fontText);
		this.text.setBackground(Color.LIGHT_GRAY);
				
		this.setPanelNorth(new JPanel());
		
		this.getPanelNorth().add(this.getBar(), FlowLayout.LEFT);

		this.getPanelNorth().setBorder(BorderFactory.createLineBorder(Color.black));
	
	}
	
	public void initPanel() {
				
		this.panel = new JPanel();
		this.panel.removeAll();
		this.panel.setBackground(Color.WHITE);
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.panelNorth, BorderLayout.NORTH);
		this.panel.add(this.split, BorderLayout.CENTER);
		this.panel.add(this.label, BorderLayout.SOUTH);		
		
		this.setContentPane(this.panel);
		this.panel.revalidate();
		
	}
	
	public void initFenetre() {
		
		this.setSize(800, 800);
		this.setTitle("Querys Executor");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	public void initAction() {
		
		this.getBar().getExecution().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				long time = System.currentTimeMillis();
				
				setExecutor(new Executor(text.getText(), getUrl(), getUser(), getPassword(), isNewConnection()));
				
				setTable(getExecutor().getControler().getTable());
				
				time = System.currentTimeMillis() - time;
				
				setMessageTime("query executed in " + 
						time + 
						" ms and returns " + 
						getTable().getRowCount() + 
						" line(s)"
				);
				
				initComponents();				
				initPanel();
				initAction();
		
			}
			
		});
		
		this.getBar().getConnection().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				setFrame(new ConnectionFrame());
				
				
				getFrame().getButtonOK().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						setUrl(getFrame().getUrl().getText());
						setUser(getFrame().getUser().getText());
						setPassword(getFrame().getPassword().getText());
						setNewConnection(true);
						
						new Thread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								getFrame().setVisible(false);
							}
							
							
						}).start();
												
					}
					
				});
				
					
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		
		Fenetre fenetre = new Fenetre();
		fenetre.setVisible(true);
		
	}
	
	public JTable getTable() {		
		return this.table;		
	}

	public void setTable(JTable table) {		
		this.table = table;		
	}

	public String getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}

	public Executor getExecutor() {
		return executor;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}

	public JPanel getPanelNorth() {
		return this.panelNorth;
	}

	public void setPanelNorth(JPanel panelNorth) {
		this.panelNorth = panelNorth;
	}
	
	public Bar getBar() {
		return this.bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}
	
	public ConnectionFrame getFrame() {
		return this.frame;
	}

	public void setFrame(ConnectionFrame frame) {
		this.frame = frame;
	}
	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isNewConnection() {
		return newConnection;
	}

	public void setNewConnection(boolean newConnection) {
		this.newConnection = newConnection;
	}

}

