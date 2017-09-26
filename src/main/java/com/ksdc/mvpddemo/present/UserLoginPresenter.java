package com.ksdc.mvpddemo.present;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.ksdc.mvpddemo.bean.UserBean;
import com.ksdc.mvpddemo.listen.OnLoginListener;
import com.ksdc.mvpddemo.model.ILogin;
import com.ksdc.mvpddemo.view.UserLoginView;

/**
 * Created by hankkin on 2017/6/19.
 */

public class UserLoginPresenter extends BasePresent<UserLoginView> {
    private ILogin userBiz;
    private UserLoginView userLoginView;
    private Context context;
    private Handler mHandler = new Handler();
//
    public UserLoginPresenter(Context context, UserLoginView userLoginView) {
        this.context = context;
        this.userLoginView = userLoginView;
        this.userBiz = new ILogin();
    }

    public void login() {
        userLoginView.showProgress();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new
                OnLoginListener() {
                    @Override
                    public void loginSuccess(final UserBean user) {
                        //需要在UI线程执行
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                userLoginView.toMainActivity(user);
                                userLoginView.hideProgress();
                            }
                        });
                    }

                    @Override
                    public void loginFailed() {
                        //需要在UI线程执行
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                userLoginView.showErrorFaile();
                                userLoginView.hideProgress();
                            }
                        });
                    }
                });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

    public void getData() {
//        ToastUtils.toastContent(context, "得到数据");
        Log.e("login", "获得数据");
    }
}
