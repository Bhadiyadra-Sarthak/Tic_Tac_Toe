package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class GameAct extends AppCompatActivity {
    game g;
    private InterstitialAd firstad;
    private static final String TAG = "GameAct";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final String player1,player2;
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, "ca-app-pub-5768902856087769/1498471196", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        firstad = interstitialAd;
                        Log.i(TAG,"onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError){
                        Log.i(TAG, loadAdError.getMessage());
                        firstad = null;
                    }
                });



        ImageView turn = findViewById(R.id.turn);
        player1 = getIntent().getExtras().getString("p1");
        player2 = getIntent().getExtras().getString("p2");
        g = new game(player1,player2);
        turn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_path_4));
        setContentsOfTextView(R.id.result,player1+"'s Turn");

        ImageView box1 = findViewById(R.id.box1);
        ImageView box2 = findViewById(R.id.box2);
        ImageView box3 = findViewById(R.id.box3);
        ImageView box4 = findViewById(R.id.box4);
        ImageView box5 = findViewById(R.id.box5);
        ImageView box6 = findViewById(R.id.box6);
        ImageView box7 = findViewById(R.id.box7);
        ImageView box8 = findViewById(R.id.box8);
        ImageView box9 = findViewById(R.id.box9);

        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(g.getIsDone() == 1){
                    Toast.makeText(GameAct.this,"Game Over",Toast.LENGTH_SHORT).show();
                }
                else if(!g.getBoard(0,0)){
                    Toast.makeText(GameAct.this, "This Place is not Empty",Toast.LENGTH_SHORT).show();
                }

                else if(g.getTurn().equals(player1)){
                    box1.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+"'s Turn");
                    g.board(0,0);
                    g.setTurn(player2);
                }
                else if(g.getTurn().equals(player2)){
                    box1.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+"'s Turn");
                    g.board(0,0);
                    g.setTurn(player1);
                }
                if(g.check() == 1){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+" Wins!");

                }
                else if(g.check() == 2){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+" Wins!");

                }
                else if(g.check() == -1){
                    setContentsOfTextView(R.id.result,"It's a draw!");
                    turn.setImageDrawable(getDrawable(R.drawable.btn_bg));

                }
            }
        });
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(g.getIsDone() == 1){
                    Toast.makeText(GameAct.this,"Game Over",Toast.LENGTH_SHORT).show();
                }
                else if(!g.getBoard(0,1)){
                    Toast.makeText(GameAct.this, "This Place is not Empty",Toast.LENGTH_SHORT).show();
                }

                else if(g.getTurn().equals(player1)){
                    box2.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+"'s Turn");

                    g.board(0,1);
                    g.setTurn(player2);
                }
                else if(g.getTurn().equals(player2)){
                    box2.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+"'s Turn");

                    g.board(0,1);
                    g.setTurn(player1);
                }
                if(g.check() == 1){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+" Wins!");

                }
                else if(g.check() == 2){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+" Wins!");

                }
                else if(g.check() == -1){
                    setContentsOfTextView(R.id.result,"It's a draw!");
                    turn.setImageDrawable(getDrawable(R.drawable.btn_bg));

                }
            }
        });
        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(g.getIsDone() == 1){
                    Toast.makeText(GameAct.this,"Game Over",Toast.LENGTH_SHORT).show();
                }
                else if(!g.getBoard(0,2)){
                    Toast.makeText(GameAct.this, "This Place is not Empty",Toast.LENGTH_SHORT).show();
                }

                else if(g.getTurn().equals(player1)){
                    box3.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+"'s Turn");

                    g.board(0,2);
                    g.setTurn(player2);
                }
                else if(g.getTurn().equals(player2)){
                    box3.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+"'s Turn");

                    g.board(0,2);
                    g.setTurn(player1);
                }
                if(g.check() == 1){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+" Wins!");

                }
                else if(g.check() == 2){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+" Wins!");

                }
                else if(g.check() == -1){
                    setContentsOfTextView(R.id.result,"It's a draw!");
                    turn.setImageDrawable(getDrawable(R.drawable.btn_bg));

                }
            }
        });
        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(g.getIsDone() == 1){
                    Toast.makeText(GameAct.this,"Game Over",Toast.LENGTH_SHORT).show();
                }
                else if(!g.getBoard(1,0)){
                    Toast.makeText(GameAct.this, "This Place is not Empty",Toast.LENGTH_SHORT).show();
                }
                else if(g.getTurn().equals(player1)){
                    box4.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+"'s Turn");

                    g.board(1,0);
                    g.setTurn(player2);
                }
                else if(g.getTurn().equals(player2)){
                    box4.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+"'s Turn");

                    g.board(1,0);
                    g.setTurn(player1);
                }
                if(g.check() == 1){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+" Wins!");

                }
                else if(g.check() == 2){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+" Wins!");

                }
                else if(g.check() == -1){
                    setContentsOfTextView(R.id.result,"It's a draw!");
                    turn.setImageDrawable(getDrawable(R.drawable.btn_bg));

                }
            }
        });
        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(g.getIsDone() == 1){
                    Toast.makeText(GameAct.this,"Game Over",Toast.LENGTH_SHORT).show();
                }
                else if(!g.getBoard(1,1)){
                    Toast.makeText(GameAct.this, "This Place is not Empty",Toast.LENGTH_SHORT).show();
                }

                else if(g.getTurn().equals(player1)){
                    box5.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+"'s Turn");
                    g.board(1,1);
                    g.setTurn(player2);
                }
                else if(g.getTurn().equals(player2)){
                    box5.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+"'s Turn");
                    g.board(1,1);
                    g.setTurn(player1);
                }
                if(g.check() == 1){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+" Wins!");

                }
                else if(g.check() == 2){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+" Wins!");

                }
                else if(g.check() == -1){
                    setContentsOfTextView(R.id.result,"It's a draw!");
                    turn.setImageDrawable(getDrawable(R.drawable.btn_bg));

                }
            }
        });
        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(g.getIsDone() == 1){
                    Toast.makeText(GameAct.this,"Game Over",Toast.LENGTH_SHORT).show();
                }
                else if(!g.getBoard(1,2)){
                    Toast.makeText(GameAct.this, "This Place is not Empty",Toast.LENGTH_SHORT).show();
                }

                else if(g.getTurn().equals(player1)){
                    box6.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+"'s Turn");

                    g.board(1,2);
                    g.setTurn(player2);
                }
                else if(g.getTurn().equals(player2)){
                    box6.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+"'s Turn");

                    g.board(1,2);
                    g.setTurn(player1);
                }
                if(g.check() == 1){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+" Wins!");

                }
                else if(g.check() == 2){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+" Wins!");

                }
                else if(g.check() == -1){
                    setContentsOfTextView(R.id.result,"It's a draw!");
                    turn.setImageDrawable(getDrawable(R.drawable.btn_bg));

                }
            }
        });
        box7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(g.getIsDone() == 1){
                    Toast.makeText(GameAct.this,"Game Over",Toast.LENGTH_SHORT).show();
                }
                else if(!g.getBoard(2,0)){
                    Toast.makeText(GameAct.this, "This Place is not Empty",Toast.LENGTH_SHORT).show();
                }
                else if(g.getTurn().equals(player1)){
                    box7.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+"'s Turn");

                    g.board(2,0);
                    g.setTurn(player2);
                }
                else if(g.getTurn().equals(player2)){
                    box7.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+"'s Turn");

                    g.board(2,0);
                    g.setTurn(player1);
                }
                if(g.check() == 1){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+" Wins!");

                }
                else if(g.check() == 2){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+" Wins!");

                }
                else if(g.check() == -1){
                    setContentsOfTextView(R.id.result,"It's a draw!");
                    turn.setImageDrawable(getDrawable(R.drawable.btn_bg));

                }
            }
        });
        box8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(g.getIsDone() == 1){
                    Toast.makeText(GameAct.this,"Game Over",Toast.LENGTH_SHORT).show();
                }
                else if(!g.getBoard(2,1)){
                    Toast.makeText(GameAct.this, "This Place is not Empty",Toast.LENGTH_SHORT).show();
                }
                else if(g.getTurn().equals(player1)){
                    box8.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+"'s Turn");

                    g.board(2,1);
                    g.setTurn(player2);
                }
                else if(g.getTurn().equals(player2)){
                    box8.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+"'s Turn");

                    g.board(2,1);
                    g.setTurn(player1);
                }
                if(g.check() == 1){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+" Wins!");

                }
                else if(g.check() == 2){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+" Wins!");

                }
                else if(g.check() == -1){
                    setContentsOfTextView(R.id.result,"It's a draw!");
                    turn.setImageDrawable(getDrawable(R.drawable.btn_bg));

                }
            }
        });
        box9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(g.getIsDone() == 1){
                    Toast.makeText(GameAct.this,"Game Over",Toast.LENGTH_SHORT).show();
                }
                else if(!g.getBoard(2,2)){
                    Toast.makeText(GameAct.this, "This Place is not Empty",Toast.LENGTH_SHORT).show();
                }
                else if(g.getTurn().equals(player1)){
                    box9.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+"'s Turn");

                    g.board(2,2);
                    g.setTurn(player2);
                }
                else if(g.getTurn().equals(player2)){
                    box9.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+"'s Turn");

                    g.board(2,2);
                    g.setTurn(player1);
                }
                if(g.check() == 1){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                    setContentsOfTextView(R.id.result,player1+" Wins!");
                }
                else if(g.check() == 2){
                    turn.setImageDrawable(getDrawable(R.drawable.ic_group_4));
                    setContentsOfTextView(R.id.result,player2+" Wins!");
                }
                else if(g.check() == -1){
                    setContentsOfTextView(R.id.result,"It's a draw!");
                    turn.setImageDrawable(getDrawable(R.drawable.btn_bg));
                }
            }
        });

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                g = new game(player1,player2);
                setContentsOfTextView(R.id.result,player1+"'s Turn");
                turn.setImageDrawable(getDrawable(R.drawable.ic_path_4));
                box1.setImageDrawable(null);
                box2.setImageDrawable(null);
                box3.setImageDrawable(null);
                box4.setImageDrawable(null);
                box5.setImageDrawable(null);
                box6.setImageDrawable(null);
                box7.setImageDrawable(null);
                box8.setImageDrawable(null);
                box9.setImageDrawable(null);
                if (firstad != null) {
                    firstad.show(GameAct.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }



            }
        });



    }
    private void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }
    private String getInputOfTextField(int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }



}