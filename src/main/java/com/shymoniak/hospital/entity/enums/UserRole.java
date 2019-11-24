package com.shymoniak.hospital.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    ROLE_ADMIN, ROLE_USER_DOCTOR, ROLE_USER_PATIENT;


    @Override
    public String getAuthority() {
        return name();
    }
}