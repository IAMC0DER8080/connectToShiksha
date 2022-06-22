
// ************************ Drag and drop ***************** //
let dropArea = document.getElementById("drop-area")

        // Prevent default drag behaviors
        ;['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
                dropArea.addEventListener(eventName, preventDefaults, false)
                document.body.addEventListener(eventName, preventDefaults, false)
        })

        // Highlight drop area when item is dragged over it
        ;['dragenter', 'dragover'].forEach(eventName => {
                dropArea.addEventListener(eventName, highlight, false)
        })

        ;['dragleave', 'drop'].forEach(eventName => {
                dropArea.addEventListener(eventName, unhighlight, false)

        })

// Handle dropped files
dropArea.addEventListener('drop', handleDrop, false)

function preventDefaults(e) {
        e.preventDefault()
        e.stopPropagation()
}

function highlight(e) {
        dropArea.classList.add('highlight')
}

function unhighlight(e) {
        dropArea.classList.remove('active')
}

function handleDrop(e) {
	var fileStatus = $("#fileElem").is(':disabled');	   
	if(fileStatus == false)
	{				
		
		fileElem.files = e.dataTransfer.files;
		 const dT = new DataTransfer();
	  dT.items.add(e.dataTransfer.files[0]);			 
	  fileElem.files = dT.files;
		handleFiles(fileElem.files);
	  e.preventDefault();
					
		
		
	}
 }

let uploadProgress = []
let progressBar = document.getElementById('progress-bar')

function initializeProgress(numFiles) {
        progressBar.value = 0
        uploadProgress = []

        for (let i = numFiles; i > 0; i--) {
                uploadProgress.push(0)
        }
}

function updateProgress(fileNumber, percent) {
        uploadProgress[fileNumber] = percent
        let total = uploadProgress.reduce((tot, curr) => tot + curr, 0) / uploadProgress.length
        console.debug('update', fileNumber, percent, total)
        progressBar.value = total
}

function handleFiles(files) {

        $("#progress-bar").show();
        $(".cancel-btn").show();
        $("#gallery").show(); 
        files = [...files]
        console.log("files.length   "+files.length); 
        initializeProgress(files.length)
       // files.forEach(uploadFile)
        files.forEach(previewFile)
       // $("#fileElem").prop('disabled', true);



}

function previewFile(file) {
        console.log('file', file);
        $("#fileName span").text('');  
        document.getElementById('fileName').insertAdjacentHTML('beforeend', `<span>${file.name}</span>`);
        let reader = new FileReader();;
        console.log('reader', reader);
        reader.readAsDataURL(file)
        reader.onloadend = function () {
                let img = document.createElement('img')
                img.src = reader.result
                var fileexe = $("#fileName").text().split('.').pop();
                $("#gallery").show(); 
             /*   if (fileexe == 'pdf' || fileexe == 'doc' || fileexe == 'docx' || fileexe == 'docm' || fileexe == 'zip') {
                    $("#gallery").append("<img alt = 'pdfImg' src='${pageContext.request.contextPath}/assets/images/file-upload.svg' class='pdf-icons'>");
            }
            
            else {
                    document.getElementById('gallery').appendChild(img);
            }*/




        }
}



$(".cancel-btn").click(function () {
        $("#fileElem").prop('disabled', false);
        $("#progress-bar").val("");
        $("#gallery").hide();
        $("#fileName span").text('');
        $(".filename").text('');
        $("#fileElem").val("");
        $("#progress-bar").hide();
        $(".cancel-btn").hide();
});



function uploadFile(file, i) {
        var url = '#'
        var xhr = new XMLHttpRequest()
        var formData = new FormData()
        xhr.open('POST', url, true)
        xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest')

        // Update progress (can be used to show progress indicator)
        xhr.upload.addEventListener("progress", function (e) {
                updateProgress(i, (e.loaded * 100.0 / e.total) || 100)
        })

        xhr.addEventListener('readystatechange', function (e) {
                if (xhr.readyState == 4 && xhr.status == 200) {
                        updateProgress(i, 100) // <- Add this
                }
                else if (xhr.readyState == 4 && xhr.status != 200) {
                        // Error. Inform the user
                }
        })

        formData.append('upload_preset', 'ujpu6gyk')
        formData.append('file', file)
        //xhr.send(formData)
}



