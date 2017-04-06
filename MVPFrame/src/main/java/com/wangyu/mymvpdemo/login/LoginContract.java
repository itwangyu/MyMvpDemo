package com.wangyu.mymvpdemo.login;

import com.wangyu.mymvpdemo.mvp.BasePresenter;
import com.wangyu.mymvpdemo.mvp.BaseView;


/**
 * MVPPlugin
 */

public class LoginContract {
    interface View extends BaseView {
        String getAccount();
        String getPwd();
        void showResult(String s);
    }

    interface  Presenter extends BasePresenter<View> {
        void login();
    }
}
