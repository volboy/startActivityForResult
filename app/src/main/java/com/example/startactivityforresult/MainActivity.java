package com.example.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String AGE_KEY="AGE";
    static final String ACCESS_MESSAGE="ACCESS_MESSAGE";
    private static final int REQUEST_ACCESS_TYPE=1;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
    }
    public void onClick(View view){
        //получаем введенный возраст
        EditText ageBox=findViewById(R.id.ageBox);
        String age=ageBox.getText().toString();

        Intent intent=new Intent(this, SecondActivity.class);
        intent.putExtra(AGE_KEY,age);
        startActivityForResult(intent,REQUEST_ACCESS_TYPE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==REQUEST_ACCESS_TYPE){
            if (resultCode==RESULT_OK){
                String accessMessage=data.getStringExtra(ACCESS_MESSAGE);
                textView.setText(accessMessage);
            }
            else {
                textView.setText("Ошибка доступа");
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
