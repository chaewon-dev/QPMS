


var main = {
	
    init : function (){
		var _this = this;
		
		_this.getPMList();
		
		var toggleEditMode = false;
		$('#btnEditMode').on('click', function(){
			toggleEditMode = !toggleEditMode;
			if(toggleEditMode){
				$('#btnEditModeText').html("Exit Edit Mode");
				$('input').attr('readonly',false);
				$('textarea').attr('readonly',false);
				$('select').attr('disabled',false);
				
			}else{
				$('#btnEditModeText').html("Edit Mode");
				$('input').attr('readonly',true);
				$('textarea').attr('readonly',true);
				$('select').attr('disabled',true);
			}
		});
        
        $('#projectDept').change(function(){
			_this.getPMList();
		});
		
		$('#btnProjectUpdate').on('click',function (){
			
				// -----------유효성 검사--------------
			var count = 0;

			if($('#projectPM').val() == null){
				$('#projectPM')[0].setCustomValidity('이 값을 입력하세요.');
				$('#projectPM')[0].reportValidity();
				
			}else{
				count = count+1;
				$('#projectPM')[0].setCustomValidity('');
			}

			if($('#projectName').val() == ''){
				$('#projectName')[0].setCustomValidity('이 값을 입력하세요.');
				$('#projectName')[0].reportValidity();
				
			}else{
				count = count+1;
				$('#projectName')[0].setCustomValidity('');
			}
			// -----------유효성 검사 끝--------------
			//console.log(count); 
	
			if(count==2){
				_this.update();
			}
			
			
        });

        
        $('#btnProjectDelete').on('click',function (){
			_this.delete();
        });

    },
    getPMList: function () {
		var deptData = $('#projectDept').val();
		//console.log(deptData);
		
        $.ajax({
		    type: 'GET',
		    url: '/api/PMList/' + deptData,
		    dataType: 'json',	//json or text
		    contentType: 'application/json; charset=utf-8',
		}).done(function (pmArr) {
			$('#projectPM').html("");
			for(var i=0; i<pmArr.length; i++){
				if($('#cur_emp_cd_pk').val() == pmArr[i].emp_cd_pk){
					
					$('#projectPM').append(
						"<option selected value='"+pmArr[i].emp_cd_pk+"'>"+pmArr[i].emp_cd_pk+" / "+pmArr[i].emp_name+"</option>"
					);
				}else{
					$('#projectPM').append(
						"<option value='"+pmArr[i].emp_cd_pk+"'>"+pmArr[i].emp_cd_pk+" / "+pmArr[i].emp_name+"</option>"
					);
				}
				
			}
		
		}).fail(function (error) {
			//console.log(data);
		    alert(JSON.stringify(error));
		});
    },
    delete: function () {
		if(confirm('프로젝트를 정말 삭제하시겠습니까?')){
			$.ajax({
	            type: 'DELETE',
	            url: '/project/' + $('#projectId').val(),
	            dataType: 'text',	
	            contentType: 'application/json; charset=utf-8',
	        }).done(function () {
	            alert('프로젝트가 삭제되었습니다.');
	            window.location.href = '/project';
	        }).fail(function () {
	            alert('Approver 혹은 Manager가 지정된 Task가 남아있는 경우 삭제하실 수 없습니다.');
	        });
		}
    },
    update: function () {
        var data = {
            project_pk: $('#projectId').val(),
			project_nm: $('#projectName').val(),
			project_type: $('#projectType').val(),
			rnd_type: $('#rndType').val(),
			emp_dept_pk: $('#projectDept').val(),
			project_start_dt: $('#projectStartDT').val(),
			project_comp_dt: $('#projectCompDT').val(),
			project_description: $('#projectDescription').val(),
			project_state_pk: $('#projectState').val(),
			
			cur_resource_pk: $('#cur_resource_pk').val(),
			cur_emp_cd_pk: $('#cur_emp_cd_pk').val(),
			new_emp_cd_pk: $('#projectPM').val()
			
        };
		if(confirm('프로젝트 수정사항을 반영하시겠습니까?')){
			$.ajax({
	            type: 'PUT',
	            url: '/project/' + $('#projectId').val(),
	            dataType: 'text',	
	            contentType: 'application/json; charset=utf-8',
	            data: JSON.stringify(data) 
	        }).done(function () {
	            alert('프로젝트 정보가 수정되었습니다.');
	            window.location.href = '/project/basic/' + $('#projectId').val();
	        }).fail(function (error) {
	            alert(JSON.stringify(error));
	        });
		}
    }
};

main.init();