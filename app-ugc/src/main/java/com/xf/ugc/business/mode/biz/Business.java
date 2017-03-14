package com.xf.ugc.business.mode.biz;

import com.xf.ugc.business.mode.serviceapi.IServiceAPI;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-13:12
 * @describe
 */
public class Business implements IBusiness {


    @Override
    public void search(String key, ICallBackListener mICallBackListener) {


        IServiceAPI mIServiceAPI = HttpDao.getInstance().getIServiceAPI();
        mIServiceAPI.search(key)
                // Subscriber前面执行的代码都是在I/O线程中运行
                .subscribeOn(Schedulers.io())
                // 操作observeOn之后操作主线程中运行.
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(HttpDao.getInstance().createSubscriber(mICallBackListener));

    }

    //测试
    public void test(String schoolId,String classId,String pageSize,String userId,String currentPage,String token, ICallBackListener mICallBackListener) {
        IServiceAPI mIServiceAPI = HttpDao.getInstance().getIServiceAPI();
        mIServiceAPI.test( schoolId, classId, pageSize, userId, currentPage, token)
                // Subscriber前面执行的代码都是在I/O线程中运行
                .subscribeOn(Schedulers.io())
                // 操作observeOn之后操作主线程中运行.
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(HttpDao.getInstance().createSubscriber(mICallBackListener));
    }
}