// second upload ====================
// ************************ Drag and drop ***************** //
let dropAreaTI = document.getElementById("drop-areaTI")

        // Prevent default drag behaviors
        ;['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
                dropAreaTI.addEventListener(eventName, preventDefaultsTI, false)
                document.body.addEventListener(eventName, preventDefaultsTI, false)
        })

        // Highlight drop area when item is dragged over it
        ;['dragenter', 'dragover'].forEach(eventName => {
                dropAreaTI.addEventListener(eventName, highlightTI, false)
        })

        ;['dragleave', 'drop'].forEach(eventName => {
                dropAreaTI.addEventListener(eventName, unhighlightTI, false)

        })

// Handle dropped files
dropAreaTI.addEventListener('drop', handleDropTI, false)

function preventDefaultsTI(e) {
        e.preventDefault()
        e.stopPropagation()
}

function highlightTI(e) {
        dropAreaTI.classList.add('highlight')
}

function unhighlightTI(e) {
        dropAreaTI.classList.remove('active')
}

function handleDropTI(e) {
        var fileStatus = $("#fileElemTI").is(':disabled');
        if (fileStatus == false) {
                var dt = e.dataTransfer
                var files = dt.files
                handleFilesTI(files)
        }
}

let uploadProgressTI = []
let progressBarTI = document.getElementById('progress-barTI')

function initializeProgressTI(numFiles) {
        progressBarTI.value = 0
        uploadProgressTI = []

        for (let i = numFiles; i > 0; i--) {
                uploadProgressTI.push(0)
        }
}

function updateProgress(fileNumber, percent) {
        uploadProgressTI[fileNumber] = percent
        let totalTI = uploadProgressTI.reduce((tot, curr) => tot + curr, 0) / uploadProgressTI.length
        console.debug('update', fileNumber, percent, totalTI)
        progressBarTI.value = totalTI
}

function handleFilesTI(files) {

        $("#progress-barTI").show();
        $(".cancel-btnTI").show();
        $("#gallery").show();
        files = [...files]
        console.log("files        "+files);
        initializeProgressTI(files.length)
        files.forEach(uploadFileTI)
        files.forEach(previewFileTI)
        $("#fileElemTI").prop('disabled', true);



}

function previewFileTI(file) {
        console.log('file', file);
        document.getElementById('fileNameTI').insertAdjacentHTML('beforeend', `<span>${file.name}</span>`);
        let reader = new FileReader();;
        console.log('reader', reader);
        reader.readAsDataURL(file)
        reader.onloadend = function () {
                let img = document.createElement('img')
                img.src = reader.result
                var fileexe = $("#fileNameTI").text().split('.').pop();
             /*   if (fileexe == 'pdf' || fileexe == 'doc' || fileexe == 'docx' || fileexe == 'docm' || fileexe == 'zip') {
                    $("#gallery").append("<img alt = 'pdfImg' src='${pageContext.request.contextPath}/assets/images/file-upload.svg' class='pdf-icons'>");
            }
            
            else {
                    document.getElementById('gallery').appendChild(img);
            }*/



        }
}



$(".cancel-btnTI").click(function () {
        $("#fileElemTI").prop('disabled', false);
        $("#progress-barTI").val("");
        $("#galleryTI").text('');
        $("#fileNameTI span").text('');
        $("#fileElemTI").val("");
        $("#progress-barTI").hide();
        $(".cancel-btnTI").hide();
});



function uploadFileTI(file, i) {
        var url = '#'
        var xhr = new XMLHttpRequest()
        var formData = new FormData()
        xhr.open('POST', url, true)
        xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest')

        // Update progress (can be used to show progress indicator)
        xhr.upload.addEventListener("progress", function (e) {
                updateProgress(i, (e.loaded * 100.0 / e.totalTI) || 100)
        })

        xhr.addEventListener('readystatechange', function (e) {
                if (xhr.readyState == 4 && xhr.status == 200) {
                        updateProgress(i, 100) // <- Add this
                }
                else if (xhr.readyState == 4 && xhr.status != 200) {
                        // Error. Inform the user
                }
        })

        formData.append('upload_preset', 'ujpu6gyk')
        formData.append('file', file)
        //xhr.send(formData)
}