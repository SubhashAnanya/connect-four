package com.example.game;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button[][] buttons = new Button[7][7];
    private boolean p1turn = true;
    private Button reset;
    private TextView p1;
    private Button db;
    private int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = (Button) findViewById(R.id.b);
        db = (Button) findViewById(R.id.db);
        p1 = (TextView) findViewById(R.id.P1);
        db.setBackgroundColor(Color.rgb(255,255,255));
        p1.setBackgroundColor(Color.rgb(255, 255, 255));
        reset.setText("RESET");
        p1.setText("Player 1: Blue\n" +"Player 2:Red\n");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                String buttonID = "b_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
            }
        }
for (int i=1;i<7;i++)
{for (int j=0;j<7;j++)
{buttons[i][j].setEnabled(false);
}
}
          reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 1;
                while (i < 7) {
                    int j = 0;
                    while (j < 7) {
                        buttons[i][j].setBackgroundColor(Color.rgb(255, 255, 255));
                        buttons[i][j].setText("");
                        j++;
                    }
                    i++;
                }
                p1.setText("");
            }
        });
       buttons[0][6].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               colourer(6);
              wincheck();
           }
       });
       buttons[0][5].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               colourer(5);
               wincheck();
           }
       });
       buttons[0][4].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               colourer(4);
           wincheck();
           }
       });
        buttons[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colourer(3);
                wincheck();
            }
        });
        buttons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colourer(2);
            wincheck();
            }
        });
        buttons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colourer(1);
            wincheck();}
        });
        buttons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colourer(0);
            wincheck();
            }
        });
    }public void colourer(int a){
        if (buttons[6][a].getText().toString().equals(db.getText()))
        {
            if (count%2==1) {
                buttons[6][a].setBackgroundColor(Color.rgb(255, 0, 0));
                buttons[6][a].setText("o");
            } else
            {      buttons[6][a].setBackgroundColor(Color.rgb(0,0,255));
                buttons[6][a].setText("c");
            }
        count++;}
        else if (buttons[5][a].getText().toString().equals(db.getText())) {
            if (count%2==1) {
                buttons[5][a].setText("o");
                buttons[5][a].setBackgroundColor(Color.rgb(255, 0, 0));
            } else
            {      buttons[5][a].setText("c");
                buttons[5][a].setBackgroundColor(Color.rgb(0,0,255));

            }
        count++;}
        else if (buttons[4][a].getText().toString().equals(db.getText())) {
            if (count%2==1) {
                buttons[4][a].setText("o");
                buttons[4][a].setBackgroundColor(Color.rgb(255, 0, 0));
            } else
            {  buttons[4][a].setBackgroundColor(Color.rgb(0,0,255));
                buttons[4][a].setText("c");
            }
         count++;}
        else if (buttons[3][a].getText().toString().equals(db.getText())) {
            if (count%2==1) {
                {      buttons[3][a].setText("o");
                    buttons[3][a].setBackgroundColor(Color.rgb(255, 0, 0));
                }} else
            {buttons[3][a].setBackgroundColor(Color.rgb(0,0,255));
                buttons[3][a].setText("c");
            }
        count++;}
        else if (buttons[2][a].getText().toString().equals(db.getText())) {
            if (count%2==1) {
                buttons[2][a].setText("o");
                buttons[2][a].setBackgroundColor(Color.rgb(255, 0, 0));
            } else
            {      buttons[2][a].setBackgroundColor(Color.rgb(0,0,255));
                buttons[2][a].setText("c");
            }
        count++;}
        else if (buttons[1][a].getText().toString().equals(db.getText())) {
            if (count%2==1) {
                buttons[1][a].setText("o");
                buttons[1][a].setBackgroundColor(Color.rgb(255, 0, 0));
            } else
            {      buttons[1][a].setBackgroundColor(Color.rgb(0,0,255));
                buttons[1][a].setText("c");

            }
        count++;}

    }
public void wincheck(){
        String[][] text= new String[7][7];
        for (int i=1;i<7;i++)
        {for(int j=0;j<7;j++)
                text[i][j]=buttons[i][j].getText().toString();
        }
        //Rowcheck
    for (int i=1;i<7;i++)
        {
            for (int j=0;j<4;j++)
            {
            if ((text[i][j].equals(text[i][j+1])&&(text[i][j].equals(text[i][j+2]))&&(text[i][j].equals(text[i][j+3]))&&!(text[i][j].equals("")))){
                if(count%2==1){
                    db.setText("Player 1 wins");
                }
                else if (count%2==0){
                    db.setText("Player 2 wins");
            }}
            }

        }
    for (int i=1;i<4;i++)
    {
        for (int j=0;j<7;j++)
        {
            if ((text[i][j].equals(text[i+1][j])&&(text[i][j].equals(text[i+2][j]))&&(text[i][j].equals(text[i+3][j]))&&!(text[i][j].equals("")))){
                if(count%2==1){
                    db.setText("Player 1 wins");
                }
                else if (count%2==0){
                    db.setText("Player 2 wins");
                }}
        }

    }

    for (int i=1;i<4;i++)
    {for (int j=0;j<4;j++){
        if ((text[i][j].equals(text[i+1][j+1])&&(text[i][j].equals(text[i+2][j+2]))&&(text[i][j].equals(text[i+3][j+3]))&&!(text[i][j].equals("")))){
            if(count%2==1){
                db.setText("Player 1 wins");
            }
            else if (count%2==0){
                db.setText("Player 2 wins");
            }}
    }
    }
    for (int i=4;i<7;i++)
    {for (int j=0;j<4;j++){
        if ((text[i][j].equals(text[i-1][j+1])&&(text[i][j].equals(text[i-2][j+2]))&&(text[i][j].equals(text[i-3][j+3]))&&!(text[i][j].equals("")))){
            if(count%2==1){
                db.setText("Player 1 wins");
            }
            else if (count%2==0){
                db.setText("Player 2 wins");
            }}
    }
    }
    }
}

//first player colour is blue and text is c
//second player colour is red and text is o
