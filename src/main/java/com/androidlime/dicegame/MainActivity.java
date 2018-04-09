package com.androidlime.dicegame;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_cpu, iv_player;

    TextView tv_cpu, tv_player;


    Random r;

    int cpuPoints = 0, playerPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);

        iv_player = (ImageView) findViewById(R.id.iv_player);

        tv_cpu = (TextView) findViewById(R.id.tv_cpu);

        tv_player = (TextView) findViewById(R.id.tv_player);

        r = new Random();

        iv_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cpuThrow = r.nextInt(6) + 1;
                int playerThrow = r.nextInt(6) + 1;

                setImageCPU(cpuThrow);
                setImagePlayer(playerThrow);

                if (cpuThrow > playerThrow) {
                    cpuPoints++;
                }

                if (playerThrow > cpuThrow) {
                    playerPoints++;
                }

                if (playerThrow == cpuThrow) {
                    Toast.makeText(MainActivity.this, "Drow!", Toast.LENGTH_SHORT).show();
                    MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.raw.rr);
                    mp.start();
                }

                tv_cpu.setText(("CPU :" + cpuPoints));

                tv_player.setText("YOU :" + playerPoints);

                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                iv_cpu.startAnimation(rotate);
                iv_player.startAnimation(rotate);
            }
        });

    }

    public void setImageCPU(int num) {
        switch (num) {

            case 1:
                iv_cpu.setImageResource(R.drawable.ic_1);
                break;
            case 2:
                iv_cpu.setImageResource(R.drawable.ic_2);
                break;
            case 3:
                iv_cpu.setImageResource(R.drawable.ic_3);
                break;
            case 4:
                iv_cpu.setImageResource(R.drawable.ic_4);
                break;
            case 5:
                iv_cpu.setImageResource(R.drawable.ic_5);
                break;
            case 6:
                iv_cpu.setImageResource(R.drawable.ic_6);
                break;

        }
    }


    public void setImagePlayer(int num) {
        switch (num) {

            case 1:
                iv_player.setImageResource(R.drawable.ic_1);
                break;
            case 2:
                iv_player.setImageResource(R.drawable.ic_2);
                break;
            case 3:
                iv_player.setImageResource(R.drawable.ic_3);
                break;
            case 4:
                iv_player.setImageResource(R.drawable.ic_4);
                break;
            case 5:
                iv_player.setImageResource(R.drawable.ic_5);
                break;
            case 6:
                iv_player.setImageResource(R.drawable.ic_6);
                break;

        }
    }

}
