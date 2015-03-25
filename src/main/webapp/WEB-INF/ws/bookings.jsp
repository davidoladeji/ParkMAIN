<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>All Bookings</h1>

<table>
	<tr>
		<td width="150">Status</td>
		<td width="150">Car Registration</td>
		<td width="150">Username</td>
        <td width="150">Name</td>
	</tr>
	<c:forEach items="${booking}" var="booking">
		<tr>
			<td><c:out value="${booking.active}" /></td>
			<td><c:out value="${booking.carRegistration}" /></td>
			<td><c:out value="${booking.account.firstName}, ${booking.account.lastName}" /></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>