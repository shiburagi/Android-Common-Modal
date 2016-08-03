package com.app.infideap.commonmodal.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.infideap.commonmodal.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TypeALoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TypeALoginFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String KEY = "TYPE_A";

    private String mParam1;
    private String mParam2;

    private TextView trademarkTextView;
    private TextView progressTextView;

    private Button loginButton;
    private Button forgotPasswordButton;
    private Button signUpButton;

    private EditText usernameEditText;
    private EditText passwordEditText;

    private ImageView visibilityImageView;

    private View progressLayout;
    private View formLayout;

    private ProgressBar progressBar;

    public TypeALoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TypeALoginFragment.
     */
    public static TypeALoginFragment newInstance() {
        return new TypeALoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_type_alogin, container, false);

        trademarkTextView = (TextView) rootView.findViewById(R.id.textView_trademark);
        progressTextView = (TextView) rootView.findViewById(R.id.textView_progress);

        usernameEditText = (EditText) rootView.findViewById(R.id.editText_username);
        passwordEditText = (EditText) rootView.findViewById(R.id.editText_password);


        loginButton = (Button) rootView.findViewById(R.id.button_login);
        forgotPasswordButton = (Button) rootView.findViewById(R.id.button_forgot_password);
        signUpButton = (Button) rootView.findViewById(R.id.button_signup);

        formLayout = rootView.findViewById(R.id.layout_form);
        progressLayout = rootView.findViewById(R.id.layout_progress);
        progressLayout.setVisibility(View.GONE);

        progressBar = (ProgressBar) progressLayout.findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(
                getResources().getColor(R.color.colorWhite),
                android.graphics.PorterDuff.Mode.MULTIPLY);


        visibilityImageView = (ImageView) rootView.findViewById(R.id.imageView_visibility);
        visibilityImageView.setOnClickListener(new View.OnClickListener() {
            PasswordTransformationMethod passwordTransformationMethod = new PasswordTransformationMethod();
            SingleLineTransformationMethod singleLineTransformationMethod = new SingleLineTransformationMethod();

            @Override
            public void onClick(View view) {

                int start = passwordEditText.getSelectionStart();
                int end = passwordEditText.getSelectionEnd();

                if (passwordEditText.getTransformationMethod() instanceof SingleLineTransformationMethod) {
                    passwordEditText.setTransformationMethod(passwordTransformationMethod);
                    visibilityImageView.setImageResource(R.drawable.ic_visibility_off_white_24dp);
                } else {
                    passwordEditText.setTransformationMethod(singleLineTransformationMethod);
                    visibilityImageView.setImageResource(R.drawable.ic_visibility_white_24dp);
                }
                passwordEditText.setSelection(start, end);

            }
        });


        return rootView;
    }


    public void setOnButtonClickListener(final OnButtonClickListener listener) {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLoading(true);

                listener.onLoginButtonClick(
                        view,
                        usernameEditText.getText().toString(),
                        passwordEditText.getText().toString()
                );
            }
        });

        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLoading(true);

                listener.onForgotPasswordButtonClick(view);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLoading(true);

                listener.onSignUpButtonClick(view);
            }
        });
    }

    public void setLoading(boolean load) {
        if (load) {
            progressLayout.setVisibility(View.VISIBLE);
            formLayout.setVisibility(View.GONE);
            signUpButton.setVisibility(View.GONE);
        } else {
            progressLayout.setVisibility(View.GONE);
            formLayout.setVisibility(View.VISIBLE);
            signUpButton.setVisibility(View.VISIBLE);
        }
    }

    public TextView getTrademarkHolder() {
        return trademarkTextView;
    }

    public EditText getUsernameEditText() {
        return usernameEditText;
    }

    public EditText getPasswordEditText() {
        return passwordEditText;
    }

    public void setTrademarkLogo(int resId) {
        Drawable drawable = getContext().getResources().getDrawable(resId);
        trademarkTextView.setCompoundDrawablesWithIntrinsicBounds(
                null, drawable, null, null
        );
    }

    public void setUsernameHint(int resId) {
        usernameEditText.setHint(resId);
    }

    public void setUsernameHint(String hint) {
        usernameEditText.setHint(hint);
    }

    public void setPasswordHint(int resId) {
        passwordEditText.setHint(resId);
    }

    public void setPasswordHint(String hint) {
        passwordEditText.setHint(hint);
    }

    public void setUsernameText(int resId) {
        usernameEditText.setText(resId);
    }

    public void setUsernameText(String hint) {
        usernameEditText.setText(hint);
    }

    public void setPasswordText(int resId) {
        passwordEditText.setText(resId);
    }

    public void setPasswordText(String hint) {
        passwordEditText.setText(hint);
    }

    public void setLoginButtonText(int resId) {
        loginButton.setText(resId);
    }

    public void setLoginButtonText(String text) {
        loginButton.setText(text);
    }

    public void setSignUpButtonText(int resId) {
        signUpButton.setText(resId);
    }

    public void setSignUpButtonText(String text) {
        signUpButton.setText(text);
    }

    public void setForgotPasswordButtonText(int resId) {
        signUpButton.setText(resId);
    }

    public void setForgotPasswordButtonText(String text) {
        signUpButton.setText(text);
    }

    public void setProgressText(int resId) {
        progressTextView.setText(resId);
    }

    public void setProgressText(String text) {
        progressTextView.setText(text);
    }


    public interface OnButtonClickListener {
        void onLoginButtonClick(View view, String username, String password);

        void onSignUpButtonClick(View view);

        void onForgotPasswordButtonClick(View view);
    }
}
