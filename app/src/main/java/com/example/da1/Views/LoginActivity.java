package com.example.da1.Views;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.da1.Fragments.HomeFragment;
import com.example.da1.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    //gg
    GoogleSignInClient gsc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //gg
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        gsc = GoogleSignIn.getClient(LoginActivity.this, gso);

        //kiểm tra đăng nhập hay chưa
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(LoginActivity.this);
        if (account!= null){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

        //tạo nút đăng nhập
        TextView tv_googleLogin = findViewById(R.id.tv_googleLogin);
        tv_googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = gsc.getSignInIntent();
                gglaunch.launch(intent);
            }
        });
    }

    //nhận trả về googleLogin
    ActivityResultLauncher<Intent> gglaunch = registerForActivityResult(new ActivityResultContracts
            .StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Intent dataIntent = result.getData();
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(dataIntent);
            try {
                //
                GoogleSignInAccount account = task.getResult(ApiException.class);

                //lấy tên của email
//                Intent i = new Intent();
                String name = account.getDisplayName();
//                i.putExtra("nameemail", name);
//                LocalBroadcastManager.getInstance(LoginActivity.this).sendBroadcast(i);
                Toast.makeText(LoginActivity.this, "NAME: "+name, Toast.LENGTH_SHORT).show();

                //kiểm tra firebase có email hay chưa

                //chuyển màn hình
                //intent giũa login và home
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                Toast.makeText(LoginActivity.this, "Đăng Nhập Thành Công!", Toast.LENGTH_SHORT).show();
                finish();
            }catch (Exception e){

            }
        }
    });
}