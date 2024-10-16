package com.ipad.project.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
	

	@Size(min =3, max = 25)
	@NotEmpty(message = "아이디는 필수항목입니다.")
	private String userId;
	
	
	@NotEmpty(message = "비밀번호는 필수항목입니다.")
	private String password1;
	
	@NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
	private String password2;
	
	@Size(max = 10)
	@NotEmpty(message = "이름은 필수항목입니다.")
	private String username;
	
	@Size(max = 11)
	@NotEmpty(message = "'- 하이픈 없이 입력해주세요.'")
	private String phone;
	
	@Size(max = 30)
	@NotEmpty(message = "필수항목입니다.")
	@Email(message = "유효한 이메일 형식이 아닙니다.")
	private String email;
	
}
