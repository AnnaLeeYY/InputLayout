package org.alex.inputlayout.library;

/**
 * 作者：Alex
 * 时间：2017/3/27 10:05
 * 简述：
 */
public interface IParams {
    @EmptyVisibilityEnum
    int getEmptyVisibilityEnum();

    @FunctionEnum
    int getFunctionEnum();

    @PwdEnum
    int getPwdEnum();
}
