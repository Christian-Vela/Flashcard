package com.example.flashcard;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Addcard extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViewById(R.id.go_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Addcard.this, MainActivity.class);
                startActivity(i);


            }
        });
        findViewById(R.id.download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Addcard.this, MainActivity.class);
                if (((EditText) findViewById(R.id.enterquestion)).getText().length() ==0||((EditText) findViewById(R.id.answer2)).getText().length() ==0||((EditText) findViewById(R.id.answer2)).getText().length() ==0||((EditText) findViewById(R.id.answer3)).getText().length() ==0)
                {
                    Toast.makeText(getApplicationContext(), "Question or answer too short", Toast.LENGTH_LONG).show();
                }
                else{
                    intent.putExtra("Question", ((EditText) findViewById(R.id.enterquestion)).getText().toString());
                    intent.putExtra("answer1", ((EditText) findViewById(R.id.answer1)).getText().toString());
                    intent.putExtra("answer2", ((EditText) findViewById(R.id.answer2)).getText().toString());
                    intent.putExtra("answer3", ((EditText) findViewById(R.id.answer3)).getText().toString());
                    setResult(1, intent);
                    finish();

                }





            }
        });


    }


}
