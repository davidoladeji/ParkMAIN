<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>

<html>

<head>
    <%@ include file="template/header.html" %>
    <%@ include file="template/styles.html" %>
    <%@ include file="template/meta.html" %>
    <%@ include file="template/scripts.html" %>
</head>

<body>
<div class="global-wrap">
    <%@ include file="template/successheader.jsp" %>
    <div class="container">
        <p><br/></p>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <i class="fa fa-check round box-icon-large box-icon-center box-icon-success mb30"></i>

                <h2 class="text-center">${loggedInUser.firstName}, your payment was successful!</h2>
                <h5 class="text-center mb30">Booking details has been send to ${loggedInUser.email}</h5>

            </div>
        </div>
        <div class="gap"></div>
    </div>
    <%@ include file="template/footer.html" %>
    <%@ include file="template/footerscripts.html" %>
</div>
</body>

</html>


