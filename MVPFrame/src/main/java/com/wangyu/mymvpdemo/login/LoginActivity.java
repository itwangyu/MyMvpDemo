package com.wangyu.mymvpdemo.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wangyu.mymvpdemo.R;
import com.wangyu.mymvpdemo.mvp.MVPBaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * MVPPlugin
 * �? 邮箱 784787081@qq.com
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {
    @InjectView(R.id.et_username)
    EditText etUsername;
    @InjectView(R.id.tv_usernameerrorinfo)
    TextView tvUsernameerrorinfo;
    @InjectView(R.id.et_pwd)
    EditText etPwd;
    @InjectView(R.id.tv_pwderrorinfo)
    TextView tvPwderrorinfo;
    @InjectView(R.id.bt_login)
    Button btLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @Override
    public String getAccount() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return etPwd.getText().toString().trim();
    }

    @Override
    public void showResult(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.bt_login)
    public void onClick() {
        mPresenter.login();
    }
}
