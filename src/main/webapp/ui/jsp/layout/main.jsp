<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding='UTF-8'%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8" />
      <title><tiles:getAsString name="title" /></title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta content="" name="description" />
      <meta content="Coderthemes" name="author" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <!-- App favicon -->
      <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" />
      <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700&display=swap" rel="stylesheet" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/material-icons.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.theme.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery.timepicker.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/suneditor.min.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.min.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/dataTables.bootstrap4.min.css" />
      <style>
         tfoot input {
         width: 100%;
         padding: 3px;
         box-sizing: border-box;
         }
      </style>
      <script type="text/javascript">
      function ValidateAlphaNumeric(evt) {
    	    var keyCode = (evt.which) ? evt.which : evt.keyCode
    	    if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 122) && keyCode != 8 && keyCode!=32 && (keyCode < 48 || keyCode > 57) )
    	        return false;
    	    return true;
    	}
      </script>
   </head>
   <body class="loading">
      <!-- Begin page -->
      <div id="wrapper">
	<tiles:insertAttribute name="header" />
	
	 <!-- page wrapper start -->
         <div class="pageWrapper">
         <tiles:insertAttribute name="nav" />
         <tiles:insertAttribute name="body" />
         </div>
	
	
	<tiles:insertAttribute name="footer" />
	<!-- page wrapper end -->
  </div>
</body>
</html>