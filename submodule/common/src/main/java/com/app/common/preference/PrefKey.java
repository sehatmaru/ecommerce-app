package com.app.common.preference;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface PrefKey {
    String TOKEN = "token";
    String USERNAME = "username";
}
