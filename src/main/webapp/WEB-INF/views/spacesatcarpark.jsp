<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <%@ include file="template/myheader.jsp" %>
    <div class="container">
        <div class="mfp-with-anim mfp-hide mfp-dialog mfp-search-dialog" id="search-dialog">
            <h3>Search for Available Carpark</h3>
            <form:form commandName="search" action="/spaces/search" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group form-group-lg form-group-icon-left"><i
                                class="fa fa-map-marker input-icon"></i>
                            <label>Select Airport</label>
                            <form:select path="airportid" class="typeahead form-control">
                                <c:forEach items="${airportList}" var="airport">
                                    <form:option value="${airport.id}" label="${airport.name}"/>
                                </c:forEach>

                            </form:select>
                        </div>
                    </div>
                </div>
                <div class="input-daterange" data-date-format="yyyy-MM-dd">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="form-group form-group-lg form-group-icon-left">
                                <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                <label>Travel Date</label>

                                <form:input class="date-pick form-control" path="traveldate" name="start" type="text"/>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group form-group-lg form-group-icon-left">
                                <i class="fa fa-clock-o input-icon input-icon-highlight"></i>
                                <label>Travel Time</label>
                                <form:input class="time-pick form-control" path="traveltime" name="traveltime"
                                            value="12:00 AM"
                                            type="text"/>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group form-group-lg form-group-icon-left">
                                <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                <label>Trip End Date</label>
                                <form:input class="date-pick form-control" path="travelenddate" name="end" type="text"/>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group form-group-lg form-group-icon-left">
                                <i class="fa fa-clock-o input-icon input-icon-highlight"></i>
                                <label>Trip End Time</label>
                                <form:input class="time-pick form-control" path="travelendtime" name="travelendtime"
                                            value="12:00 AM"
                                            type="text"/>
                            </div>
                        </div>
                    </div>
                    <div>


                    </div>
                </div>

                <button class="btn btn-primary btn-lg" type="submit">Search for Spaces</button>
            </form:form>
        </div>
        <h3 class="booking-title">Available Carparks: Result of search:
            <small><a class="popup-text" href="#search-dialog" data-effect="mfp-zoom-out">Change search</a></small>
        </h3>
        <div class="row">
            <%@ include file="template/searchsideby.html" %>
            <div class="col-md-9">
                <div class="nav-drop booking-sort">
                    <h5 class="booking-sort-title"><a href="#">Sort: Sort: Price (low to high)<i
                            class="fa fa-angle-down"></i><i class="fa fa-angle-up"></i></a></h5>
                    <ul class="nav-drop-menu">
                        <li><a href="#">Price (high to low)</a>
                        </li>
                        <li><a href="#">Avaiability</a>
                        </li>
                        <li><a href="#">Name</a>
                        </li>
                    </ul>
                </div>
                <ul class="booking-list">
                    <li>
                        <div class="booking-item-container">
                            <c:if test="${!empty carparkSpaceList || carparkList != null}">
                                <c:forEach items="${carparkSpaceList}" var="space">
                                    <div class="booking-item">
                                        <div class="row">
                                            <div class="col-md-2">
                                                <div class="booking-item-airline-logo">
                                                    <img src="img/american-airlines.jpg" alt="Image Alternative text"
                                                         title="Image Title"/>

                                                    <p>${space.carpark.airport.name}</p>

                                                    <p>${space.carpark.airport.postcode}</p>
                                                </div>
                                            </div>
                                            <div class="col-md-5">
                                                <div class="booking-item-flight-details">
                                                    <div class="booking-item-departure"><i class="fa fa-car"></i>
                                                        <h5>${space.carpark.codename}</h5>

                                                        <p class="booking-item-date">Mobile: ${space.carpark.mobile}</p>

                                                        <p class="booking-item-destination">
                                                            Capacity: ${space.carpark.capacity}</p>
                                                    </div>
                                                    <div class="booking-item-arrival"><i class="fa  fa-calendar"></i> <h4>
                                                        SCHEDULE </h4>

                                                        <p class="booking-item-date"> ${search.traveldate.toLocaleString()}</p>

                                                        <p class="booking-item-date"> ${search.travelenddate.toLocaleString()}</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-2">
                                                <h5>${space.spaceType.name}</h5>
                                                    <%--<p>${space.}</p>--%>
                                            </div>
                                            <div class="col-md-3"><span
                                                    class="booking-item-price">&pound; ${space.carpark.regularprice}</span><span></span>

                                                <p class="booking-item-flight-class">Regular price</p>
                                                 <c:url var="bookthis" value="/booking/${space.id}"></c:url>
                                                <a class="btn btn-primary" href="${bookthis }">Book This</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty carparkSpaceList}">
                                There are
                                <c:out value="${carparkSpaceList.size()}">

                                </c:out>
                                with available spaces at ${space.carpark.codename}
                            </c:if>
                        </div>
                    </li>

                </ul>
                <p class="text-right">Not what you're looking for? <a class="popup-text" href="#search-dialog"
                                                                      data-effect="mfp-zoom-out">Try your search
                    again</a>
                </p>
            </div>
        </div>
        <div class="gap"></div>
    </div>

    <%@ include file="template/footer.html" %>
    <%@ include file="template/footerscripts.html" %>
</div>
</body>

</html>


