package bpi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bpi.util.SQLCommand;

public class ForexBean implements SQLCommand{
	//input values
	private int pesoAmount;
	private String currencyType;
	//computed values
		private double result;
		private String message;
	public int getPesoAmount() {
		return pesoAmount;
	}
	public void setPesoAmount(int pesoAmount) {
		this.pesoAmount = pesoAmount;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//business logic
	
	public void compute(){
		switch(this.currencyType){
		case "USD":
			this.result = this.pesoAmount / 51.11;
			this.message = "US$ " + result;
			break;
		case "EUR":
			this.result = this.pesoAmount / 59.88;
			this.message = "EUR " + result;
			break;
		case "YEN":
			this.result = this.pesoAmount / 40.60;
			this.message = "YEN " + result;
			break;
		case "AUD":
			this.result = this.pesoAmount / 0.4676;
			this.message = "AUD " + result;
			break;
		
		}
	}
	//SQL Operations
	private Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ticzon-entjav2-se31-db","root","");
	}catch(ClassNotFoundException cnfe){
		System.err.println("Class not found: "+cnfe.getMessage());
	}catch(SQLException sqle){
		System.err.println("SQL Exception "+ sqle.getMessage());
	}
		return connection;
	}
	
	public void insertRecord(){
		Connection connection = getConnection();
		 if(connection !=null){
			 try{
				
				 
				 PreparedStatement pstmnt = connection.prepareStatement(INSERT_REC);
				 pstmnt.setInt(1, this.pesoAmount);
				 pstmnt.setString(2, this.currencyType);
				 pstmnt.setDouble(3, this.result);
				 pstmnt.setString(4, this.message);
				 
				 pstmnt.executeUpdate();
			 }catch(SQLException sqle){
				 throw new RuntimeException();
			 }
		 }
	}
	
	public ResultSet getAllRecords(){
		ResultSet records = null;
		Connection connection = getConnection();
		 if(connection !=null){
			 try{
				
				 
				 PreparedStatement pstmnt = connection.prepareStatement(GET_ALL_RECORDS);
				 
				 
				records = pstmnt.executeQuery();
			 }catch(SQLException sqle){
				 throw new RuntimeException();
			 }
		 }
		 return records;
	}
	
}
