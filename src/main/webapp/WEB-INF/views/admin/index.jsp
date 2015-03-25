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

                    <div class="row">
                        <div class="col-md-6">
                            <div class="widget widget-tabs widget-tabs-double-2 border-bottom widget-tabs-responsive">
                                <div class="widget-body">
                                    <div class="tab-content">
                                        <!-- Tab content -->
                                        <div id="tabReports"
                                             class="tab-pane active widget-body-regular innerAll inner-2x text-center">
                                            <div data-percent="85" data-size="95" class="easy-pie inline-block primary"
                                                 data-scale-color="false"
                                                 data-track-color="#efefef" data-line-width="8">
                                                <div class="value text-center">
                                                        <span class="strong"><i class="icon-car fa-3x text-primary"></i>
                                                        </span>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- // Tab content END -->
                                        <!-- Tab content -->
                                        <div id="tabIncome"
                                             class="tab-pane widget-body-regular innerAll inner-2x text-center">
                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit,
                                            omnis
                                            minus voluptatibus assumenda sint
                                            autem dolorum. Rem, cupiditate,
                                            sed, optio est cumque repudiandae
                                            quo natus dignissimos praesentium
                                            alias nihil aspernatur?
                                        </div>
                                        <!-- // Tab content END -->
                                        <!-- Tab content -->
                                        <div id="tabAccounts"
                                             class="tab-pane widget-body-regular innerAll inner-2x text-center">
                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic qui natus
                                            deserunt
                                            atque quae laborum. Porro, eveniet,
                                            voluptatem, obcaecati quisquam
                                            tempore architecto nostrum quis
                                            eius corrupti ea non facilis quidem.
                                        </div>
                                        <!-- // Tab content END -->
                                    </div>
                                </div>
                                <!-- Tabs Heading -->
                                <div class="widget-head border-top-none bg-gray">
                                    <ul>
                                        <li class="active"><a class="glyphicons notes" href="#tabReports"
                                                              data-toggle="tab"><i></i><span>Reports</span></a>
                                        </li>
                                        <li><a class="glyphicons credit_card" href="#tabIncome"
                                               data-toggle="tab"><i></i><span>Income</span></a>
                                        </li>
                                        <li><a class="glyphicons user" href="#tabAccounts"
                                               data-toggle="tab"><i></i><span>Accounts</span></a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- // Tabs Heading END -->
                            </div>
                            <!-- //Widget -->
                        </div>

                    </div>
                    <!-- //Row -->
                </div>
                <!-- //  End Col -->
                <div class="col-md-4">
                    <!-- Widget -->
                    <div class="widget widget-body-gray">
                        <div class="widget-body padding-none">
                            <div class="bg-primary innerAll">
                                <div class="text-large text-white pull-right">&pound;1000</div>
                                <h4 class="text-white strong text-medium">Gross Sales</h4>
                                <h5 class="text-white margin-none">Today's earnings</h5>

                                <div class="separator bottom"></div>
                                <div class="progress primary progress-mini  margin-none">
                                    <div class="progress-bar progress-bar-white	" style="width: 70%;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- //End Widget -->
                    <!-- Widget -->
                    <div class="widget widget-body-gray">
                        <div class="innerAll half border-bottom">
                            <div class="btn-group btn-group-sm pull-right">
                                <button data-toggle="dropdown" class="btn btn-primary dropdown-toggle">Monthly
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li class="active"><a href="">Monthly</a>
                                    </li>
                                    <li><a href="">Quarterly</a>
                                    </li>
                                    <li><a href="">Yearly</a>
                                    </li>
                                </ul>
                            </div>
                            <h4 class="innerT half margin-none pull-left">Monthly Spend</h4>

                            <div class="clearfix"></div>
                        </div>
                        <div class="widget-body">
                            <p class="margin-none">Lorem ipsum dolor sit amet, consectetur adipisicing
                                elit. Quod, ipsam, minus nam consequatur aliquid
                                sint.</p>
                        </div>
                        <div class="innerAll ">
                            <p class="text-large">&pound;3,204.89</p>

                            <div class="progress">
                                <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="40"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                    <span class="sr-only">40% from last month</span>
                                </div>
                            </div>
                            <div class="text-right">
                                <p class="strong margin-none">&pound;5,127.82</p>

                                <p>
                                    <em>Previus month bill</em>
                                </p>
                            </div>
                        </div>
                    </div>
                    <!-- //End Widget -->
                    <!-- Widget	 -->

                    <!-- //Widget -->
                    <!-- Widget -->

                    <!-- //End Widget -->
                    <!-- Widget -->
                    <div class="widget widget-body-gray">
                        <div class=" innerAll half border-bottom">
                            <div class="btn-group btn-group-sm pull-right">
                                <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Day
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Day</a>
                                    </li>
                                    <li><a href="#">Week</a>
                                    </li>
                                    <li><a href="#">Month</a>
                                    </li>
                                </ul>
                            </div>
                            <h4 class="pull-left innerT half margin-none"><i class="fa fa-fw fa-money"></i> Earnings
                            </h4>

                            <div class="clearfix"></div>
                        </div>
                        <div class="innerAll border-bottom">
                            <p class="margin-none">
                                <span class="strong">Today:</span>&pound;502.42 <i
                                    class="fa text-primary fa-fw fa-arrow-up"></i>
                                    <span
                                            class="strong text-primary">4%</span>
                            </p>
                        </div>
                        <div class="widget-body ">
                            <div class="sparkline" sparkType="line" sparkResize="true" sparkHeight="76"
                                 sparkLineWidth="2"
                                 sparkWidth="100%" sparkLineColor="#3695d5" sparkSpotColor="#3695d5"
                                 sparkFillColor="" sparkHighlightLineColor="#7c7c7c"
                                 sparkHighlightSpotColor="#7c7c7c" sparkSpotRadius="4"
                                 sparkMinSpotColor="#b55151" sparkMaxSpotColor="#609450">
                                187,424,172,222,423,437,174,488,350,395
                            </div>
                        </div>
                    </div>
                    <!-- //End Widget -->
                    <!-- Widget -->
                    <div class="widget">
                        <div class="bg-primary text-center innerAll">
                            <div class="innerTB">
                                <h4 class="innerTB text-white">Today's Weather</h4>

                                <div class="strong text-xlarge text-white">
                                    <i class="fa fa-cloud"></i> 26<sup>&deg;</sup>
                                </div>
                            </div>
                        </div>
                        <div class="row row-merge">
                            <div class="col-md-6">
                                <div class="text-center innerAll">
                                    <p class="margin-none"><i class="fa icon-wind-speed-censor fa-2x"></i>
                                    </p>

                                    <p class="lead margin-none strong">15 m/h</p>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="text-center innerAll">
                                    <p class="margin-none"><i class="fa icon-water fa-2x"></i>
                                    </p>

                                    <p class="lead margin-none strong">40%</p>
                                </div>
                            </div>
                        </div>
                        <!-- //Widget -->
                    </div>

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