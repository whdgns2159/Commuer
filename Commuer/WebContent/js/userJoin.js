var joinSub=function(){
	if(!userJoinF.userId.value){
		alert('닉네임을 입력해주세요');
		return;
	}
	if(!userJoinF.userNick.value){
		alert('닉네임을 입력해주세요');
		return;
	}
	if(!userJoinF.userPwd.value){
		alert('비밀번호를 입력해주세요');
		return;
	}
	if(!userJoinF.pwdCheck.value){
		alert('비밀번호를 확인해주세요');
		return;
	}
	if(!userJoinF.userEmail.value){
		alert('이메일을 입력해주세요');
		return;
	}
	if(!userJoinF.userTel.value){
		alert('연락처을 입력해주세요');
		return;
	}
	userJoinF.submit();
	}
