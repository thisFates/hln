package com.keeplive.hln.utils;


import com.keeplive.hln.App;

public class DpPxUtil {

    private static float density;
    private static float scaledDensity;
    static {
        density = App.applicationContext.getResources().getDisplayMetrics().density;
        scaledDensity = App.applicationContext.getResources().getDisplayMetrics().scaledDensity;
    }
    public static int getPxByDp(float dipValue){
        return (int) (dipValue*density+0.5f);
    }

    public static int getDpByPx(float pxValue){
        return (int) (pxValue/density+0.5f);
    }

    public static int getPxBySp(float spValue) {
        return (int) (spValue * scaledDensity + 0.5f);
    }

    public static int getSpByPx(float pxValue) {
        return (int) (pxValue / scaledDensity + 0.5f);
    }


    public static float getPxByDp_F(float dipValue){
        return dipValue*density+0.5f;
    }

    public static float getDpByPx_F(float pxValue){
        return pxValue/density+0.5f;
    }

}
