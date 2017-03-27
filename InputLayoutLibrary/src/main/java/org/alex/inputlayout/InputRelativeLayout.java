package org.alex.inputlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import org.alex.inputlayout.library.IParamsProxy;
import org.alex.inputlayout.library.IParams;
import org.alex.inputlayout.library.InputLayoutHelper;
import org.alex.inputlayout.library.ParamsProxy;

/**
 * 作者：Alex
 * 时间：2017/3/18 10:35
 * 简述：
 */
public class InputRelativeLayout extends RelativeLayout {
    private InputLayoutHelper inputLayoutHelper;

    public InputRelativeLayout(Context context) {
        super(context);
        initView();
    }

    public InputRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        setTag("ignore");
        inputLayoutHelper = new InputLayoutHelper();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        inputLayoutHelper.onFinishInflate(this);
    }

    public static class LayoutParams extends RelativeLayout.LayoutParams implements IParamsProxy {
        private ParamsProxy paramsProxy;

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            paramsProxy = new ParamsProxy().obtainStyledAttributes(context, attrs);
        }

        @Override
        public IParams getInputParams() {
            return paramsProxy;
        }
    }

    @Override
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

}
