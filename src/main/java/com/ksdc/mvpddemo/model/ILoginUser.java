package com.ksdc.mvpddemo.model;

import com.ksdc.mvpddemo.listen.OnLoginListener;

/**
 * Created by liangkun on 2017/6/22 0022.
 */

public interface ILoginUser {
    void login(String username, String password, OnLoginListener loginListener);
}
