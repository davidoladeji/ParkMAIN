<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>
<fmt:formatDate value="${date}" type="both" timeStyle="long"
                dateStyle="long" />

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
    <%@ include file="template/myheader.jsp" %>

    <!-- MAIN AREA -->
    <div class="top-area show-onload">
        <div class="bg-holder full">
            <div class="bg-mask"></div>
            <div class="bg-parallax" style="background-image:url(img/background.jpg);"></div>
            <div class="bg-content">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="search-tabs search-tabs-bg mt50">
                                <%--<h1>Book parking space ...</h1>--%>

                                <div class="tabbable">
                                    <ul class="nav nav-tabs" id="myTab">

                                        <li><a href="#tab-1" data-toggle="tab"><i class="fa fa-car"></i> <span>Parking Space</span></a>
                                        </li>

                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane fade in active" id="tab-1">

                                            <h2>Search for parking space </h2>
                                            <form:errors path="*"></form:errors>
                                            <c:url var="action" value="/spaces/search"></c:url>

                                            <form:form commandName="search" action="${action }" method="get">
                                                <form:errors path="*" cssClass="has-error, notify-error"/>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group form-group-lg form-group-icon-left"><i
                                                                class="fa fa-map-marker input-icon"></i>
                                                            <label>Select Airport</label>
                                                            <form:select path="airportid"
                                                                         class="typeahead1 form-control">
                                                                <c:forEach items="${airportList}" var="airport">
                                                                    <form:option value="${airport.id}"
                                                                                 label="${airport.name}"/>
                                                                </c:forEach>

                                                            </form:select>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group form-group-lg form-group-icon-left"><i
                                                                class="fa fa-map-marker input-icon"></i>
                                                            <label>Select Space Type</label>
                                                            <form:select path="spaceTypeId"
                                                                         class="typeahead1 form-control">
                                                                <c:forEach items="${spaceTypeList}" var="spaceType">
                                                                    <form:option value="${spaceType.id}"
                                                                                 label="${spaceType.name}"/>
                                                                </c:forEach>

                                                            </form:select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <%--<div class="input-daterange" data-date-format="yyyy-MM-dd">--%>
                                                    <div class="row">
                                                        <div class="col-md-3">
                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                <label>Travel Date</label>
                                                                <fmt:formatDate value="${search.traveldate}" var="fmtTravelDate"
                                                                               pattern="yyyy-MM-dd" />
                                                                <form:input class="date-pick1 form-control r_from_date"
                                                                            path="traveldate" name="start"  value = "${fmtTravelDate}" type="text" required="required"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                <i class="fa fa-clock-o input-icon input-icon-highlight"></i>
                                                                <label>Travel Time</label>
                                                                <fmt:formatDate value="${search.travelenddate}" var="fmtTravelTime"
                                                                               pattern="hh:mm:ss" />
                                                                <form:input class="time-pick form-control"
                                                                            path="traveltime" name="traveltime"
                                                                            value="${fmtTravelTime}" type="text" required="required"/>

                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                <label>Trip End Date</label>
                                                                <fmt:formatDate value="${search.travelendtime}" var="fmtTravelEndDate"
                                                                               pattern="yyyy-MM-dd" />
                                                                <form:input class="date-pick1 form-control r_to_date"
                                                                            path="travelenddate" name="end"
                                                                            value = "${fmtTravelEndDate}" type="text" required="required"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                <i class="fa fa-clock-o input-icon input-icon-highlight"></i>
                                                                <label>Trip End Time</label>
                                                                <fmt:formatDate value="${search.traveltime}" var="fmtTravelEndTime"
                                                                               pattern="hh:mm:ss" />
                                                                <form:input class="time-pick form-control"
                                                                            path="travelendtime" name="travelendtime"
                                                                            value="${fmtTravelEndTime}" type="text" required="required"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div>


                                                    </div>
                                                <%--</div>--%>

                                                <button class="btn btn-primary btn-lg" type="submit">Search for Spaces
                                                </button>
                                            </form:form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="loc-info text-right hidden-xs hidden-sm">
                                <h3 class="loc-info-title"><img src="img/flags/32/fr.png" alt="Image Alternative text"
                                                                title="Image Title"/>Paris</h3>

                                <p class="loc-info-weather"><span class="loc-info-weather-num">+35</span><i
                                        class="im im-sun loc-info-weather-icon"></i>
                                </p>
                                <ul class="loc-info-list">
                                    <li><a href="#"><i class="fa fa-building-o"></i> 102 Hotels from $38/night</a>
                                    </li>
                                    <li><a href="#"><i class="fa fa-home"></i> 291 Rentals from $32/night</a>
                                    </li>
                                    <li><a href="#"><i class="fa fa-car"></i> 244 Car Offers from $46/day</a>
                                    </li>
                                    <li><a href="#"><i class="fa fa-bolt"></i> 188 Activities this Week</a>
                                    </li>
                                </ul>
                                <a class="btn btn-white btn-ghost mt10" href="#"><i class="fa fa-angle-right"></i>
                                    Explore</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END MAIN AREA  -->

    <%@ include file="template/footerscripts.html" %>

</div>
</body>

</html>