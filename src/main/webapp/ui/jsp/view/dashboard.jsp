<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modal.css" />


<style>
#snackbar {
	visibility: hidden;
	min-width: 250px;
	margin-left: -125px;
	color: #1304ef;
	background-color: #FFF; /* rgba(233, 75, 107, 0.5); */
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
	bottom: 500px;
	opacity: 1;
}

}
@
keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}

to {
	bottom: 500px;
	opacity: 1;
}

}
@
-webkit-keyframes fadeout {
	from {bottom: 500px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}

}
@
keyframes fadeout {
	from {bottom: 500px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}

}
.rpt-title a {
	color: #000000;
}

.btn-lg-modal{
width: 100px;
padding-left: 18px;
padding-right: 18px;
}

 .buttons {
width: 200px;
margin: 0 auto;
display: inline;}

    .action_btn {
width: 200px;
margin: 0 auto;
display: inline;}

</style>

<!-- ============================================================== -->
<!-- Start Page Content here -->
<!-- ============================================================== -->


<div id="myModal" class="modal" style="display: block;">

  <div class="modal-content">
    <span class="close" id="close-modal">×</span>
    <p>Mark Your Attendace here Click Mark Button</p>
  <!-- <button class="button-modal" id="close" value="Close" style="">Close</button>
  <button type="button" class="button-modal" id="mrak" value="Mrak"> Mark</button> -->
  
   <button type="button" class="btn btn-lg-modal btn-outline-primary" id="mrak" value="Mrak"> Mark</button>
  </div><!-- Modal content -->
  

</div>

<div id="errorModal" class="modal" style="display: none;">

  <div class="modal-content">
    <span class="close" id="close-errmodal">×</span>
    <p id="errormsg"></p>
  <!-- <button class="button-modal" id="close" value="Close" style="">Close</button>
  <button type="button" class="button-modal" id="mrak" value="Mrak"> Mark</button> -->
  
  
  </div><!-- Modal content -->
  

</div>

