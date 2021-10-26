// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");

var pieData = [];
var pieLabels = [];
var colors_pie = ['#36b9cc','#4e73df', '#1cc88a'];
var pieColors = [];

$.ajax({
    type: 'GET',
    url: '/api/summary/' + $('#projectId').val() + '/task/chart',
    dataType: 'json',	
    contentType: 'application/json; charset=utf-8',
}).done(function (dataList) {
	
	if(dataList.length == 0){
		$("#pieChartDiv").html("태스크가 존재하지 않습니다.");
	}else{
		for(var i=0; i<dataList.length; i++){
		pieData.push(dataList[i].count);
		pieLabels.push(dataList[i].task_state);
		if(dataList[i].task_state == '시작전'){
			pieColors.push(colors_pie[0]);
		}else if(dataList[i].task_state == '진행중'){
			pieColors.push(colors_pie[1]);
		}else{
			pieColors.push(colors_pie[2]);
		}
	}
	
	var myPieChart = new Chart(ctx, {
	  type: 'doughnut',
	  data: {
	    labels: pieLabels,
	    datasets: [{
	      data: pieData,
	      backgroundColor: pieColors,
	      hoverBorderColor: "rgba(234, 236, 244, 1)",
	    }],
	  },
	  options: {
	    maintainAspectRatio: false,
	    tooltips: {
	      backgroundColor: "rgb(255,255,255)",
	      bodyFontColor: "#858796",
	      borderColor: '#dddfeb',
	      borderWidth: 1,
	      xPadding: 15,
	      yPadding: 15,
	      displayColors: false,
	      caretPadding: 10,
	    },
	    legend: {
	      display: true
	    },
	    cutoutPercentage: 70,
	  },
	});
	}

}).fail(function (error) {
	//console.log(data);
    alert(JSON.stringify(error));
});


