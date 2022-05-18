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

public class RegistrationActivity extends AppCompatActivity {

    EditText loginView;
    EditText passwordView;
    EditText password2View;
    EditText nameView;
    TextView errorView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        loginView=findViewById(R.id.editTextEmail);
        passwordView=findViewById(R.id.editTextPassword);
        password2View=findViewById(R.id.editTextPassword2);
        nameView=findViewById(R.id.editTextName);
        errorView=findViewById(R.id.textViewError);
    }

    public void registrationOn(View view){
        String login=loginView.getText().toString();
        String password=passwordView.getText().toString();
        String password2=password2View.getText().toString();
        String name=nameView.getText().toString();
        if(login.isEmpty() && password.isEmpty() && password2.isEmpty() && name.isEmpty()){
            errorView.setText("Не все поля заполнены");
        }else {
            if (!password.equals(password2)) {
                errorView.setText("Пароли не совпадают");
            } else{
                System.out.println("Создался");
                SQLiteDatabase db=getBaseContext().openOrCreateDatabase("app.db",MODE_PRIVATE,null);
                db.execSQL("CREATE TABLE IF NOT EXISTS usersss(id INTEGER,login TEXT,password TEXT,name TEXT,UNIQUE(id))");
                Cursor query=db.rawQuery("SELECT * FROM usersss",null);
                int size=0;
                while (query.moveToNext()){
                    size++;
                    System.out.println("ккккк");
                }
                int id=size+1;
                db.execSQL("INSERT OR IGNORE INTO usersss VALUES("+id+",'"+login+"','"+password+"','"+name+"')");
                query.close();
                db.close();
                Intent intent=new Intent(this,StartActivity.class);
                startActivity(intent);
            }
        }
    }
}
