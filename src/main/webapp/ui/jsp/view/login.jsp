<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored = "false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8" />
      <title>
         DB Audit Utility | Login Form
      </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta content="" name="description" />
      <meta content="Coderthemes" name="author" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <!-- App favicon -->
       <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.css"/>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.css" />
     <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/material-icons.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.theme.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery.timepicker.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/suneditor.min.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css" /> 
   </head>
   <body class="loading">
      <!-- Begin page -->
      <div id="wrapper">
         <!-- ============================================================== -->
         <!-- Start Page Content here -->
         <!-- ============================================================== -->
         <div class="main">
            <div class="content">
               <!-- Start Content-->
               <!-- start page title -->
               <div class="row">
                  <div class="col-md-5 col-sm-12 bg-div">
                     <div class="login-main-text">
                     <h1 class="text-center">WelCome</h1>
                        <h2 class="text-center">Connect To Class</h2>
                        <img src="${pageContext.request.contextPath}/assets/images/normal_u13.svg" class="img-responsive img-width-select">
                     </div>
                  </div>
                  <div class="col-md-7 col-sm-12 bgblue">
                     <form:form class="form-signin" action="validate" modelAttribute="user" method="POST">
                        <h2 class="form-signin-heading">Log In</h2>
                        <p class="access">Access the portal using username and password.</p>
                        <div class="form-group">
                           <label>User Name</label>
                           <form:input type="text" class="form-control" id="userName" path="userId" placeholder="User Name"  maxlength="100"/> 
                           <form:errors path="userId" id="nameError" class="text-danger adfont">
								</form:errors>
								<span id="userNmae_error" class="text-danger adfont"></span>  
                        </div> 
                        <div class="form-group">
                           <label>Password</label>
                           <form:input type="password" id="passWord" class="form-control" path="password" placeholder="Password" maxlength="100"/>
                           <form:errors path="password" id="passError" class="text-danger adfont">
								</form:errors>
								<span id="passWord_error" class="text-danger adfont"></span> 
                        </div>
                        <form:hidden path="hiidenParameater" id="txtHidenText"/>
                        <button class="btn btn-lg btn-primary btn-block" id="loginbtn" type="submit" onclick="return loginValidation()">Login</button>  
                        <!-- <a class="forgot">Forgot Password?</a>	  --> 
                     </form:form>
                  </div>  
               </div>
            </div>
            <!-- content -->
         </div>
        
         <!-- ============================================================== -->
         <!-- End Page content -->
         <!-- ============================================================== -->
         <!-- page wrapper end -->
      </div>
      <!-- END wrapper -->
      <script src="${pageContext.request.contextPath}/assets/js/jquery-3.5.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/jquery-ui.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/jquery.timepicker.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/formValidation.js"></script> 
      <script >

      $(document).ready(function(){
    		 noBack();
    	 history.pushState(null, null, location.href);
    	    window.onpopstate  = function () {
    	    	
    	        history.go(1);
    	    }; 
    	  
    	    window.history.back();
    		function noBack() { window.history.forward(); } 



    		$("#loginbtn").on('click',function(){
    			
    			var encodedString = btoa(document.getElementById("passWord").value);
    			 document.getElementById("txtHidenText").value=encodedString;
    			 document.getElementById("passWord").value="--";
    		});
    		
    	})  

      </script>
    
   </body>
</html>