$(document).ready(function () {
  //   create new date picker

 /* $("#ctStartDate").datepicker({
    minDate: 0,
  });
  $("#ctendDate").datepicker({
    minDate: 0,
  });
  $("#ctstartime").timepicker();
  $("#ctendtime").timepicker();*/

	
	$(document).ready(function () {
		  //   create new date picker
		var str = '';
		  $("#ctStartDate").datepicker({
		    minDate: 0,
		  });
		  $("#ctendDate").datepicker({
		    minDate: 0,
		  });
		$(function() {
		  $("#acStartDate").datepicker({
				onSelect : function() {
					str = document.getElementById('trainingDays').value;
					var date = $('#acStartDate').datepicker('getDate');
					date.setDate(date.getDate() + 5 +  parseInt(str));
					$('#acendDate').datepicker('option', 'maxDate', date);
					$('#acendDate').datepicker( 'option', 'minDate', $('#acStartDate').datepicker('getDate'));
					showUser();
				},
				minDate : 0,
			});
		  $("#acendDate").datepicker({
			  onSelect : showUser,
			  onSelect: function(){
			  $(".bggrays").show();
			    var start = new Date( $('#acStartDate').val() ).getTime(),
				end = new Date( $('#acendDate').val() ).getTime();
				var diffDays = ((end - start) / 86400000) + 1;
				//$(".dayscounts").text(diffDays+" Days Training");   	
				$(".dayscounts").text(str+" Days Training");
		        } ,
			 
		  });
		});
		function showUser() {
		}
		 
		});






});
