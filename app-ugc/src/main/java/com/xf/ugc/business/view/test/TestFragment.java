package com.xf.ugc.business.view.test;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.xf.ugc.R;
import com.xf.ugc.adapter.NewsAdapter;
import com.xf.ugc.app.UgcTvApp;
import com.xf.ugc.app.base.BaseFragment;
import com.xf.ugc.business.mode.bean.CallBackVo;
import com.xf.ugc.business.mode.bean.UserVo;
import com.xf.ugc.config.AppConstant;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/22-16:20
 * @describe
 */
@EFragment(R.layout.mainlayout)
public class TestFragment extends BaseFragment implements TestDelegate.View{

    private TestDelegate.Presenter mPresenter;

    private Dialog mDialog;

    @ViewById
    RecyclerView recyclerView;

    @ViewById
    ImageView iv_image;

    @AfterViews
    public void initview(){

    }

    @Override
    public void initPresenter(TestDelegate.Presenter presenter) {
        mPresenter = presenter;
    }
    @Override
    public String getParamenters() {

        /*User user = new User();
        user.classId = "";
        user.schoolId = "25";
        user.pageSize = "10";
        user.userId = "9707";
        user.currentPage = "1";
        user.token = "368A7BD67A7BBC7334A8626B42E53EE6";
        return user;*/
        return "ec673a339a3f46129ef741e9897084f2";
    }

    @Override
    public void excuteSuccessCallBack(CallBackVo mCallBackVo) {
        List<UserVo.ResultEntity> mUserVo = (List<UserVo.ResultEntity>) mCallBackVo.getResult();

        NewsAdapter newsAdapter = new NewsAdapter(getActivity(),mUserVo);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newsAdapter);

        for (int i = 0; i < mUserVo.size(); i++) {
            Log.e("TAg","--"+mUserVo.get(i).Id);
            Log.e("TAg","--"+mUserVo.get(i).KeyWord);
        }
    }

    @Override
    public void excuteFailedCallBack(CallBackVo mCallBackVo) {
        Log.e("TAG",mCallBackVo.getReason());
    }
    @Click({R.id.btn})
    public void onClick(View view){

        if (view.getId() == R.id.btn){
//            AppConstant.URL_HOST = "http://app.xsj100.com/restapi/api/growarchives/";
//            mPresenter.init();

            //测试图片加载
//            Glide.with(getActivity())
//                    .load("http://app.xsj100.com/restapi/api/home/photo/9707")
//                    .error(R.drawable.ic_launcher)
//                    .placeholder(R.drawable.actionbar_add_btn)
//                    .into(iv_image);

            UgcTvApp.getInstance().getAxImageLoader().displayImage(getActivity(), "http://app.xsj100.com/restapi/api/home/photo/9707", iv_image);
        }
    }
    public void showProgress()
    {
        mDialog = new ProgressDialog(getActivity());
        mDialog.setTitle("Loading");
        mDialog.show();


    }

    public void closeProgress()
    {
        mDialog.dismiss();
    }


}
