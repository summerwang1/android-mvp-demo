package com.xf.ugc.business.mode.biz;

import android.util.Log;

import com.xf.ugc.business.mode.bean.CallBackVo;
import com.xf.ugc.business.mode.serviceapi.DeserializerData;
import com.xf.ugc.business.mode.serviceapi.IServiceAPI;
import com.xf.ugc.config.AppConstant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-13:17
 * @describe
 */
public class HttpDao {

    private static final String TAG = HttpDao.class.getSimpleName();
    private static HttpDao mHttpDao = null;
    private HttpDao(){};

    public static HttpDao getInstance(){
        if (mHttpDao == null) {
            mHttpDao = new HttpDao();
        }
        return mHttpDao;
    }

    /**
     * 获取 IServiceAPI实列
     * @return IServiceAPI
     */
    public IServiceAPI getIServiceAPI() {
        // 使用自定义转换器
        Gson mGson = new GsonBuilder()
                .registerTypeAdapter(String.class, new DeserializerData())
                .create();
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.URL_HOST)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                //build.gradle引入：compile 'com.squareup.retrofit2:adapter-rxjava:2.0.0-beta4'
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return mRetrofit.create(IServiceAPI.class);
    }

    /**
     * 创建 Subscriber
     * @param mICallBackListener
     * @return Subscriber
     */
    public Subscriber createSubscriber(final ICallBackListener mICallBackListener) {
        Subscriber mSubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "[onCompleted]");
            }
            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "[onError]" + e.getMessage());
                CallBackVo mCallBackVo = new CallBackVo();
                mCallBackVo.setError_code("400");
                mCallBackVo.setReason("请求失败");
                mCallBackVo.setResult(null);
                mICallBackListener.onFaild(mCallBackVo);
                return;
            }
            @Override
            public void onNext(String s) {
                Log.i(TAG, "[onNext]" + s);
                Gson gosn = new Gson();
                CallBackVo mCallBackVo = gosn.fromJson(s, CallBackVo.class);
                if (mCallBackVo.getError_code().equals(AppConstant.REQUEST_SUCCESS_CODE)) {
                    mICallBackListener.onSuccess(mCallBackVo);
                } else {
                    mICallBackListener.onFaild(mCallBackVo);
                }
            }
        };
        return mSubscriber;
    }

}
