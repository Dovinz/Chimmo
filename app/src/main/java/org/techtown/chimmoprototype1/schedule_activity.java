package org.techtown.chimmoprototype1;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class schedule_activity extends AppCompatActivity {
    CalendarView calendar;
    TextView txt_date;
    EditText edit_schedule;
    Button btn_save,btn_delete;

    private void savePlan(long dateInMillis, String plan) {
        try {
            FileOutputStream fos = openFileOutput(getPlanFilename(dateInMillis), MODE_PRIVATE);
            fos.write(plan.getBytes());
            fos.close();
            //Toast.makeText(this, "Plan saved for " + getDateAsString(dateInMillis), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getPlanFilename(long dateInMillis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date(dateInMillis)) + ".txt";
    }


    private String loadPlan(long dateInMillis) {
        try {
            FileInputStream fis = openFileInput(getPlanFilename(dateInMillis));
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            fis.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }









    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


        calendar = findViewById(R.id.calendar);
        txt_date= findViewById(R.id.txt_date);
        edit_schedule=findViewById(R.id.edit_schedule);
        btn_save=findViewById(R.id.btn_save);
        btn_delete=findViewById(R.id.btn_delete);
        txt_date.setText("Date");



        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
             @Override
             public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                 i1++;
                 String day = i+"Y "+i1+"M "+i2+"D";
                 txt_date.setText(day);
                 String plan = edit_schedule.getText().toString().trim();

                 if (!plan.isEmpty()) {
                     // Save the plan to a file
                     Calendar cal = Calendar.getInstance();
                     cal.set(i, i1, i2);
                     long selectedDateInMillis = cal.getTimeInMillis();
                     savePlan(selectedDateInMillis, plan);
                 }

                 // Load the plan for the selected date and display it in a Toast
                 Calendar cal = Calendar.getInstance();
                 cal.set(i, i1, i2);
                 long selectedDateInMillis = cal.getTimeInMillis();
                 String loadedPlan = loadPlan(selectedDateInMillis);
                 if (!loadedPlan.isEmpty()) {
                     Toast.makeText(schedule_activity.this, loadedPlan, Toast.LENGTH_SHORT).show();
                 }


             }
         });

    }
}