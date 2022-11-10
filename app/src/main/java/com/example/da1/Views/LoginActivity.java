package com.example.da1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.da1.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    CallbackManager callbackManager;
    private LoginButton loginFB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // login bằng fb
        loginFB = findViewById(R.id.login_fb);
        callbackManager = CallbackManager.Factory.create();
        loginFB.setReadPermissions("email",  "public_profile");

        loginFB.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(LoginActivity.this,"Successful", Toast.LENGTH_LONG).show();
                Log.d(">>>>>>>>>>>>TAG", "onSuccess: "+loginResult.getAccessToken());
                // Lấy access token sử dụng LoginResult
                AccessToken accessToken = loginResult.getAccessToken();
                useLoginInformation(accessToken);

                Intent MainIntent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(MainIntent);
                finish();
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this,"Login attempt canceled.", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onError(FacebookException e) {
                Toast.makeText(LoginActivity.this,"Login attempt failed.", Toast.LENGTH_LONG).show();
            }
        });



        // kiểm tra trạng thái login

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    private void useLoginInformation(AccessToken accessToken) {

        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            //OnCompleted is invoked once the GraphRequest is successful
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String name = object.getString("name");
                    String email = object.getString("email");
                    String id = object.getString("id");
                    String image = object.getJSONObject("picture").getJSONObject("data").getString("url");
//                    Intent intent = new Intent(LoginActivity.this,UserService.class);
//                    intent.putExtra("email",id);

//                    intent.setAction(UserService.USER_SERVICE_ACTION_REGISTER);
//                    startService(intent);

                    //Sử dụng thông tin lấy được
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        // We set parameters to the GraphRequest using a Bundle.
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,picture.width(200)");
        request.setParameters(parameters);
        // Initiate the GraphRequest
        request.executeAsync();
    }
}