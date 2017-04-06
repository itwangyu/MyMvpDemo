package com.wangyu.mymvpdemo.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.wangyu.mymvpdemo.R;


public class DialogUtil {
	public final static int ONLY_TEXE = 1;
	public final static int TEXT_AND_IMAGE = 2;
	public final static int TEXT_AND_PROCESSBAR = 3;
	private static Dialog loadingDialog;
	private static Context oldContext;
	/**
	 * 得到自定义的progressDialog（加载中的进度条）
	 * @param context
	 * @return
	 */
	public synchronized static Dialog createLoadingDialog(Context context) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.loadingdialog, null);// 得到加载view
		if (oldContext == null || !oldContext.toString().equals(context.toString())) {
			loadingDialog = new Dialog(context, R.style.loading_dialog);
		}
		oldContext = context;

		loadingDialog.setCanceledOnTouchOutside(false);
		loadingDialog.setCancelable(true);// 可以用“返回键”取消
		loadingDialog.setContentView(v, new LinearLayout.LayoutParams(
				AppInfoUtil.dip2px(context, 100), AppInfoUtil.dip2px(context, 100)));// 设置布局
		return loadingDialog;

	}

    public static void onDestory() {
        oldContext=null;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog=null;
        }
    }
}
