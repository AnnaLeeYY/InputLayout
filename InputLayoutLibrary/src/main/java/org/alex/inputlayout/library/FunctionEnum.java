package org.alex.inputlayout.library;

import android.support.annotation.IntDef;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：Alex
 * 时间：2017/3/26 17:23
 * 简述：
 */
@SuppressWarnings("all")
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@IntDef(value = {FunctionEnum.clearInput, FunctionEnum.input, FunctionEnum.pwdVisibility})
public @interface FunctionEnum {
    /**
     * 作为输入框
     */
    int input = 1;
    /**
     * 用于切换密码可见性
     */
    int pwdVisibility = 2;
    /**
     * 用于清空输入框
     */
    int clearInput = 3;
}
