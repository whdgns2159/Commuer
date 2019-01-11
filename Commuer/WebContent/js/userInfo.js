var adjustSub=function(){
		if(!userAdjustF.userNick.value){
			alert('닉네임을 입력해주세요');
			return;
		}
		if(!userAdjustF.userPwd.value){
			alert('비밀번호를 입력해주세요');
			return;
		}
		if(!userAdjustF.pwdCheck.value){
			alert('비밀번호를 확인해주세요');
			return;
		}
		if(!userAdjustF.userEmail.value){
			alert('이메일을 입력해주세요');
			return;
		}
		if(!userAdjustF.userTel.value){
			alert('연락처을 입력해주세요');
			return;
		}
		userAdjustF.submit();
 	}

