package com.ksdc.mvpddemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ksdc.mvpddemo.activtiy.BaseAcitvity;
import com.ksdc.mvpddemo.bean.UserBean;
import com.ksdc.mvpddemo.present.UserLoginPresenter;
import com.ksdc.mvpddemo.utils.ToastUtils;
import com.ksdc.mvpddemo.view.UserLoginView;

import butterknife.Bind;

public class MainActivity extends BaseAcitvity<UserLoginView, UserLoginPresenter> implements
        UserLoginView {
    @Bind(R.id.id_et_username)
    protected EditText mEtUsername;
    @Bind(R.id.id_et_password)
    protected EditText mEtPassword;
    @Bind(R.id.id_btn_clear)
    protected Button mBtnClear;
    @Bind(R.id.id_btn_login)
    protected Button mBtnLogin;
    @Bind(R.id.id_pb_loading)
    protected ProgressBar mPbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initEvent(Bundle savedInstanceState) {

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_login;
    }

    @Override
    public UserLoginPresenter initPresenter() {
        return new UserLoginPresenter(this, this);
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    public void showProgress() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toast(String s) {
        ToastUtils.toastContent(this, s);
    }

    @Override
    public void showErrorFaile() {
        toast("login failed");
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void toMainActivity(UserBean user) {
        toast(user.getUsername() + " login success , to MainActivity");
    }
}
