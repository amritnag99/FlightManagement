<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.nagarro.flight.model.Flight"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Search</title>
</head>

<body>

	<div>
		<br>
		<h2 style="text-align: center">
			<b>Search Flight</b>
		</h2>
		<br> <br>

		<form action="search" method="post" id="form-id">
			<table
				style="font-size: 14px; width: 35%; margin-left: auto; margin-right: auto">

				<tr>
					<td>Departure Location:</td>
					<td><input type="text" name="departure" id="dep"
						onblur="inputValidationDep(this)" required /></td>
					<td style="color: red">*</td>
				</tr>
				<tr>
					<td><div id="textDep"></div></td>
					<td><small>Valid location codes: 
								<c:forEach var="value" items="${dep_lists}">
									${value}
								</c:forEach>
					</small></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><label></label></td>
					<td></td>
				</tr>
				<tr>
					<td>Arrival Location:</td>
					<td><input type="text" name="arrival" id="arr"
						onblur="inputValidationArr(this)" required /></td>
					<td style="color: red">*</td>
				</tr>
				<tr>
					<td><div id="textArr"></div></td>
					<td><small id="arr_list">Valid location codes: 
								<c:forEach var="value" items="${arr_lists}">
									${value}
								</c:forEach>
					</small></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><label></label></td>
					<td></td>
				</tr>
				<tr>
					<td>Date:</td>
					<td><input type="text" name="date" id="date_id"
						onblur="inputValidationDate(this)" required /></td>
					<td style="color: red">*</td>
				</tr>
				<tr>
					<td><div id="textDate"></div></td>
					<td><small>Enter date in dd-mm-yyyy format only</small></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><label></label></td>
					<td></td>
				</tr>
				<tr>
					<td>Flight class:</td>
					<td><input type="text" name="flight_class" id="class"
						onblur="inputValidationClass(this)"required /></td>
					<td style="color: red">*</td>
				</tr>
				<tr>
					<td><div id="textClass"></div></td>
					<td><small>E: Economic, B: Business</small></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><label></label></td>
					<td></td>
				</tr>
				<tr>
					<td>Preference:</td>
					<td><input type="text" name="preference" id="pref"
						onblur="inputValidationPref(this)"required /></td>
					<td style="color: red">*</td>
				</tr>
				<tr>
					<td><div id="textPref"></div></td>
					<td><small>0: sort by fare, 1: sort by flight duration</small></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><label></label></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td style="color: red"><label>${message}</label></td>
					<td></td>
				</tr>

				<tr id="tfoot">
					<td></td>
					<td><input type="submit" value="Search>>" /></td>
				</tr>
			</table>
		</form>

	</div>
	<br>
	<br>


	<div>
		<c:if test="${not empty flight_lists}">

			<table class="table table-striped"
				style="font-size: 14px; width: 70%; margin-left: auto; margin-right: auto;">

				<tr style="border: 2px solid black">
					<th>Air line</th>
					<th>Departure</th>
					<th>Arrival</th>
					<th>Duration</th>
					<th>Date</th>
					<th>Fare</th>
				</tr>

				<c:forEach items="${flight_lists}" var="Flight">

					<tr>
						<td>${Flight.air_line}</td>
						<td>${Flight.dep_loc}</td>
						<td>${Flight.arr_loc}</td>
						<td>${Flight.flight_dur}</td>
						<td>${Flight.valid_till}</td>
						<td>${Flight.fare}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<br>
	<br>

</body>
<script>

	function inputValidationDep(inputDep) {

		var textField = document.getElementById("textDep");
		var input = document.getElementById("dep");

		if (inputDep.value == 'DEL' || inputDep.value == 'MUB') {
			textField.style.color = "green";
			textField.textContent = " ";
			input.style.border = "solid 2px green";
		} else {
			textField.textContent = "Invalid";
			textField.style.color = "red";
			input.style.border = "solid 2px red";
		}

	}

	function inputValidationArr(inputArr) {

		var textField = document.getElementById("textArr");
		var input = document.getElementById("arr");

		if (inputArr.value == 'MUB' || inputArr.value == 'BGR') {
			textField.style.color = "green";
			textField.textContent = " ";
			input.style.border = "solid 2px green";
		} else {
			textField.textContent = "Invalid";
			textField.style.color = "red";
			input.style.border = "solid 2px red";
		}
	}

	function inputValidationDate(inputDate) {

		var regx = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
		var textField = document.getElementById("textDate");
		var input = document.getElementById("date_id");

		if (inputDate.value.match(regx)) {
			textField.style.color = "green";
			textField.textContent = " ";
			input.style.border = "solid 2px green";
		} else {
			textField.textContent = "Invalid";
			textField.style.color = "red";
			input.style.border = "solid 2px red";
		}
	}
	
	function inputValidationClass(inputClass) {

		var textField = document.getElementById("textClass");
		var input = document.getElementById("class");

		if (inputClass.value == 'E' || inputClass.value == 'B') {
			textField.style.color = "green";
			textField.textContent = " ";
			input.style.border = "solid 2px green";
		} else {
			textField.textContent = "Invalid";
			textField.style.color = "red";
			input.style.border = "solid 2px red";
		}
	}
	
	function inputValidationPref(inputPref) {

		var textField = document.getElementById("textPref");
		var input = document.getElementById("pref");

		if (inputPref.value == '0' || inputPref.value == '1') {
			textField.style.color = "green";
			textField.textContent = " ";
			input.style.border = "solid 2px green";
		} else {
			textField.textContent = "Invalid";
			textField.style.color = "red";
			input.style.border = "solid 2px red";
		}
	}
</script>
</html>
