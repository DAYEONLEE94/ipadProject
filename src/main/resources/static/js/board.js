 function showDeleteModal() {
        var password = prompt("비밀번호를 입력해주세요:");
        if (password != null && password !== "") {
            // 비밀번호가 입력되었을 때, 서버로 전송
            var form = document.getElementById("deleteForm");
            form.password.value = password;
            console.log(password);
            form.submit();
        } else {
            alert("비밀번호를 입력해주세요.");
        }
    }