<div class="content-page">
	<div class="content">
		<!-- Start Content-->

		<!-- start page title -->
		<div class="row">
			<div class="col-12">
				<div class="page-head-box">
					<!-- <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item">
                                            <a href="#">Dashboard</a>
                                        </li>
                                        <li class="breadcrumb-item active" aria-current="page">
                                            Dashboard
                                        </li>
                                    </ol>
                                </nav> -->
					<div class="page-head-content hasbutton">
						<h4 class="page-head">Dashboard</h4>
						
						<c:if test="${not empty userEntity}">
						<input type="hidden" id="userId" value="${userEntity.userId}">
							<c:if test="${userEntity.designation != 0}">
								<form action="./create-new-training">

									<button type="submit" id="createId"
										class="btn btn-lg btn-outline-primary">

										<span class="fa fa-plus"></span> Create Lecture
									</button>
								</form>
								
								<form action="./create-new-assignment">

									<button type="submit" id="createId"
										class="btn btn-lg btn-outline-primary">

										<span class="fa fa-plus"></span> Create Assignment
									</button>
								</form>
							</c:if>
						</c:if>
						
					</div>
					
					
					
				</div>
			</div>
		</div>

		<!-- dash-card-wrapper -->
		<div class="dash-card-wrapper">
			<div class="card-head hasbutton">
				<h5 class="card-title">Lecture</h5>

			</div>
			<div class="customrow">


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

				<!-- dash-card-box -->
				<c:if test="${not empty lectureList}">
					<%Integer counter=1; %>
					<c:forEach var="list" items="${lectureList}">

						<div class="customCol customCol-single">
							<div class="dash-card-box" name="${list.subject}"
								id="<%=(counter++)%>">
								<%--  <c:if test="${list.key}"> --%>
								<a href="/search-table">
									<div class="dots">
										<span class="dot"></span> <span class="dot"></span> <span
											class="dot"></span>
									</div>
								</a>
								<%--  </c:if> --%>
								<div class="dash-content">
									<div class="dash-head">
									<input type="hidden"id="lectureId" value="${list.lectureId}">
										<div id="lecturer" class="dash-subtitle">${list.teacherNmae}</div>
										<div class="dash-title">${list.subject}</div>
									</div>
									<div class="dash-num">
										<span>${list.lecturetime}</span> 
										<input type="hidden" id="url" value="${list.URL}">
										<input type="button" value="join" id="joinLecture" class="btn btn-lg btn-outline-primary"  onclick="joinLecture('${userEntity.userId}','${list.lectureId}','${list.URL}','${list.teacherNmae}');">  <!--onclick="window.open('${list.URL}');  -->
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${ empty lectureList}">
					<span style="margin-left: 100px">No Lecture for today</span>
				</c:if>
				<!-- dash-card-box -->


			</div>
		</div>


		<!-- recently published trainings -->
		<div class="dash-card-wrapper">
			<div class="card-head hasbutton">
				<h5 class="card-title">Assignments</h5>

			</div>
			<div class="customrow">
				<%-- <c:if test="${not empty entityList}">
							<c:forEach var="entity" items="${entityList}">
                            <div class="customCol customCol-single">
                                <!-- rpt box -->
                                <div class="rpt-box">
                                    <div class="rpt-datetime">
                                    <fmt:parseDate var="parseDate" pattern="yyyy-MM-dd" value="${entity.schedule_date}" />
									<fmt:formatDate var="formattedDate" pattern="dd/MM/yyyy" value="${parseDate}" />
                                        <span class="rpt-date">${formattedDate} </span> 
                                        
                                        <fmt:parseDate var="parseTime" pattern="HH:mm:ss" value="${entity.time_start}" />
							<fmt:formatDate var="formattedTime" pattern="hh:mma" value="${parseTime}" />
							<fmt:parseDate var="parseEndTime" pattern="HH:mm:ss" value="${entity.time_end}" />
							<fmt:formatDate var="formattedEndTime" pattern="hh:mma" value="${parseEndTime}" />
                                        <span class="rpt-time">${formattedTime} - ${formattedEndTime}</span>
                                    </div>
                                    <div class="rpt-title"><a  href="./training/${entity.training_id}">${entity.topic}</a></div>
                                    <div class="rpt-tag">${entity.training_type}</div>

                                    <div class="rpt-rsbox">
                                        <div class="rpt-reg">
                                            <div class="rpt-reg-title">Registration</div>
                                            <div class="rpt-num  rpt-num-icon rpt-success">${entity.seat_booked}</div>
                                        </div>
                                        <div class="rpt-reg"> 
                                            <div class="rpt-reg-title">Available Seats</div>
                                             
                                            <div class="rpt-num">${entity.seat_capacity-entity.seat_booked}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                            </c:if> --%>
				<!-- dash-card-box -->
				<c:if test="${not empty assignmentList}">
					<%Integer counter=1; %>
					<c:forEach var="list" items="${assignmentList}">

						<div class="customCol customCol-single">
							<div class="dash-card-box" name="${list.subject}"
								id="<%=(counter++)%>">
								<a href="#">
									<div class="dots">
										<span class="dot"></span> <span class="dot"></span> <span
											class="dot"></span>
									</div>
								</a>
								<div class="dash-content">
									<div class="dash-head">
										<div class="dash-subtitle">${list.teacherNmae}</div>
										<div class="dash-title">${list.topic}</div>
									</div>
									<div class="dash-num">
										<span>${list.assignEndDate}</span> <input type="button"
											value="View" class="btn btn-lg btn-outline-primary"
											onclick="location.href='/connect-to-class/view-assignment/${list.assignmentId}'">
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${ empty assignmentList}">
					<span style="margin-left: 100px">No Pending Assignments
						Found</span>
				</c:if>
				,
				<!-- dash-card-box -->


			</div>
		</div>

	</div>
	<!-- content -->
