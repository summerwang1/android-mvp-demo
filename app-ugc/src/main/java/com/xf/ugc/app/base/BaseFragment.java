package com.xf.ugc.app.base;


import com.framework.sdk.base.AxBaseFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;


/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-16:19
 * @describe
 */
@EFragment
public class BaseFragment extends AxBaseFragment {

    @UiThread
    public void showToast(int resId) {

        showToast(getString(resId));
    }

    @UiThread
    public void showDialog() {

        showDialog("Loading");
    }
}
