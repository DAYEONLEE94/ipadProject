function check() {
	var isCheck1 = document.getElementById("isCheck1");
	var isCheck2 = document.getElementById("isCheck2");

	if (isCheck1.checked && isCheck2.checked) {
		document.form.submit();

	} else {
		alert("개인정보 약관에 동의하셔야 합니다.");
	}

}

function loginCheck() {

	if (document.frm.id.value.length == 0) {
		alert("아이디를 써주세요");
		document.frm.id.focus();
		return false;
	}
	if (document.frm.pass1.value == "") {
		alert("암호는 반드시 입력하셔야 합니다.");
		document.frm.pass1.focus();
		return false;
	}

	if (document.frm.pass1.value != null) {
		btnLogout.onclick = function() {
			location.href = "main.do?id=logout";
		}
	}
	return true;
}

//회원가입시 아이디 중복체크
function idCheck(){
	console.log('idCheck function called');
	if(document.frm.id.value==""){
		alert('아이디를 입력하세요.');
		document.frm.id.focus();
		return;
	}
	var url ="idCheck.do?id=" + document.frm.id.value;
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");  
	//창틀만 만들어놓고 좀 이따가 forward를 이용해 idcheck.jsp로 채운다.
	
}

//아이디 중복 검사 완료 된 아이디 값을 넘김
function idok(id) {
	opener.frm.id.value = document.frm.id.value;
	opener.frm.reid.value = document.frm.id.value;  //중복 검사를 한 아이디인지 아닌지를 저장
	self.close();
}

function joinCheck() {
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.id.value.length == 0) {
		alert("아이디를 써주세요");
		frm.id.focus();
		return false;
	}
	if (document.frm.id.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.id.focus();
		return false;
	}
	if (document.frm.pass1.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pass1.focus();
		return false;
	}
	if (document.frm.pass1.value != document.frm.pass2.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pass1.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.id.focus();
		return false;
	}
	if (document.frm.email.value.length == 0) {
		alert("이메일을 입력해주세요.");
		frm.email.focus();
		return false;
	}if (document.frm.map.value.length == 0) {
		alert("희망지역을 선택해주세요.");
		frm.map.focus();
		return false;
	}if (document.frm.year.value.length == 0) {
		alert("생년월일을 선택해주세요.");
		frm.year.focus();
		return false;
	}
	return true;
}


function mypageClick() {
    // 각각의 mypageButton 클래스를 가진 요소에 대해 클릭 이벤트 리스너를 추가
    document.querySelectorAll('.mypageButton').forEach(function(btn) {
        btn.addEventListener('click', function() {
        	
        	
            // data-href 속성에 저장된 URL로 페이지 이동
            var href = this.getAttribute('data-href');
            if (href) {
                window.location.href = href;
            }
        });
    });
}



