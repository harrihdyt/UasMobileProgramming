package com.harrihidayat.uasmobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {
    TimePicker picker;
    Button buttonStart;
    Button buttonCancel;
    TextView textPromt;

    TimePickerDialog timePicker;

    final  static  int req = 1;
//    private TimePickerDialog.OnTimeSetListener timeSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        textPromt = (TextView) findViewById(R.id.promtID);
        buttonStart = (Button) findViewById(R.id.btnSet);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textPromt.setText("");
                openTimePicker(false);
            }
        });

        buttonCancel = (Button) findViewById(R.id.btnCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });

    }


    private void openTimePicker(boolean is24jam){
        Calendar kalender = Calendar.getInstance();
        timePicker = new TimePickerDialog(
                AlarmActivity.this, timeSetListener, kalender.get(Calendar.HOUR_OF_DAY), kalender.get(Calendar.MINUTE), true
        );

        timePicker.setTitle("Set Alarm Anda");
        timePicker.show();
    }

    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();

            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);

            if (calSet.compareTo(calNow) <= 0){
                calSet.add(Calendar.DATE, 1);
            }
            setAlarm(calNow);
        }
    };

    private void setAlarm(Calendar targetCal){
        textPromt.setText("\n\n" + "Alarm Telah Diatur Pada: " + targetCal.getTime());

        Intent intent = new Intent(getBaseContext(), AlarmActivity.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), req, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
    }

    private void cancelAlarm(){
        textPromt.setText("\n\n" + "Alarm Telah Dibatalkan!");

        Intent intent = new Intent(getBaseContext(), AlarmActivity.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), req, intent,0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }
}