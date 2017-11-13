package com.queryexe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect{
	
	private Connection connection;
	private volatile static Connect connect;
	private static int i = 0;
	
	private Connect(String url, String user, String password){
	
	    try {
	
	    	this.setConnection(DriverManager.getConnection(url, user, password));
	
	    } catch (SQLException e) {
	
	    	e.printStackTrace();
	
	    }
	    
	
	}

	public static Connect getInstance(String url, String user, String password, boolean newConnection){
    
		if(connect == null || newConnection){
    
			synchronized(Connect.class){
     		   
		    	  if(connect == null || newConnection) {		        	
		    		  
		    		connect = new Connect(url, user, password);
		    	  	i++;
		    		
		    		System.out.println("INSTANCIATION DE LA CONNEXION SQL N° " + i + " !");
		    		System.out.println(url + " " + user + " " + password + " " + newConnection);
		    	  	
		    	  }
		      }
					
		} else{
		    
			System.out.println("CONNEXION SQL EXISTANTE ! ");
		 
		}
  
		return connect;   
 
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		Connect.i = i;
	}   

}


