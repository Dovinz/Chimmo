package org.techtown.chimmoprototype1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity  {

    private String password="0904";
    private String entered_password;
    private EditText edit_password;
    int pw_count=0;
    Button btn_ok;
    Timer timer=new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        edit_password=findViewById(R.id.edit_password);

        edit_password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (i) {
                    case KeyEvent.KEYCODE_ENTER:
                        /*Enter Key Pressed*/
                        entered_password=edit_password.getText().toString();
                        if(entered_password.equals(password)==true){
                            Intent loadingActivity=new Intent(MainActivity.this,chimmo_loading.class);
                            startActivity(loadingActivity);
                        }
                        else{
                            pw_count++;
                            Toast.makeText(MainActivity.this, "Password is incorrect :"+pw_count, Toast.LENGTH_SHORT).show();
                            edit_password.setText("");


                        }

                        break;
                }

                return false;
            }
        });


    }

}