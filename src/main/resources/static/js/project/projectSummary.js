


var main = {
	
    init : function (){
		var _this = this;
		_this.getEngagementMemberList();
		
		// -----------select dept ajax 처리----------

/*		$.ajax({
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
		});*/
		
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

    
    
};

main.init();