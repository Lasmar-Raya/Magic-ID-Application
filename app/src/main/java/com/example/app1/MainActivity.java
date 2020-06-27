package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edID;
    Button btnSubmit;
    TextView tvResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//in the 'R'esoures fold where the layout exist you get main_activity
        edID = findViewById(R.id.edID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNumber = edID.getText().toString().trim(); //trim avoid spaces from the begining and end
                String dob = idNumber.substring(0,6); // substring exclude the last char
                String sGender;
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                if (gender<5)
                    sGender=getString(R.string.Female);
                else
                    sGender=getString(R.string.Male);
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                if(nationality==0)
                    sNationality=getString(R.string.SAcitizen);
                else
                    sNationality=getString(R.string.permaent);
                String text=getString(R.string.dob)+dob+ getString(R.string.newline) +getString(R.string.gender)+sGender+getString(R.string.newline) +getString(R.string.nationality)+sNationality;
                tvResults.setText(text);
            }
        });
    }
}
