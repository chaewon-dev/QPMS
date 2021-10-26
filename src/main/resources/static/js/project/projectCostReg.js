


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
				$('#emp_dept_pk').append(
					"<option value='"+dept[i].emp_dept_pk+"'>"+dept[i].dept_name+"</option>"
				);
			}
		
		}).fail(function (error) {
			//console.log(data);
		    alert(JSON.stringify(error));
		});
		
		// -----------select dept ajax 처리 끝----------
	

        
        $('#btnCostSave').on('click',function (){

		
			// -----------유효성 검사--------------
			var count = 0;
			
			if($('#cost_dt').val() == ''){
				$('#cost_dt')[0].setCustomValidity('이 값을 입력하세요.');
				$('#cost_dt')[0].reportValidity();
				
			}else{
				count = count+1;
				$('#cost_dt')[0].setCustomValidity('');
			}
			if($('#emp_dept_pk').val() == null){
				$('#emp_dept_pk')[0].setCustomValidity('이 값을 입력하세요.');
				$('#emp_dept_pk')[0].reportValidity();
				
			}else{
				count = count+1;
				$('#emp_dept_pk')[0].setCustomValidity('');
			}
			if($('#cost').val() == ''){
				$('#cost')[0].setCustomValidity('이 값을 입력하세요.');
				$('#cost')[0].reportValidity();
				
			}else{
				count = count+1;
				$('#cost')[0].setCustomValidity('');
			}
			if($('#cost_type').val() == null){
				$('#cost_type')[0].setCustomValidity('이 값을 입력하세요.');
				$('#cost_type')[0].reportValidity();
				
			}else{
				count = count+1;
				$('#cost_type')[0].setCustomValidity('');
			}


			// -----------유효성 검사 끝--------------
			//console.log(count); 
	
			if(count==4){
				_this.save();
			}
			

        
        });

    },

    
    save: function () {
		//Project DB에 등록 + PM 리소스 등록 동시에 처리.
        var data = {
            cost_type: $('#cost_type').val(),
            cost: $('#cost').val(),
            emp_dept_pk: $('#emp_dept_pk').val(),
            cost_dt: $('#cost_dt').val(),
            cost_memo: $('#cost_memo').val()
        };
        

        $.ajax({
            type: 'POST',
            url: '/cost/' + $('#projectId').val(),
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data) 
        }).done(function () {
            alert('비용이 등록되었습니다.');
            window.location.href = '/project/cost/'+$('#projectId').val();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();