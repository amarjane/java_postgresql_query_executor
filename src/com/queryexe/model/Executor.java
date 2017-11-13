package com.queryexe.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.queryexe.controler.Controler;

public class Executor {

	private String query;
	private Statement statement;
	private ResultSet resultSet;
	private Controler controler;
	
	public Executor(String query, String url, String user, String password, boolean newConnection) {
		
		this.setQuery(query);
		this.setUrl(url);
		this.setUser(user);
		this.setPassword(password);
		
		this.execution(url, user, password, newConnection);
		this.setControler(new Controler(this.getResultSet()));		
		
		try {
			
			this.getResultSet().close();
			this.getStatement().close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
				
	}
	
	private void setPassword(String password) {		
	}

	private void setUser(String user) {		
	}
	
	private void setUrl(String url) {		
	}

	public void execution(String url, String user, String password, boolean newConnection) {
		
		try {
			
			this.setStatement(Connect.getInstance(url, user, password, newConnection).getConnection().createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_UPDATABLE
			));
			
			this.setResultSet(this.statement.executeQuery(this.getQuery()));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			
		}
				
	}
	
	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}


	public ResultSet getResultSet() {
		return this.resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	public Statement getStatement() {
		return this.statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public Controler getControler() {
		return this.controler;
	}

	public void setControler(Controler controler) {
		this.controler = controler;
	}
	
}

