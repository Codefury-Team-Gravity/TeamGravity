<!DOCTYPE html>
<html>
<head>
	<title>Payment Gateway</title>
</head>
<style>
.flex-container {
  display: flex;
  background-color: #2a4e70;

}

.flex-container div {
  background-color: #f1f1f1;
  margin: 10px;
  padding: 20px;
  font-size: 30px;
}
.form {
  margin: auto;
  width: 25%;
  border: 5px solid #FFFF00;
  padding: 10px;
  background-color: #faf1f0;
}
body {
  background-image: url('images/12.jpeg');
  background-size: cover;
  background-attachment: fixed;
}
</style>
<body >
<div class="title">
	<h1 align="center"> PAYMENT GATEWAY</h1>
	<div class="flex-container">
	<h2>Select Payment Method</h2><br><br>
  	<div>Credit card</div>
  	<div>Netbanking</div>
  	<div>Debit Card</div>
  	<div>Other wallets</div>  
</div>
<div class="form" style="float:right;text-align:center; margin-right:100px">
	<form action="userReturn.jsp">
		<h2 align="center">Personal information</h2><br><br>
		Email address:<input type="email" required><br><br>
		First Name:<input type="text" required><br><hr><br>
		Name on Card:<input type="text" required><br><br>
		Card Number:<input type="text" minlength="16" maxlength="16" required><br><br>
		Expiration:<input type="month" required><br><br> CVV:<input type="password" value="" maxlength="3" required><br><br>
		<input type="checkbox" required>By checking this box, I agree to the Terms & Conditions & Privacy Policy.<br><br>
		<input type="submit" name="Submit"required>
		
	</form>
</div>
</body>
</html>