package com.example.android_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView adviceView;
    TextView helloView;
    String name;
    Bundle arguments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adviceView=findViewById(R.id.advice);
        helloView=findViewById(R.id.textViewHello);
        arguments=getIntent().getExtras();
        name=arguments.get("name").toString();
        helloView.setText("С возвращением, "+name+"!");
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        Intent intent;
        switch(id){
            case R.id.profile:
                intent=new Intent(this,ProfileActivity.class);
                String email= arguments.getString("email");
                intent.putExtra("email",email);
                intent.putExtra("name",name);
                startActivity(intent);
                return  true;
            case R.id.about_developers:
                intent=new Intent(this,AboutDevelopersActivity.class);
                startActivity(intent);
                return true;
            case R.id.user_guide:

                return true;
        }
        return true;
    }

    public void relax(View view){
        adviceView.setText("В физиологии под расслаблением или релаксацией понимают " +
                "процесс уменьшения мышечного тонуса и снижения степени психоэмоционального " +
                "напряжения. В науке вообще этим термином обычно описывается " +
                "процесс установления равновесия в какой-либо системе. Психофизиология" +
                " также рассматривает релаксацию как одно из функциональных состояний организма," +
                " наряду с другими функциональными состояниями, такими как сон, стресс, " +
                "оптимальное рабочее состояние, утомление. \n" +
                "\n" +
                "Релаксация наступает вследствие снятия напряжения, " +
                "после физических усилий или эмоциональных переживаний," +
                " и может быть непроизвольной и произвольной. Например, " +
                "непроизвольное состояние расслабленности возникает при засыпании " +
                "или значительном физическом и психическом утомлении. Произвольно состояние" +
                " релаксации может достигаться с использованием разнообразных стратегий, " +
                "начиная с принятия удобной спокойной позы, заканчивая применением всевозможных" +
                " техник, индуцирующих расслабление. ");
    }

    public void calm(View view){
        adviceView.setText("Это нормально - чувствовать себя так, как вы сейчас чувствуете.\n Оказывать на себя давление всегда «быть счастливым», «оставаться позитивным» \n" +
                        "или «оставаться продуктивным» иногда может ухудшить ваше самочувствие.\n Вместо этого, если вы заметили, что испытываете сложные эмоции,\n" +
                        " попробуйте сказать себе: «Я чувствую беспокойство и страх, \n" +
                        "но это не значит, что я не справляюсь».\n" +
                        " «Это были тяжелые времена, и вполне нормально чувствовать себя расстроенным».\n" +
                        " «Я чувствую [напишите, как вы себя чувствуете], и это нормально». \n" +
                        "«Сейчас трудные времена, и это нормально \n" +
                        "чувствовать себя расстроенным». Или думайте о том, что поможет\n" +
                        " успокоить вас.Важно прислушиваться к своим чувствам.\n Не игнорируйте свои чувства!\n" +
                "Иногда может помочь отражение своих чувств на бумаге.\n Попробуйте следующее:\n" +
                " «Я чувствую ....... прямо сейчас»." );
    }

    public void focus(View view){
        adviceView.setText("Сосредоточенность на чем-то – это определенное состояние человека," +
                " которое ассоциируется у нас с собранностью, концентрацией," +
                " нацеленностью на одну определенную тему, объект," +
                " проект или дело; с гармонией и слиянием с делом, полной " +
                "самоотдачей своему делу. Это состояние связано с сохранением внимания, " +
                "усилением восприятия и направленностью энергии человека. Пять органов " +
                "восприятия и чувства внутреннего восприятия (интуиция, шестое чувство," +
                " порывы сердца, сомнения, внутренние позывы, и т.д.) человека подвержены " +
                "бесконечному стимулированию как изнутри, так и извне человеческого организма.");
    }
}