package com.ljj.ljjgame.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ljj.ljjgame.R;

public class DialogUtil {
    public static DialogUtil dialogUtil;

    public static DialogUtil getInstance() {
        if (dialogUtil == null) {
            synchronized (DialogUtil.class) {
                if (dialogUtil == null) {
                    dialogUtil = new DialogUtil();
                }
            }
        }
        return dialogUtil;
    }

    public  void showDialog(Context context){
        // 以特定的风格创建一个dialog
        Dialog  dialog = new Dialog(context, R.style.MyDialog);
        // 加载dialog布局view
        View purchase = LayoutInflater.from(context).inflate(R.layout.dialog_wite, null);
        initWiteViews(purchase, dialog);
        // 设置外部点击 取消dialog
        dialog.setCancelable(true);
        dialog.setContentView(purchase);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.show();

//        WindowManager m = context.getWindowManager();
//        Display d = m.getDefaultDisplay();  //为获取屏幕宽、高
        android.view.WindowManager.LayoutParams p = dialog.getWindow().getAttributes();  //获取对话框当前的参数值

        LogUtil.e("height:" + p.height);
        LogUtil.e("width:" + p.width);
        int width = BaseUtil.getInstance().width;
        int height = BaseUtil.getInstance().height;
        p.height = height/3;   //高度设置为屏幕的0.3
        p.width = width/2;   //高度设置为屏幕的0.3
//        p.height = (int) (d.getHeight() * 0.3);   //高度设置为屏幕的0.3
//        p.width = (int) (d.getWidth() * 0.5);    //宽度设置为屏幕的0.5
        dialog.getWindow().setAttributes(p);     //设置生效
    }

    private void initWiteViews(View layout, final Dialog dialog) {
//        LinearLayout linear = layout.findViewById(R.id.dlg_content);
//        linear.setLayoutParams(new LinearLayout.LayoutParams(500,300));
        TextView textView = layout.findViewById(R.id.device_name_text);
        TextView cancel = layout.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
//                alert(GateWayActivity.this);
            }
        });
    }

}
