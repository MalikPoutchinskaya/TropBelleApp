package com.malikbouras.tropbelleapp.helpers;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.malikbouras.tropbelleapp.R;

/**
 *
 */

public class RevealHelper {
    /**
     * Instance unique non préinitialisée
     */
    private static RevealHelper INSTANCE = null;

    /**
     * Point d'accès pour l'instance unique du singleton
     */
    public static synchronized RevealHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RevealHelper();
        }
        return INSTANCE;
    }


    public Boolean viewMenu(Context context, FloatingActionButton fab, Boolean isOpen, View layoutBase, final View layoutReveal) {

        if (!isOpen) {

            int x = fab.getRight() - fab.getWidth() / 2;
            int y = fab.getBottom() - fab.getHeight() / 2;

            int startRadius = 0;
            int endRadius = (int) Math.hypot(layoutBase.getWidth(), layoutBase.getHeight());

            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(context.getResources(), R.color.light_blue_500, null)));
            fab.setImageResource(R.drawable.ic_close_black_24dp);

            Animator anim = ViewAnimationUtils.createCircularReveal(layoutReveal, x, y, startRadius, endRadius);

            layoutReveal.setVisibility(View.VISIBLE);
            anim.start();

            return true;

        } else {

            int x = fab.getRight() - fab.getWidth() / 2;
            int y = fab.getBottom() - fab.getHeight() / 2;

            int startRadius = Math.max(layoutBase.getWidth(), layoutBase.getHeight());
            int endRadius = 0;

            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(context.getResources(), R.color.indigo_500, null)));
            fab.setImageResource(R.drawable.ic_announcement_black_24dp);

            Animator anim = ViewAnimationUtils.createCircularReveal(layoutReveal, x, y, startRadius, endRadius);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    layoutReveal.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            anim.start();

            return false;
        }
    }
}
