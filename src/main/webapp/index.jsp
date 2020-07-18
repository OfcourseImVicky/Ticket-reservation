<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Reservation</title>
</head>
<body>
	<form action="book" method="POST">
		<div class="split left">
			<div class="centered">
				<div>
					<br> <b>Source City</b> <select name="sourceCity"
						id="sourceCity">
						<option value="chennai">Chennai</option>
					</select><br>
				</div>
				<div>
					<br>
					<b>Destination City</b> <select required name="destinationCity"
						id="destinationCity">
						<option value="Coimbatore">coimbatore</option>
						<option value="Tirunelveli">Tirunelveli</option>
					</select><br>
				</div>
				<div>
					<br> <b>Travel Date</b> <input type="date" name="travelDate"
						required> <br>
				</div>
				<div>
					<br> <b>ReturnDate</b> <input type="date" name="returnDate">
					<br>
				</div>
			</div>
		</div>
		<br>
		<button name="bookTicket" value="bookTicket">Book Ticket</button>
	</form>
</body>
</html>