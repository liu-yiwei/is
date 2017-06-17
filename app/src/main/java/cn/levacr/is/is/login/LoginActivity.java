package cn.levacr.is.is.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.isnc.facesdk.SuperID;
import com.isnc.facesdk.common.SDKConfig;

import cn.levacr.is.is.MainActivity;
import cn.levacr.is.is.R;
import cn.levacr.is.is.util.Md5Util;

/**
 * Created by hello on 2017/5/3.
 */

public class LoginActivity extends Activity {

    Button faceBut;
    Button loginBut;
    TextView username;
    TextView password;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SuperID.initFaceSDK(this);
        setContentView(R.layout.activity_login);



        faceBut = (Button) findViewById(R.id.faceLogin);
        loginBut = (Button) findViewById(R.id.login);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);

        faceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginWithFace();
            }
        });
        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = username.getText().toString();
                String p =password.getText().toString();
                if (!u.isEmpty()&&!p.isEmpty()){
                    if (login(u,p))
                        turnToMain();
                }else
                    showFailure();

            }
        });
    }


    //shua刷脸登录的函数
    void loginWithFace(){
        SuperID.faceLogin(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case SDKConfig.LOGINSUCCESS:
                turnToMain();
                break;
            case SDKConfig.LOGINFAIL:
                showFailure();
                break;
            default:
               showFailure();
                break;
        }
    }

    private void showFailure(){
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    public boolean login(String username, String password){
        return getMd5FromSever(username).equals(getMd5FromUser(password));
    }


    private void turnToMain(){
        Intent i = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);
        LoginActivity.this.finish();
    }

    private String getMd5FromSever(String username){
        // TODO: 2017/5/3   从服务器获取md5的操作
        return "e10adc3949ba59abbe56e057f20f883e";
    }
    
    private String getMd5FromUser(String password){
        return Md5Util.md5(password);
    }
}

