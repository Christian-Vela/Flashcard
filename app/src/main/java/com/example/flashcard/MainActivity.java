package com.example.flashcard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    private void MarkCorrectAnswer()
    {
        if (findViewById(R.id.question).getTag().equals("1"))
            findViewById(R.id.answer1).setBackgroundColor(getResources().getColor(R.color.green));
        else
            {
            findViewById(R.id.answer1).setBackgroundColor(getResources().getColor(R.color.red));
            }
        if (findViewById(R.id.question).getTag().equals("2"))
                findViewById(R.id.answer2).setBackgroundColor(getResources().getColor(R.color.green));
        else
                {
                    findViewById(R.id.answer2).setBackgroundColor(getResources().getColor(R.color.red));
                }

        if (findViewById(R.id.question).getTag().equals("3"))
                findViewById(R.id.answer3).setBackgroundColor(getResources().getColor(R.color.green));
        else
                {
                    findViewById(R.id.answer3).setBackgroundColor(getResources().getColor(R.color.red));
                }
    }

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.answer1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                MarkCorrectAnswer();

            }


        });
        findViewById(R.id.answer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                MarkCorrectAnswer();
            }


        });
        findViewById(R.id.answer3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                MarkCorrectAnswer();
            }


        });




        findViewById(R.id.See).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer3).setVisibility(View.INVISIBLE);
                findViewById(R.id.answer2).setVisibility(View.INVISIBLE);
                findViewById(R.id.answer1).setVisibility(View.INVISIBLE);

                findViewById(R.id.See).setVisibility(View.INVISIBLE);
                findViewById(R.id.nosee).setVisibility(View.VISIBLE);
                findViewById(R.id.rootView).setClickable(true);
                findViewById(R.id.question).setClickable(true);
                findViewById(R.id.question).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        findViewById(R.id.question).setVisibility(View.INVISIBLE);
                        findViewById(R.id.answer1).setVisibility(View.VISIBLE);

                    }
                });
                findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        findViewById(R.id.question).setVisibility(View.VISIBLE);
                        findViewById(R.id.answer1).setVisibility(View.INVISIBLE);
                    }
                });

            }
        });
        findViewById(R.id.nosee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer1).setVisibility(View.VISIBLE);
                findViewById(R.id.answer2).setVisibility(View.VISIBLE);
                findViewById(R.id.answer1).setVisibility(View.VISIBLE);
                findViewById(R.id.See).setVisibility(View.VISIBLE);
                findViewById(R.id.nosee).setVisibility(View.INVISIBLE);
                findViewById(R.id.question).setVisibility(View.VISIBLE);
                findViewById(R.id.rootView).setClickable(false);
                findViewById(R.id.question).setClickable(false);


            }
        });
        findViewById(R.id.addcard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, Addcard.class);
                startActivityForResult(i, 1);
//                overridePendingTransition(R.anim.right_in, R.anim.left_out);


            }
        });

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // REQUEST_CODE is defined above
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            // Extract name value from result extras

           ((TextView)findViewById(R.id.question)).setText(data.getExtras().getString("Question"));
        ((TextView)findViewById(R.id.answer1)).setText(data.getExtras().getString("answer1"));
        ((TextView)findViewById(R.id.answer2)).setText(data.getExtras().getString("answer2"));
        ((TextView)findViewById(R.id.answer3)).setText(data.getExtras().getString("answer3"));
           //int code = data.getExtras().getInt("question", 1);
            Snackbar newcard = Snackbar.make(findViewById(R.id.rootView), "Your New card has been created", Snackbar.LENGTH_SHORT);
            newcard.show();

        }
    }

}


