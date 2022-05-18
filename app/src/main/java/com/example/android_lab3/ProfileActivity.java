package com.example.android_lab3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView nameView;
    TextView emailView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        nameView=findViewById(R.id.name);
        emailView=findViewById(R.id.email);
        Bundle arguments=getIntent().getExtras();
        String name=arguments.get("name").toString();
        String email=arguments.get("email").toString();
        nameView.setText(name);
        emailView.setText(email);
    }
}
