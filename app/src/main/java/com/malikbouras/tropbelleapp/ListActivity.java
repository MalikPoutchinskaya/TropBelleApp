package com.malikbouras.tropbelleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.malikbouras.tropbelleapp.adapters.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 *
 */

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyRecyclerAdapter(createMockList(), R.layout.row, new MyRecyclerAdapter.Click() {
            @Override
            public void click(ImageView image, TextView textView) {
                Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
                // Pass data object in the bundle and populate details activity.
                //intent.putExtra(DetailsActivity.EXTRA_CONTACT, contact);
                Pair<View, String> p1 = Pair.create((View) image, "image");
                Pair<View, String> p2 = Pair.create((View) textView, "title");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(ListActivity.this, p1, p2);
                startActivity(intent, options.toBundle());
            }
        }));

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private List<Bean> createMockList() {
        List<Bean> beans = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            beans.add(new Bean());
        }
        return beans;
    }
}
