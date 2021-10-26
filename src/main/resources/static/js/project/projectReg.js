


var main = {
	
    init : function (){
		var _this = this;
	
		// -----------select dept ajax 처리----------

		$.ajax({
		    type: 'GET',
		    url: '/api/dept',
		    dataType: 'json',	//json or text
		    contentType: 'application/json; charset=utf-8',
		}).done(function (dept) {
		
			for(var i=0; i<dept.length; i++){
				$('#projectDept').append(
					"<option value='"+dept[i].emp_dept_pk+"'>"+dept[i].dept_name+"</option>"
				);
			}
		
		}).fail(function (error) {
			//console.log(data);
		    alert(JSON.stringify(error));
		});
		
		// -----------select dept ajax 처리 끝----------
	
	
        
        
        $('#projectDept').change(function(){
			_this.getPMList();
		});
        
        $('#btnProjectSave').on('click',function (){

		
		// -----------유효성 검사--------------
		var count = 0;
		
		if($('#projectCompDT').val() == ''){
			$('#projectCompDT')[0].setCustomValidity('이 값을 입력하세요.');
			$('#projectCompDT')[0].reportValidity();
			
		}else{
			count = count+1;
			$('#projectCompDT')[0].setCustomValidity('');
		}
		if($('#projectStartDT').val() == ''){
			$('#projectStartDT')[0].setCustomValidity('이 값을 입력하세요.');
			$('#projectStartDT')[0].reportValidity();
			
		}else{
			count = count+1;
			$('#projectStartDT')[0].setCustomValidity('');
		}
		if($('#projectPM').val() == null){
			$('#projectPM')[0].setCustomValidity('이 값을 입력하세요.');
			$('#projectPM')[0].reportValidity();
			
		}else{
			count = count+1;
			$('#projectPM')[0].setCustomValidity('');
		}
		
		
		if($('#projectDept').val() == null){
			$('#projectDept')[0].setCustomValidity('이 값을 입력하세요.');
			$('#projectDept')[0].reportValidity();
			
		}else{
			count = count+1;
			$('#projectDept')[0].setCustomValidity('');
		}
		
		
		if($('#rndType').val() == null){
			$('#rndType')[0].setCustomValidity('이 값을 입력하세요.');
			$('#rndType')[0].reportValidity();
			
		}else{
			count = count+1;
			$('#rndType')[0].setCustomValidity('');
		}
		if($('#projectType').val() == null){
			$('#projectType')[0].setCustomValidity('이 값을 입력하세요.');
			$('#projectType')[0].reportValidity();
			
		}else{
			count = count+1;
			$('#projectType')[0].setCustomValidity('');
		}
		if($('#projectName').val() == ''){
			$('#projectName')[0].setCustomValidity('이 값을 입력하세요.');
			$('#projectName')[0].reportValidity();
			
		}else{
			count = count+1;
			$('#projectName')[0].setCustomValidity('');
		}
		// -----------유효성 검사 끝--------------

		if(count==7){
			if($('#projectStartDT').val() > $('#projectCompDT').val()){
				alert('시작일이 종료일보다 늦을 수 없습니다.')
			}else{
				_this.save();
			}
			
		}
		

        
        });

    },
    getPMList: function () {
		var deptData = $('#projectDept').val();
		//console.log(deptData);
		$('#projectPM').html("<option selected disabled value=''>선택하세요</option>");
        $.ajax({
		    type: 'GET',
		    url: '/api/PMList/' + deptData,
		    dataType: 'json',	//json or text
		    contentType: 'application/json; charset=utf-8',
		}).done(function (pmArr) {
			
			for(var i=0; i<pmArr.length; i++){
				$('#projectPM').append(
					"<option value='"+pmArr[i].emp_cd_pk+"'>"+pmArr[i].emp_cd_pk+" / "+pmArr[i].emp_name+"</option>"
				);
			}
		
		}).fail(function (error) {
			//console.log(data);
		    alert(JSON.stringify(error));
		});
    },
    
    save: function () {
		//Project DB에 등록 + PM 리소스 등록 동시에 처리.
        var data = {
            projectName: $('#projectName').val(),
            projectType: $('#projectType').val(),
            rndType: $('#rndType').val(),
            projectDept: $('#projectDept').val(),
            projectPM: $('#projectPM').val(),
            projectStartDT: $('#projectStartDT').val(),
            projectCompDT: $('#projectCompDT').val(),
            projectDescription: $('#projectDescription').val()
        };

        $.ajax({
            type: 'POST',
            url: '/project',
            dataType: 'text',	
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data) 
        }).done(function () {
            alert('프로젝트가 등록되었습니다.');
            window.location.href = '/project';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();