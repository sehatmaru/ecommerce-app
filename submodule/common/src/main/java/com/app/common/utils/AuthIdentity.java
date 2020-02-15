package com.app.common.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AuthIdentity {
    String EMAIL = "nakruma@gmail.com";
    String PASSWORD = "000000";
}
