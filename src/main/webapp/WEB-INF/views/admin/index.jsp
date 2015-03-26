<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>


<!DOCTYPE html>
<%@ include file="template/sidebar.html" %>
<head>
    <%@ include file="template/header.html" %>
    <%@ include file="template/styles.html" %>
    <%@ include file="template/meta.html" %>
    <%@ include file="template/scripts.html" %>
</head>
<body class="">
<!-- Main Container Fluid -->
<div class="container-fluid menu-hidden">
    <!-- Sidebar Menu -->
    <%@ include file="template/sidebarmenu.html" %>
    <!-- // Sidebar Menu END -->
    <!-- Content -->
    <div id="content">
        <%@ include file="template/navbar.html" %>
        <!-- // END navbar -->
        <div class="innerLR">
            <h2 class="margin-none">Analytics &nbsp;<i class="fa fa-fw fa-pencil text-muted"></i>
            </h2>

            <div class="row">
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="bg-gray">
                                <h4 class="innerAll  border-top  border-bottom margin-bottom-none">Total Airports
                                    Managed:

                                </h4>
                            </div>
                            <div class="progress progress-mini margin-none bg-gray border-bottom">
                                <div class="progress-bar progress-bar-info" style="width: 100%;"></div>
                            </div>
                            <div class="widget innerAll text-center">
                                <div data-percent="100" data-size="100" class="easy-pie inline-block primary"
                                     data-scale-color="false"
                                     data-track-color="#efefef" data-line-width="8">
                                    <div class="value text-center">
                                                          <span class="strong"><i
                                                                  class="icon-plane fa-3x text-primary"></i>
                                                        </span>
                                    </div>
                                </div>
                                <p class="innerB margin-none text-xlarge text-condensed strong text-primary"><c:if
                                        test="${numAirtports >=1}">${numAirtports}</c:if><c:if
                                        test="${numAirtports <= 0}">0</c:if></p>
                            </div>
                        </div>

                        <!-- End Column -->

                        <div class="col-md-6">
                            <div class="bg-gray">
                                <h4 class="innerAll  border-top  border-bottom margin-bottom-none">Total Carparks
                                    Managed:

                                </h4>
                            </div>
                            <div class="progress progress-mini margin-none bg-gray border-bottom">
                                <div class="progress-bar progress-bar-info" style="width: 100%;"></div>
                            </div>
                            <div class="widget innerAll text-center">
                                <div data-percent="100" data-size="100" class="easy-pie inline-block primary"
                                     data-scale-color="false"
                                     data-track-color="#efefef" data-line-width="8">
                                    <div class="value text-center">
                                                          <span class="strong"><i
                                                                  class="icon-parking fa-3x text-primary"></i>
                                                        </span>
                                    </div>
                                </div>
                                <p class="innerB margin-none text-xlarge text-condensed strong text-primary"><c:if
                                        test="${numCarparks >=1}">${numCarparks}</c:if><c:if
                                        test="${numCarparks <=0}">0</c:if></p>
                            </div>
                        </div>


                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="bg-gray">
                                <h4 class="innerAll  border-top  border-bottom margin-bottom-none">Total Spaces Managed:

                                </h4>
                            </div>
                            <div class="progress progress-mini margin-none bg-gray border-bottom">
                                <div class="progress-bar progress-bar-info" style="width: 100%;"></div>
                            </div>
                            <div class="widget innerAll text-center">
                                <div data-percent="100" data-size="100" class="easy-pie inline-block primary"
                                     data-scale-color="false"
                                     data-track-color="#efefef" data-line-width="8">
                                    <div class="value text-center">
                                                        <span class="strong"><i class="icon-car fa-3x text-primary"></i>
                                                        </span>
                                    </div>
                                </div>
                                <p class="innerB margin-none text-xlarge text-condensed strong text-primary"><c:if
                                        test="${numSpaces >=1}">${numSpaces}</c:if><c:if
                                        test="${numSpaces <= 0}">0</c:if></p>
                            </div>
                        </div>


                        <!-- End Column -->
                        <div class="col-md-6">
                            <div class="bg-gray">
                                <h4 class="innerAll  border-top  border-bottom margin-bottom-none">Spaces Available:
                                    <p class="margin-none strong pull-right"><c:if
                                            test="${availablespacepercebtage >=1}">${availablespacepercebtage}%</c:if><c:if
                                            test="${availablespacepercebtage <= 0}">0%</c:if></p>
                                </h4>
                            </div>
                            <div class="progress progress-mini margin-none bg-gray border-bottom">
                                <c:if test="${availablespacepercebtage >=1}">
                                    <div class="progress-bar progress-bar-info"
                                         style="width: ${availablespacepercebtage}%;"></div>
                                </c:if><c:if test="${availablespacepercebtage <= 0}">
                                <div class="progress-bar progress-bar-info"
                                     style="width: 0%;"></div>
                            </c:if>

                            </div>
                            <div class="widget innerAll text-center">
                                <i class="icon-car-keys fa-3x text-primary"></i>

                                <div data-percent="100" data-size="100" class="easy-pie inline-block primary"
                                     data-scale-color="false"
                                     data-track-color="#efefef" data-line-width="8">
                                    <div class="value text-center">
                                                        <span class="strong"><i
                                                                class="icon-car-key fa-3x text-primary"></i>
                                                        </span>
                                    </div>
                                </div>
                                <p class="innerB text-xlarge text-condensed strong text-primary">${numAvailableSpaces}</p>

                            </div>
                        </div>
                        <!-- End Column -->

                    </div>

                </div>
                <!-- //  End Col -->
                <div class="col-md-4">
                    <!-- Widget -->
                    <div class="widget widget-body-gray">
                        <div class="widget-body padding-none">
                            <div class="bg-primary innerAll">
                                <div class="text-large text-white pull-right">&pound; ${totalSoldBookings}</div>
                                <h4 class="text-white strong text-medium">Gross Sales</h4>

                                <div class="separator bottom"></div>
                                <div class="progress primary progress-mini  margin-none">
                                    <div class="progress-bar progress-bar-white	" style="width: 70%;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- //End Widget -->


                </div>
                <!-- //End Col -->
            </div>
        </div>
    </div>
    <!-- // Content END -->
    <div class="clearfix"></div>
    <!-- // Sidebar menu & content wrapper END -->
    <%@ include file="template/footer.html" %>
</div>
<%@ include file="template/footerscripts.html" %>
</body>
</html>