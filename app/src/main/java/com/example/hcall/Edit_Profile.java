package com.example.hcall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Edit_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile);
        getSupportActionBar().hide();
    }
}
