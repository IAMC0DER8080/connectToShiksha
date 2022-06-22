<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding='UTF-8'%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>



<!-- ============================================================== -->
<!-- Start Page Content here -->
<!-- ============================================================== -->
<div class="content-page">
	<div class="content">
		<!-- Start Content-->
		<!-- start page title -->
		<div class="row">
			<div class="col-12">
				<div class="page-head-box">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="/dbauditutility/reports">${object}</a></li>
							<!-- <li class="breadcrumb-item active" aria-current="page">
                        Reports
                        </li> -->
						</ol>
					</nav>
					<h4 class="page-head">${object}</h4>
				</div>
			</div>
		</div>
		<form action="">
			<!-- report section  -->
			<div class="card-box training-infoSecond-box mb-30">
				<!-- <h5 class="card-title">
                               Reports
                           </h5> -->
				<div class="form-row">

					<div class="form-group col-md-4">
						<div class="form-group venue-field">
							<label for="venueDetails">Selected</label> <input type="text"
								class="form-control" id="firstInput" placeholder="${name}"
								value="${name}" onkeypress="return isAlphaNumeric(event)"
								maxlength="100"> <span id="error_venue"
								class="text-danger adfont"></span>
						</div>
					</div>

					<div class="form-group col-md-4">
						<label for="reportName">Searched Results </label> <select
							class="form-control select2" name="" id="list">
							<option value="" selected="selected" disabled>Select</option>
							<c:if test="${not empty list}">
								<%Integer counter=1; %>
								<c:forEach var="val" items="${list}">
									<option value="${val}" id="<%=(counter++)%>">${val}</option>

								</c:forEach>
							</c:if>
						</select>
						<div style="color: red;" id="input-error" class="errormain"></div>
					</div>

					<input type="hidden" id="hiddenFiled" value="${env}">
				</div>
			</div>

			<div class="btn-box mb-30">

				<button type="button" id="button" class="btn btn-outline-primary">Compare</button>
			</div>
			<div class="card-box training-info-box mb-30 card-box-training" id="resultTable">
			
			</div>
		<div id="main">
		<div class="page-wrap">
		<div style="margin-left: 133px"><span >The Difference Between Two Text</span></div>
		<div class="sidebar"></div>
		<div class="sidebar2"></div>
		</div>
		</div>


		</form>
	</div>
	<!-- content -->
</div>

<div class="centerloader" style="display: none">
	<div class="ring"></div>
	<span class="loding">Loading...</span>
</div>
n

<script src="${pageContext.request.contextPath}/assets/js/moment.min.js"></script>
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
 /*   $("#reportStartDate").datepicker({});
   $("#reportEndtDate").datepicker({}); */
</script>

<style>

#main {
	width: 800px;
	margin: 0 auto;
}

.sidebar    {
    position: absolute;
    left: -172px;
    width: 420px;
    height: 400px;
    overflow: scroll; 
     border: black;
    border-width: 1px;
    border-style: solid;
}
.sidebar2    {
position: absolute;
    left: 267px;
    width: 420px;
    height: 400px;
    overflow: scroll;
    border: black;
    border-width: 1px;
    border-style: solid;
}
.page-wrap  {
    position: relative;
    width: 600px;
    background: #ffffff;
    height: 400px;
    margin: 0 auto;
}

</style>

<script>

$(document).ready(function(){
	$("#resultTable").hide();
	$("#main").hide();
	
$("#button").prop('disabled', true);

$("#list").on('change',function(){

	$("#button").prop('disabled', false);
	
});


$("#button").on('click', function(){
	var json=getData();
	var div1='';
	var div2='';
	var object='';
	//console.log(JSON.stringify(json));
$.ajax({
	
	type : "POST",
	url : "/dbauditutility/compare-data", 
	contentType : "application/json",
	data : json,
	dataType : 'json',
	
	error : function(e) {
	console.log("ERROR: ", e);

	
},
	success : function(data) {
		$("#resultTable").html(" ");
		
		$("#resultTable").show();
		var values = new Array();
		var tbodyStr1=' ';
		var tbodyStr2=' ';
		
		
		//$("#example").append('<thead> <tr><th scope="col">Column Name</th></tr></thead>')  ; 
		//$("#example2").append('<thead> <tr><th scope="col">Column Name</th></tr></thead>')  ; 
		console.log(data);
		
		for ( var key in data) {
			if(key=='object'){
				object=data[key];
				}
		}
			
			if(object=='Procedure'){
				//console.log("object==Procedure   "+(object=='Procedure'));
				for ( var key in data) {
				if(key=='uat'){
					div1=data[key];
				}
				if(key=='prod'){
					div2=data[key];

					}
				}
		}else{
			for ( var key in data) {
		 if(key=='uat'){
			values=data[key];
			console.log(values.length);
			for(var index=0;index<values.length;index++)
			tbodyStr1=tbodyStr1.concat('</tr><tr><td>'+values[index]+'</td></tr>')  ; 
		}

		if(key=='prod'){
			values=data[key];
			console.log(values.length);
			for(var index=0;index<values.length;index++)
				tbodyStr2=tbodyStr2.concat('</tr><tr><td>'+values[index]+'</td></tr>')  ; 
		} 
			
		}
			
		}
	
		
		if(object=='Procedure'){
			$("#resultTable").html(" ");
			$("#main").show();
			$("#resultTable").hide();
		$(".sidebar").append(div1);
		$(".sidebar2").append(div2);
		}else{
		$("#resultTable").append(  ' <div class="row noStrech"><div class="nav-tabs-custom "><div class="row borders  align-items-end"><div class="col-8"><ul class="nav nav-tabs" role="tablist"><li class="nav-item navMargin"><a class="nav-link active onGoingTrain" data-toggle="tab" href="#home">UAT</a></li><li class="nav-item navMargin"><a class="nav-link completeTrain" data-toggle="tab" href="#menu1">Production</a></li></ul></div></div><div class="tab-content"><div id="home" class="container tab-pane active"><div class=" table-responsive"><table class="table order-table table-custom table-striped" id="example"><thead><tr><th scope="col">Tbale Name</th></tr></thead><tbody>  '+tbodyStr1+'   </tbody></table></div></div><div id="menu1" class="container tab-pane fade"><div class=" table-responsive"><table class="table order-table table-custom table-striped" id="example2"><thead><tr><th scope="col">Table Name</th></tr></thead><tbody>'+tbodyStr2+'</tbody></table></div></div></div></div></div>')  ; 
		}
		}

	}); 
});

})  
function getData(){
var firstInput= $("#firstInput").val();
var secondInput = $("#list").val();
var evn=$("#hiddenFiled").val();
var object=$("h4").text();
var json='{'+'"firstInput"'+":"+ '"'+firstInput+'"'+','+'"secondInput"'+':'+'"'+secondInput+'"'+','+'"evn"'+':'+'"'+evn+'"'+','+'"object"'+':'+'"'+object+'"'+'}';
	return json;
}



		

</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css" />