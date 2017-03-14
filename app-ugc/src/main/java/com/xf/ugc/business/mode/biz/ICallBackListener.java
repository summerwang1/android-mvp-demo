package com.xf.ugc.business.mode.biz;

import com.xf.ugc.business.mode.bean.CallBackVo;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-13:08
 * @describe
 */
public interface ICallBackListener {

    public void onSuccess(CallBackVo mCallBackVo);

    public void onFaild(CallBackVo mCallBackVo);

}
