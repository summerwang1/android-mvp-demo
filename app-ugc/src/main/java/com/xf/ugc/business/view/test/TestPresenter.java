package com.xf.ugc.business.view.test;

import android.media.MediaPlayer;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.xf.ugc.business.mode.bean.CallBackVo;
import com.xf.ugc.business.mode.bean.UserVo;
import com.xf.ugc.business.mode.biz.ICallBackListener;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-14:52
 * @describe
 */
public class TestPresenter implements TestDelegate.Presenter {

    private TestDelegate.View mView;

    public TestPresenter(TestDelegate.View view) {
        //
        mView = view;
        //
        mView.initPresenter(this);
    }

    @Override
    public void init() {

        mView.showProgress();


/*       User user = mView.getParamenters();
        mIBusiness.test(user.schoolId, user.classId, user.pageSize, user.userId, user.currentPage, user.token, new ICallBackListener() {
            @Override
            public void onSuccess(CallBackVo mCallBackVo) {
                Log.e("tag","------"+mCallBackVo.getResult().toString());
            }

            @Override
            public void onFaild(CallBackVo mCallBackVo) {
                Log.e("tag","=========="+mCallBackVo.getResult().toString());
            }
        });*/
        mIBusiness.search((String) mView.getParamenters(), new ICallBackListener() {

            @Override
            public void onSuccess(final CallBackVo mCallBackVo) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Gson mGson = new Gson();
                        JsonElement mJsonElement = mGson.toJsonTree(mCallBackVo.getResult());
                        Type mType = new TypeToken<List<UserVo.ResultEntity>>() {
                        }.getType();
                        List<UserVo.ResultEntity> mRegisterVo = mGson.fromJson(mJsonElement, mType);
                        mCallBackVo.setResult(mRegisterVo);
                        mView.closeProgress();
                        mView.excuteSuccessCallBack(mCallBackVo);
                    }
                });
            }

            @Override
            public void onFaild(final CallBackVo mCallBackVo) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.closeProgress();
                        mView.excuteFailedCallBack(mCallBackVo);
                        Log.e("Tag",mCallBackVo.getReason());
                    }
                });
            }
        });
    }

}
