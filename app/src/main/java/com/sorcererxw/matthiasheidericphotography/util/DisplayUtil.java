package com.sorcererxw.matthiasheidericphotography.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Sorcerer on 2016/4/28.
 */
public class DisplayUtil {

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int sp2px(Context context, float sp) {
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                sp,
                context.getResources().getDisplayMetrics()
        );
        return px;
    }

}
