package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Mainscreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        playClicked();
    }

    private String getInputOfTextField(int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    public void playClicked(){
        Button play = (Button) findViewById(R.id.playbtn);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1 = getInputOfTextField(R.id.player1);
                String player2 = getInputOfTextField(R.id.player2);
                if(TextUtils.isEmpty(player1)){
                    Toast.makeText(Mainscreen.this, "Please Enter Player 1 Name",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(player2)){
                    Toast.makeText(Mainscreen.this, "Please Enter Player 2 Name",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(Mainscreen.this, GameAct.class);
                    player1 = getInputOfTextField(R.id.player1);
                    player2 = getInputOfTextField(R.id.player2);
                    i.putExtra("p1",player1);
                    i.putExtra("p2",player2);
                    startActivity(i);
                }
            }
        });
    }
}