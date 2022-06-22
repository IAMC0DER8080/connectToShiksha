var cal = {
  // (A) PROPERTIES
  // (A1) COMMON CALENDAR
  sMon : false, // Week start on Monday?
  mName : ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"], // Month Names

  // (A2) CALENDAR DATA
  data : null, // Events for the selected period
  sDay : 0, sMth : 0, sYear : 0, // Current selected day, month, year

  // (A3) COMMON HTML ELEMENTS
  hMth : null, hYear : null, // month/year selector
  hForm : null, hfHead : null, hfDate : null, hfTxt : null, hfDel : null, // event form

  // (B) INIT CALENDAR
  init : () => {
    // (B1) GET + SET COMMON HTML ELEMENTS
    cal.hMth = document.getElementById("cal-mth");
    cal.hYear = document.getElementById("cal-yr");
    cal.hForm = document.getElementById("cal-event");
    cal.hfHead = document.getElementById("evt-head");
    cal.hfDate = document.getElementById("evt-date");
    cal.hfTxt = document.getElementById("evt-details");
    cal.hfDel = document.getElementById("evt-del");
    document.getElementById("evt-close").onclick = cal.close;
    cal.hfDel.onclick = cal.del;
    cal.hForm.onsubmit = cal.save;
 	
    // (B2) DATE NOW
    let now = new Date(),
        nowMth = now.getMonth(),
        nowYear = parseInt(now.getFullYear());

    // (B3) APPEND MONTHS SELECTOR
    for (let i=0; i<12; i++) {
      let opt = document.createElement("option");
      opt.value = i;
      opt.innerHTML = cal.mName[i];
      if (i==nowMth) { opt.selected = true; }
      cal.hMth.appendChild(opt);
    }
    cal.hMth.onchange = cal.list;

    // (B4) APPEND YEARS SELECTOR
    // Set to 10 years range. Change this as you like.
    for (let i=nowYear-10; i<=nowYear+10; i++) {
      let opt = document.createElement("option");
      opt.value = i;
      opt.innerHTML = i;
      if (i==nowYear) { opt.selected = true; }
      cal.hYear.appendChild(opt);
    }
    cal.hYear.onchange = cal.list;

    // (B5) START - DRAW CALENDAR
    cal.list();
  },

  // (C) DRAW CALENDAR FOR SELECTED MONTH
  list : () => {
    // (C1) BASIC CALCULATIONS - DAYS IN MONTH, START + END DAY
    // Note - Jan is 0 & Dec is 11
    // Note - Sun is 0 & Sat is 6
    cal.sMth = parseInt(cal.hMth.value); // selected month
    cal.sYear = parseInt(cal.hYear.value); // selected year
    let daysInMth = new Date(cal.sYear, cal.sMth+1, 0).getDate(), // number of days in selected month
        startDay = new Date(cal.sYear, cal.sMth, 1).getDay(), // first day of the month
        endDay = new Date(cal.sYear, cal.sMth, daysInMth).getDay(), // last day of the month
        now = new Date(), // current date
        nowMth = now.getMonth(), // current month
        nowYear = parseInt(now.getFullYear()), // current year
        nowDay = cal.sMth==nowMth && cal.sYear==nowYear ? now.getDate() : null ;
		
    // (C2) LOAD DATA FROM LOCALSTORAGE
    cal.data = localStorage.getItem("cal-" + cal.sMth + "-" + cal.sYear);
    if (cal.data==null) {
      localStorage.setItem("cal-" + cal.sMth + "-" + cal.sYear, "{}");
      cal.data = {};
    } else { cal.data = JSON.parse(cal.data); }

    // (C3) DRAWING CALCULATIONS
    // Blank squares before start of month
    let squares = [];
    if (cal.sMon && startDay != 1) {
      let blanks = startDay==0 ? 7 : startDay ;
      for (let i=1; i<blanks; i++) { squares.push("b"); }
    }
    if (!cal.sMon && startDay != 0) {
      for (let i=0; i<startDay; i++) { squares.push("b"); }
    }

    // Days of the month
    for (let i=1; i<=daysInMth; i++) { squares.push(i); }

    // Blank squares after end of month
    if (cal.sMon && endDay != 0) {
      let blanks = endDay==6 ? 1 : 7-endDay;
      for (let i=0; i<blanks; i++) { squares.push("b"); }
    }
    if (!cal.sMon && endDay != 6) {
      let blanks = endDay==0 ? 6 : 6-endDay;
      for (let i=0; i<blanks; i++) { squares.push("b"); }
    }

    // (C4) DRAW HTML CALENDAR
    // Get container
    let container = document.getElementById("cal-container"),
    cTable = document.createElement("table");
    cTable.id = "calendar";
    container.innerHTML = "";
    container.appendChild(cTable);

    // First row - Day names
    let cRow = document.createElement("tr"),
        days = ["Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"];
    if (cal.sMon) { days.push(days.shift()); }
    for (let d of days) {
      let cCell = document.createElement("td");
      cCell.innerHTML = d;
      cRow.appendChild(cCell);
    }
    cRow.classList.add("head");
    cTable.appendChild(cRow);

    // Days in Month
    let total = squares.length;
    cRow = document.createElement("tr");
    cRow.classList.add("day");
   var sDays= sundays(cal.sYear, cal.sMth);
   var cnt=0;
   var presentDays=$("#attendenceDate").val();
   let currentDate = new Date();
  var currentMnth= currentDate.getMonth()+1;
   var currentYear= currentDate.getFullYear();
   console.log("currentMnth  =====  "+currentMnth+"  currentYear=====>> "+currentYear);
    console.log("cRow   =======>> "+total);
    
    var cleanStr1=presentDays.replace("[","");
	var cleanStr2=cleanStr1.replace("]","");
	var dateArray=cleanStr2.split(",");
	/*for(let ittrator =0;ittrator<dateArray.length;ittrator++){
		for(let innerIttrator =0;innerIttrator<=ittrator;innerIttrator++){
			let presentDates = new Date(dateArray[ittrator].trim());
		}
		
	}*/
    for (let i=0; i<total; i++) {
	
      let cCell = document.createElement("td");
     
      if (squares[i]=="b") { cCell.classList.add("blank");  }
      else {
	
	
	if(cnt<sDays.length){
	if(squares[i]==sDays[cnt]){cCell.classList.add("holiday");cnt++;}}
	//if(!presentDates<now){
		cCell.classList.add("absent");
	//}
	
	for(let j=0;j<dateArray.length;j++){
	
		
		let presentDates = new Date(dateArray[j].trim());
//	console.log("(cal.sMth+1): "+(cal.sMth+1)+", nowYear: "+nowYear+", squares[i]: "+squares[i]+", presentDates.getDate() "+presentDates.getDate());
	let thisMonth=presentDates.getMonth()+1;
	if(thisMonth==(cal.sMth+1) && presentDates.getFullYear()==cal.sYear && squares[i]==presentDates.getDate()){
		 cCell.classList.remove("absent");
		cCell.classList.add("present");
		
	}else if(thisMonth==(cal.sMth+1) && presentDates.getFullYear()==cal.sYear && squares[i]==presentDates.getDate()){
		 cCell.classList.remove("absent");
		cCell.classList.add("present");
		
	}
	
	if((cal.sMth+1)==currentMnth && cal.sYear==currentYear && squares[i]>nowDay){
		console.log("thisMonth: "+thisMonth+" nowMth: "+nowMth+" nowYear:  "+nowYear);
		 cCell.classList.remove("absent");
	}
	
	}
	//console.log("nowDay  ======>> "+nowDay);
	
	
        if (nowDay==squares[i]) { cCell.classList.add("today"); }
        
       
        cCell.innerHTML = `<div class="dd">${squares[i]}</div>`;
        if (cal.data[squares[i]]) {
          cCell.innerHTML += "<div class='evt'>" + cal.data[squares[i]] + "</div>";
        }
        cCell.onclick = () => { cal.show(cCell); };
      }
      cRow.appendChild(cCell);
      if (i!=0 && (i+1)%7==0) {
        cTable.appendChild(cRow);
        cRow = document.createElement("tr");
        cRow.classList.add("day");
      }
     // j++;
    }

    // (C5) REMOVE ANY PREVIOUS ADD/EDIT EVENT DOCKET
    cal.close();
  },

  // (D) SHOW EDIT EVENT DOCKET FOR SELECTED DAY
  show : (el) => {
    // (D1) FETCH EXISTING DATA
    cal.sDay = el.getElementsByClassName("dd")[0].innerHTML;
    let isEdit = cal.data[cal.sDay] !== undefined ;

    // (D2) UPDATE EVENT FORM
    cal.hfTxt.value = isEdit ? cal.data[cal.sDay] : "" ;
    cal.hfHead.innerHTML = isEdit ? "EDIT EVENT" : "ADD EVENT" ;
    cal.hfDate.innerHTML = `${cal.sDay} ${cal.mName[cal.sMth]} ${cal.sYear}`;
    if (isEdit) { cal.hfDel.classList.remove("ninja"); }
    else { cal.hfDel.classList.add("ninja"); }
    cal.hForm.classList.remove("ninja");
  },

  // (E) CLOSE EVENT DOCKET
  close : () => {
    cal.hForm.classList.add("ninja");
  },

  // (F) SAVE EVENT
  save : () => {
    cal.data[cal.sDay] = cal.hfTxt.value;
    localStorage.setItem(`cal-${cal.sMth}-${cal.sYear}`, JSON.stringify(cal.data));
    cal.list();
    return false;
  },

  // (G) DELETE EVENT FOR SELECTED DATE
  del : () => { if (confirm("Delete event?")) {
    delete cal.data[cal.sDay];
    localStorage.setItem(`cal-${cal.sMth}-${cal.sYear}`, JSON.stringify(cal.data));
    cal.list();
  }}
};

function sundays(year, month) {

    var day, counter, date;
    let days=[];

    day = 1;
    counter = 0;
    date = new Date(year, month, day);
    while (date.getMonth() === month) {
        if (date.getDay() === 0) { // Sun=0, Mon=1, Tue=2, etc.
            counter += 1;
            // console.log(date.getDate());
             days.push(date.getDate());
        }
        day += 1;
        date = new Date(year, month, day);
       //
    }
    return days;
}

/*function getAttendace(){
	var userId=$("#userId").val();
	 console.log("ID=======>>  "+userId);
	var data = '{userId:'+userId+'}';
	  $.ajax({
			    type: "POST",
			    url: "/connect-to-class/get-attendance-days",
			    data : data,
			    contentType: "application/json",
			   // contentType: "text",
			    dataType:"text",
			    success: function(response){
			        //if request if made successfully then the response represent the data
			        console.log("response    =======>> "+response);
					return response;
			     
			    }
			  })
	 
}*/


window.addEventListener("load", cal.init);
