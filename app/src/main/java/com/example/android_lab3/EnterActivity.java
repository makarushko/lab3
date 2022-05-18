package com.example.android_lab3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EnterActivity extends AppCompatActivity {

    EditText loginView;
    EditText passwordView;
    TextView errorView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_activity);
        loginView=findViewById(R.id.editTextEmailForEnter);
        passwordView=findViewById(R.id.editTextPasswordForEnter);
        errorView=findViewById(R.id.textViewErrorEnter);
    }

    public void enterOn(View view){
        String login=loginView.getText().toString();
        String password=passwordView.getText().toString();
        SQLiteDatabase db=getBaseContext().openOrCreateDatabase("app.db",MODE_PRIVATE,null);
        Cursor query=db.rawQuery("SELECT * FROM usersss",null);
        boolean check=true;
        while(query.moveToNext()){
            if(login.equals(query.getString(1)) && password.equals(query.getString(2))){
                check=false;
                Intent intent=new Intent(this,MainActivity.class);
                intent.putExtra("name",query.getString(3));
                intent.putExtra("email",query.getString(1));
                query.close();
                db.close();
                startActivity(intent);
            }
        }
        if(check)errorView.setText("Не удалось войти");
        query.close();
        db.close();
    }
}
