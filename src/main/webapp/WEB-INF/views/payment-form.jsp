<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>


<head>
    <%@ include file="template/header.html" %>
    <%@ include file="template/styles.html" %>
    <%@ include file="template/meta.html" %>
    <%@ include file="template/scripts.html" %>
</head>

<body>
<div class="global-wrap">
    <%@ include file="template/paymentheader.jsp" %>
    <div class="container">
        <h1 class="page-title">Booking ...</h1>
    </div>
    <div class="container">
    <c:url value="/booking/payment-successful" var = "action"/>
    <form:form class="cc-form" action="${action }" commandName="booking" method="get">
        <div class="row">
            <div class="col-md-4">
                <img class="pp-img" src="img/paypal.png" alt="Image Alternative text" title="Image Title"/>

                <p>Important: You will be redirected to PayPal's website to securely complete your payment.</p><a
                    class="btn btn-primary">Checkout via Paypal</a>
            </div>

            <div class="col-md-4">
                <h4>Pay via Credit/Debit Card</h4>
                <ul class="card-select">
                    <li>
                        <img class="card-select-img" src="img/payment/visa-curved-64px.png" alt="Image Alternative text"
                             title="Image Title"/>

                        <div class="card-select-data">
                            <p class="card-select-number">xxxx xxxx xxxx 1456</p>
                            <input class="form-control card-select-cvc" type="text" placeholder="CVC"/>
                        </div>
                    </li>
                    <li>
                        <img class="card-select-img" src="img/payment/maestro-curved-64px.png"
                             alt="Image Alternative text" title="Image Title"/>

                        <div class="card-select-data">
                            <p class="card-select-number">xxxx xxxx xxxx 6698</p>
                            <input class="form-control card-select-cvc" type="text" placeholder="CVC"/>
                        </div>
                    </li>
                </ul>
                <div class="gap gap-small"></div>
                <h4>Pay with new Card</h4>


                    <div class="clearfix">
                        <div class="form-group form-group-cc-number">
                            <label>Card Number</label>
                            <input class="form-control" placeholder="xxxx xxxx xxxx xxxx" type="text"/><span
                                class="cc-card-icon"></span>
                        </div>
                        <div class="form-group form-group-cc-cvc">
                            <label>CVC</label>
                            <input class="form-control" placeholder="xxxx" type="text"/>
                        </div>
                    </div>
                    <div class="clearfix">
                        <div class="form-group form-group-cc-name">
                            <label>Cardholder Name</label>
                            <input class="form-control" type="text"/>
                        </div>
                        <div class="form-group form-group-cc-date">
                            <label>Valid Thru</label>
                            <input class="form-control" placeholder="mm/yy" type="text"/>
                        </div>
                    </div>
                    <div class="checkbox checkbox-small">
                        <label>
                            <input class="i-check" type="checkbox" checked/>Add to My Cards</label>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-lg pull-right">Proceed Payment</button>
                    </div>


            </div>

            <div class="col-md-4">
                <div class="booking-item-payment">
                    <header class="clearfix">
                        <a class="booking-item-payment-img" href="#">
                            <img src="img/car.png" alt="Image Alternative text" title="Image Title"/>
                        </a>
                        <h5 class="booking-item-payment-title"><a href="#">${booking.carparkSpace.carpark.codename }</a></h5>
                    </header>
                    <ul class="booking-item-payment-details">
                        <li>
                            <c:if test="${booking.numOfDays == 1}">
                                <h5>Booking for ${booking.numOfDays} day</h5>
                            </c:if>
                            <c:if test="${booking.numOfDays > 1}">
                            <h5>Booking for ${booking.numOfDays} days</h5>
                            </c:if>

                            <div class="booking-item-payment-date">
                                <p class="booking-item-payment-date-day"><fmt:formatDate pattern="MMMM, dd"
            value="${booking.arrivalDate}" /></p>

                                <p class="booking-item-payment-date-weekday"><fmt:formatDate pattern="EEEE"
            value="${booking.arrivalDate}" /></p>
                            </div>
                            <i class="fa fa-arrow-right booking-item-payment-date-separator"></i>

                            <div class="booking-item-payment-date">
                                <p class="booking-item-payment-date-day"><fmt:formatDate pattern="MMMM, dd"
            value="${booking.departureDate}" /></p>

                                <p class="booking-item-payment-date-weekday"><fmt:formatDate pattern="EEEE"
            value="${booking.departureDate}" /></p>
                            </div>
                        </li>
                        <li>
                            <h5>Car: ${booking.carBody }</h5>
                        </li>
                    </ul>

                    <p class="booking-item-payment-total">Total trip: <span id="symbol">  </span> <span id="totalTrip"> ${booking.total}</span>

                    </p>
                </div>
            </div>
        </div>
         </form:form>
        <div class="gap"></div>
    </div>
    <%@ include file="template/footer.html" %>
    <%@ include file="template/footerscripts.html" %>
</div>
</body>

</html>


