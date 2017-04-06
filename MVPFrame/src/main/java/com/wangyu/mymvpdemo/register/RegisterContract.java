package com.wangyu.mymvpdemo.register;

import com.wangyu.mymvpdemo.mvp.BasePresenter;
import com.wangyu.mymvpdemo.mvp.BaseView;


/**
 * MVPPlugin
 * �? 邮箱 784787081@qq.com
 */

public class RegisterContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        
    }
}
