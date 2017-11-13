package com.queryexe.controler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTable;

public class Controler {

	private ResultSet resultSet;
	private JTable table;
	private Object[][] data;
	private String[] title;
	private ResultSetMetaData metaData; 
	private int rowCounter;
	
	public Controler(ResultSet resultSet) {
		
		this.setResultSet(resultSet);
		
		try {
			
			this.setMetaData(this.getResultSet().getMetaData());
		
		} catch (SQLException e) {
						
			e.printStackTrace();
			
		}

		this.initTitle();
		this.rowCount();
		this.initData();
		this.initTable();
		
	}

	public void initTable() {
		
		this.setTable(new JTable(this.getData(), this.getTitle()));
			
	}
	
	public void initTitle() {
			
		try {
					
			this.setTitle(new String[this.metaData.getColumnCount()]);
						
			for(int i = 1; i <= this.metaData.getColumnCount(); i++) {
								
				this.title[i-1] = this.metaData.getColumnName(i);
							
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
				
	}
	
	public void initData() {
		
		try {			
			
			this.setData(new Object[this.getRowCounter()][this.metaData.getColumnCount()]);
			
			int row = 0;

			while(this.getResultSet().next()) {
				
				for(int col = 1; col <= this.metaData.getColumnCount(); col++) {
									
					this.getData()[row][col - 1] = this.getResultSet().getObject(col);
								
				}
				
				row++;
			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}		
		
		
	}
	
	public void rowCount() {
		
		this.setRowCounter(0);
		
		try {
		
			while(this.getResultSet().next()) {
					
				this.setRowCounter(this.getRowCounter() + 1);			
			}
		
		
			this.getResultSet().beforeFirst();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}		
	}
	
	public ResultSet getResultSet() {		
		return this.resultSet;		
	}

	public void setResultSet(ResultSet resultSet) {		
		this.resultSet = resultSet;		
	}

	public ResultSetMetaData getMetaData() {		
		return metaData;		
	}

	public void setMetaData(ResultSetMetaData metaData) {		
		this.metaData = metaData;		
	}

	public Object[][] getData() {		
		return this.data;		
	}

	public void setData(Object[][] data) {		
		this.data = data;		
	}

	public String [] getTitle() {		
		return this.title;		
	}

	public void setTitle(String [] title) {		
		this.title = title;		
	}

	public JTable getTable() {		
		return this.table;		
	}

	public void setTable(JTable table) {		
		this.table = table;		
	}
	
	public int getRowCounter() {		
		return this.rowCounter;		
	}

	public void setRowCounter(int counter) {		
		this.rowCounter = counter;		
	}
	
}
