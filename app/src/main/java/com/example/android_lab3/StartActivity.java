package com.example.android_lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
    }

    public void registration(View view){
        Intent intent=new Intent(this,RegistrationActivity.class);
        startActivity(intent);
    }

    public void enter(View view){
        Intent intent=new Intent(this,EnterActivity.class);
        startActivity(intent);
    }
}
