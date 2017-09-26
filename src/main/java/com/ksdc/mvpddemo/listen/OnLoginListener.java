package com.ksdc.mvpddemo.listen;

import com.ksdc.mvpddemo.bean.UserBean;

/**
 * Created by zhy on 15/6/19.
 */
public interface OnLoginListener {
    void loginSuccess(UserBean user);

    void loginFailed();
}
