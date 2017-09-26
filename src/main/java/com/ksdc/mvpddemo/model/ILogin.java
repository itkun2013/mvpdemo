package com.ksdc.mvpddemo.model;

import com.ksdc.mvpddemo.bean.UserBean;
import com.ksdc.mvpddemo.listen.OnLoginListener;

/**
 * Created by liangkun on 2017/6/22 0022.
 */

public class ILogin implements ILoginUser {
    @Override
    public void login(final String username, final String password, final OnLoginListener
            loginListener) {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("lk".equals(username) && "123".equals(password)) {
                    UserBean user = new UserBean();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
