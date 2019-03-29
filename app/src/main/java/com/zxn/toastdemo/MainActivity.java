package com.zxn.toastdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zxn.toast.ZToast;
import com.zxn.toast.ZToastConfig;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String text01 = "从前有坐山,山上有坐庙,庙里有个老和尚在讲故事,讲的什么啊,从前有座山,山里有座庙,庙里有个盆,盆里有个锅,锅里有个碗,碗里有个匙,匙里有个花生仁,我吃了,你谗了,我的故事讲完了.";
    private Context mContext;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    private Button btn13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initViews();
    }


    private void initViews() {
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        btn10 = (Button) findViewById(R.id.btn10);
        btn11 = (Button) findViewById(R.id.btn11);
        btn12 = (Button) findViewById(R.id.btn12);
        btn13 = (Button) findViewById(R.id.btn13);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn2:
                ZToast.showShort(mContext, R.string.text_01, new ZToastConfig.Builder()
                        .setGravity(ZToastConfig.TOP)
                        .build());
                break;
            case R.id.btn3:
                ZToast.showLong(mContext, R.string.text_01, new ZToastConfig.Builder()
                        .setGravity(ZToastConfig.TOP)
                        .build());
                break;
            case R.id.btn4:
                ZToast.showShort(mContext, R.string.text_01);
                break;
            case R.id.btn5:
                ZToast.showLong(mContext, R.string.text_01);
                break;
            case R.id.btn6:
                ZToast.showShort(mContext, text01, new ZToastConfig.Builder()
                        .setGravity(ZToastConfig.TOP)
                        .build());
                break;
            case R.id.btn7:
                ZToast.showLong(mContext, text01);
                break;
            case R.id.btn8:
                ZToastConfig config = new ZToastConfig.Builder()
                        .setGravity(ZToastConfig.CENTRE)
                        .build();
                ZToast.showShort(mContext, text01, config);
                break;
            case R.id.btn9:
                ZToast.showShort(mContext, text01, new ZToastConfig.Builder()
                        .setGravity(ZToastConfig.BOTTOM)
                        .build());
                break;
            case R.id.btn10:
                showToast();
                break;
            case R.id.btn11:
                showToastCustom();
                break;
            case R.id.btn12:
                showToastCustom2();
                break;
            case R.id.btn13:
                showToastCustom3();
                break;
        }
    }


    private int getMyColor(int colorID) {
        return mContext.getResources().getColor(colorID);
    }

    /**
     * --------------------ZToast start -------------------
     */

    private void showToastCustom3() {
        ZToastConfig config = new ZToastConfig.Builder()
                .setBackgroundStrokeColor(Color.YELLOW)
                .setBackgroundStrokeWidth(1)
                .setBackgroundCornerRadius(20)
                .build();
        ZToast.showShort(mContext, text01, config);
    }

    private void showToastCustom2() {
        ZToastConfig config = new ZToastConfig.Builder()
                .setGravity(ZToastConfig.CENTRE)
                .setTextColor(Color.MAGENTA)
                .setBackgroundColor(getMyColor(R.color.colorDialogTest))
                .setToastIcon(mContext.getResources().getDrawable(R.drawable.mn_icon_dialog_ok))
                .setBackgroundCornerRadius(10)
                .setTextSize(13)
                .setImgWidthAndHeight(40, 40)
                .setPadding(20, 20, 20, 20)
                .build();
        ZToast.showShort(mContext, text01, config);
    }

    private void showToastCustom() {
        ZToastConfig config = new ZToastConfig.Builder()
                .setTextColor(getMyColor(R.color.white))
                .setBackgroundColor(getMyColor(R.color.colorDialogTest))
                .setToastIcon(mContext.getResources().getDrawable(R.drawable.mn_icon_dialog_ok))
                .setTextSize(18)
                .build();
        ZToast.showShort(mContext, "欢迎使用自定义Toast", config);

    }

    private void showToast() {
        ZToast.showShort(mContext, "我是默认Toast");
    }


}
