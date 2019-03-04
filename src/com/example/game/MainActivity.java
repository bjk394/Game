package com.example.game;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	Random rand = new Random();
	int playerScore = 0, dealerScore = 0;
	int currentCard = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ArrayList deckArray = new ArrayList();
		final ArrayList playerHandArray = new ArrayList();
		final ArrayList dealerHandArray = new ArrayList();
		final ArrayList firstDelt = new ArrayList();
		final Button btHit=(Button)findViewById(R.id.btnHit);
		final Button btStay=(Button)findViewById(R.id.btnStay);
		final Button btPlay=(Button)findViewById(R.id.btnPlay);
		final TextView playerText = (TextView)findViewById(R.id.txtPlScore);
		final TextView dealerText = (TextView)findViewById(R.id.txtDlScore);
		btHit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView currentImg;
				if(playerScore < 21){
					int pick = rand.nextInt(deckArray.size()-1);
					currentImg = (ImageView) playerHandArray.get(currentCard);
					currentImg.setImageResource(Integer.parseInt(deckArray.get(pick).toString()));
					playerScore += getScore(Integer.parseInt(deckArray.get(pick).toString()));
					deckArray.remove(pick);
					++currentCard;
					playerText.setText("Player Score: "+playerScore);
					Log.d("TEST", "score: "+playerScore);
				} 
				if(playerScore > 21){
					playerText.setText("Player Score: "+playerScore + " YOU'RE OVER 21!");
					btHit.setEnabled(false);
					
				}
				if(playerScore == 21){
					playerText.setText("Player Score: "+playerScore + " You have 21!");
					btHit.setEnabled(false);
					
				}
			}
		});
		btStay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImageView currentImg;
				currentCard = 2; //to skip the first two slots
				
				while(dealerScore < 16){
					int pick = rand.nextInt(deckArray.size()-1);
					currentImg = (ImageView) dealerHandArray.get(currentCard);
					currentImg.setImageResource(Integer.parseInt(deckArray.get(pick).toString()));
					dealerScore += getScore(Integer.parseInt(deckArray.get(pick).toString()));
					deckArray.remove(pick);
					++currentCard;
				} 
				currentImg = (ImageView) dealerHandArray.get(0);
				currentImg.setImageResource(Integer.parseInt(firstDelt.get(0).toString()));
				dealerText.setText("Dealer Score: "+dealerScore);
				Log.d("TEST", "d score: "+dealerScore);
				if(dealerScore > 21){
					dealerText.setText("Dealer Score: "+dealerScore+ " They went over!");
				}
				if(dealerScore == 21){
					dealerText.setText("Dealer Score: "+dealerScore + " They have 21!");
				}
				if(playerScore <= 21 && playerScore > dealerScore){
					playerText.setText("Player Score: "+playerScore + " YOU WIN!");
				}
				if(playerScore < 21 && playerScore < dealerScore){
					playerText.setText("Player Score: "+playerScore + " YOU LOSE!");
				}
				if(playerScore > 21 && dealerScore <= 21){
					playerText.setText("Player Score: "+playerScore + " YOU LOSE!");
				}
				if(playerScore <= 21 && dealerScore > 21){
					playerText.setText("Player Score: "+playerScore + " YOU WIN!");
				}
				if(playerScore == dealerScore){
					playerText.setText("Player Score: "+playerScore + " TIE!");
				}
				btHit.setEnabled(false);
				btStay.setEnabled(false);
			}
		});
		btPlay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dealerScore = 0;
				playerScore = 0;
				currentCard = 0;
				playerText.setText("");
				dealerText.setText("");
				deckArray.clear();
				playerHandArray.clear();
				dealerHandArray.clear();
				firstDelt.clear();
				
				btHit.setEnabled(true);
				btStay.setEnabled(true);
				
				final ImageView imgPlayer1=(ImageView)findViewById(R.id.ImageView01);
				final ImageView imgPlayer2=(ImageView)findViewById(R.id.ImageView02);
				final ImageView imgPlayer3=(ImageView)findViewById(R.id.ImageView03);
				final ImageView imgPlayer4=(ImageView)findViewById(R.id.ImageView04);
				final ImageView imgPlayer5=(ImageView)findViewById(R.id.ImageView05);
				final ImageView imgPlayer6=(ImageView)findViewById(R.id.ImageView06);
				final ImageView imgPlayer7=(ImageView)findViewById(R.id.ImageView07);
				final ImageView imgPlayer8=(ImageView)findViewById(R.id.ImageView08);
				final ImageView imgPlayer9=(ImageView)findViewById(R.id.ImageView09);
				final ImageView imgPlayer10=(ImageView)findViewById(R.id.ImageView10);
				final ImageView imgDealer1=(ImageView)findViewById(R.id.ImageView11);
				final ImageView imgDealer2=(ImageView)findViewById(R.id.ImageView12);
				final ImageView imgDealer3=(ImageView)findViewById(R.id.ImageView13);
				final ImageView imgDealer4=(ImageView)findViewById(R.id.ImageView14);
				final ImageView imgDealer5=(ImageView)findViewById(R.id.ImageView15);
				final ImageView imgDealer6=(ImageView)findViewById(R.id.ImageView16);
				final ImageView imgDealer7=(ImageView)findViewById(R.id.ImageView17);
				final ImageView imgDealer8=(ImageView)findViewById(R.id.ImageView18);
				final ImageView imgDealer9=(ImageView)findViewById(R.id.ImageView19);
				final ImageView imgDealer10=(ImageView)findViewById(R.id.ImageView20);
				
					deckArray.add(R.drawable.c0);
					deckArray.add(R.drawable.c1);
					deckArray.add(R.drawable.c2);
					deckArray.add(R.drawable.c3);
					deckArray.add(R.drawable.c4);
					deckArray.add(R.drawable.c5);
					deckArray.add(R.drawable.c6);
					deckArray.add(R.drawable.c7);
					deckArray.add(R.drawable.c8);
					deckArray.add(R.drawable.c9);
					deckArray.add(R.drawable.c10);
					deckArray.add(R.drawable.c11);
					deckArray.add(R.drawable.c12);
					deckArray.add(R.drawable.c13);
					deckArray.add(R.drawable.c14);
					deckArray.add(R.drawable.c15);
					deckArray.add(R.drawable.c16);
					deckArray.add(R.drawable.c17);
					deckArray.add(R.drawable.c18);
					deckArray.add(R.drawable.c19);
					deckArray.add(R.drawable.c20);
					deckArray.add(R.drawable.c21);
					deckArray.add(R.drawable.c22);
					deckArray.add(R.drawable.c23);
					deckArray.add(R.drawable.c24);
					deckArray.add(R.drawable.c25);
					deckArray.add(R.drawable.c26);
					deckArray.add(R.drawable.c27);
					deckArray.add(R.drawable.c28);
					deckArray.add(R.drawable.c29);
					deckArray.add(R.drawable.c30);
					deckArray.add(R.drawable.c30);
					deckArray.add(R.drawable.c31);
					deckArray.add(R.drawable.c32);
					deckArray.add(R.drawable.c33);
					deckArray.add(R.drawable.c34);
					deckArray.add(R.drawable.c35);
					deckArray.add(R.drawable.c36);
					deckArray.add(R.drawable.c37);
					deckArray.add(R.drawable.c38);
					deckArray.add(R.drawable.c39);
					deckArray.add(R.drawable.c40);
					deckArray.add(R.drawable.c41);
					deckArray.add(R.drawable.c42);
					deckArray.add(R.drawable.c43);
					deckArray.add(R.drawable.c44);
					deckArray.add(R.drawable.c45);
					deckArray.add(R.drawable.c46);
					deckArray.add(R.drawable.c47);
					deckArray.add(R.drawable.c48);
					deckArray.add(R.drawable.c49);
					deckArray.add(R.drawable.c50);
					deckArray.add(R.drawable.c51);
					
					playerHandArray.add(imgPlayer1);
					playerHandArray.add(imgPlayer2);
					playerHandArray.add(imgPlayer3);
					playerHandArray.add(imgPlayer4);
					playerHandArray.add(imgPlayer5);
					playerHandArray.add(imgPlayer6);
					playerHandArray.add(imgPlayer7);
					playerHandArray.add(imgPlayer8);
					playerHandArray.add(imgPlayer9);
					playerHandArray.add(imgPlayer10);
					
					dealerHandArray.add(imgDealer1);
					dealerHandArray.add(imgDealer2);
					dealerHandArray.add(imgDealer3);
					dealerHandArray.add(imgDealer4);
					dealerHandArray.add(imgDealer5);
					dealerHandArray.add(imgDealer6);
					dealerHandArray.add(imgDealer7);
					dealerHandArray.add(imgDealer8);
					dealerHandArray.add(imgDealer9);
					dealerHandArray.add(imgDealer10);
					ImageView tempImg;
					for(int i=0; i<playerHandArray.size(); i++){
						tempImg = (ImageView) playerHandArray.get(i);
						tempImg.setImageResource(R.drawable.ic_launcher);
					}
					for(int i=0; i<dealerHandArray.size(); i++){
						tempImg = (ImageView) dealerHandArray.get(i);
						tempImg.setImageResource(R.drawable.ic_launcher);
					}
					btHit.performClick();
					btHit.performClick();
					ImageView currentImg;
					for(int i=0; i<2; i++){
					int pick = rand.nextInt(deckArray.size()-1);
						firstDelt.add(Integer.parseInt(deckArray.get(pick).toString()));
						dealerScore += getScore(Integer.parseInt(deckArray.get(pick).toString()));
						deckArray.remove(pick);
					}
					currentImg = (ImageView) dealerHandArray.get(0);
					currentImg.setImageResource(R.drawable.b2fv);
					currentImg = (ImageView) dealerHandArray.get(1);
					currentImg.setImageResource(Integer.parseInt(firstDelt.get(1).toString()));
					
			}
		});
		btPlay.performClick();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public int getScore(int card){
		if(card == R.drawable.c0 || card == R.drawable.c13 || card == R.drawable.c26 || card == R.drawable.c39 ){
			return 2;
		}else if(card == R.drawable.c1 || card == R.drawable.c14 || card == R.drawable.c27 || card == R.drawable.c40 ){
			return 3;
		}else if(card == R.drawable.c2 || card == R.drawable.c15 || card == R.drawable.c28 || card == R.drawable.c41 ){
			return 4;
		}else if(card == R.drawable.c3 || card == R.drawable.c16 || card == R.drawable.c29 || card == R.drawable.c42 ){
			return 5;
		}else if(card == R.drawable.c4 || card == R.drawable.c17 || card == R.drawable.c30 || card == R.drawable.c43 ){
			return 6;
		}else if(card == R.drawable.c5 || card == R.drawable.c18 || card == R.drawable.c31 || card == R.drawable.c44 ){
			return 7;
		}else if(card == R.drawable.c6 || card == R.drawable.c19 || card == R.drawable.c32 || card == R.drawable.c45 ){
			return 8;
		}else if(card == R.drawable.c7 || card == R.drawable.c20 || card == R.drawable.c33 || card == R.drawable.c46 ){
			return 9;
		}else if(card == R.drawable.c8 || card == R.drawable.c9 || card == R.drawable.c10 || card == R.drawable.c11 || 
				 card == R.drawable.c21 || card == R.drawable.c22 ||card == R.drawable.c23 ||card == R.drawable.c24 ||  
				 card == R.drawable.c34 || card == R.drawable.c35 || card == R.drawable.c36 || card == R.drawable.c37 || 
				 card == R.drawable.c47 || card == R.drawable.c48 ||card == R.drawable.c49 || card == R.drawable.c50){
			return 10;
		}else if(card == R.drawable.c12 || card == R.drawable.c25 || card == R.drawable.c38 || card == R.drawable.c51){
			return 11;
		}else
			return 0;
	}

}
