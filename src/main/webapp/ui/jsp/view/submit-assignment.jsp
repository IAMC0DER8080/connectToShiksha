`a<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding='UTF-8'%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!-- end Topbar -->

<!-- ============================================================== -->
<!-- Start Page Content here -->
<!-- ============================================================== -->

<<style>
.select2:disabled{
    background-color: #F4F4F4;
}
input[type="text"]:disabled{
background-color: #F4F4F4;
}
.sun-editor .se-wrapper .se-wrapper-wysiwyg{
background-color: #F4F4F4 ;
}
input[type="checkbox"][disabled]{
  background-color: #F4F4F4;
}

.upload-form-content {
	background-color: #F4F4F4;
}
.filename{
	margin-top: -26px;
}
.filename{
	color: #6c757d;
}


</style>

<style>
      #snackbar {
	  visibility: hidden; 
	min-width: 250px;
	margin-left: -125px;
	color: #1304ef;
	background-color: #FFF;  /* rgba(233, 75, 107, 0.5); */
	border-color: #c3e6cb;
	text-align: center;
	border-radius: 2px;
	padding: 16px;
	position: fixed;
	z-index: 1;
	left: 50%;
	bottom: 400px; 
	font-size: 17px;
	border: 2px solid #1965bd !important; 
    box-shadow: none !important;
}

#snackbar.show {
	visibility: visible;
	-webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
	animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@
-webkit-keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}

to {
	bottom: 400px;
	opacity: 1;
}

}
@
keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}

to {
	bottom: 400px;
	opacity: 1;
}

}
@
-webkit-keyframes fadeout {
	from {bottom: 400px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}

}
@
keyframes fadeout {
	from {bottom: 400px;
	opacity: 1;
} 

to {
	bottom: 0;
	opacity: 0; 
} 
}
</style>

<div class="content-page">
	<div class="content">
		<!-- Start Content-->

		<!-- start page title -->
		<div class="row">
			<div class="col-12">
				<div class="page-head-box">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/connect-to-class/dashboard">Dashboard</a></li>
							<li class="breadcrumb-item active" aria-current="page">
								Submit Assignment</li>
						</ol>
					</nav>
					<h4 class="page-head">Submit Assignment</h4>
				</div>
			</div>
		</div>

   <div id="snackbar">
				
				<c:if test="${message != null }"> 
				<noscript>
				<c:out value="${message}"></c:out>
				</noscript>
					<script type="text/javascript">
					
						var x = document.getElementById("snackbar");
						x.className = "show";
						setTimeout(function() {
							x.className = x.className.replace("show", "");
						}, 3000);
					</script>
					<c:out value="${message}"></c:out>  
				</c:if>
				</div>  

		<form:form action="/connect-to-class/assignment-submit" modelAttribute="assignment" name="assignment" method="POST" enctype="multipart/form-data">
		
		<!-- <div class="card-box training-assignee-box mb-20">
				<h5 class="card-title">
					Lecture Assignee Information <span class="card-subheading">Please
						select who can see this Lecture</span>
				</h5>
				
			</div> -->
		
			<!-- section1 training information  -->
			<div class="card-box training-info-box mb-30">
				<h5 class="card-title">Assignment Information</h5>

				<div class="row noStrech">
					<div class="col-lg-7 custom-card-width card-left">
					
					<div class="form-row">
						<form:hidden id="assignId" path="assignmentId"/>
							<div class="form-group col-md-6">
								<label for="product-category">Select Department </label>
								<form:select class="form-control select2" value="" name="department" onclick="this.setAttribute('value', this.value);" id="department" path="department" disabled="true">
									<option>${assignment.department}</option>
									<!-- <option>Webex</option> -->
								</form:select>
								<form:errors path="department" id="deptError" class="text-danger adfont"/>
								<span id="error_department" class="text-danger adfont"></span>
							</div>
						
					<!-- <div class="form-group-inlineWrap mb-40" id="team"> -->
					

						<div class="form-group col-md-6">
								<label for="product-category">Select Class </label>
								<form:select class="form-control select2" value="" name="className" onclick="this.setAttribute('value', this.value);" id="className" path="className"  disabled="true">
									<option>${assignment.className}</option>
									<!-- <option>Webex</option> -->
								</form:select>
								<form:errors path="className" id="bandError" class="text-danger adfont"/>
								<span id="error_eligible_band" class="text-danger adfont"></span>
							</div>

						</div>

				
					
						<div class="form-row">
						
							<div class="form-group1 col-md-6">
								<div class="form-group1 venue-field">
									<label for="venueDetails">Subject Name</label>
									<form:input style="margin-left: -8px;" type="text" class="form-control" id="venueDetails" placeholder="" path="subject" onkeypress="return isAlphaNumeric(event)" maxlength="200"  disabled="true"/>
									<%-- <form:errors path="venue" id="venueError"  class="text-danger adfont"/> --%>
									<!-- <span id="error_venue" class="text-danger adfont"></span> -->
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="ttitle">Topic </label>
							<form:input type="text" id="ttitle" path="topic" class="form-control" placeholder="" onkeypress="return isAlphaNumeric(event)" maxlength="100"  disabled="true"/>
							<form:errors path="topic" id="titleError" class="text-danger adfont"/>
							<span id="error_topic" class="text-danger adfont"></span>
						</div>
						
						<div class="form-group mb-0">
							<label for="">Download Document</label>
							<div class="form-group">
							<a href="/connect-to-class/get-assignment-file/${assignment.assignmentId}">
							<button type="button" id="downLoadBtn" class="btn btn-outline-primary">Download</button>
							</a>
							</div>
						</div>
						
						
						
					<div class="form-group custom-textareaWrapper">
							<label for="tlongdesc" class=" custom-textareaWrapper-label">Long Description </label>
							<form:textarea id="editorCNT" path="decription" onkeypress="return isTextArea(event)" maxlength="2000"></form:textarea>
							<form:errors path="decription" id="agendaError" class="text-danger adfont"/>
							<span id="error_agenda" class="text-danger adfont"></span>
						</div>
						
					

					</div>
					<div class="col-lg-5 custom-card-width card-right">

						

						<div class="form-row">
							<div class="form-group col-md-6">
								<c:catch var="catchtheException">
									<fmt:parseDate var="parseDate" pattern="yyyy-MM-dd" value="${assignment.assignStartDate}" />
									<fmt:formatDate var="formattedDate" pattern="dd/MM/yyyy" value="${parseDate}" />
								</c:catch>
								<c:if test="${catchtheException != null}">
									<c:set var="formattedDate" value="${assignment.assignStartDate}"></c:set>
								</c:if>

								<label class="form-label" for="acStartDate">Start Date</label>
								<form:input type="text" class="form-control customCalendar" value="${formattedDate}" path="assignStartDate" id="acStartDate" placeholder="Select" readonly="true" onkeypress="return isDate(event)" maxlength="10" autocomplete="off"  disabled="true"/>
								<form:errors path="assignStartDate" id="startDateError" class="text-danger adfont"/>
								<span id="error_schedule_date" class="text-danger adfont"></span>
							</div>
							
							<div class="form-group col-md-6 padding">

								<c:catch var="catchtheException">
									<fmt:parseDate var="parseDate" pattern="yyyy-MM-dd" value="${assignment.assignEndDate}" />
									<fmt:formatDate var="formattedDate" pattern="MM/dd/yyyy" value="${parseDate}" />
								</c:catch>
								<c:if test="${catchtheException != null}">
									<c:set var="formattedDate" value="${assignment.assignEndDate}"></c:set>
								</c:if>
								<label class="form-label" for="acendDate">End Date</label>
								<form:input type="text" class="form-control customCalendar" value="${formattedDate}" path="assignEndDate" id="acendDate" placeholder="Select" readonly="true" onkeypress="return isDate(event)" maxlength="10" autocomplete="off"   disabled="true"/>
								<form:errors path="assignEndDate" id="endDateError" class="text-danger adfont"/>
								<span id="error_schedule_endDate" class="text-danger adfont"></span>
							</div>
							
						</div>
				<div class="form-group mb-0">
							<label for="">Upload Document</label>
							<div id="drop-area">
								<div class="upload-form-content">
									<span class="">Drag files here or </span>
									<form:input type="file" id="fileElem" name="attachment[]"
										value="" onchange="handleFiles(this.files)" path="attachment" />   <!-- onchange="handleFiles(this.files)" -->
									<label class="browse-link" for="fileElem">Browse</label> 
									<!-- multiple accept="application/octet-stream,application/pdf" -->
								</div> 
								<div class="row pose mt-10 ">
									<div class="col-md-2" id="gallery">
									<!-- <img alt="pdfImg" src="../assets/images/file-upload.svg" class="pdf-icons"> -->
									<img alt = 'pdfImg' src='${pageContext.request.contextPath}/assets/images/file-upload.svg' class='pdf-icons'>
									</div>
									<div class="col-md-8 " id="fileName"></div>
									<div class="col-md-2 cancel-btn">
										<img src="${pageContext.request.contextPath}/assets/images/close-im.png">
									</div>
								</div>
								<progress id="progress-bar" class="html5" max=100 value=0></progress> 
								<form:errors path="attachment" id="attachmentError" class="text-danger adfont"/>
								<span id="error_attachment" class="text-danger adfont"></span>
							</div>
							<div id="fileSize"></div>
							<!-- <div class="error-msg">error massage display here</div> -->
							<%-- <form:hidden path="hiddenFlag" id="flag" value="true" /> --%>
						</div>
						
				<button type="submit" class="btn btn-outline-primary"  id="sub">Save</button>
					</div>
				</div>
				
			</div>

			<!-- section2 training information  -->
			

			<!-- Training Assignee Information  -->
			

			<div class="btn-box mb-30">
				<button type="button" id="cancel_Button" class="btn btn-outline-light mr-auto" onclick="location.href='/connect-to-class/dashboard';">
					Back</button>  <!-- onclick="location.href='/EmployeeTrainingAdmin/dashboard';" -->
				<!-- <button type="submit" class="btn btn-outline-primary"  id="sub">Save</button> --><!-- onclick="return formvalidation()" -->
					<!-- <button type="button" id="publish_Button" class="btn btn-outline-primary">Publish</button> -->
            	
			</div>
			
			

			
		</form:form>
		<!-- end page title -->

		<!-- file preview template -->
	</div>
	<!-- content -->
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
<script src="${pageContext.request.contextPath}/assets/js/jquery.datepair.js"></script>
<script>


 $(document).ready(function(){

	/*  $("#downLoadBtn").on("click",function(){
		 var key=$("#assignId").val();
		 var data = '{key:'+key+'}';
		 $.ajax({
			    type: "POST",
			    url: "/connect-to-class/get-assignment-file",
			    data : data,
			    contentType: "application/json",
			   // contentType: "text",
			  	//dataType:"json",
			  //dataType:"text",
			    success: function(response){
			        //if request if made successfully then the response represent the data
			     
			    	console.info(response,typeof response);
			        }
			    
			  })
		 
	 }) */
	 
	})
	
	
		const editor = SUNEDITOR.create('editorCNT', {
			showPathLabel : false,
			// charCounter: false,
			// maxCharCount: 720,  
			width : 'auto',
			maxWidth : '100%',
			height : 'auto',
			minHeight : '223px',
			maxHeight : '223px',
			buttonList : [
			// ['undo', 'redo', 'font', 'fontSize', 'formatBlock'],
			['italic', 'bold', 'list', 'fullScreen'],
			// ['bold', 'italic', 'strike', 'subscript', 'superscript', 'removeFormat'],
			'/' // Line break

			],
			callBackSave : function(contents) {
				console.log(contents);
			}
		});
		console.log('contents', editor.getContents())
	</script>

