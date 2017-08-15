<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MVC Model 2 Lecture</title>
</head>
<body>
	<!-- this will be the header section -->
	<%@include file='design/header.html' %>
	<fieldset>
		<legend>BPI Forex Form</legend>
		<form action='precesscurrencyexchange.html' method="post">
			<p>Enter Philippine peso amount: Php
				<input type='number' name='pesoAmount' id='pesoAmount'
				min='1000' max='30000' required="required">
			</p>
			<p>Select Currency: 
			<select name='currencyType' id='currencyType'>
				<option value='USD'>US$</option>
				<option value="EUR">&euro;uro</option>
	 			<option value="YEN">&yen;en</option>
	 			<option value="AUD">AUD$</option>
			</select>
		
		</p>
	 			<p>
	 				<input type='submit' value="Compute Currency Exchange"/>&nbsp;&nbsp;&nbsp;
	 				<input type='reset'/>
	 			</p>
		</form>
	</fieldset>
	<%@include file='design/footer.jsp' %>
		<!-- this will be the footer section -->
</body>
</html>