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
 * 时间：2017/3/26 17:24
 * 简述：
 */
@SuppressWarnings("all")
@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@IntDef(value = {PwdEnum.invisible, PwdEnum.visible})
public @interface PwdEnum {
    /**
     * 密码 可见（明文）
     */
    int visible = 1;
    /**
     * 密码 不可见（密文）
     */
    int invisible = 2;
}