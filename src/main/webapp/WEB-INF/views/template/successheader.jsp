<header id="main-header">
    <div class="header-top">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <a class="logo" href="/">
                        <img src="img/logo.png" alt="Image Alternative text" title="Image Title"/>
                    </a>
                </div>
                <div class="col-md-3 col-md-offset-2">

                </div>
                <div class="col-md-4">
                    <div class="top-user-area clearfix">
                        <ul class="top-user-area-list list list-horizontal list-border">

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

</header>
<script>
	function exchange(currency, cval){


		// ajax to convert

		$.ajax({
	    	url: '${pageContext.request.contextPath}/exchange/',
	    	type: "GET",
			data: {'symb': currency},

	    	success: function(data) {
	    		console.log("Data "+ data);
	    		$('#totalTrip').html(data);
	    	}
	    });

		// refresh page
		$('#exchange').html(currency+ ' ' +cval);




	}

</script>