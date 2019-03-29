package com.zxn.toast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zcommon.lib.SizeUtils;


/**
 * Created by zxn on 2019/3/29.
 * 自定义Toast
 */

public class ZToast {

    private static Toast currentToast;

    public static void showLong(@NonNull Context context, @NonNull CharSequence message, ZToastConfig config) {
        make(config, context, message, Toast.LENGTH_LONG).show();
    }

    public static void showLong(@NonNull Context context, @StringRes int resId, ZToastConfig config) {
        make(config, context, context.getString(resId), Toast.LENGTH_LONG).show();
    }

    public static void showShort(@NonNull Context context, @NonNull CharSequence message, ZToastConfig config) {
        make(config, context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(@NonNull Context context, @StringRes int resId, ZToastConfig config) {
        make(config, context, context.getString(resId), Toast.LENGTH_SHORT).show();
    }

    public static void showLong(@NonNull Context context, @NonNull CharSequence message) {
        make(null, context, message, Toast.LENGTH_LONG).show();
    }

    public static void showLong(@NonNull Context context, @StringRes int resId) {
        make(null, context, context.getString(resId), Toast.LENGTH_LONG).show();
    }

    public static void showShort(@NonNull Context context, @NonNull CharSequence message) {
        make(null, context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(@NonNull Context context, @StringRes int resId) {
        make(null, context, context.getString(resId), Toast.LENGTH_SHORT).show();
    }

    private static void makeText(ZToastConfig config, @NonNull Context context, @NonNull CharSequence message, int duration) {
        make(config, context, message, duration).show();
    }

    private static void makeText(@NonNull Context context, @NonNull CharSequence message, int duration) {
        make(null, context, message, duration).show();
    }

    private static Toast make(ZToastConfig config, @NonNull Context context, @NonNull CharSequence message, int duration) {
        cancelToast();
        Context mCotext = context.getApplicationContext();
        if (currentToast == null) {
            currentToast = new Toast(mCotext);
        }

        View toastLayout = ((LayoutInflater) mCotext.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.mn_toast_layout, null);

        TextView tvShowToast = (TextView) toastLayout.findViewById(R.id.tvShowToast);
        ImageView ivLeftShow = (ImageView) toastLayout.findViewById(R.id.ivLeftShow);
        LinearLayout toastBackgroundView = (LinearLayout) toastLayout.findViewById(R.id.toastBackgroundView);
        currentToast.setView(toastLayout);

        //相关配置
        if (config == null) {
            config = new ZToastConfig.Builder().build();
        }
        //ZToastConfig.Gravity toastGravity = config.toastGravity;
        int toastGravity = config.toastGravity;
        int toastTextColor = config.toastTextColor;
        float toastTextSize = config.toastTextSize;
        int toastBackgroundColor = config.toastBackgroundColor;
        float toastBackgroundCornerRadius = config.toastBackgroundCornerRadius;
        Drawable toastIcon = config.toastIcon;
        int toastBackgroundStrokeColor = config.toastBackgroundStrokeColor;
        float toastBackgroundStrokeWidth = config.toastBackgroundStrokeWidth;

        //图片的显示
        if (toastIcon == null) {
            ivLeftShow.setVisibility(View.GONE);
        } else {
            ivLeftShow.setVisibility(View.VISIBLE);
            ivLeftShow.setImageDrawable(toastIcon);
        }
        //文字
        tvShowToast.setTextColor(toastTextColor);
        tvShowToast.setTextSize(TypedValue.COMPLEX_UNIT_SP, toastTextSize);
        tvShowToast.setText(message);
        //背景色和圆角
        GradientDrawable myGrad = new GradientDrawable();
        myGrad.setCornerRadius(SizeUtils.dp2px(mCotext, toastBackgroundCornerRadius));
        myGrad.setColor(toastBackgroundColor);
        myGrad.setStroke(SizeUtils.dp2px(mCotext, toastBackgroundStrokeWidth), toastBackgroundStrokeColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            toastBackgroundView.setBackground(myGrad);
        } else {
            toastBackgroundView.setBackgroundDrawable(myGrad);
        }
        toastBackgroundView.setPadding(
                SizeUtils.dp2px(mCotext, config.paddingLeft),
                SizeUtils.dp2px(mCotext, config.paddingTop),
                SizeUtils.dp2px(mCotext, config.paddingRight),
                SizeUtils.dp2px(mCotext, config.paddingBottom)
        );

        //显示位置
        if (toastGravity == ZToastConfig.CENTRE) {
            currentToast.setGravity(android.view.Gravity.CENTER, 0, 0);
        } else if (toastGravity == ZToastConfig.TOP) {
            currentToast.setGravity(Gravity.TOP, 0, 0);
        } else {
            currentToast.setGravity(android.view.Gravity.BOTTOM, 0, SizeUtils.dp2px(mCotext, 80));
        }
        //图片宽高
        if (config.imgWidth > 0 && config.imgHeight > 0) {
            ViewGroup.LayoutParams layoutParams = ivLeftShow.getLayoutParams();
            layoutParams.width = SizeUtils.dp2px(mCotext, config.imgWidth);
            layoutParams.height = SizeUtils.dp2px(mCotext, config.imgHeight);
            ivLeftShow.setLayoutParams(layoutParams);
        }
        //时间
        currentToast.setDuration(duration);
        return currentToast;
    }

    /**
     * 取消Toast
     */
    public static void cancelToast() {
        if (currentToast != null) {
            currentToast.cancel();
            currentToast = null;
        }
    }

}
