package com.xf.ugc.business.view.test;

import android.os.Handler;

import com.xf.ugc.business.mode.bean.CallBackVo;
import com.xf.ugc.business.mode.biz.Business;
import com.xf.ugc.business.mode.biz.IBusiness;
import com.framework.sdk.base.AxBaseDelegate;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-14:48
 * @describe
 */
public interface TestDelegate {

    interface View extends AxBaseDelegate.AxIView<Presenter>,AxBaseDelegate.AxIFragment{

        public void closeProgress();

        public void showProgress();

        public Object getParamenters();

        public void excuteSuccessCallBack(CallBackVo mCallBackVo);

        public void excuteFailedCallBack(CallBackVo mCallBackVo);

    }


    interface Presenter extends AxBaseDelegate.AxIPresenter{
        public IBusiness mIBusiness = new Business();
        public Handler mHandler = new Handler();
    }
}
