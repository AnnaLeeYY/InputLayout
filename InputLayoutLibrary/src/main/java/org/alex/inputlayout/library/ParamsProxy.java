package org.alex.inputlayout.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import org.alex.inputlayout.R;

/**
 * 作者：Alex
 * 时间：2017/3/27 21:02
 * 简述：
 */
public class ParamsProxy implements IParams {
    private int functionEnum;
    private int pwdEnum;
    private int emptyVisibilityEnum;

    public ParamsProxy obtainStyledAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.InputLayout);
        functionEnum = typedArray.getInteger(R.styleable.InputLayout_input_function_enum, FunctionEnum.input);
        pwdEnum = typedArray.getInteger(R.styleable.InputLayout_input_pwd_enum, PwdEnum.visible);
        emptyVisibilityEnum = typedArray.getInteger(R.styleable.InputLayout_input_empty_visibility_enum, EmptyVisibilityEnum.visible);
        typedArray.recycle();
        return this;
    }

    @Override
    @EmptyVisibilityEnum
    public int getEmptyVisibilityEnum() {
        return emptyVisibilityEnum;
    }

    @Override
    @FunctionEnum
    public int getFunctionEnum() {
        return functionEnum;
    }

    @Override
    public int getPwdEnum() {
        return pwdEnum;
    }
}
