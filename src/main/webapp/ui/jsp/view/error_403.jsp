
	<style>
	

body {
	font-family: 'Roboto', sans-serif!important;
	font-size: 15px;
	line-height: 24px;
	font-weight: 400;
	-webkit-font-smoothing: antialiased;	
}

/*------------Reset Css-----------*/
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
	display: block;
}
body {
	line-height: 1;
}
ol, ul {
	list-style: none;
}
blockquote, q {
	quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
}


/*------------------*/

.bg-div{
	 height: 100vh;
   background-size: cover;
    overflow-x: hidden;
    padding-top: 20px;
	background-image: url("../images/bg.png");
	padding-left:0px!important;
	margin-left:0px!important;
	background-position: 0px -23px;
	background-repeat: no-repeat;
	
}



@media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
}

@media screen and (max-width: 450px) {
    .login-form{
        margin-top: 0%;
    }
	.error-403{
        margin-top: 0%;
    }

    .register-form{
        margin-top: 10%;
    }
}

@media screen and (max-width: 767px) {
	.bg-div{
		 height: auto;
	}
	.hdfc{
	float:none!important;

	}
	.plz{
	margin-bottom: 0px
	}
	.login-main-text {
   margin: 20% 0% 20% 5%!important;
      padding: 0px!important;
	}
	.bg-div{
		    background-size: inherit;
	}
	.login-main-text h2{
		font-size: 20px;
	}
	
	
}
@media screen and (min-width: 768px){
  
    .sidenav{
        width: 40%;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
    }

    .login-form{
        margin-top:25%!important; 
		width:58%;
		margin:0 auto
    }
	.error-403{
        margin-top:0%!important; 
		width:58%;
		margin:0 auto;
		margin-left: 26% !important;
    }

    .register-form{
        margin-top: 20%;
    }
}


.login-main-text{
   margin-top: 50%;
    padding: 60px;
    color: #fff;
}

.login-main-text h2{
   font-weight: bold;
}


.btn-black{
    background-color: #2982d1!important;
    color: #fff;
	float: right;
    padding: 5px 40px!important;
	margin-top: 25px;
}
 
.commondiv{
color: #bebebe;
font-size: 13px;
}	
.login-main-text h2{
	margin-top: 10px;
	    margin-bottom: 5px;
}

.img-width-select{
	float: left;
    width: 80px;
    height: 80px;
	margin-right: 10px;
	
}
.hdfc{
width: 168px;
    height: 33px;
    float: right;
	margin-top: 15px;
	margin-right: 20px;	
}
.Log-In{
	color: #FF7474;
	font-size: 30px;
}
.plz{
	 font-size: 18px;
    color: #868686;
    margin-bottom: 9px;
    margin-top: 20px;
}
 label{
	 color: #6a6a6a;
    font-weight: normal!important;
 }
 .form-control{
	     height: 40px!important;
 }
 
.footer{
position: fixed;
    background-color: #2a2a2a;
    bottom: 0;
	z-index: 999999;
	width:100%;
	padding:5px

}	

.hr-divider{
	float: left;
    margin-top: 0px;
    margin-bottom: 7px;
    border: 0;
    border-top: 3px solid #ccc;
    width: 29px;
}
.main{
	overflow:hidden;
	margin-top: 265px;
}
.go-back{
	background-color: #1965bd !important;
	border-color: #1965bd !important;
}
.error-403-box{
	margin-top: 88px;
}
.err-msg{
	    margin-top: 0px;
}
	</style>




        <!-- end Topbar -->

     

            <!-- ============================================================== -->
            <!-- Start Page Content here -->
            <!-- ============================================================== -->

             <div class="content-page"> 
				 <div class="main">
				 <div class="row"> 
					<div class="col-md-12 col-sm-12"> 
					   <div class="error-403">
						  <h1 class="Log-In">Access Denied</h1>
						   <h3 class="plz"></h3>
						  <hr class="hr-divider">
						  <br>
						  <h3 class="plz err-msg">You don't have permission to access requested page</h3> 
					   </div> 
					</div>  
					</div> 
				 </div> 
			</div>

          

            <!-- ============================================================== -->
            <!-- End Page content -->
            <!-- ============================================================== -->
        
        <!-- page wrapper end -->
   
    <!-- END wrapper -->



    <script src="${pageContext.request.contextPath}/assets/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.timepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script> 


</html>