</div>


<!-- ============================================================== -->
<!-- End Page content -->
<!-- ============================================================== -->

<!-- page wrapper end -->

<!-- END wrapper -->


<script
	src="${pageContext.request.contextPath}/assets/js/jquery-3.5.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery-ui.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.timepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>

<script>

$(document).ready(function(){
	 //$("#myModal").show();
	getAttendaceStatus();
	
	$("div[name='Published Trainings'] a").attr("href", "./published-trainings"); 
	$("div[name='Cancelled Trainings'] a").attr("href", "./cancelled-trainings");    
	
	$("#close-modal").on('click',function(){
		var modal = document.getElementById("myModal");
		modal.style.display = "none";
	});
	
	
	$("#close-errmodal").on('click',function(){
		var modal = document.getElementById("errorModal");
		modal.style.display = "none";
	});
	
})

$("#mrak").on('click',function(){
	var modal = document.getElementById("myModal");
	modal.style.display = "none";
	var userPost, userId;
	
	/* userId = { userId: '${userEntity.userId}' };
	    userPost={ userPost: '${userEntity.designation}' }; */
	    //errorArr.push(errorObj);                                  
	

	//Populate the corresponding javascript object.
	var data = '{userId:${userEntity.userId},'
		+'dest:${userEntity.designation}}';
	
	console.log(data);
	 $.ajax({
		    type: "POST",
		    url: "/connect-to-class/mark-attendance",
		    data : data,
		    contentType: "application/json",
		   // contentType: "text",
		    dataType:"application/json",
		    success: function(response){
		        //if request if made successfully then the response represent the data
				if(response==1){
					
				}
		     
		    }
		  })
	
});

function joinLecture( userId, lectureId, url, lecturer){
	//var userId=$("#userId").val();
	//var lectureId=$("#lectureId").val();
	var data = '{userId: '+userId+','
		+'lectureId:'+lectureId+'}';
		//var url=$("#url").val();
		
		//var lecturer= $("#lecturer").text();
	console.log("url  =====>> "+url);
	console.log("data  =====>> "+data);
	 $.ajax({
		    type: "POST",
		    url: "/connect-to-class/mark-lecture-attendance",
		    data : data,
		    contentType: "application/json",
		   // contentType: "text",
		    //dataType:"application/json",
		    dataType:"text",
		    success: function(response){
		        //if request if made successfully then the response represent the data
				if(response=="01"){
					//alert("Wrong Leacture");
					$("#errormsg").text("Wrong Leacture Contact Lecturer "+lecturer+"!");
					$("#errorModal").show();
				}else if(response==99) {
					//alert("Something Went Wrong contac your admin!");
					$("#errormsg").text("Something Went Wrong contac your admin!");
					$("#errorModal").show();
				}else{
					 window.open(url);
				}
		     
		    }
		  })
	
}


 function getAttendaceStatus(){
	 
		var modal = document.getElementById("myModal");
		modal.style.display = "none";
		var userPost, userId;
		
		/* userId = { userId: '${userEntity.userId}' };
		    userPost={ userPost: '${userEntity.designation}' }; */
		    //errorArr.push(errorObj);                                  
		

		//Populate the corresponding javascript object.
		var data = '${userEntity.userId}'+'  '+'${userEntity.designation}';
		
		console.log(data);
		 $.ajax({
			    type: "POST",
			    url: "/connect-to-class/get-attendance-status",
			    data : data,
			    //contentType: "application/json",
			   // contentType: "text",
			    dataType:"text",
			    success: function(response){
			        //if request if made successfully then the response represent the data
					if(response==1){
						//alert("attendace allredy marked");
						var modal = document.getElementById("myModal");
						modal.style.display = "none";
					}else{
						 $("#myModal").show();
					}
			     
			    }
			  })
	 
 }

  </script>

</body>

</html>