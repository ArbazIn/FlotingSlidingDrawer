package com.tech.flotingnavigation.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by arbaz on 19/4/17.
 */

class NoClickThroughFrameLayout extends BuildLayerFrameLayout {

    public NoClickThroughFrameLayout(Context context) {
        super(context);
    }

    public NoClickThroughFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoClickThroughFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
