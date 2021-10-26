/**
 * 
 */
var sendBtn = $(".sendBtn");
var chatBox = $(".chat-area");
var messageInput = $(".messageInput");
var message = null;
var sock = null;
var url = null;
var client = null;
var roomNum = null;
var emp_cd_pk = null;
var emp_name = null;
var dept_name = null;
var send_dt = null;
var tmpList = [];

var main = {
	// 채팅방 선택
	enterRoom: function(e) {
		$.ajax({
			type: "get",
			async: false,
			url: "/community/chatRoom",
			data: "chtr_cd_pk=" + $(".chat-groups").eq(e - 1).val(),
			dataType: "json",
			success: function(data) {
				$(".chatRoomTitle").text(data.chtr_nm);
				$("#nowChat").val(data.chtr_cd_pk);
				// 연결 초기화
				if (client != null) {
					client.disconnect();
				}
				chatBox.empty();
				// 대화 시작
				emp_cd_pk = $("#nowEmpNum").text();
				roomNum = $("#nowChat").val();
				console.log("start함수 시작 : 방번호:" + roomNum);
				main.readHistory(roomNum); //이전 대화 내용 불러오기
				sock = new SockJS("/broadcast");
				url = "/sub/chat/room/" + roomNum;
				client = Stomp.over(sock);
				// connection 되면 실행
				client.connect({}, function() {
					//send(path, header, message)
					//client.send("/pub/broadcast",{},JSON.stringify({chtr_cd_pk:roomNum, emp_cd_pk:text-0002}));
					// subscribe(path, callback)로 메시지 받기
					client.subscribe(url, function(chat) {
						var content = JSON.parse(chat.body);
						var show = "";
						//chatBox.append("<div>" + content.chtr_cont + "(" + content.emp_cd_pk + ")</div>");
						if(content.emp_cd_pk == "absent") {
							show+="<div style='margin:0 auto; margin-bottom:8px; text-align:center; background-color:#dae1e6; padding:4px 5px'><span>"+content.chtr_cont+"</span></div>";
						} else {
							if (content.emp_cd_pk != emp_cd_pk) {
							show += "<div class='chat-indiv'>";
							} else {
							show += "<div class='chat-indiv chat-me'>";
							}
							show += "<img src='/img/undraw_profile_1.svg' id='chat-ij-profile' />";
							show += "<div id='chat-ij-content'>";
							show += "<div class='chat-ij-info'>";
							show += "<h5 id='chat-ij-name'><span>" + content.emp_name + "(" + content.dept_name + ")</span></h5>";
							show += "<h5 id='chat-ij-date'><span>" + content.send_dt + "</span></h5></div>";
							show += "<h5 id='chat-ij-text'><span>" + content.chtr_cont + "</span></h5></div></div>";
						}
						chatBox.append(show).stop().animate({ scrollTop: chatBox[0].scrollHeight }, 1000);
					});
				});
			},
			error: function(err) {
				console.log(err);
			}
		});
	},
	//메시지 전송
	sendMsg: function() {
		message = messageInput.val();
		emp_name = $("#nowEmpName").text();
		dept_name = $("#nowEmpDept").text();
		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth();
		var day = today.getDate();
		var hour = today.getHours();
		var min = today.getMinutes();
		send_dt = year + "-" + (month + 1) + "-" + day + " " + hour + ":" + min;
		client.send("/pub/broadcast", {}, JSON.stringify({ chtr_cd_pk: roomNum, chtr_cont: message, 
			emp_cd_pk: emp_cd_pk, emp_name: emp_name, dept_name: dept_name,
			send_dt:send_dt }));
		//메시지 저장
		main.insertChatLog(roomNum, emp_cd_pk, message);
		messageInput.val("");
	},
	// 채팅 내역 저장
	insertChatLog: function(chtr_cd_pk, sender, cont){
		$.ajax({
			type:"get",
			url:"/community/insertChatLog",
			data:"chtr_cd_pk="+chtr_cd_pk+"&clog_sender="+sender+"&clog_cont="+cont,
			contentType: "application/json; charset=utf-8",
			success:function(){
				console.log("저장!");
			},
			error:function(err){
				console.log(err);
			}
		});
	},
	// 이전 기록 조회
	readHistory: function(roomNum){
		$.ajax({
			type:"get",
			url:"/community/readHistory",
			data:"chtr_cd_pk="+roomNum+"&emp_cd_pk="+emp_cd_pk,
			dataType:"json",
			success:function(data){
				$.each(data, function(idx, log){
					var show = "";
					if(log.clog_sender== "absent") {
						show+="<div style='margin:0 auto; margin-bottom:8px; text-align:center; background-color:#dae1e6; padding:4px 5px'><span>"+log.clog_cont+"</span></div>";
					} else{
						if (log.clog_sender != emp_cd_pk) {
						show += "<div class='chat-indiv'>";
						} else {
							show += "<div class='chat-indiv chat-me'>";
						}
						show += "<img src='/img/undraw_profile_1.svg' id='chat-ij-profile' />";
						show += "<div id='chat-ij-content'>";
						show += "<div class='chat-ij-info'>";
						show += "<h5 id='chat-ij-name'><span>" + log.emp_name + "(" + log.dept_name + ")</span></h5>";
						show += "<h5 id='chat-ij-date'><span>" + log.clog_dt + "</span></h5></div>";
						show += "<h5 id='chat-ij-text'><span>" + log.clog_cont + "</span></h5></div></div>";
					}
					chatBox.append(show);
				});
				// 하단으로 스크롤
				chatBox.scrollTop(chatBox[0].scrollHeight);
			},
			error:function(err){
				console.log(err);
			}
		});
		$(".chat-area").scrollTop(200);
	},
	// 채팅방 사용자 조회
	chatUserList: function() {
		$.ajax({
			type: "get",
			url: "/community/chatUserList",
			data: "chtr_cd_pk=" + $("#nowChat").val(),
			dataType: "json",
			success: function(data) {
				var show = "";
				$.each(data, function(idx, emp) {
					show += "<div class='modal-body'>";
					show += "<img src='/img/undraw_profile_1.svg' id='chat-ij-profile'/>";
					show += "<span class='user-name'>" + emp.emp_name + "(" + emp.dept_name + ")" + "</span>";
					//show += "<input type='checkbox' name='emp_cd_pk' value='" + emp.emp_cd_pk + "' id='user-select'>";
					show += "</div>";
				});
				$("#memChkModal .chatUserList").html(show);
			},
			error: function(err) {
				console.log(err);
			}
		});
	},
	// 채팅방 멤버 추가 시 기존 사용자 추가 방지
	addUserList: function() {
		$.ajax({
			type: "get",
			url: "/community/chatUserList",
			data: "chtr_cd_pk=" + $("#nowChat").val(),
			dataType: "json",
			success: function(data) {
				var nowList = [];
				$.each(data, function(idx, emp) {
					nowList[idx] = emp.emp_cd_pk;
				});
				var filter = $("#addMemberForm .schOption").val();
				$.ajax({
					type: "get",
					async: false,
					url: "/community/empList",
					data: "filter=" + filter + "&" + filter + "=" + $("#addMemberForm .searchTab").val(),
					dataType: "json",
					success: function(data) {
						var show = "";
						$.each(data, function(idx, emp) {
							show += "<div class='modal-body'>";
							show += "<img src='/img/undraw_profile_1.svg' id='chat-ij-profile'/>";
							show += "<span class='user-name'>" + emp.emp_name + "(" + emp.dept_name + ")" + "</span>";
							if (nowList.indexOf(emp.emp_cd_pk) > -1) {
								show += "<input type='checkbox' disabled name='emp_cd_pk' value='" + emp.emp_cd_pk + "' id='user-select'>";
							} else if(tmpList.indexOf(emp.emp_cd_pk)>-1){
								show += "<input type='checkbox' checked name='emp_cd_pk' value='" + emp.emp_cd_pk + "' id='user-select'>";
							} else {
								show += "<input type='checkbox' name='emp_cd_pk' value='" + emp.emp_cd_pk + "' id='user-select'>";
							}
							show += "</div>";
						});
						$("#addMemberForm .empList").html(show);
						// 체크박스 유지
						$("input:checkbox[name='emp_cd_pk']").change(function(){
							var emp = $(this).val();
							if($(this).is(":checked")){
								tmpList.push(emp);
							} else if(tmpList.indexOf(emp)>-1){
								tmpList.splice(tmpList.indexOf(emp),1);
							}
						});
					}
					,
					error: function(err) {
						console.log(err);
					}
				});
			},
			error: function(err) {
				console.log(err);
			}
		});
	},
	// 채팅방 이름 변경
	roomNameChange: function() {
		$.ajax({
			type: "get",
			url: "/community/updateTitle",
			data: "chtr_nm=" + $("#modifiedGroupName").val() + "&chtr_cd_pk=" + $("#nowChat").val(),
			dataType: "json",
			success: function(data) {
				$(".chatRoomTitle").text(data.chtr_nm);
				$(".chat-groups").each(function(idx) {
					var chtr_cd_pk = $(this).val();
					if (chtr_cd_pk == $("#nowChat").val()) {
						$(this).children().first().text(data.chtr_nm);
					}
				});
			},
			error: function(err) {
				console.log(err);
			}
		});
	},
	// 사용자 검색 조회
	list: function(form, filter) {
		$.ajax({
			type: "get",
			async: false,
			url: "/community/empList",
			data: "filter=" + $("#" + form + " .schOption").val() + "&" + filter + "=" + $("#" + form + " .searchTab").val(),
			dataType: "json",
			success: function(data) {
				var show = "";
				var nowEmpNum = $("#nowEmpNum").text();
				$.each(data, function(idx, emp) {
					show += "<div class='modal-body'>";
					show += "<img src='/img/undraw_profile_1.svg' id='chat-ij-profile'/>";
					show += "<span class='user-name'>" + emp.emp_name + "(" + emp.dept_name + ")" + "</span>";
					if(emp.emp_cd_pk == nowEmpNum){
						show += "<input type='checkbox' disabled name='emp_cd_pk' value='" + emp.emp_cd_pk + "' id='user-select'>";
					}else if(tmpList.indexOf(emp.emp_cd_pk)>-1){
						show += "<input type='checkbox' checked name='emp_cd_pk' value='" + emp.emp_cd_pk + "' id='user-select'>";
					}else{
						show += "<input type='checkbox' name='emp_cd_pk' value='" + emp.emp_cd_pk + "' id='user-select'>";
					}
					show += "</div>";
				});
				$("#" + form + " .empList").html(show);
				// 체크박스 유지
				$("input:checkbox[name='emp_cd_pk']").change(function(){
					var emp = $(this).val();
					if($(this).is(":checked")){
						tmpList.push(emp);
					} else if(tmpList.indexOf(emp)>-1){
						tmpList.splice(tmpList.indexOf(emp),1);
					}
				});
			}
			,
			error: function(err) {
				console.log(err);
			}
		});
	},
	// 채팅방 나가기
	exitChat: function(){
		emp_name = $("#nowEmpName").text();
		dept_name = $("#nowEmpDept").text();
		var comment = emp_name+"("+dept_name+")님이 대화방에서 나갔습니다.";
		client.send("/pub/broadcast", {}, JSON.stringify({ chtr_cd_pk: roomNum, chtr_cont: comment, 
			emp_cd_pk: "absent", emp_name: emp_name, dept_name: dept_name,
			send_dt:send_dt }));
		//메시지 저장
		main.insertChatLog(roomNum, "absent", comment);
	},
	// 멤버 추가시 메시지
	noticeAddMember:function(){
		var comment = "새로운 멤버가 초대되었습니다.";
		client.send("/pub/broadcast", {}, JSON.stringify({ chtr_cd_pk: roomNum, chtr_cont: comment, 
			emp_cd_pk: "absent", emp_name: emp_name, dept_name: dept_name,
			send_dt:send_dt }));
		//메시지 저장
		main.insertChatLog(roomNum, "absent", comment);
	}

}

