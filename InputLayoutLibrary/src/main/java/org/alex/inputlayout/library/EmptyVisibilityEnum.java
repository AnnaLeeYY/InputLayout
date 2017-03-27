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
@IntDef(value = {EmptyVisibilityEnum.invisible, EmptyVisibilityEnum.visible})
public @interface EmptyVisibilityEnum {
    /**
     * 输入框内容为空， 功能按钮可见
     */
    int visible = 1;
    /**
     * 输入框内容为空， 功能按钮不可见
     */
    int invisible = 2;
}