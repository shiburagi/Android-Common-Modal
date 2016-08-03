package com.app.infideap.mycommonmodalexample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;

import com.app.infideap.commonmodal.fragment.TypeALoginFragment;
import com.app.infideap.mycommonmodalexample.R;

public class LoginActivity extends AppCompatActivity implements
        TypeALoginFragment.OnButtonClickListener {

    private TypeALoginFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        fragment = (TypeALoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);

        fragment.setTrademarkLogo(R.drawable.logo);

        fragment.setUsernameHint(R.string.email);
        fragment.setPasswordHint(R.string.password);

//        fragment.setUsernameText("test@example.com");
//        fragment.setPasswordText("test12345");

//        fragment.setSignUpButtonText("Sign Up");
//        fragment.setLoginButtonText("Log In");
//        fragment.setForgotPasswordButtonText("Forgot Password?");

        fragment.getUsernameEditText().setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

        fragment.setOnButtonClickListener(this);

    }

    @Override
    public void onLoginButtonClick(View view, String username, String password) {
        // your validation
        fragment.setProgressText(R.string.connecting);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                fragment.setLoading(false);
//                startActivity(new Intent(
//                        LoginActivity.this,
//                        MainActivity.class
//                ));
//                finish();
            }
        }, 10000);


    }

    @Override
    public void onSignUpButtonClick(View view) {
        startActivity(new Intent(
                LoginActivity.this,
                SignUpActivity.class
        ));
    }

    @Override
    public void onForgotPasswordButtonClick(View view) {
        startActivity(new Intent(
                LoginActivity.this,
                ForgotPasswordActivity.class
        ));
    }
}