// 채팅방 선택 입장
$(".chat-groups").on("click", function() {
	$("#chatShow").css("visibility", "visible");
	main.enterRoom($(this).index());
});

// 메시지 전송
$(".sendBtn").on("click", function() {
	main.sendMsg();
});
$(".messageInput").on("keyup", function(e) {
	if(e.keyCode==13){
		main.sendMsg();
	}
});

// 채팅방 사용자 조회
$("#chatUserList").on("click", function() {
	main.chatUserList();
});

// 채팅방 추가 시 기존 사용자 추가 방지
$("#addMemberForm .searchTab").on("keyup", function() {
	main.addUserList();
});

// 채팅방 이름 변경
$("#uptRoomNameBtn").on("click", function() {
	var uptName = $("#modifiedGroupName").val();
	if (uptName == "") {
		alert("변경할 채팅방 이름을 입력하세요");
	} else {
		main.roomNameChange();
		$("#modifyGroupModal").modal("hide");
	}
});

// 사용자 검색 필터
function schOption(e) {
	var val = document.querySelector(".searchTab");
	val.setAttribute("name", e.value);
	console.log(val.getAttribute("name"));
}
// 방 나가기
$("#exitChatValid").on("click",function(){
	location.href="/community/exitChat?chtr_cd_pk="+roomNum;
	main.exitChat();
});


