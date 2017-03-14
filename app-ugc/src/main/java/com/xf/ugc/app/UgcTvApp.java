package com.xf.ugc.app;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.framework.sdk.base.AxBaseApp;
import com.framework.sdk.config.AxGlobal;
import com.squareup.leakcanary.LeakCanary;
import com.xf.ugc.BuildConfig;
import com.xf.ugc.R;
import com.xf.ugc.config.AppConstant;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-10:17
 * @describe
 */
public class UgcTvApp extends AxBaseApp{

    public static UgcTvApp getInstance() {

        return (UgcTvApp) getAxApplication();
    }

    protected void attachBaseContext(Context base) {
        //
        super.attachBaseContext(base);
        //
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        //
        super.onCreate();

        //初始化系统参数
        initSystem();

        //初始化网络配置
//        initOkHttp();

        //初始化TuSDK
        initTuSDK();

        //初始化推送
        initJPush();

        // 初始化默认图片
        initImageDefault(R.drawable.pic_no, R.drawable.pic_no, R.drawable.pic_no, R.drawable.pic_no);

        // 初始化分享
//        ShareSDK.initSDK(this);

        // 初始化友盟
//        MobclickAgent.setDebugMode(true);

        initOkHttp();
    }

    /**
     * 初始化系统参数
     */
    public void initSystem() {
        //多Dex支持
        MultiDex.install(this);
        //内存泄露支持
        LeakCanary.install(this);
        //
        if (BuildConfig.BUILD_TYPE.equals("debug")) {
            //开发
            //
            AxGlobal.development = true;
            //
//            AppConstant.URL_HOST = "http://website2030.715buy.com/vshow";
            //
//            AppConstant.CHAT_SERVER_URL = "http://180.168.55.51:9091";
            //
        } else if (BuildConfig.BUILD_TYPE.equals("beta")) {
            //测试
            //
            AxGlobal.development = false;
            //
        } else if (BuildConfig.BUILD_TYPE.equals("release")) {
            //线上
            //
            AxGlobal.development = false;
            //
        }
        //
        AppConstant.ShareUrl = AppConstant.URL_HOST + "/user/index";

        AppConstant.ShareLogo = AppConstant.URL_HOST + "/images/logo_512X512.png";
    }

    /**
     * 网络配置
     */
    public void initOkHttp() {
        //
    }

    /**
     * 初始化推送
     */
    public void initJPush() {
//        // 初始化 推送
//        JPushInterface.init(this);
//        // 设置开启日志,发布时请关闭日志
//        JPushInterface.setDebugMode(BuildConfig.DEBUG);
//        // 设置显示一个通知
//        JPushInterface.setLatestNotificationNumber(getApplicationContext(), 1);
//        // 设置通知声音+震动
//        Boolean is_push_sound = getAxConfig().getBoolean(AppConstant.IS_PUSH_SOUND, true);
//        Boolean is_push_shock = getAxConfig().getBoolean(AppConstant.IS_PUSH_SHOCK, true);
//        JPushReceiver.setPushNotification(getApplicationContext(), is_push_sound, is_push_shock);
    }

    /**
     * 初始化TuSdk
     */
    public void initTuSDK() {
        //初始化全局变量
//        TuSdk.enableDebugLog(true);
//        //
//        TuSdk.init(this, "c2e1141ab5e69f72-00-lhldp1");
    }
}
