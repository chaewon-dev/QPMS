function filterSubmit(){
	// var filterSubmit = document.querySelector("#filterForm");
	// filterSubmit.submit();
	
	 
	console.log($("#inputGroupSelect01 option:selected").val());
	// ajax 처리를 해보자
	// jquery ajax 처리
	$.ajax({
		type:"get",
		url:"/RiskListJson",
		data : "riskpgs_cd="+$("#inputGroupSelect01 option:selected").val(), 
		dataType:"json",
		success:function(data){
			//data.모델명 으로 해당 데이터를 가지고 올 수 있음.
			// console.log(data);
			var list = data.riskLisk;
			// console.log(data[0]);
			var show = "";
			$(data).each(function(idx, rList){

	    		var rgedt = new Date(rList.risk_regdate_dt);
	    		var upddt = new Date(rList.risk_upddate_dt);
	    		
				show += "<tr onclick=' location.href = &#39; /RiskDetailPage?risk_cd="+rList.risk_cd+" &#39; '>"+ 
				"<td>"+rList.risk_cd+"</td>"+
        		"<td class='text-left'>"+rList.risk_nm+"</td>"+
        		"<td>"+rList.project_nm+"</td>"+
        		"<td>"+rList.riskpgs_st+"</td>"+
        		"<td>"+rList.risk_finder+"</td>"+
        		"<td>"+rList.risk_handler+"</td>"+
        		"<td>"+rgedt.toLocaleDateString()+"</td>"+
        		"<td>"+upddt.toLocaleDateString()+"</td>"+
        		"</tr>"
			});
			
			$("#dataTable tbody").html(show);
			
		},
		error:function(err){
			console.log(err);
		}
		
	});
 
}
		