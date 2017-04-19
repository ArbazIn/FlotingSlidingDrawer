package com.tech.flotingnavigation.Utils;

import android.view.animation.Interpolator;

/**
 * Created by arbaz on 19/4/17.
 */

class SmoothInterpolator implements Interpolator {

    @Override
    public float getInterpolation(float t) {
        t -= 1.0f;
        return t * t * t * t * t + 1.0f;
    }
}
