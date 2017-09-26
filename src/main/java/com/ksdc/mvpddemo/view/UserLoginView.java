package com.ksdc.mvpddemo.view;

import com.ksdc.mvpddemo.bean.UserBean;

/**
 * Created by hankkin on 2017/6/19.
 */

public interface UserLoginView extends BaseView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void toMainActivity(UserBean user);
    /**
     * 显示loading框
     */
    void showProgress();

    /**
     * 隐藏loading框
     */
    void hideProgress();

}
