package com.ksdc.mvpddemo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 避免用户重复操作，频繁弹出toast
 * Created by liangkun on 2017/3/9 0009.
 */
public class ToastUtils {
    private static Toast toast;

    /**
     *
     * @param context 上下文
     * @param message 消息
     */
    public static void toastContent(Context context, String message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }
}

