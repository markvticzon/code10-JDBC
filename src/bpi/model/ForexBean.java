package bpi.model;

public class ForexBean {
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
	
	
	
}