//checkbox, radio 유효성 검사
function checkValid() {
	console.log("길이:"+tmpList.length);
	if(tmpList.length==0){
		return false;
	} else{
		return true;
	}
}


//추가버튼 클릭 시 form 초기화
$(".btn-addChat, .btn-addMem").click(function() {
	$(":checkbox:checked").prop("checked", false);
	$(":radio:checked").prop("checked", false);
	$(".searchTab").val("");
	$(".schOption option:even").prop("selected", true);
});
//사용자 검색
$("#groupForm .searchTab").on("keyup", function() {
	var form = "groupForm";
	var filter = $("#" + form + " .schOption").val();
	main.list(form, filter);
});

$("#addMemberForm .searchTab").on("keyup", function() {
	var form = "addMemberForm";
	var filter = $("#" + form + " .schOption").val();
	main.list(form, filter);
});

//취소 시 list 초기화
$(".listEmpty").click(function(){
	tmpList = [];
});

//대화추가
$("#groupForm #confirm").click(function(){
	if(checkValid()){
		location.href="/community/new?tmpList="+tmpList;
	}else{
		alert("사용자를 선택하세요");
	}
});

//사용자추가
$("#addMemberForm #confirm").click(function(){
	var roomNum = $("#nowChat").val();
	if(checkValid()){
		main.noticeAddMember();
		location.href="/community/addUser?tmpList="+tmpList+"&roomNum="+roomNum;
	}else{
		alert("사용자를 선택하세요");
	}
});

