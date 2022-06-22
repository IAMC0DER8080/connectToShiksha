 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding='UTF-8'%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 


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
                                 <li class="breadcrumb-item">
                                    <a href="/connect-to-class/dashboard">Dashboard</a>
                                 </li>
                                 <li class="breadcrumb-item active" aria-current="page">
                                    ${object} List
                                 </li>
                              </ol>
                           </nav>
                           <h4 class="page-head">  ${object} List</h4>
                        </div>
                     </div>
                  </div>
                  <div class="formArea ">
                     <div class="row ">
                        <div class="col-lg-6 col-sm-12 col-xs-12 " >
                           <div class="form-group">
                              <input type="" class="form-control arediv light-table-filter" onkeypress="return ValidateAlphaNumeric(event)" placeholder="Search training by name…" data-table="order-table" id="searchItem">
                              <img src="${pageContext.request.contextPath}/assets/images/search.svg" class="srch" alt="">
                           </div>
                        </div>
                           <form action="/connect-to-class/compare-list" method="post">
                           <input type="hidden" name="object" value="${object}">
                        <!--  <div class="btn-box mb-30">
						<button type="submit" id="button" class="btn btn-outline-primary" >Compare</button>
						</div> -->
						</form>
                     </div>
                  </div>
                  <form action="" >
                     <!-- section1 training information  -->
                     <div class="card-box training-info-box mb-30 card-box-training">
                        <div class="row noStrech">
                           <div class="nav-tabs-custom ">
                              <div class="row borders  align-items-end">
                                 <!-- Nav tabs -->
                                 <div class="col-8">
                                    <ul class="nav nav-tabs" role="tablist">
                                       <li class="nav-item navMargin">
                                          <a class="nav-link active onGoingTrain" data-toggle="tab" href="#home">${object}</a>
                                       </li>
                                       <!-- <li class="nav-item navMargin">
                                          <a class="nav-link completeTrain" data-toggle="tab" href="#menu1">Production</a>
                                       </li> -->
                                    </ul>
                                 </div>
                                 
                                 <div class="dash-card-box-total" name="TABLE" id="1"> <div class="dash-content">
                                      <c:if test="${not empty total}">  
                                        <div class="dash-head">
                                            <div class="dash-subtitle">Total</div>
                                           
                                        </div>
                                        <div class="dash-num">
                                            <span id="rowCount">${total}</span> 
                                        </div>
                                        </c:if>
                                          
                                    </div>
                                </div>
                               
                              </div>
                              <!-- Tab panes -->
                              <div class="tab-content">
                                 <div id="home" class="container tab-pane active">
                                    <div class=" table-responsive">
                                       <table class="table order-table table-custom table-striped" id= "example">
                                          <thead>
                                             <tr>
                                           <c:if test="${not empty headerList}">  
						                	<c:forEach var="data" items="${headerList}" >
						                	
                                                <th scope="col">${data}</th>
                                           </c:forEach>
                                           </c:if>
                                             </tr>
                                          </thead>
                                          <tbody>
                                          <%--  <%Integer counter=0; %> --%>
                                          <c:if test="${not empty lectureList}">  
						                	<c:forEach var="data" items="${lectureList}" >
						                	<c:choose>
						                	<c:when test="${data.attendaceState == 'present' }">
                                             <tr >
                                            
                                              
                                                
                                                 <td class="present">${data.roll_num}</td>
                                                  <td>${data.name}</td>
                                             
                                                </tr>
                                                </c:when>
                                                <c:otherwise>
                                                <tr >
                                            
                                              
                                                
                                                 <td class="absent">${data.roll_num}</td>
                                                  <td>${data.name}</td>
                                             
                                                </tr>
                                                </c:otherwise>
                                                </c:choose>
                                                </c:forEach>
                                          
                                          
							                </c:if>
							                
							                <c:if test="${not empty assignmentList}">  
						                	<c:forEach var="data" items="${assignmentList}" >
						                	<c:choose>
						                	<c:when test="${data.attendaceState == '1' }">
                                             <tr>
                                           
                                                <td class="present"><a  href="/connect-to-class/view-assignment/${assignmentId}/${data.roll_num}">${data.roll_num}</a></td>
                                                
                                                 <td>${data.name}</td>
                                                  <%-- <td>${data.assignEndDate}</td> --%>
                                             
                                                </tr>
                                                </c:when>
                                                 <c:otherwise>
                                                 
                                                 <tr>
                                           
                                                <td class="absent">${data.roll_num}</td>
                                                
                                                 <td>${data.name}</td>
                                                 <%--  <td>${data.assignEndDate}</td> --%>
                                             
                                                </tr>
                                                
                                                </c:otherwise>
                                                 
                                                </c:choose>
                                                </c:forEach>
                                          
                                          
							                </c:if>
							                
                                          </tbody>
                                       </table>
                                    </div>
                                 </div>
                              
                              </div>
                           </div>
                        </div>
                     </div>
                  </form>
               </div>
               <!-- content -->
            </div>
       
      <!-- END wrapper -->
      <script src="${pageContext.request.contextPath}/assets/js/jquery-3.5.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/jquery-ui.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/jquery.timepicker.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/js/dataTables.bootstrap4.min.js"></script>
      <script>
         $(document).ready(function() {
         
         $('#example').dataTable( {
         "ordering": false
         } );
         $('#example2').dataTable( {
         "ordering": false
         } );
         $('.dataTables_length').hide(''); 
         $('.dataTables_info').hide('');
         $('.dataTables_filter').hide(''); 
         var table =  $('#example').DataTable();
         var table1 =  $('#example2').DataTable();
         $('#searchItem').keyup(function(){
         table.columns(0).search($(this).val()).draw() ;
         
         })
         
         $('#searchItem').keyup(function(){
         table1.columns(0).search($(this).val()).draw() ;
         
         })
         
         $('#dropdown1').on('change', function () {
         table.columns(1).search( this.value ).draw();
         table1.columns(1).search( this.value ).draw();
         } );
         $('#dropdown2').on('change', function () {
         table.columns(2).search( this.value ).draw();
         table1.columns(2).search( this.value ).draw();
         } );
         $('#dropdown3').on('change', function () {
         table.columns(4).search( this.value ).draw();
         table1.columns(4).search( this.value ).draw();
         } );

         <%-- $('#rowCount').text(<%=(counter) %>); --%>
         
        <%--  $('.nav-tabs').on('change',function(){
        	 if ( $('#home').hasClass('active') ) {
        	 	 $('#rowCount').text(<%=(counter1) %>);
              	 console.log(<%=(counter1) %>);
          	  }

           if ( $('#menu1').hasClass('active') ) {
             $('#rowCount').text(<%=(counter) %>);
           	 console.log(<%=(counter) %>);
     	  }
        	 }); --%>
         
        
          
         });
         
         //Search Content without API
         $(document).ready(function(){ 
         $('#searchItem').keyup(function(){ 
         var text = $(this).val().toLowerCase(); 
         $('tr').hide();     
         
         $('#example tr').each(function(){         
         if($(this).text().toLowerCase().indexOf(""+text+"") != -1 ){ 
         $(this).closest('tr').show();  			 
         }
         });
         $('#example2 tr').each(function(){
         if($(this).text().toLowerCase().indexOf(""+text+"") != -1 ){ 
         $(this).closest('tr').show();  			 
         }
         });
         });
         });
         
         $( ".completeTrain" ).click(function() {
         $('.registrationClose').hide(''); 
         $('.registrationOn').hide(''); 
         $('.greenOrangePoint').hide(''); 
         $('#dropdown3').hide('');   
         $("#dropdown1").prop('selectedIndex',1).trigger("change");
         $("#dropdown2").prop('selectedIndex',1).trigger("change");
         $("#dropdown3").prop('selectedIndex',1).trigger("change");   
         });         
         
         
         $( ".onGoingTrain" ).click(function() {
         $('.registrationClose').show(''); 
         $('.registrationOn').show(''); 
         $('.greenOrangePoint').show(''); 
         $('#dropdown3').show(''); 
         
         $("#dropdown1").prop('selectedIndex',1).trigger("change");
         $("#dropdown2").prop('selectedIndex',1).trigger("change");
         
         $("#dropdown3").prop('selectedIndex',1).trigger("change");  
         });
         
        /*  $(".nav-tabs-custom .nav-tabs").click(function() {
         
         }); */
         
         
         
      </script> 
      
<style>
.btn-box {
    display: flex;
    padding-left: 21.5rem;
    padding-right: 2.5rem;
}




.dash-subtitle {
    color: #9d9d9d;
    font-size: 12px;
    margin-bottom: -6px;
    margin-top: 11px;
    margin-left: 7px;
    margin-right: 7px;
}

.dash-num span {
    font-size: 26px;
    color: #FF7474;
    font-weight: 500;
}

.present {
  color: #1724e5 !important;
}

.absent {
  color: red !important;
}

</style>     