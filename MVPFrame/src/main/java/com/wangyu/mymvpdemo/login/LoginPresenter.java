package com.wangyu.mymvpdemo.login;

import com.wangyu.mymvpdemo.base.Api;
import com.wangyu.mymvpdemo.bean.Login;
import com.wangyu.mymvpdemo.mvp.BasePresenterImpl;
import com.wangyu.mymvpdemo.utils.HttpCallback;
import com.wangyu.mymvpdemo.utils.HttpUtils;

import java.util.HashMap;

import okhttp3.Call;


/**
 * MVPPlugin
 */

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter{

    @Override
    public void login() {
        HashMap<String, String> map = new HashMap<>();
        map.put("account",mView.getAccount());
        map.put("pwd",mView.getPwd());
        HttpUtils.post(Api.login, map, new HttpCallback<Login>(mView) {
            @Override
            public void onSuccess(Login response, int id) {
                mView.showResult(response.msg);
            }

            @Override
            public void onFail(Call call, Exception e, int id) {
                mView.showResult("失败");
            }
        });
    }
}
