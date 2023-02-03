package org.techtown.chimmoprototype1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class menu extends AppCompatActivity {

    private ImageView img_back;
    private ImageButton btn_schedule, btn_products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Button for going to first screen
        img_back = findViewById(R.id.img_back);
        btn_schedule= findViewById(R.id.btn_schedule);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btn_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schedule = new Intent(menu.this,schedule_activity.class);
                startActivity(schedule);
            }
        });




    }
}