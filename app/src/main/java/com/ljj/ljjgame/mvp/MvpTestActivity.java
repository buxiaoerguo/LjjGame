package com.ljj.ljjgame.mvp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ljj.ljjgame.R;

import java.lang.ref.WeakReference;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MvpTestActivity extends AppCompatActivity implements View.OnClickListener,MvpTestCallBack{
    public EditText et_username_login,et_password_login;
    Button btn_signin_login;

    private MvpTestPresenter presenter;
    private MyHandler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);

        et_username_login = (EditText) findViewById(R.id.et_username_login);
        et_password_login = (EditText) findViewById(R.id.et_password_login);
        btn_signin_login = (Button) findViewById(R.id.btn_signin_login);

        handler = new MyHandler(this);
        presenter = new MvpTestPresenter(this);

        btn_signin_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signin_login:
                String url = et_username_login.getText().toString();
                presenter.getUrlData(url);
                break;
            default:
                break;
        }
    }

    @Override
    public void getMessage(String message) {
        Message msg = handler.obtainMessage(0, message);
        handler.sendMessage(msg);
    }

    @Override
    public void error() {
        Message msg = handler.obtainMessage(1, "error");
        handler.sendMessage(msg);
    }

    private static class MyHandler extends Handler {
        private WeakReference<MvpTestActivity> reference;

        private MyHandler(MvpTestActivity activity) {
            reference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MvpTestActivity activity = reference.get();
            switch (msg.what) {
                case 0:
                    activity.et_password_login.setText(msg.obj.toString());
                    break;
                case 1:
                    activity.et_password_login.setText(msg.obj.toString());
                    break;
                default:
                    break;
            }
        }
    }
}