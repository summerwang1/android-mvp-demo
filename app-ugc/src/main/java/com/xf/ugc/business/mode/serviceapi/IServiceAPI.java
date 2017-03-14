package com.xf.ugc.business.mode.serviceapi;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-13:15
 * @describe
 */
public interface IServiceAPI {

    // 注册
    @FormUrlEncoded
    @POST("words")
    Observable<String> search(@Field("key") String key);

    @FormUrlEncoded
    @POST("list")
    Observable<String> test(@Field("schoolId") String schoolId,
                            @Field("classId") String classId,
                            @Field("pageSize") String pageSize,
                            @Field("userId") String userId,
                            @Field("currentPage") String currentPage,
                            @Field("token") String token);
}
