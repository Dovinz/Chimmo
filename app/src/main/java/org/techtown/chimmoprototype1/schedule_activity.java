package org.techtown.chimmoprototype1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.ScaleAnimation;
import android.widget.CalendarView;
import android.widget.EditText;

public class schedule_activity extends AppCompatActivity {
    CalendarView calendar;
    EditText edit_schedule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


         calendar = findViewById(R.id.calendar);
         edit_schedule= (EditText) findViewById(R.id.edit_schedule);

        edit_schedule.setText("날짜");


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
             @Override
             public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                 i1++;
                 String day = i+"년"+i1+"월"+i2+"일";
                 edit_schedule.setText(day);
             }
         });


    }
}