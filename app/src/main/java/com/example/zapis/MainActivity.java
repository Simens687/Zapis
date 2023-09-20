package com.example.zapis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dateTxt, timeTxt;
    ImageButton datePick, timePick;
    Button applyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTxt = findViewById(R.id.date_edit);
        timeTxt = findViewById(R.id.time_edit);

        datePick = findViewById(R.id.date_image);
        timePick = findViewById(R.id.time_image);

        applyBtn = findViewById(R.id.btn_zapis);


        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedYear = 2000;
                int selectedMonth = 2;
                int selectedDay = 2;

                DatePicker datePicker;
                Button okButton;

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.date_layout);

                datePicker = dialog.findViewById(R.id.date_piker);
                okButton = dialog.findViewById(R.id.date_piker_ok);

                datePicker.init(selectedYear, selectedMonth, selectedDay, null);

                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedYear = datePicker.getYear();
                        int selectedMonth = datePicker.getMonth();
                        int selectedDay = datePicker.getDayOfMonth();

                        dateTxt.setText(selectedDay + "." + selectedMonth + "." + selectedYear);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        timePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedHour = 18;
                int selectedMinute = 20;

                TimePicker timePicker;
                Button okButton;

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.time_layout);

                timePicker = dialog.findViewById(R.id.time_piker);
                okButton = dialog.findViewById(R.id.date_piker_ok);

                timePicker.setHour(selectedHour);
                timePicker.setMinute(selectedMinute);

                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int selectedHour, selectedMinute;

                        selectedHour = timePicker.getHour();
                        selectedMinute = timePicker.getMinute();

                        timeTxt.setText(selectedHour + ":" + selectedMinute);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button yesButton;
                Button noButton;

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.accept_layout);

                yesButton = dialog.findViewById(R.id.btn_ok);
                noButton = dialog.findViewById(R.id.btn_no);

                yesButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Ждем", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                noButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Сами тогда приедем", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
}