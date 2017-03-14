package com.xf.ugc.business.view.test;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.framework.sdk.base.AxBaseFragmentActivity;
import com.xf.ugc.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-14:39
 * @describe
 */

@EActivity(R.layout.activity_fragment_main_toolbar)
public class TestActivity extends AxBaseFragmentActivity {

    private TestFragment mTestFragment;


    @AfterViews
    public void initView() {

        mTestFragment = (TestFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (mTestFragment == null) {
            //
            mTestFragment = TestFragment_.builder().build();
            //
            addFragmentToActivity(getSupportFragmentManager(), mTestFragment, R.id.contentFrame);
        }
        // Create the presenter
        new TestPresenter(mTestFragment);

    }
}
