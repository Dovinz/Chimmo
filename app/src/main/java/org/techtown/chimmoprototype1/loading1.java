package org.techtown.chimmoprototype1;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.SupportActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class loading1 extends AppCompatActivity {

    public int page;

    Timer timer = new Timer();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading1);

        EditText editText = ((MainActivity)MainActivity.context_main).edit_password;
        editText.setText("");
        page =0;

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page=1;
                Intent intent = new Intent(loading1.this,menu.class);
                startActivity(intent);

            }
        });


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(page ==0){
                    Intent intent = new Intent(loading1.this, menu.class);
                    startActivity(intent);}
                }
            }, 2000);


    }
}