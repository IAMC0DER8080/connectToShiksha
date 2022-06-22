<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding='UTF-8'%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!-- end Topbar -->

<!-- ============================================================== -->
<!-- Start Page Content here -->
<!-- ============================================================== -->
<link href="${pageContext.request.contextPath}/assets/css/calendar.css" rel="stylesheet">



</head>
<body>

<div class="content-page">
	<div class="content">

<div id="cal-wrap">
      <!-- (A) PERIOD SELECTOR -->
      <input type="hidden" id="userId" value="${userId}">
      <input type="hidden" id="attendenceDate" value="${attendenceDate}">
      <div id="cal-date">
        <select id="cal-mth"></select>
        <select id="cal-yr"></select>
      </div>

      <!-- (B) CALENDAR -->
      <div id="cal-container"></div>

      <!-- (C) EVENT FORM -->
       <form id="cal-event">
        <h1 id="evt-head"></h1>
        <div id="evt-date"></div>
        <textarea id="evt-details" required></textarea>
        <input id="evt-close" type="button" value="Close"/>
        <input id="evt-del" type="button" value="Delete"/>
        <input id="evt-save" type="submit" value="Save"/>
      </form> 
    </div>

</div>
</div>

<!-- ============================================================== -->
<!-- End Page content -->
<!-- ============================================================== -->

<!-- page wrapper end -->

<!-- END wrapper -->

<!-- App js -->

<script
	src="${pageContext.request.contextPath}/assets/js/jquery-3.5.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery-ui.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.timepicker.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/suneditor.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/upload-file.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/formValidation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/datepair.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.datepair.js"></script>
	<script async src="${pageContext.request.contextPath}/assets/js/calendar.js"></script>
	
	


 

