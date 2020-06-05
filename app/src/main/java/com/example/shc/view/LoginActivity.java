package com.example.shc.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shc.R;
import com.example.shc.databinding.ActivityLoginBinding;
import com.example.shc.di.DaggerLoginComponent;
import com.example.shc.di.LoginModule;
import com.example.shc.http.entities.LoginEntity;
import com.example.shc.viewmodel.LoginViewModel;

import javax.inject.Inject;


public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginViewModel viewModel;
    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);
        binding.setUser(viewModel.getUser());
        handleEvent();
    }

    private void handleEvent() {
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.login();
            }
        });

        viewModel.err().observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                Toast.makeText(LoginActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        viewModel.success().observe(this, new Observer<LoginEntity>() {
            @Override
            public void onChanged(LoginEntity entity) {
                MainActivity.launch(LoginActivity.this);
            }
        });
        binding.loginToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.launch(LoginActivity.this);
            }
        });
    }
}
