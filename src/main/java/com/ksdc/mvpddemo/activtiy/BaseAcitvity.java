package com.ksdc.mvpddemo.activtiy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ksdc.mvpddemo.present.BasePresent;
import com.ksdc.mvpddemo.view.BaseView;

import butterknife.ButterKnife;

/**
 * Created by hankkin on 2017/3/31.
 */

public abstract class BaseAcitvity<V, P extends BasePresent<V>> extends AppCompatActivity
        implements BaseView {
    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initBind();
        presenter = initPresenter();
        initEvent(savedInstanceState);
        initData();
    }

    protected void initBind() {
        ButterKnife.bind(this);
    }

    protected int getLayoutId() {
        return 0;
    }
    public abstract P initPresenter();
//    protected abstract void initViews(Bundle savedInstanceState);
    protected abstract void initEvent(Bundle savedInstanceState);

    protected abstract void initData();
}
