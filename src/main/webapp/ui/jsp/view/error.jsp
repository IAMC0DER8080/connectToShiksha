<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Error Page ${errorCode} </title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/error-style.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
      <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" type="image/x-icon">
   </head>
   <body>
      <div>
         <div class="main">
		 <div class="row">
            <div class="col-md-6 col-sm-12 bg-div">
               <div class="sidenav">
               </div>
            </div>
            <div class="col-md-6 col-sm-12">
               <a class="logo" href="login.html"> <img src="${pageContext.request.contextPath}/assets/images/logo_v2.jpg" class="hdfc"> </a>
               <div class="login-form">
                  <h1 class="Log-In">Error ${errorCode}</h1>
                  <hr class="hr-divider">
                  <br>
                  <h3 class="plz">${errorMessage}</h3>
               </div>
            </div>
			</div>
         </div>
      </div>
      <div class="footer">
	   <div class="row">
         <div class="col-md-6 col-sm-12">
            <div class="commondiv">Copyright © MPASC College - IT Dept. All rights reserved.</div>
         </div>
         <div class="col-md-6 col-sm-12">
            <div class="commondiv float-right">Unauthorised use of the HDFC bank's application is prohibited.</div>
            <div></div>
         </div>
      </div>
	  </div>
      <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
   </body>
</html>
