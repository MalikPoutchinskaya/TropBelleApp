package com.malikbouras.tropbelleapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.support.transition.TransitionManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.malikbouras.tropbelleapp.adapters.TutoAdapter;
import com.malikbouras.tropbelleapp.helpers.RevealHelper;

public class TutoActivity extends AppCompatActivity {

    private AnimationDrawable animationDrawable;

    private boolean isOpen = false;

    private ViewPager mViewPager;

    private boolean isTaped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuto);

        ConstraintLayout coordinatorLayout = findViewById(R.id.activityTuto_cl_base);

        //background animation
        animationDrawable = (AnimationDrawable) coordinatorLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(1000);

        //fab animation
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOpen = RevealHelper.getInstance().viewMenu(
                        TutoActivity.this,
                        (FloatingActionButton) findViewById(R.id.fab),
                        isOpen,
                        findViewById(R.id.activityTuto_cl_base),
                        findViewById(R.id.activityTuto_vp));
            }
        });

        findViewById(R.id.malik).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TutoActivity.this, ListActivity.class);
                startActivity(intent);


            }
        });

        //viewpager animation
        mViewPager = (ViewPager) findViewById(R.id.activityTuto_vp);

        // Set an Adapter on the ViewPager
        mViewPager.setAdapter(new TutoAdapter(getSupportFragmentManager()));

        // Set a PageTransformer
        mViewPager.setPageTransformer(false, new TutoPageTransformer());

        //animation constraint
        final ConstraintLayout constraintLayout = findViewById(R.id.activityTuto_cl_base);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintSet constraintSet = new ConstraintSet();
                TransitionManager.beginDelayedTransition(constraintLayout);

                if (isTaped) {
                    constraintSet.clone(TutoActivity.this, R.layout.activity_tuto);
                    constraintSet.applyTo(constraintLayout);

                    isTaped = false;
                } else {

                    constraintSet.clone(TutoActivity.this, R.layout.activity_tuto_alt);
                    constraintSet.applyTo(constraintLayout);

                    isTaped = true;
                }
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        animationDrawable.start();
    }
}
