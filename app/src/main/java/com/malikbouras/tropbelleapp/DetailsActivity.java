package com.malikbouras.tropbelleapp;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 *
 */

public class DetailsActivity extends AppCompatActivity {
    private ImageView tickCross;
    private AnimatedVectorDrawable tickToCross;
    private AnimatedVectorDrawable crossToTick;
    private boolean tick = true;

    private ImageView tickCross2;
    private AnimatedVectorDrawable tickToCross2;
    private AnimatedVectorDrawable crossToTick2;
    private boolean tick2 = true;

    private ImageView playPause;
    private AnimatedVectorDrawable playToPause;
    private AnimatedVectorDrawable pauseToPlay;
    private boolean play = true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tickCross = (ImageView) findViewById(R.id.tick_cross);
        tickToCross = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_tick_to_cross);
        crossToTick = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross_to_tick);

        tickCross2 = (ImageView) findViewById(R.id.tick_cross2);
        tickToCross2 = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_tick_to_cross_transf);
        crossToTick2 = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross_to_tick_transf);

        playPause = (ImageView) findViewById(R.id.play_pause);
        playToPause = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_play_to_pause);
        pauseToPlay = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_pause_to_play);

    }

    public void animate(View view) {
        AnimatedVectorDrawable drawable = tick ? tickToCross : crossToTick;
        tickCross.setImageDrawable(drawable);
        drawable.start();
        tick = !tick;
    }

    public void animate2(View view) {
        AnimatedVectorDrawable drawable = tick2 ? tickToCross2 : crossToTick2;
        tickCross2.setImageDrawable(drawable);
        drawable.start();
        tick2 = !tick2;
    }

    public void animate3(View view) {
        AnimatedVectorDrawable drawable = play ? playToPause : pauseToPlay;
        playPause.setImageDrawable(drawable);
        drawable.start();
        play = !play;
    }

}
