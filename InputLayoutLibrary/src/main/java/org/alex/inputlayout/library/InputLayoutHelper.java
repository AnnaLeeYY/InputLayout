package org.alex.inputlayout.library;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import org.alex.util.LogTrack;

/**
 * 作者：Alex
 * 时间：2017/3/18 10:35
 * 简述：
 */
public class InputLayoutHelper implements TextWatcher, View.OnClickListener {
    /**
     * 输入框
     */
    private EditText editText;
    /**
     * 清除按钮
     */
    private View clearView;
    /**
     * 密码可见性
     */
    private ImageView ivPwdVisibility;
    /**
     * true 明文； false 密文
     */
    private boolean isPwdVisible;

    public void onFinishInflate(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            ViewGroup.LayoutParams childAtLayoutParams = childAt.getLayoutParams();
            String name = childAtLayoutParams.getClass().getName();
            if (!(childAtLayoutParams instanceof IParamsProxy)) {
                continue;
            }
            IParamsProxy paramsProxy = (IParamsProxy) childAtLayoutParams;
            IParams params = paramsProxy.getInputParams();
            LogTrack.i(name);

            if (FunctionEnum.clearInput == params.getFunctionEnum()) {
                clearView = childAt;
            }
            if (FunctionEnum.pwdVisibility == params.getFunctionEnum() && (childAt instanceof ImageView)) {
                ivPwdVisibility = (ImageView) childAt;
            }
            if (FunctionEnum.input == params.getFunctionEnum() && (childAt instanceof EditText)) {
                editText = (EditText) childAt;
                isPwdVisible = PwdEnum.visible == params.getPwdEnum();
                editText.addTextChangedListener(this);
            }
            if (editText != null) {
                setClearVisibility(isEmpty(editText.getText()));
                setPwdVisibility(isPwdVisible);
            }
            childAt.setOnClickListener(this);
        }
    }

    @Override
    public void afterTextChanged(Editable result) {
        boolean isEmpty = isEmpty(result);
        setClearVisibility(isEmpty);
    }

    private void setClearVisibility(boolean isEmpty) {
        if (clearView == null) {
            return;
        }
        /**
         * 输入框 为空， 功能按钮，不展示
         */
        boolean isEmptyVisibility = false;
        if (clearView.getLayoutParams() instanceof IParamsProxy) {
            IParamsProxy paramsProxy = (IParamsProxy) clearView.getLayoutParams();
            IParams params = paramsProxy.getInputParams();
            isEmptyVisibility = (EmptyVisibilityEnum.invisible == params.getEmptyVisibilityEnum());
        }
        clearView.setVisibility(isEmpty && isEmptyVisibility ? View.INVISIBLE : View.VISIBLE);
        clearView.setEnabled(!isEmpty);
    }

    @Override
    public void onClick(View v) {
        if (editText == null) {
            return;
        }
        if (v == clearView) {
            editText.setText("");
            return;
        }
        if (v == ivPwdVisibility) {
            isPwdVisible = !isPwdVisible;
            setPwdVisibility(isPwdVisible);
            return;
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    private boolean isEmpty(Object text) {
        return text == null || text.toString().length() <= 0;
    }

    /**
     * 当前 密码的 可见性
     *
     * @param enable true 可见， false 不可见；默认不可见
     */
    public void setPwdVisibility(boolean enable) {
        if (ivPwdVisibility != null) {
            ivPwdVisibility.setSelected(enable);
            ivPwdVisibility.setPressed(enable);
        }
        if (editText != null) {
            editText.setTransformationMethod(enable ? HideReturnsTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance());
            editText.setSelection(editText.getText().length());
        }
    }
}
