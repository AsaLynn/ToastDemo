package com.zxn.toast;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntDef;
import android.support.annotation.IntegerRes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zxn on 2019/3/29.
 * Toast自定义相关参数
 */
public class ZToastConfig {

    public static final int BOTTOM = 0;
    public static final int CENTRE = 1;
    public static final int TOP = 2;

    @IntDef({BOTTOM, CENTRE, TOP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityType {
    }


//    @Deprecated
//    public enum Gravity {
//        @Deprecated
//        CENTRE,
//        @Deprecated
//        BOTTOM,
//        @Deprecated
//        TOP
//    }

    public float toastTextSize = 13;
    public int toastTextColor = Color.parseColor("#FFFFFFFF");
    public int toastBackgroundColor = Color.parseColor("#b2000000");
    public float toastBackgroundCornerRadius = 4.0f;
    public float toastBackgroundStrokeWidth = 0.0f;
    public int toastBackgroundStrokeColor = Color.parseColor("#00000000");
    //public Gravity toastGravity = Gravity.BOTTOM;
    public int toastGravity = BOTTOM;
    public Drawable toastIcon = null;
    //布局的Padding--int left, int top, int right, int bottom
    public int paddingLeft = 20;
    public int paddingTop = 12;
    public int paddingRight = 20;
    public int paddingBottom = 12;
    //图片宽高
    public int imgWidth = 20;
    public int imgHeight = 20;


    private ZToastConfig() {
    }

    public static class Builder {

        private ZToastConfig mToastConfig = null;

        public Builder() {
            mToastConfig = new ZToastConfig();
        }

        public ZToastConfig build() {
            return mToastConfig;
        }

        public Builder setTextColor(@ColorInt int textColor) {
            mToastConfig.toastTextColor = textColor;
            return this;
        }

        public Builder setTextSize(float textSize) {
            mToastConfig.toastTextSize = textSize;
            return this;
        }

        public Builder setBackgroundColor(@ColorInt int backgroundColor) {
            mToastConfig.toastBackgroundColor = backgroundColor;
            return this;
        }

        public Builder setBackgroundCornerRadius(float radius) {
            mToastConfig.toastBackgroundCornerRadius = radius;
            return this;
        }

        public Builder setGravity(@GravityType int toastGravity) {
            mToastConfig.toastGravity = toastGravity;
            return this;
        }

        public Builder setToastIcon(Drawable ToastIcon) {
            mToastConfig.toastIcon = ToastIcon;
            return this;
        }

        public Builder setBackgroundStrokeWidth(float width) {
            mToastConfig.toastBackgroundStrokeWidth = width;
            return this;
        }

        public Builder setBackgroundStrokeColor(@ColorInt int strokeColor) {
            mToastConfig.toastBackgroundStrokeColor = strokeColor;
            return this;
        }

        public Builder setImgWidthAndHeight(int imgWidth, int imgHeight) {
            mToastConfig.imgWidth = imgWidth;
            mToastConfig.imgHeight = imgHeight;
            return this;
        }

        public Builder setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
            mToastConfig.paddingLeft = paddingLeft;
            mToastConfig.paddingTop = paddingTop;
            mToastConfig.paddingRight = paddingRight;
            mToastConfig.paddingBottom = paddingBottom;
            return this;
        }

    }

}
