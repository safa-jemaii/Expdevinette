package com.isetR.devinette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {


    private TextView userName;

    // button for logout
    private Button commencer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        commencer = findViewById(R.id.commencer);

        userName = findViewById(R.id.userName);

        String name = getIntent().getStringExtra("username");

        userName.setText(name);

        commencer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                        Intent i = new Intent(Home.this, MainActivity.class);
                               i.putExtra("Nom", userName.getText().toString());

                        startActivity(i);
                            finish();
                    }
                });}}