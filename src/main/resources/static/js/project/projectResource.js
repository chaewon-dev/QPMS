


var main = {
	
    init : function (){
		var _this = this;
		_this.getEngagementMemberList();
		
		// -----------select dept ajax 처리----------

		$.ajax({
		    type: 'GET',
		    url: '/api/dept',
		    dataType: 'json',	//json or text
		    contentType: 'application/json; charset=utf-8',
		}).done(function (dept) {
		
			for(var i=0; i<dept.length; i++){
				$('#dept').append(
					"<option value='"+dept[i].emp_dept_pk+"'>"+dept[i].dept_name+"</option>"
				);
			}
			
			_this.getMemberList();	//부서목록 불러온 후 전체사용자 출력
		
		}).fail(function (error) {
			//console.log(data);
		    alert(JSON.stringify(error));
		});
		
		// -----------select dept ajax 처리 끝----------
		
		// ----------Approver Manager List Ajax 처리 ----------
		
/*		$.ajax({
		    type: 'GET',
		    url: '/api/project/resource/approvermanager/' + $('#projectId').val(),
		    dataType: 'json',	//json or text
		    contentType: 'application/json; charset=utf-8',
		}).done(function (dept) {
			//전역변수 선언하기?
			for(var i=0; i<dept.length; i++){
				$('#dept').append(
					"<option value='"+dept[i].emp_dept_pk+"'>"+dept[i].dept_name+"</option>"
				);
			}
			
			_this.getMemberList();	//부서목록 불러온 후 전체사용자 출력
		
		}).fail(function (error) {
			//console.log(data);
		    alert(JSON.stringify(error));
		});*/
		
		
		
		// ----------Approver Manager List Ajax 처리 끝 ----------
		
		
		
		
		$('#dept').change(function(){
			_this.getMemberList();
		});
        
        $('#btnAdd').on('click',function (){
			_this.addResource();
        });
        
        $('#btnDelete').on('click',function (){
			_this.deleteResource();
        });
        
    },
    getMemberList: function () {
		var deptData = $('#dept option:selected').val();
		var projectId = $('#projectId').val();
        $.ajax({
            type: 'GET',
            url: '/resource/member/dept/' + deptData +'/' + projectId,
            dataType: 'json'
        }).done(function (member) {
            $('#memberListContents').html("");
            for(var i=0; i<member.length; i++){
				$('#memberListContents').append(
					"<tr>"+
						"<td>"+
							"<input type='checkbox' name='memberCheck' value="+member[i].emp_cd_pk+">"+
						"</td>"+
						"<td>"+
							member[i].emp_cd_pk+
						"</td>"+
						"<td>"+
							member[i].emp_name+
						"</td>"+
						"<td>"+
							member[i].dept_name+
						"</td>"+
					"</tr>"
				);
			}
            
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    getEngagementMemberList: function () {
		var projectId = $('#projectId').val();
        $.ajax({
            type: 'GET',
            url: '/resource/enegagementMember/' + projectId,
            dataType: 'json'
            //contentType: 'application/json; charset=utf-8',
            //data: JSON.stringify(data) 
        }).done(function (member) {
			console.log(member);
			
            $('#engageMemberListContents').html("");
            for(var i=0; i<member.length; i++){
				$('#engageMemberListContents').append(
					"<tr>"+
						"<td>"+
							"<input type='checkbox' name='EngagementMemberCheck' value="+member[i].emp_cd_pk+">"+
						"</td>"+
						"<td>"+
							member[i].emp_cd_pk+
						"</td>"+
						"<td>"+
							member[i].emp_name+
						"</td>"+
						"<td>"+
							member[i].dept_name+
						"</td>"+
					"</tr>"
				);
			}
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    addResource: function () {
		var _this = this;
		var projectId = $('#projectId').val();
		var chkVal = [];
		if($("[name='memberCheck']:checked").length > 0){
			$("[name='memberCheck']:checked").each(function(i,iVal){
				chkVal.push(iVal.value);
			})
			
			$.ajax({
	            type: 'POST',
	            url: '/resource/enegagementMember/' + projectId,
	            dataType: 'text',
	            contentType: 'application/json; charset=utf-8',
	            data: JSON.stringify(chkVal)
	        }).done(function () {
				_this.getMemberList();
				_this.getEngagementMemberList();
	        }).fail(function (error) {
	            alert(JSON.stringify(error));
	        });
		}
    },
    deleteResource: function () {
		var _this = this;
		var projectId = $('#projectId').val();
		//console.log($("[name='memberCheck']:checked").val());
		var chkVal = [];
		//console.log($("[name='memberCheck']:checked").length);
		if($("[name='EngagementMemberCheck']:checked").length > 0){
			$("[name='EngagementMemberCheck']:checked").each(function(i,iVal){
				//console.log(iVal.value);
				chkVal.push(iVal.value);
			})
			//console.log(chkVal);
		}
		console.log(chkVal);
		
		if($("[name='EngagementMemberCheck']:checked").length > 0){	//PM인지 유무 확인

			for(var i=0; i<chkVal.length; i++){
				if(chkVal[i] != $('#cur_emp_cd_pk').val()){
					
					var temp = chkVal[i];
					
					$.ajax({
			            type: 'DELETE',
			            url: '/resource/enegagementMember/' +chkVal[i] + '/' + projectId,
			            dataType: 'text',
			            contentType: 'application/json; charset=utf-8',
			        }).done(function () {
						_this.getMemberList();
						_this.getEngagementMemberList();
			        }).fail(function () {
			            alert('[ '+temp+' ] '+'Approver 혹은 Manager는 삭제할 수 없습니다.');
			        });
			        
		        }else{
					
					alert('PM은 삭제할 수 없습니다.\nPM: '+chkVal[i]+' / '+$('#cur_emp_name').val());
					
				}
			}
		        
	    }
    }
    
    
};

main.init();