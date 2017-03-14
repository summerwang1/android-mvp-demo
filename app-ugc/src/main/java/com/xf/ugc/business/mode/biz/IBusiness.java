package com.xf.ugc.business.mode.biz;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-13:07
 * @describe
 */
public interface IBusiness {

    /**
     * 注册
     *
     * @param mUserVo:请求参数：封装为bean
     * @param mICallBackListener:回调接口
     */
    public void search(String key, ICallBackListener mICallBackListener);

    public void test(String schoolId, String classId, String pageSize, String userId, String currentPage, String token, ICallBackListener mICallBackListener);

}