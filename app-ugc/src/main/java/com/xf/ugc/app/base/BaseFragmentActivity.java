package com.xf.ugc.app.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.framework.sdk.base.AxBaseFragmentActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;


/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-14:41
 * @describe
 */
@EActivity
public class BaseFragmentActivity extends AxBaseFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onResume() {

        super.onResume();
//        closeSoftInput();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        //
    }

    @UiThread
    public void showDialog() {

        showDialog("Loading");
    }

    @UiThread
    public void showToast(int resId) {

        showToast(getString(resId));
    }

    @UiThread(delay = 800)
    public void showSoftInputDelay() {

        super.showSoftInput();
    }

    @UiThread(delay = 0)
    public void closeSoftInputDelay() {

        super.closeSoftInput();
    }
}
