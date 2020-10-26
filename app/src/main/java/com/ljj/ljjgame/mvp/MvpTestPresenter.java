package com.ljj.ljjgame.mvp;

import java.io.IOException;

import androidx.annotation.NonNull;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

class MvpTestPresenter {
    private MvpTestCallBack callBack;
    private MvpTestModel model;
    public MvpTestPresenter(MvpTestCallBack callBack){
        this.callBack = callBack;
        model = new MvpTestModel();
    }
    public void getUrlData(String url){

        if (url.contains("123456")){
            callBack.getMessage("ok");
        }else{
            callBack.error();
        }
//        model.getData(url).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                callBack.error();
//            }
//
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                callBack.getMessage(response.body().string());
//            }
//        });
    }
}
