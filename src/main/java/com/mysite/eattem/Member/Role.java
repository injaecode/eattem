package com.mysite.eattem.Member;

import lombok.Getter;

@Getter
public enum Role {
    USER("ROLE_User"), ADMIN("ROLE_ADMIN");
	
	Role(String value){
		this.value=value;
	}
    private String value;
}