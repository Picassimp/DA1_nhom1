package com.example.da1.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.da1.R;
import com.example.da1.Views.LoginActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.concurrent.Executor;

public class ProfileFragment extends Fragment {

    GoogleSignInClient gsc;
    GoogleSignInAccount account;
    Button btn_profilefrag_logout;

    public ProfileFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //gg
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();

        gsc = GoogleSignIn.getClient(getActivity(), gso);
        account =GoogleSignIn.getLastSignedInAccount(getActivity());

        btn_profilefrag_logout = view.findViewById(R.id.btn_profilefrag_logout);

        btn_profilefrag_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (account!= null){
                    gsc.signOut().addOnCompleteListener(getActivity()
                            , new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(getContext(), "Đã Đăng Xuất", Toast.LENGTH_SHORT).show();
                                }
                            });
                }else {
                    //chưa thêm vô
                }
            }
        });
        //end gg
    }

}
